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

        final String[] expected = {
        	"194:25: " + getCheckMessage(ParameterNameCheck.class, "name.invalidPattern", "aArg1", "^[a-z]{2,}[a-zA-Z0-9]*$"),
        	"194:36: " + getCheckMessage(ParameterNameCheck.class, "name.invalidPattern", "aArg2", "^[a-z]{2,}[a-zA-Z0-9]*$"),
        	"194:47: " + getCheckMessage(ParameterNameCheck.class, "name.invalidPattern", "aArg3", "^[a-z]{2,}[a-zA-Z0-9]*$"),
        	"194:58: " + getCheckMessage(ParameterNameCheck.class, "name.invalidPattern", "aArg4", "^[a-z]{2,}[a-zA-Z0-9]*$"),
        	"194:69: " + getCheckMessage(ParameterNameCheck.class, "name.invalidPattern", "aArg5", "^[a-z]{2,}[a-zA-Z0-9]*$"),
        	"195:25: " + getCheckMessage(ParameterNameCheck.class, "name.invalidPattern", "aArg6", "^[a-z]{2,}[a-zA-Z0-9]*$"),
        	"195:36: " + getCheckMessage(ParameterNameCheck.class, "name.invalidPattern", "aArg7", "^[a-z]{2,}[a-zA-Z0-9]*$"),
        	"195:47: " + getCheckMessage(ParameterNameCheck.class, "name.invalidPattern", "aArg8", "^[a-z]{2,}[a-zA-Z0-9]*$"),
        	"195:58: " + getCheckMessage(ParameterNameCheck.class, "name.invalidPattern", "aArg9", "^[a-z]{2,}[a-zA-Z0-9]*$"),
        };

        Configuration checkConfig = builder.getCheckConfig("ParameterName");
        String filePath = builder.getFilePath("ParameterNameInput_Simple");
        
        verify(checkConfig, filePath, expected);
    }
}


