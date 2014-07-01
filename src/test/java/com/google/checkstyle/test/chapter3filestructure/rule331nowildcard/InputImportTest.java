package com.google.checkstyle.test.chapter3filestructure.rule331nowildcard;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.checkstyle.test.base.BaseCheckTestSupport;
import com.google.checkstyle.test.base.ConfigurationBuilder;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration;
import com.puppycrawl.tools.checkstyle.checks.imports.AvoidStarImportCheck;

public class InputImportTest extends BaseCheckTestSupport{
    
    static ConfigurationBuilder builder;
    
    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException {
        builder = new ConfigurationBuilder(new File("src/"),
                "checkstyle_google_style.xml");
    }

    @Test
    public void emptyTest() throws IOException, Exception {
        
    	String msg = getCheckMessage(AvoidStarImportCheck.class, "import.avoidStar");

        final String[] expected = {};
        
        Configuration checkConfig = builder.getCheckConfig("AvoidStarImport");
        String filePath = builder.getFilePath("InputImportTest");
        
        verify(checkConfig, filePath, expected);
    }
}

