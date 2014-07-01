package com.google.checkstyle.test.chapter4formatting.rule43onestatement;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.checkstyle.test.base.ConfigurationBuilder;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration; 
import com.google.checkstyle.test.base.BaseCheckTestSupport;

public class OneStatementPerLineCheckInputTest extends BaseCheckTestSupport{
    
    static ConfigurationBuilder builder;
    
    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException {
        builder = new ConfigurationBuilder(new File("src/"),
                "checkstyle_google_style.xml");
    }

    @Test
    public void emptyTest() throws IOException, Exception {
        
    	String msg = getCheckMessage("multiple.statements.line", "coding");

        final String[] expected = {
        		"99:18: " + msg,
        		"127:11: " + msg,
                };
        
        Configuration checkConfig = builder.getCheckConfig("OneStatementPerLine");
        String filePath = builder.getFilePath("OneStatementPerLineCheckInput");
        
        verify(checkConfig, filePath, expected);
    }
}


