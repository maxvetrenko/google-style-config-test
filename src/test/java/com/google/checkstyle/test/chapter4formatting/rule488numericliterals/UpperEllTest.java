package com.google.checkstyle.test.chapter4formatting.rule488numericliterals;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.checkstyle.test.base.ConfigurationBuilder;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration; 
import com.google.checkstyle.test.base.BaseCheckTestSupport;

public class UpperEllTest extends BaseCheckTestSupport{
    
    static ConfigurationBuilder builder;
    
    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException {
        builder = new ConfigurationBuilder(new File("src/"),
                "checkstyle_google_style.xml");
    }

    @Test
    public void emptyTest() throws IOException, Exception {
        
        final String[] expected = {
            "6:43: Should use uppercase 'L'.",
            "12:19: Should use uppercase 'L'.",
        };
        
        Configuration checkConfig = builder.getCheckConfig("UpperEll");
        String filePath = builder.getFilePath("UpperEllInput");
        
        verify(checkConfig, filePath, expected);
    }
}


