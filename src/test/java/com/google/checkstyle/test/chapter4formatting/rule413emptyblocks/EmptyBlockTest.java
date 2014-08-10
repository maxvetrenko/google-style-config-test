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
        
        final String[] expected = {
            "19:21: " + getCheckMessage(EmptyBlockCheck.class, "block.empty", "if"),
            "22:34: " + getCheckMessage(EmptyBlockCheck.class, "block.empty", "if"),
            "26:21: " + getCheckMessage(EmptyBlockCheck.class, "block.empty", "if"),
            "28:20: " + getCheckMessage(EmptyBlockCheck.class, "block.empty", "switch"),
            "68:25: " + getCheckMessage(EmptyBlockCheck.class, "block.empty", "if"),
            "71:38: " + getCheckMessage(EmptyBlockCheck.class, "block.empty", "if"),
            "75:25: " + getCheckMessage(EmptyBlockCheck.class, "block.empty", "if"),
            "77:24: " + getCheckMessage(EmptyBlockCheck.class, "block.empty", "switch"),
            "98:29: " + getCheckMessage(EmptyBlockCheck.class, "block.empty", "if"),
            "101:42: " + getCheckMessage(EmptyBlockCheck.class, "block.empty", "if"),
            "105:29: " + getCheckMessage(EmptyBlockCheck.class, "block.empty", "if"),
            "107:28: " + getCheckMessage(EmptyBlockCheck.class, "block.empty", "switch"),
        };

        Configuration checkConfig = builder.getCheckConfig("EmptyBlock");
        String filePath = builder.getFilePath("EmptyBlockInput");
        
        verify(checkConfig, filePath, expected);
    }
    
    @Test
    public void emptyBlockTestCatch() throws IOException, Exception {
        
        final String[] expected = {
            "28:31: " + getCheckMessage(EmptyBlockCheck.class, "block.empty", "catch"),
            "29:17: " + getCheckMessage(EmptyBlockCheck.class, "block.empty", "finally"),
            "49:35: " + getCheckMessage(EmptyBlockCheck.class, "block.empty", "catch"),
            "50:21: " + getCheckMessage(EmptyBlockCheck.class, "block.empty", "finally"),
            "71:35: " + getCheckMessage(EmptyBlockCheck.class, "block.empty", "catch"),
            "72:21: " + getCheckMessage(EmptyBlockCheck.class, "block.empty", "finally"),
        };

        Configuration checkConfig = builder.getCheckConfig("EmptyBlock");
        String filePath = builder.getFilePath("EmptyBlockInputCatch");
        
        verify(checkConfig, filePath, expected);
    }
}


