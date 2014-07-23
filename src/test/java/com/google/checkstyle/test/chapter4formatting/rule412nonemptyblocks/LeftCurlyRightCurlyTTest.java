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

public class LeftCurlyRightCurlyTTest extends BaseCheckTestSupport{
    
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
            "12:1: " + checkMessage,
            "15:5: " + checkMessage,
            "21:5: " + checkMessage,
            "34:5: " + checkMessage,
            "51:5: " + checkMessage,
            "69:5: " + checkMessage,
            "105:5: " + checkMessage,
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
        	"12:1: " + checkMessagePrevious,
            "17:5: " + checkMessagePrevious,
            "24:5: " + checkMessagePrevious,
            "34:31: " + checkMessageNew,
            "39:1: " + checkMessagePrevious,
            "41:5: " + checkMessagePrevious,
            "46:9: " + checkMessagePrevious,
            "56:35: " + checkMessageNew,
            "69:5: " + checkMessagePrevious,
            "77:5: " + checkMessagePrevious,
            "87:31: " + checkMessageNew,
            };

        Configuration checkConfig = builder.getCheckConfig("LeftCurly");
        String filePath = builder.getFilePath("LeftCurlyInput_Method");
        
        verify(checkConfig, filePath, expected);
    }
    
    @Test
    public void rightCurlyTest() throws Exception {
    	String checkMessagePrevious = getCheckMessage(RightCurlyCheck.class, "line.new", "}");
    	final String[] expected = {
    		"111:10: " + checkMessagePrevious,
    		"122:10: " + checkMessagePrevious,
    		"136:10: " + checkMessagePrevious,
    	};
    	
    	Configuration checkConfig = builder.getCheckConfig("RightCurly");
        String filePath = builder.getFilePath("RightCurlyInput_Other");
        
        verify(checkConfig, filePath, expected);
    }
}


