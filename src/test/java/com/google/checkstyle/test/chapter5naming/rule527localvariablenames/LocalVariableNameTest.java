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
        	"119:13: " + getCheckMessage(clazz, msgKey, "ABC", format),
        	"130:18: " + getCheckMessage(clazz, msgKey, "I", format),
        	"132:20: " + getCheckMessage(clazz, msgKey, "InnerBlockVariable", format),
        	"207:21: " + getCheckMessage(clazz, msgKey, "O", format),
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
        	"19:21: " + getCheckMessage(clazz, msgKey, "i", format),
        	"25:17: " + getCheckMessage(clazz, msgKey, "Index", format),
        };

        Configuration checkConfig = builder.getCheckConfig("LocalVariableName");
        String filePath = builder.getFilePath("LocalVariableNameInput_OneCharVarName");
        
        verify(checkConfig, filePath, expected);
    }
}


