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

	private Class<ParameterNameCheck> clazz = ParameterNameCheck.class;
	private String msgKey = "name.invalidPattern";
	private static String format;
	private static ConfigurationBuilder builder;
	private static Configuration checkConfig;

    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException {
        builder = new ConfigurationBuilder(new File("src/"),
                "checkstyle_google_style.xml");
        checkConfig = builder.getCheckConfig("ParameterName");
        format = checkConfig.getAttribute("format");
    }

    @Test
    public void emptyTest() throws IOException, Exception {


        final String[] expected = {
            "7:25: " + getCheckMessage(clazz, msgKey, "$arg1", format),
            "7:36: " + getCheckMessage(clazz, msgKey, "ar$g2", format),
            "7:47: " + getCheckMessage(clazz, msgKey, "arg3$", format),
            "7:58: " + getCheckMessage(clazz, msgKey, "a_rg4", format),
            "7:69: " + getCheckMessage(clazz, msgKey, "_arg5", format),
            "8:21: " + getCheckMessage(clazz, msgKey, "arg6_", format),
            "8:32: " + getCheckMessage(clazz, msgKey, "aArg7", format),
            "8:43: " + getCheckMessage(clazz, msgKey, "aArg8", format),
            "8:54: " + getCheckMessage(clazz, msgKey, "aar_g", format),
            "18:21: " + getCheckMessage(clazz, msgKey, "bB", format),
            "41:22: " + getCheckMessage(clazz, msgKey, "llll_llll", format),
            "42:21: " + getCheckMessage(clazz, msgKey, "bB", format),
        };

        String filePath = builder.getFilePath("ParameterNameInput_Simple");
        
        verify(checkConfig, filePath, expected);
    }
}


