package com.google.checkstyle.test.chapter6programpractice.rule64finalizers;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.checkstyle.test.base.ConfigurationBuilder;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration; 
import com.puppycrawl.tools.checkstyle.checks.coding.NoFinalizerCheck;
import com.google.checkstyle.test.base.BaseCheckTestSupport;

public class NoFinalizerTest extends BaseCheckTestSupport{

    static ConfigurationBuilder builder;

    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException {
        builder = new ConfigurationBuilder(new File("src/"),
                "checkstyle_google_style.xml");
    }

    @Test
    public void noFinalizerBasicTest() throws IOException, Exception {
        
        String msg = getCheckMessage(NoFinalizerCheck.class, "avoid.finalizer.method");

        final String[] expected = {
            "5: " + msg,
        };

        Configuration checkConfig = builder.getCheckConfig("NoFinalizer");
        String filePath = builder.getFilePath("NoFinalizerInput");
        
        verify(checkConfig, filePath, expected);
    }
    
    @Test
    public void noFinalizerExtendedTest() throws IOException, Exception {
        
        String msg = getCheckMessage(NoFinalizerCheck.class, "avoid.finalizer.method");

        final String[] expected = {
            "9: " + msg,
            "21: " + msg,
            "33: " + msg,
            "45: " + msg,
            "57: " + msg,
            "69: " + msg,
            "79: " + msg,
            "119: " + msg,
            "136: " + msg,
        };

        Configuration checkConfig = builder.getCheckConfig("NoFinalizer");
        String filePath = builder.getFilePath("NoFinalizeExtendInput");
        
        verify(checkConfig, filePath, expected);
    }
}


