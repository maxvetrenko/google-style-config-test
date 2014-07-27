package com.google.checkstyle.test.chapter5naming.rule528typevariablenames;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.checkstyle.test.base.BaseCheckTestSupport;
import com.google.checkstyle.test.base.ConfigurationBuilder;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration;
import com.puppycrawl.tools.checkstyle.checks.naming.ClassTypeParameterNameCheck;
import com.puppycrawl.tools.checkstyle.checks.naming.MethodTypeParameterNameCheck;

public class ClassMethodTypeParameterNameTest extends BaseCheckTestSupport{

    private static ConfigurationBuilder builder;
    private Class<ClassTypeParameterNameCheck> clazz = ClassTypeParameterNameCheck.class;
    private String msgKey = "name.invalidPattern";
    private static Configuration checkConfig;
    private static String format;
    
    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException {
        builder = new ConfigurationBuilder(new File("src/"),
                "checkstyle_google_style.xml");
        checkConfig = builder.getCheckConfig("ClassTypeParameterName");
        format = checkConfig.getAttribute("format");
    }

    @Test
    public void testClassDefault() throws IOException, Exception {

        final String[] expected = {
            "5:31: " + getCheckMessage(clazz, msgKey, "t", format),
            "13:14: " + getCheckMessage(clazz, msgKey, "foo", format),
            "27:24: " + getCheckMessage(clazz, msgKey, "$foo", format),
        };

        String filePath = builder.getFilePath("ClassMethodTypeParameterNameInput");
        
        verify(checkConfig, filePath, expected);
    }

    @Test
    public void testMethodDefault() throws IOException, Exception {

        Class<MethodTypeParameterNameCheck> clazz = MethodTypeParameterNameCheck.class;

        final String[] expected = {
            "9:6: " + getCheckMessage(clazz, msgKey, "e_e", format),
            "19:6: " + getCheckMessage(clazz, msgKey, "Tfo$o2T", format),
            "23:6: " + getCheckMessage(clazz, msgKey, "foo_", format),
            "28:10: " + getCheckMessage(clazz, msgKey, "_abc", format),
            "37:14: " + getCheckMessage(clazz, msgKey, "T$", format),
            "42:14: " + getCheckMessage(clazz, msgKey, "EE", format),
        };

        Configuration checkConfig = builder.getCheckConfig("MethodTypeParameterName");
        String filePath = builder.getFilePath("ClassMethodTypeParameterNameInput");
        
        verify(checkConfig, filePath, expected);
    }
}