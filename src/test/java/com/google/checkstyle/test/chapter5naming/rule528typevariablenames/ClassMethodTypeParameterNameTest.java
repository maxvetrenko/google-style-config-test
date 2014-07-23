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

    static ConfigurationBuilder builder;

    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException {
        builder = new ConfigurationBuilder(new File("src/"),
                "checkstyle_google_style.xml");
    }

    @Test
    public void testClassDefault() throws IOException, Exception {

        Class<ClassTypeParameterNameCheck> clazz = ClassTypeParameterNameCheck.class;
		String msgKey = "name.invalidPattern";
		String format = "(^[A-Z][0-9]?)$|([A-Z][a-zA-Z0-9]*[T]$)";

		final String[] expected = {
        	"5:31: " + getCheckMessage(clazz, msgKey, "t", format),
        	"13:14: " + getCheckMessage(clazz, msgKey, "foo", format),
        	"27:24: " + getCheckMessage(clazz, msgKey, "foo", format),
        };

        Configuration checkConfig = builder.getCheckConfig("ClassTypeParameterName");
        String filePath = builder.getFilePath("ClassMethodTypeParameterNameInput");
        
        verify(checkConfig, filePath, expected);
    }

    @Test
    public void testMethodDefault() throws IOException, Exception {

        Class<MethodTypeParameterNameCheck> clazz = MethodTypeParameterNameCheck.class;
		String msgKey = "name.invalidPattern";
		String format = "(^[A-Z][0-9]?)$|([A-Z][a-zA-Z0-9]*[T]$)";

		final String[] expected = {
        	"9:6: " + getCheckMessage(clazz, msgKey, "e_e", format),
        	"19:6: " + getCheckMessage(clazz, msgKey, "Tfo$o2T", format),
        	"23:6: " + getCheckMessage(clazz, msgKey, "foo", format),
        	"28:10: " + getCheckMessage(clazz, msgKey, "_fo", format),
        };

        Configuration checkConfig = builder.getCheckConfig("MethodTypeParameterName");
        String filePath = builder.getFilePath("ClassMethodTypeParameterNameInput");
        
        verify(checkConfig, filePath, expected);
    }
}