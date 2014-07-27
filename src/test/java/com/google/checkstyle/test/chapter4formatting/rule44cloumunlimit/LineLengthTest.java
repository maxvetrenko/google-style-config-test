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

public class LineLengthTest extends BaseCheckTestSupport{
    
    static ConfigurationBuilder builder;
    
    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException {
        builder = new ConfigurationBuilder(new File("src/"),
                "checkstyle_google_style.xml");
    }

    @Test
    public void emptyTest() throws IOException, Exception {
        
        final String[] expected = {
             "5: " + getCheckMessage(LineLengthCheck.class, "maxLineLen", 100, 105),
             "29: " + getCheckMessage(LineLengthCheck.class, "maxLineLen", 100, 113),
        };
        
        Configuration checkConfig = builder.getCheckConfig("LineLength");
        String filePath = builder.getFilePath("LineLengthInput");
        
        verify(checkConfig, filePath, expected);
    }
}


