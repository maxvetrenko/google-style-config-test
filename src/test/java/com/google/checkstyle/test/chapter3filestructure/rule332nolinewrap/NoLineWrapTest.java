package com.google.checkstyle.test.chapter3filestructure.rule332nolinewrap;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.checkstyle.test.base.BaseCheckTestSupport;
import com.google.checkstyle.test.base.ConfigurationBuilder;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration;
import com.puppycrawl.tools.checkstyle.checks.whitespace.NoLineWrapCheck;

public class NoLineWrapTest extends BaseCheckTestSupport{
    
    static ConfigurationBuilder builder;
    
    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException {
        builder = new ConfigurationBuilder(new File("src/"),
                "checkstyle_google_style.xml");
    }

    @Test
    public void badLineWrapTest() throws IOException, Exception {
        
        String msg = getCheckMessage(NoLineWrapCheck.class, "no.line.wrap", "import");

        final String[] expected = {
            "1: " + getCheckMessage(NoLineWrapCheck.class, "no.line.wrap", "package"),
            "6: " + getCheckMessage(NoLineWrapCheck.class, "no.line.wrap", "import"),            
        };
        
        Configuration checkConfig = builder.getCheckConfig("NoLineWrap");
        String filePath = builder.getFilePath("NoLineWrap_Bad");
        
        verify(checkConfig, filePath, expected);
    }
    
    @Test
    public void goodLineWrapTest() throws IOException, Exception {
        
        final String[] expected = {};
        
        Configuration checkConfig = builder.getCheckConfig("NoLineWrap");
        String filePath = builder.getFilePath("NoLineWrap_Good");
        
        verify(checkConfig, filePath, expected);
    }
}


