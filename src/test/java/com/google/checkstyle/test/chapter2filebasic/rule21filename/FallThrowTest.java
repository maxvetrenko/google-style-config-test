package com.google.checkstyle.test.chapter2filebasic.rule21filename;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.checkstyle.test.base.ConfigurationBuilder;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration; 
import com.google.checkstyle.test.base.BaseCheckTestSupport;

public class FallThrowTest extends BaseCheckTestSupport{
    
    static ConfigurationBuilder builder;
    
    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException {
        builder = new ConfigurationBuilder(new File("src/"),
                "checkstyle_google_style.xml");
    }

    @Test
    public void emptyTest() throws IOException, Exception {
        
    	String msg =
    			"Fall through from previous branch of the switch statement.";

        final String[] expected = {
                "14:13: " + msg,
                "38:13: " + msg, 
                "53:13: " + msg,
                "70:13: " + msg,
                "87:13: " + msg,
                "105:13: " + msg,
                "123:13: " + msg,
                "369:11: " + msg,
                "372:11: " + msg,
                "374:40: " + msg,
                };
        
        Configuration checkConfig = builder.getCheckConfig("FallThrough");
        String filePath = builder.getFilePath("InputFallThrough");
        
        verify(checkConfig, filePath, expected);
    }
}


