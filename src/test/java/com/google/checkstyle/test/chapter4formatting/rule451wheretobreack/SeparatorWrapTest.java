package com.google.checkstyle.test.chapter4formatting.rule451wheretobreack;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.checkstyle.test.base.BaseCheckTestSupport;
import com.google.checkstyle.test.base.ConfigurationBuilder;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration;
import com.puppycrawl.tools.checkstyle.checks.whitespace.SeparatorWrapCheck;

public class SeparatorWrapTest extends BaseCheckTestSupport{
    
    static ConfigurationBuilder builder;
    
    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException {
        builder = new ConfigurationBuilder(new File("src/"),
                "checkstyle_google_style.xml");
    }

    @Test
    public void emptyTest() throws IOException, Exception {
        
        final String[] expected = {
            "28:10: " + getCheckMessage(SeparatorWrapCheck.class, "line.new", "."),
        };

        Configuration checkConfig = builder.getCheckConfig("SeparatorWrap");
        String filePath = builder.getFilePath("SeparatorWrapInput");

        verify(checkConfig, filePath, expected);
    }
    
    @Test
    public void emptyTest2() throws IOException, Exception {
        
        final String[] expected = {
            "28:10: " + getCheckMessage(SeparatorWrapCheck.class, "line.new", "."),
        };

        Configuration checkConfig = builder.getCheckConfig("SeparatorWrap");
        String filePath = builder.getFilePath("SeparatorWrapInput");

        verify(checkConfig, filePath, expected);
    }
}


