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

	private static ConfigurationBuilder builder;
	private Class<LocalVariableNameCheck> clazz = LocalVariableNameCheck.class;
	private String msgKey = "name.invalidPattern";
	private static Configuration checkConfig;
	private static String format;

    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException {
        builder = new ConfigurationBuilder(new File("src/"),
                "checkstyle_google_style.xml");
        checkConfig = builder.getCheckConfig("LocalVariableName");
        format = checkConfig.getAttribute("format");
    }

    @Test
    public void emptyTest() throws IOException, Exception {

        final String[] expected = {
            "26:13: " + getCheckMessage(clazz, msgKey, "a", format),
            "27:13: " + getCheckMessage(clazz, msgKey, "aA", format),
            "28:13: " + getCheckMessage(clazz, msgKey, "a1_a", format),
            "29:13: " + getCheckMessage(clazz, msgKey, "A_A", format),
            "30:13: " + getCheckMessage(clazz, msgKey, "aa2_a", format),
            "31:13: " + getCheckMessage(clazz, msgKey, "_a", format),
            "32:13: " + getCheckMessage(clazz, msgKey, "_aa", format),
            "33:13: " + getCheckMessage(clazz, msgKey, "aa_", format),
            "34:13: " + getCheckMessage(clazz, msgKey, "aaa$aaa", format),
            "35:13: " + getCheckMessage(clazz, msgKey, "$aaaaaa", format),
            "36:13: " + getCheckMessage(clazz, msgKey, "aaaaaa$", format),
        };

        String filePath = builder.getFilePath("LocalVariableNameInput_Simple");
        
        verify(checkConfig, filePath, expected);
    }
    
    @Test
    public void oneCharTest() throws IOException, Exception {

        final String[] expected = {
            "15:13: " + getCheckMessage(clazz, msgKey, "i", format),
            "21:17: " + getCheckMessage(clazz, msgKey, "I_ndex", format),
            "45:17: " + getCheckMessage(clazz, msgKey, "i_ndex", format),
            "49:17: " + getCheckMessage(clazz, msgKey, "ii_i1", format),
            "53:17: " + getCheckMessage(clazz, msgKey, "$index", format),
            "57:17: " + getCheckMessage(clazz, msgKey, "in$dex", format),
            "61:17: " + getCheckMessage(clazz, msgKey, "index$", format),
        };

        String filePath = builder.getFilePath("LocalVariableNameInput_OneCharVarName");
        
        verify(checkConfig, filePath, expected);
    }
}


