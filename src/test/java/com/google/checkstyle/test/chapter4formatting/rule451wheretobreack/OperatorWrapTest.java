package com.google.checkstyle.test.chapter4formatting.rule451wheretobreack;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.checkstyle.test.base.BaseCheckTestSupport;
import com.google.checkstyle.test.base.ConfigurationBuilder;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration;
import com.puppycrawl.tools.checkstyle.checks.whitespace.OperatorWrapCheck;

public class OperatorWrapTest extends BaseCheckTestSupport{
    
    static ConfigurationBuilder builder;
    
    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException {
        builder = new ConfigurationBuilder(new File("src/"),
                "checkstyle_google_style.xml");
    }

    @Test
    public void operatorWrapTest() throws IOException, Exception {
        
        Class<OperatorWrapCheck> clazz = OperatorWrapCheck.class;
        String messageKey = "line.new";

        final String[] expected = {
            "10:27: " + getCheckMessage(clazz, messageKey, "+"),
            "11:28: " + getCheckMessage(clazz, messageKey, "-"),
            "19:27: " + getCheckMessage(clazz, messageKey, "&&"),
            "34:35: " + getCheckMessage(clazz, messageKey, "&"),
            "53:42: " + getCheckMessage(clazz, messageKey, "?"),
            "57:27: " + getCheckMessage(clazz, messageKey, "!="),
            "63:30: " + getCheckMessage(clazz, messageKey, "=="),
            "69:27: " + getCheckMessage(clazz, messageKey, ">"),
            "75:35: " + getCheckMessage(clazz, messageKey, "||"),
            "98:46: " + getCheckMessage(clazz, messageKey, "?"),
            "102:31: " + getCheckMessage(clazz, messageKey, "!="),
            "108:34: " + getCheckMessage(clazz, messageKey, "=="),
            "114:31: " + getCheckMessage(clazz, messageKey, ">"),
            "120:39: " + getCheckMessage(clazz, messageKey, "||"),
            "144:46: " + getCheckMessage(clazz, messageKey, "?"),
            "148:31: " + getCheckMessage(clazz, messageKey, "!="),
            "154:34: " + getCheckMessage(clazz, messageKey, "=="),
            "160:31: " + getCheckMessage(clazz, messageKey, ">"),
            "166:39: " + getCheckMessage(clazz, messageKey, "||"),
        };

        Configuration checkConfig = builder.getCheckConfig("OperatorWrap");
        String filePath = builder.getFilePath("OperatorWrapInput");

        verify(checkConfig, filePath, expected);
    }
}