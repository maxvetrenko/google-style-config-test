package com.google.checkstyle.test.chapter4formatting.rule44cloumunlimit;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.checkstyle.test.base.ConfigurationBuilder;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration; 
import com.puppycrawl.tools.checkstyle.checks.sizes.LineLengthCheck;
import com.google.checkstyle.test.base.BaseCheckTestSupport;

public class Rule44_CloumunLimitTest extends BaseCheckTestSupport{
    
    static ConfigurationBuilder builder;
    
    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException {
        builder = new ConfigurationBuilder(new File("src/"),
                "checkstyle_google_style.xml");
    }

    @Test
    public void emptyTest() throws IOException, Exception {
        
    	String msg = getCheckMessage(LineLengthCheck.class, "maxLineLen");

        final String[] expected = {};
        
        Configuration checkConfig = builder.getCheckConfig("LineLength");
        String filePath = builder.getFilePath("Simple");
        
        verify(checkConfig, filePath, expected);
    }
}


