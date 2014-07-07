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

public class Rule64_FinalizersTest extends BaseCheckTestSupport{

    static ConfigurationBuilder builder;

    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException {
        builder = new ConfigurationBuilder(new File("src/"),
                "checkstyle_google_style.xml");
    }

    @Test
    public void emptyTest() throws IOException, Exception {
        
    	String msg = getCheckMessage(NoFinalizerCheck.class, "avoid.finalizer.method");

        final String[] expected = {
                "5: " + msg,
                };
        
        Configuration checkConfig = builder.getCheckConfig("NoFinalizer");
        String filePath = builder.getFilePath("HasFinalizer");
        
        verify(checkConfig, filePath, expected);
    }
}


