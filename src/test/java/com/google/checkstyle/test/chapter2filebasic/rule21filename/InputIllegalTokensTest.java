package com.google.checkstyle.test.chapter2filebasic.rule21filename;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.checkstyle.test.base.ConfigurationBuilder;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration; 
import com.puppycrawl.tools.checkstyle.checks.OuterTypeFilenameCheck;
import com.google.checkstyle.test.base.BaseCheckTestSupport;

public class InputIllegalTokensTest extends BaseCheckTestSupport{
    
    static ConfigurationBuilder builder;
    
    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException {
        builder = new ConfigurationBuilder(new File("src/"),
                "checkstyle_google_style.xml");
    }

    @Test
    public void emptyTest() throws IOException, Exception {
    	 
    	String msg = getCheckMessage(OuterTypeFilenameCheck.class, "fall.through");

        final String[] expected = {
                };
        
        Configuration checkConfig = builder.getCheckConfig("OuterTypeFilename");
        String filePath = builder.getFilePath("InputIllegalTokens");
        
        verify(checkConfig, filePath, expected);
    }
}


