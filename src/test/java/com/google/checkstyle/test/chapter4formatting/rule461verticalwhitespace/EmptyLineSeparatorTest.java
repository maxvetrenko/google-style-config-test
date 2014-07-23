package com.google.checkstyle.test.chapter4formatting.rule461verticalwhitespace;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.checkstyle.test.base.BaseCheckTestSupport;
import com.google.checkstyle.test.base.ConfigurationBuilder;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration;
import com.puppycrawl.tools.checkstyle.checks.whitespace.EmptyLineSeparatorCheck;

public class EmptyLineSeparatorTest extends BaseCheckTestSupport{

    static ConfigurationBuilder builder;

    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException {
        builder = new ConfigurationBuilder(new File("src/"),
                "checkstyle_google_style.xml");
    }

    @Test
    public void emptyTest() throws IOException, Exception {
    	
        Class<EmptyLineSeparatorCheck> clazz = EmptyLineSeparatorCheck.class;
		String messageKey = "empty.line.separator";

		final String[] expected = {
        	"16: " + getCheckMessage(clazz, messageKey, "CLASS_DEF"),
        	"19: " + getCheckMessage(clazz, messageKey, "VARIABLE_DEF"),
        	"58: " + getCheckMessage(clazz, messageKey, "INTERFACE_DEF"),
        };

        Configuration checkConfig = builder.getCheckConfig("EmptyLineSeparator");
        String filePath = builder.getFilePath("EmptyLineSeparatorInput");

        verify(checkConfig, filePath, expected);
    }
}


