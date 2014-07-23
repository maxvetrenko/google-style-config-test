package com.google.checkstyle.test.chapter5naming.rule525nonconstantfieldnames;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.checkstyle.test.base.BaseCheckTestSupport;
import com.google.checkstyle.test.base.ConfigurationBuilder;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration;
import com.puppycrawl.tools.checkstyle.checks.naming.TypeNameCheck;

public class MemberNameTest extends BaseCheckTestSupport{
    
    static ConfigurationBuilder builder;
    
    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException {
        builder = new ConfigurationBuilder(new File("src/"),
                "checkstyle_google_style.xml");
    }

    @Test
    public void emptyTest() throws IOException, Exception {
    	
    	Class<TypeNameCheck> clazz = TypeNameCheck.class;
        
        String msgKey = "name.invalidPattern";
		String foramt = "^[a-z]{2,}[a-zA-Z0-9]*$";

		final String[] expected = {
        	"5:16: " + getCheckMessage(clazz, msgKey, "mPublic", foramt),
        	"6:19: " + getCheckMessage(clazz, msgKey, "mProtected", foramt),
        	"7:9: " + getCheckMessage(clazz, msgKey, "mPackage", foramt),
        	"8:17: " + getCheckMessage(clazz, msgKey, "mPrivate", foramt),
        	"10:16: " + getCheckMessage(clazz, msgKey, "_public", foramt),
        	"11:19: " + getCheckMessage(clazz, msgKey, "_protected", foramt),
        	"12:9: " + getCheckMessage(clazz, msgKey, "_package", foramt),
        	"13:17: " + getCheckMessage(clazz, msgKey, "_private", foramt),
        };
        
        Configuration checkConfig = builder.getCheckConfig("MemberName");
        String filePath = builder.getFilePath("MemberNameInput");
        
        verify(checkConfig, filePath, expected);
    }

    @Test
    public void simpleTest() throws IOException, Exception {
    	
    	Class<TypeNameCheck> clazz = TypeNameCheck.class;
        String msgKey = "name.invalidPattern";
		String format = "^[a-z]{2,}[a-zA-Z0-9]*$";

		final String[] expected = {
            "37:17: " + getCheckMessage(clazz, msgKey, "mNumCreated1", format),
            "39:19: " + getCheckMessage(clazz, msgKey, "mNumCreated2", format),
            "42:19: " + getCheckMessage(clazz, msgKey, "mInts", format),
            "56:9: " + getCheckMessage(clazz, msgKey, "mTest1", format),
            "58:16: " + getCheckMessage(clazz, msgKey, "mTest2", format),
        };
        
        Configuration checkConfig = builder.getCheckConfig("MemberName");
        String filePath = builder.getFilePath("MemberNameInput_Simple");
        
        verify(checkConfig, filePath, expected);
    }
}


