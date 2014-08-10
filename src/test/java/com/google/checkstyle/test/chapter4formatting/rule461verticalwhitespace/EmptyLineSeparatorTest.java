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
    public void emptyLineSeparatorTest() throws IOException, Exception {
        
        Class<EmptyLineSeparatorCheck> clazz = EmptyLineSeparatorCheck.class;
        String messageKey = "empty.line.separator";

        final String[] expected = {
            "19: " + getCheckMessage(clazz, messageKey, "package"),
            "20: " + getCheckMessage(clazz, messageKey, "import"),
            "33: " + getCheckMessage(clazz, messageKey, "CLASS_DEF"),
            "37: " + getCheckMessage(clazz, messageKey, "STATIC_INIT"),
            "75: " + getCheckMessage(clazz, messageKey, "INTERFACE_DEF"),
            "82: " + getCheckMessage(clazz, messageKey, "INSTANCE_INIT"),
        };

        Configuration checkConfig = builder.getCheckConfig("EmptyLineSeparator");
        String filePath = builder.getFilePath("EmptyLineSeparatorInput");

        verify(checkConfig, filePath, expected);
    }
}


