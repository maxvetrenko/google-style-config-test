package com.google.checkstyle.test.chapter4formatting.rule412nonemptyblocks;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.checkstyle.test.base.BaseCheckTestSupport;
import com.google.checkstyle.test.base.ConfigurationBuilder;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration;
import com.puppycrawl.tools.checkstyle.checks.blocks.LeftCurlyCheck;

public class InputLeftCurlyMethodTest extends BaseCheckTestSupport{
    
    static ConfigurationBuilder builder;
    
    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException {
        builder = new ConfigurationBuilder(new File("src/"),
                "checkstyle_google_style.xml");
    }

    @Test
    public void emptyTest() throws IOException, Exception {
        

        final String[] expected = {
        	"12:1: " + getCheckMessage(LeftCurlyCheck.class, "line.previous", "{"),
            "17:5: " + getCheckMessage(LeftCurlyCheck.class, "line.previous", "{"),
            "24:5: " + getCheckMessage(LeftCurlyCheck.class, "line.previous", "{"),
            "31:5: " + getCheckMessage(LeftCurlyCheck.class, "line.previous", "{"),
            "39:1: " + getCheckMessage(LeftCurlyCheck.class, "line.previous", "{"),
            "41:5: " + getCheckMessage(LeftCurlyCheck.class, "line.previous", "{"),
            "46:9: " + getCheckMessage(LeftCurlyCheck.class, "line.previous", "{"),
            "53:9: " + getCheckMessage(LeftCurlyCheck.class, "line.previous", "{"),
            "69:5: " + getCheckMessage(LeftCurlyCheck.class, "line.previous", "{"),
            "77:5: " + getCheckMessage(LeftCurlyCheck.class, "line.previous", "{"),
            "84:5: " + getCheckMessage(LeftCurlyCheck.class, "line.previous", "{"),
            };
        
        Configuration checkConfig = builder.getCheckConfig("LeftCurly");
        String filePath = builder.getFilePath("InputLeftCurlyMethod");
        
        verify(checkConfig, filePath, expected);
    }
}


