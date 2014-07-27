package com.google.checkstyle.test.chapter5naming.rule522typenames;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.checkstyle.test.base.BaseCheckTestSupport;
import com.google.checkstyle.test.base.ConfigurationBuilder;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration;
import com.puppycrawl.tools.checkstyle.checks.naming.TypeNameCheck;

public class TypeNameTest extends BaseCheckTestSupport{
    
    static ConfigurationBuilder builder;
    
    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException {
        builder = new ConfigurationBuilder(new File("src/"),
                "checkstyle_google_style.xml");
    }

    @Test
    public void emptyTest() throws IOException, Exception {
        
        Class<TypeNameCheck> clazz = TypeNameCheck.class;
        String msgKey = "name.invalidPattern";
        String format = "^[A-Z][a-zA-Z0-9]*$";

        final String[] expected = {
            "3:7: " + getCheckMessage(clazz, msgKey, "inputHeaderClass", format),
            "5:22: " + getCheckMessage(clazz, msgKey, "inputHeaderInterface", format),
            "7:17: " + getCheckMessage(clazz, msgKey, "inputHeaderEnum", format),
            "9:11: " + getCheckMessage(clazz, msgKey, "noValidName", format),
        };
        
        Configuration checkConfig = builder.getCheckConfig("TypeName");
        String filePath = builder.getFilePath("TypeNameInput");
        
        verify(checkConfig, filePath, expected);
    }
}


