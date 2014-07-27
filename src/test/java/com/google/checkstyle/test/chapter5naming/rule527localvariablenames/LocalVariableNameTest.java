package com.google.checkstyle.test.chapter5naming.rule527localvariablenames;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.checkstyle.test.base.BaseCheckTestSupport;
import com.google.checkstyle.test.base.ConfigurationBuilder;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration;
import com.puppycrawl.tools.checkstyle.checks.naming.LocalVariableNameCheck;

public class LocalVariableNameTest extends BaseCheckTestSupport{

    static ConfigurationBuilder builder;

    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException {
        builder = new ConfigurationBuilder(new File("src/"),
                "checkstyle_google_style.xml");
    }

    @Test
    public void emptyTest() throws IOException, Exception {

        Class<LocalVariableNameCheck> clazz = LocalVariableNameCheck.class;
        String msgKey = "name.invalidPattern";
        String format = "^[a-z]{2,}[a-zA-Z0-9]*$";

        final String[] expected = {
            "26:13: " + getCheckMessage(clazz, msgKey, "a", format),
            "27:13: " + getCheckMessage(clazz, msgKey, "aA", format),
            "28:13: " + getCheckMessage(clazz, msgKey, "a1_a", format),
            "29:13: " + getCheckMessage(clazz, msgKey, "A_A", format),
            "30:13: " + getCheckMessage(clazz, msgKey, "aa2_a", format),
            "31:13: " + getCheckMessage(clazz, msgKey, "_a", format),
            "32:13: " + getCheckMessage(clazz, msgKey, "_aa", format),
            "33:13: " + getCheckMessage(clazz, msgKey, "aa_", format),
        };

        Configuration checkConfig = builder.getCheckConfig("LocalVariableName");
        String filePath = builder.getFilePath("LocalVariableNameInput_Simple");
        
        verify(checkConfig, filePath, expected);
    }
    
    @Test
    public void oneCharTest() throws IOException, Exception {

        Class<LocalVariableNameCheck> clazz = LocalVariableNameCheck.class;
        String msgKey = "name.invalidPattern";
        String format = "^[a-z]{2,}[a-zA-Z0-9]*$";

        final String[] expected = {
            "15:13: " + getCheckMessage(clazz, msgKey, "i", format),
            "21:17: " + getCheckMessage(clazz, msgKey, "Index", format),
        };

        Configuration checkConfig = builder.getCheckConfig("LocalVariableName");
        String filePath = builder.getFilePath("LocalVariableNameInput_OneCharVarName");
        
        verify(checkConfig, filePath, expected);
    }
}


