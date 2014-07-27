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
import com.puppycrawl.tools.checkstyle.checks.blocks.RightCurlyCheck;

public class LeftCurlyRightCurlyTest extends BaseCheckTestSupport{
    
    static ConfigurationBuilder builder;
    
    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException {
        builder = new ConfigurationBuilder(new File("src/"),
                "checkstyle_google_style.xml");
    }

    @Test
    public void emptyTest() throws IOException, Exception {
        
        String checkMessage = getCheckMessage(LeftCurlyCheck.class, "line.previous", "{");
        final String[] expected = {
            "4:1: " + checkMessage,
            "7:5: " + checkMessage,
            "13:5: " + checkMessage,
            "26:5: " + checkMessage,
            "43:5: " + checkMessage,
            "61:5: " + checkMessage,
            "97:5: " + checkMessage,
            };
        
        Configuration checkConfig = builder.getCheckConfig("LeftCurly");
        String filePath = builder.getFilePath("LeftCurlyInput_Braces");
        
        verify(checkConfig, filePath, expected);
    }
    
    @Test
    public void emptyTest2() throws IOException, Exception {
        
        String checkMessagePrevious = getCheckMessage(LeftCurlyCheck.class, "line.previous", "{");
        final String[] expected = {
            "10:1: " + checkMessagePrevious,
            "14:5: " + checkMessagePrevious,
            "21:5: " + checkMessagePrevious,
        };
        
        Configuration checkConfig = builder.getCheckConfig("LeftCurly");
        String filePath = builder.getFilePath("LeftCurlyInput_Annotations");
        
        verify(checkConfig, filePath, expected);
    }
    
    @Test
    public void emptyTest3() throws IOException, Exception {
        

        String checkMessagePrevious = getCheckMessage(LeftCurlyCheck.class, "line.previous", "{");
        String checkMessageNew = getCheckMessage(LeftCurlyCheck.class, "line.new", "{");
        final String[] expected = {
            "4:1: " + checkMessagePrevious,
            "9:5: " + checkMessagePrevious,
            "16:5: " + checkMessagePrevious,
            "26:31: " + checkMessageNew,
            "31:1: " + checkMessagePrevious,
            "33:5: " + checkMessagePrevious,
            "38:9: " + checkMessagePrevious,
            "48:35: " + checkMessageNew,
            "61:5: " + checkMessagePrevious,
            "69:5: " + checkMessagePrevious,
            "79:31: " + checkMessageNew,
         };

        Configuration checkConfig = builder.getCheckConfig("LeftCurly");
        String filePath = builder.getFilePath("LeftCurlyInput_Method");
        
        verify(checkConfig, filePath, expected);
    }
    
    @Test
    public void rightCurlyTest() throws Exception {
        String checkMessagePrevious = getCheckMessage(RightCurlyCheck.class, "line.new", "}");
        final String[] expected = {
            "99:6: " + checkMessagePrevious,
            "110:6: " + checkMessagePrevious,
            "124:6: " + checkMessagePrevious,
        };
        
        Configuration checkConfig = builder.getCheckConfig("RightCurly");
        String filePath = builder.getFilePath("RightCurlyInput_Other");
        
        verify(checkConfig, filePath, expected);
    }
}


