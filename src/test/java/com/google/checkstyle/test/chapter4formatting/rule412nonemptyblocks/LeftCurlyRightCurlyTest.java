package com.google.checkstyle.test.chapter4formatting.rule412nonemptyblocks;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.checkstyle.test.base.BaseCheckTestSupport;
import com.google.checkstyle.test.base.ConfigurationBuilder;
import com.puppycrawl.tools.checkstyle.DefaultConfiguration;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration;
import com.puppycrawl.tools.checkstyle.checks.blocks.LeftCurlyCheck;
import com.puppycrawl.tools.checkstyle.checks.blocks.RightCurlyCheck;
import com.puppycrawl.tools.checkstyle.checks.blocks.RightCurlyOption;

public class LeftCurlyRightCurlyTest extends BaseCheckTestSupport{
    
    static ConfigurationBuilder builder;
    
    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException {
        builder = new ConfigurationBuilder(new File("src/"),
                "checkstyle_google_style.xml");
    }

    @Test
    public void leftCurlyBracesTest() throws IOException, Exception {
        
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
    public void leftCurlyAnnotationsTest() throws IOException, Exception {
        
        String checkMessagePrevious = getCheckMessage(LeftCurlyCheck.class, "line.previous", "{");
        final String[] expected = {
            "10:1: " + checkMessagePrevious,
            "14:5: " + checkMessagePrevious,
            "21:5: " + checkMessagePrevious,
            "27:5: " + checkMessagePrevious,
            "50:5: " + checkMessagePrevious,
        };
        
        Configuration checkConfig = builder.getCheckConfig("LeftCurly");
        String filePath = builder.getFilePath("LeftCurlyInput_Annotations");
        
        verify(checkConfig, filePath, expected);
    }
    
    @Test
    public void leftCurlyMethodsTest() throws IOException, Exception {
        

        String checkMessagePrevious = getCheckMessage(LeftCurlyCheck.class, "line.previous", "{");
        final String[] expected = {
            "4:1: " + checkMessagePrevious,
            "9:5: " + checkMessagePrevious,
            "16:5: " + checkMessagePrevious,
            "19:5: " + checkMessagePrevious,
            "23:5: " + checkMessagePrevious,
            "31:1: " + checkMessagePrevious,
            "33:5: " + checkMessagePrevious,
            "38:9: " + checkMessagePrevious,
            "41:9: " + checkMessagePrevious,
            "45:9: " + checkMessagePrevious,
            "57:5: " + checkMessagePrevious,
            "61:5: " + checkMessagePrevious,
            "69:5: " + checkMessagePrevious,
            "72:5: " + checkMessagePrevious, 
            "76:5: " + checkMessagePrevious,
         };

        Configuration checkConfig = builder.getCheckConfig("LeftCurly");
        String filePath = builder.getFilePath("LeftCurlyInput_Method");
        
        verify(checkConfig, filePath, expected);
    }

    @Test
    public void rightCurlyTestSame() throws Exception {

        String checkMessageSame = getCheckMessage(RightCurlyCheck.class, "line.same", "}");
        String checkMessageAlone = getCheckMessage(RightCurlyCheck.class, "line.alone", "}");
        String checkMessageNew = getCheckMessage(RightCurlyCheck.class, "line.new", "}");
        String checkMessageLineBreak = getCheckMessage(RightCurlyCheck.class, "line.break.before");
        
        final String[] expected = {
            "20:17: " + checkMessageSame,
            "32:13: " + checkMessageSame,
            "79:27: " + checkMessageAlone,
            "79:27: " + checkMessageNew,
            "79:27: '}' should have line break before.",
            "83:53: '}' should have line break before.",
        };

        Configuration checkConfig = builder.getCheckConfig("RightCurly");
        String filePath = builder.getFilePath("RightCurlyInput_Other");
        
        verify(checkConfig, filePath, expected);
    }
    
    @Test
    public void rightCurlyTestAlone() throws Exception {
        DefaultConfiguration newCheckConfig = createCheckConfig(RightCurlyCheck.class);
        newCheckConfig.addAttribute("option", RightCurlyOption.ALONE.toString());
        newCheckConfig.addAttribute("tokens", "CLASS_DEF, METHOD_DEF, CTOR_DEF");
        
        String checkMessageNew = getCheckMessage(RightCurlyCheck.class, "line.new", "}");
        final String[] expected = {
            "97:6: " + checkMessageNew,
            "108:6: " + checkMessageNew,
            "122:6: " + checkMessageNew,
        };

        String filePath = builder.getFilePath("RightCurlyInput_Other");
        
        verify(newCheckConfig, filePath, expected);
    }
}


