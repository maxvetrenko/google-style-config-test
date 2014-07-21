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

        final String[] expected = {
        	"5:38: " + getCheckMessage(ClassTypeParameterNameCheck.class, "name.invalidPattern", "t", "(^[A-Z][0-9]?)$|([A-Z][a-zA-Z0-9]*[T]$)"),
        	"13:14: " + getCheckMessage(ClassTypeParameterNameCheck.class, "name.invalidPattern", "foo", "(^[A-Z][0-9]?)$|([A-Z][a-zA-Z0-9]*[T]$)"),
        	"27:24: " + getCheckMessage(ClassTypeParameterNameCheck.class, "name.invalidPattern", "foo", "(^[A-Z][0-9]?)$|([A-Z][a-zA-Z0-9]*[T]$)"),
        };

        Configuration checkConfig = builder.getCheckConfig("ClassTypeParameterName");
        String filePath = builder.getFilePath("ClassMethodTypeParameterNameInput");
        
        verify(checkConfig, filePath, expected);
    }

    @Test
    public void testMethodDefault() throws IOException, Exception {

        final String[] expected = {
        	"9:6: " + getCheckMessage(MethodTypeParameterNameCheck.class, "name.invalidPattern", "e_e", "(^[A-Z][0-9]?)$|([A-Z][a-zA-Z0-9]*[T]$)"),
        	"19:6: " + getCheckMessage(MethodTypeParameterNameCheck.class, "name.invalidPattern", "Tfo$o2T", "(^[A-Z][0-9]?)$|([A-Z][a-zA-Z0-9]*[T]$)"),
        	"23:6: " + getCheckMessage(MethodTypeParameterNameCheck.class, "name.invalidPattern", "foo", "(^[A-Z][0-9]?)$|([A-Z][a-zA-Z0-9]*[T]$)"),
        	"28:10: " + getCheckMessage(MethodTypeParameterNameCheck.class, "name.invalidPattern", "_fo", "(^[A-Z][0-9]?)$|([A-Z][a-zA-Z0-9]*[T]$)"),
        };

        Configuration checkConfig = builder.getCheckConfig("MethodTypeParameterName");
        String filePath = builder.getFilePath("ClassMethodTypeParameterNameInput");
        
        verify(checkConfig, filePath, expected);
    }
}