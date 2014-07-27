package com.google.checkstyle.test.chapter5naming.rule526parameternames;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.checkstyle.test.base.BaseCheckTestSupport;
import com.google.checkstyle.test.base.ConfigurationBuilder;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration;
import com.puppycrawl.tools.checkstyle.checks.naming.ParameterNameCheck;

public class ParameterNameTest extends BaseCheckTestSupport{

    static ConfigurationBuilder builder;

    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException {
        builder = new ConfigurationBuilder(new File("src/"),
                "checkstyle_google_style.xml");
    }

    @Test
    public void emptyTest() throws IOException, Exception {

        Class<ParameterNameCheck> clazz = ParameterNameCheck.class;
        String msgKey = "name.invalidPattern";
        String format = "^[a-z]{2,}[a-zA-Z0-9]*$";

        final String[] expected = {
            "7:25: " + getCheckMessage(clazz, msgKey, "aArg1", format),
            "7:36: " + getCheckMessage(clazz, msgKey, "aArg2", format),
            "7:47: " + getCheckMessage(clazz, msgKey, "aArg3", format),
            "7:58: " + getCheckMessage(clazz, msgKey, "aArg4", format),
            "7:69: " + getCheckMessage(clazz, msgKey, "aArg5", format),
            "8:25: " + getCheckMessage(clazz, msgKey, "aArg6", format),
            "8:36: " + getCheckMessage(clazz, msgKey, "aArg7", format),
            "8:47: " + getCheckMessage(clazz, msgKey, "aArg8", format),
            "8:58: " + getCheckMessage(clazz, msgKey, "aArg9", format),
            "18:21: " + getCheckMessage(clazz, msgKey, "bB", format),
            "41:21: " + getCheckMessage(clazz, msgKey, "bB", format),
        };

        Configuration checkConfig = builder.getCheckConfig("ParameterName");
        String filePath = builder.getFilePath("ParameterNameInput_Simple");
        
        verify(checkConfig, filePath, expected);
    }
}


