package com.google.checkstyle.test.chapter4formatting.rule411bracesareused;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.checkstyle.test.base.BaseCheckTestSupport;
import com.google.checkstyle.test.base.ConfigurationBuilder;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration;
import com.puppycrawl.tools.checkstyle.checks.blocks.NeedBracesCheck;

public class Rule411_BracesAreUsed extends BaseCheckTestSupport{
    
    static ConfigurationBuilder builder;
    
    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException {
        builder = new ConfigurationBuilder(new File("src/"),
                "checkstyle_google_style.xml");
    }

    @Test
    public void emptyTest() throws IOException, Exception {
        
    	String msg = getCheckMessage(NeedBracesCheck.class, "needBraces");

        final String[] expected = {
                };
        
        Configuration checkConfig = builder.getCheckConfig("NeedBraces");
        String filePath = builder.getFilePath("BracesTest");
        
        verify(checkConfig, filePath, expected);
    }
}
