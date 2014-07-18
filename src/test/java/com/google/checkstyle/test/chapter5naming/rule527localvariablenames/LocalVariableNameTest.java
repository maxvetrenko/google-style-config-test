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

        final String[] expected = {
        	"119:13: " + getCheckMessage(LocalVariableNameCheck.class, "name.invalidPattern", "ABC", "^[a-z]{2,}[a-zA-Z0-9]*$"),
        	"130:18: " + getCheckMessage(LocalVariableNameCheck.class, "name.invalidPattern", "I", "^[a-z]{2,}[a-zA-Z0-9]*$"),
        	"132:20: " + getCheckMessage(LocalVariableNameCheck.class, "name.invalidPattern", "InnerBlockVariable", "^[a-z]{2,}[a-zA-Z0-9]*$"),
        	"207:21: " + getCheckMessage(LocalVariableNameCheck.class, "name.invalidPattern", "O", "^[a-z]{2,}[a-zA-Z0-9]*$"),
        };

        Configuration checkConfig = builder.getCheckConfig("LocalVariableName");
        String filePath = builder.getFilePath("LocalVariableNameInput_Simple");
        
        verify(checkConfig, filePath, expected);
    }
    
    @Test
    public void oneCharTest() throws IOException, Exception {

        final String[] expected = {
        	"19:21: " + getCheckMessage(LocalVariableNameCheck.class, "name.invalidPattern", "i", "^[a-z]{2,}[a-zA-Z0-9]*$"),
        	"25:17: " + getCheckMessage(LocalVariableNameCheck.class, "name.invalidPattern", "Index", "^[a-z]{2,}[a-zA-Z0-9]*$"),
        };

        Configuration checkConfig = builder.getCheckConfig("LocalVariableName");
        String filePath = builder.getFilePath("LocalVariableNameInput_OneCharVarName");
        
        verify(checkConfig, filePath, expected);
    }
}


