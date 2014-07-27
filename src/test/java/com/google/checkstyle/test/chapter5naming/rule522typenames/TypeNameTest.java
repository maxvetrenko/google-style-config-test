package com.google.checkstyle.test.chapter5naming.rule522typenames;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.checkstyle.test.base.BaseCheckTestSupport;
import com.google.checkstyle.test.base.ConfigurationBuilder;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration;
import com.puppycrawl.tools.checkstyle.checks.naming.TypeNameCheck;

public class TypeNameTest extends BaseCheckTestSupport{
    
	private static ConfigurationBuilder builder;
    
    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException {
        builder = new ConfigurationBuilder(new File("src/"),
                "checkstyle_google_style.xml");
    }

    @Test
    public void emptyTest() throws IOException, Exception {
        
        Class<TypeNameCheck> clazz = TypeNameCheck.class;
        String msgKey = "name.invalidPattern";
        String format = "^[A-Z][a-zA-Z0-9]*$";

        final String[] expected = {
            "3:7: " + getCheckMessage(clazz, msgKey, "inputHeaderClass", format),
            "5:22: " + getCheckMessage(clazz, msgKey, "InputHeader___Interface", format),
            "7:17: " + getCheckMessage(clazz, msgKey, "inputHeaderEnum", format),
            "9:11: " + getCheckMessage(clazz, msgKey, "NoValid$Name", format),
            "11:11: " + getCheckMessage(clazz, msgKey, "$NoValidName", format),
            "13:11: " + getCheckMessage(clazz, msgKey, "NoValidName$", format),
            "19:7: " + getCheckMessage(clazz, msgKey, "_ValidName", format),
            "21:7: " + getCheckMessage(clazz, msgKey, "Valid_Name", format),
            "23:7: " + getCheckMessage(clazz, msgKey, "ValidName_", format),
            "27:11: " + getCheckMessage(clazz, msgKey, "_Foo", format),
            "29:11: " + getCheckMessage(clazz, msgKey, "Fo_o", format),
            "31:11: " + getCheckMessage(clazz, msgKey, "Foo_", format),
            "33:11: " + getCheckMessage(clazz, msgKey, "$Foo", format),
            "35:11: " + getCheckMessage(clazz, msgKey, "Fo$o", format),
            "37:11: " + getCheckMessage(clazz, msgKey, "Foo$", format),
            "41:6: " + getCheckMessage(clazz, msgKey, "_FooEnum", format),
            "43:6: " + getCheckMessage(clazz, msgKey, "Foo_Enum", format),
            "45:6: " + getCheckMessage(clazz, msgKey, "FooEnum_", format),
            "47:6: " + getCheckMessage(clazz, msgKey, "$FooEnum", format),
            "49:6: " + getCheckMessage(clazz, msgKey, "Foo$Enum", format),
            "51:6: " + getCheckMessage(clazz, msgKey, "FooEnum$", format),
            "53:7: " + getCheckMessage(clazz, msgKey, "aaa", format),
            "55:11: " + getCheckMessage(clazz, msgKey, "bbb", format),
            "57:6: " + getCheckMessage(clazz, msgKey, "ccc", format),
            "61:12: " + getCheckMessage(clazz, msgKey, "_Annotation", format),
            "63:12: " + getCheckMessage(clazz, msgKey, "Annot_ation", format),
            "65:12: " + getCheckMessage(clazz, msgKey, "Annotation_", format),
            "67:12: " + getCheckMessage(clazz, msgKey, "$Annotation", format),
            "69:12: " + getCheckMessage(clazz, msgKey, "Annot$ation", format),
            "71:12: " + getCheckMessage(clazz, msgKey, "Annotation$", format),
        };
        
        Configuration checkConfig = builder.getCheckConfig("TypeName");
        String filePath = builder.getFilePath("TypeNameInput");
        
        verify(checkConfig, filePath, expected);
    }
}


