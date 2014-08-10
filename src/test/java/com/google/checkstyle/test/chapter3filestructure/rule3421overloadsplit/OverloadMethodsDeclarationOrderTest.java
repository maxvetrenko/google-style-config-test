package com.google.checkstyle.test.chapter3filestructure.rule3421overloadsplit;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.checkstyle.test.base.BaseCheckTestSupport;
import com.google.checkstyle.test.base.ConfigurationBuilder;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration;
import com.puppycrawl.tools.checkstyle.checks.coding.OverloadMethodsDeclarationOrderCheck;

public class OverloadMethodsDeclarationOrderTest extends BaseCheckTestSupport{
    
    static ConfigurationBuilder builder;
    
    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException {
        builder = new ConfigurationBuilder(new File("src/"),
                "checkstyle_google_style.xml");
    }

    @Test
    public void overloadMethodsTest() throws IOException, Exception {
        
        Class<OverloadMethodsDeclarationOrderCheck> clazz = OverloadMethodsDeclarationOrderCheck.class;

        String msg = getCheckMessage(clazz, "overload.methods.declaration");

        final String[] expected = {
            "26: " + msg,
            "54: " + msg,
            "66: " + msg,
            "109: " + msg,
        };
        
        Configuration checkConfig = builder.getCheckConfig("OverloadMethodsDeclarationOrder");
        String filePath = builder.getFilePath("InputOverloadMethodsDeclarationOrder");
        
        verify(checkConfig, filePath, expected);
    }
}


