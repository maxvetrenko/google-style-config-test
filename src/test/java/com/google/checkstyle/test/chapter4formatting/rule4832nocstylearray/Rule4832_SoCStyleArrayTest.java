package com.google.checkstyle.test.chapter4formatting.rule4832nocstylearray;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.checkstyle.test.base.ConfigurationBuilder;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration; 
import com.puppycrawl.tools.checkstyle.checks.ArrayTypeStyleCheck;
import com.google.checkstyle.test.base.BaseCheckTestSupport;

public class Rule4832_SoCStyleArrayTest extends BaseCheckTestSupport{
    
    static ConfigurationBuilder builder;
    
    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException {
        builder = new ConfigurationBuilder(new File("src/"),
                "checkstyle_google_style.xml");
    }

    @Test
    public void emptyTest() throws IOException, Exception {
        
    	String msg = getCheckMessage(ArrayTypeStyleCheck.class, "array.type.style");

        final String[] expected = {
                "14:23: " + msg,
                "20:44: " + msg,
                };
        
        Configuration checkConfig = builder.getCheckConfig("ArrayTypeStyle");
        String filePath = builder.getFilePath("ArrayTypeStyle");
        
        verify(checkConfig, filePath, expected);
    }
}


