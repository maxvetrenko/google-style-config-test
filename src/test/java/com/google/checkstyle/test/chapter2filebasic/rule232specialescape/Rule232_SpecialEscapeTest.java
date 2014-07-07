package com.google.checkstyle.test.chapter2filebasic.rule232specialescape;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.checkstyle.test.base.BaseCheckTestSupport;
import com.google.checkstyle.test.base.ConfigurationBuilder;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration;
import com.puppycrawl.tools.checkstyle.checks.coding.IllegalTokenTextCheck;

public class Rule232_SpecialEscapeTest extends BaseCheckTestSupport{
    
    static ConfigurationBuilder builder;
    
    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException {
        builder = new ConfigurationBuilder(new File("src/"),
                "checkstyle_google_style.xml");
    }

    @Test
    public void emptyTest() throws IOException, Exception {
        
    	String msg = getCheckMessage(IllegalTokenTextCheck.class, "illegal.token.text");

        final String[] expected = {
                };
        
        Configuration checkConfig = builder.getCheckConfig("IllegalTokenText");
        String filePath = builder.getFilePath("IllegalTokens");
        
        verify(checkConfig, filePath, expected);
    }
}


