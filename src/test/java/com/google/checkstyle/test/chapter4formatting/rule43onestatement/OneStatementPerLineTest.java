package com.google.checkstyle.test.chapter4formatting.rule43onestatement;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.checkstyle.test.base.BaseCheckTestSupport;
import com.google.checkstyle.test.base.ConfigurationBuilder;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration;
import com.puppycrawl.tools.checkstyle.checks.coding.OneStatementPerLineCheck;

public class OneStatementPerLineTest extends BaseCheckTestSupport{
    
    static ConfigurationBuilder builder;
    
    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException {
        builder = new ConfigurationBuilder(new File("src/"),
                "checkstyle_google_style.xml");
    }

    @Test
    public void oneStatmentTest() throws IOException, Exception {
        
        String msg = getCheckMessage(OneStatementPerLineCheck.class, "multiple.statements.line");

        final String[] expected = {
            "45:18: " + msg,
            "47:19: " + msg,
            "49:40: " + msg,
            "51:30: " + msg,
            "51:41: " + msg,
            "51:57: " + msg,
            "52:23: " + msg,
            "53:33: " + msg,
            "54:55: " + msg,
            "54:64: " + msg,
            "63:11: " + msg,
            "90:22: " + msg,
            "92:23: " + msg,
            "94:44: " + msg,
            "96:34: " + msg,
            "96:45: " + msg,
            "96:61: " + msg,
            "97:27: " + msg,
            "98:37: " + msg,
            "99:59: " + msg,
            "99:68: " + msg,
        };
        
        Configuration checkConfig = builder.getCheckConfig("OneStatementPerLine");
        String filePath = builder.getFilePath("OneStatementPerLineInput");
        
        verify(checkConfig, filePath, expected);
    }
}


