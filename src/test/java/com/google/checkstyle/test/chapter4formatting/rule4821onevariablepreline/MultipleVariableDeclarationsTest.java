package com.google.checkstyle.test.chapter4formatting.rule4821onevariablepreline;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.checkstyle.test.base.ConfigurationBuilder;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration; 
import com.puppycrawl.tools.checkstyle.checks.coding.MultipleVariableDeclarationsCheck;
import com.google.checkstyle.test.base.BaseCheckTestSupport;

public class MultipleVariableDeclarationsTest extends BaseCheckTestSupport{
    
    static ConfigurationBuilder builder;
    
    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException {
        builder = new ConfigurationBuilder(new File("src/"),
                "checkstyle_google_style.xml");
    }

    @Test
    public void emptyTest() throws IOException, Exception {
        
    	String msgComma = getCheckMessage(MultipleVariableDeclarationsCheck.class, "multiple.variable.declarations.comma");
    	String msg = getCheckMessage(MultipleVariableDeclarationsCheck.class, "multiple.variable.declarations");

        final String[] expected = {
            "5:5: " + msgComma,
            "6:5: " + msg,
            "9:9: " + msgComma,
            "10:9: " + msg,
            "14:5: " + msg,
            "17:5: " + msg,
            };
        
        Configuration checkConfig = builder.getCheckConfig("MultipleVariableDeclarations");
        String filePath = builder.getFilePath("MultipleVariableDeclarationsInput");
        
        verify(checkConfig, filePath, expected);
    }
}


