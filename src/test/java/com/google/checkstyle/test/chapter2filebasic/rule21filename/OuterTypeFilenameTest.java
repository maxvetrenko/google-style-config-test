package com.google.checkstyle.test.chapter2filebasic.rule21filename;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.checkstyle.test.base.ConfigurationBuilder;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration; 
import com.puppycrawl.tools.checkstyle.checks.OuterTypeFilenameCheck;
import com.google.checkstyle.test.base.BaseCheckTestSupport;

public class OuterTypeFilenameTest extends BaseCheckTestSupport{
    
    static ConfigurationBuilder builder;
    
    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException {
        builder = new ConfigurationBuilder(new File("src/"),
                "checkstyle_google_style.xml");
    }

    @Test
    public void outerTypeFilenameTest_1() throws IOException, Exception {

        String msg = getCheckMessage(OuterTypeFilenameCheck.class, "type.file.mismatch");

        final String[] expected = {
            "4: " + msg,
        };
        
        Configuration checkConfig = builder.getCheckConfig("OuterTypeFilename");
        String filePath = builder.getFilePath("OuterTypeFilenameInput_1");
        
        verify(checkConfig, filePath, expected);
    } 
    
    @Test
    public void outerTypeFilenameTest_2() throws IOException, Exception {
         
        final String[] expected = {};
        
        Configuration checkConfig = builder.getCheckConfig("OuterTypeFilename");
        String filePath = builder.getFilePath("OuterTypeFilenameInput_2");
        
        verify(checkConfig, filePath, expected);
    }
}


