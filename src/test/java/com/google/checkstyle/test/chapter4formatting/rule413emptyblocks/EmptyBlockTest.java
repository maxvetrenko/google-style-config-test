package com.google.checkstyle.test.chapter4formatting.rule413emptyblocks;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.checkstyle.test.base.BaseCheckTestSupport;
import com.google.checkstyle.test.base.ConfigurationBuilder;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration;
import com.puppycrawl.tools.checkstyle.checks.blocks.EmptyBlockCheck;

public class EmptyBlockTest extends BaseCheckTestSupport{
    
    static ConfigurationBuilder builder;
    
    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException {
        builder = new ConfigurationBuilder(new File("src/"),
                "checkstyle_google_style.xml");
    }

    @Test
    public void emptyBlockTest() throws IOException, Exception {
        
        String msg = getCheckMessage(EmptyBlockCheck.class, "block.noStmt");
        
        final String[] expected = {
            "19:21: " + msg,
            "22:34: " + msg,
            "26:21: " + msg,
            "28:20: " + msg,
            "67:25: " + msg,
            "70:38: " + msg,
            "74:25: " + msg,
            "76:24: " + msg,
            "96:29: " + msg,
            "99:42: " + msg,
            "103:29: " + msg,
            "105:28: " + msg,
        };
        
        Configuration checkConfig = builder.getCheckConfig("EmptyBlock");
        String filePath = builder.getFilePath("EmptyBlockInput");
        
        verify(checkConfig, filePath, expected);
    }
}


