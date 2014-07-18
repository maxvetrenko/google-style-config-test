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
    	
    	String msg = getCheckMessage(TypeNameCheck.class, "name.invalidPattern", "", "^[a-z]{2,}[a-zA-Z0-9]*$");
        
        final String[] expected = {
        	"5:16: " + getCheckMessage(TypeNameCheck.class, "name.invalidPattern", "mPublic", "^[a-z]{2,}[a-zA-Z0-9]*$"),
        	"6:19: " + getCheckMessage(TypeNameCheck.class, "name.invalidPattern", "mProtected", "^[a-z]{2,}[a-zA-Z0-9]*$"),
        	"7:9: " + getCheckMessage(TypeNameCheck.class, "name.invalidPattern", "mPackage", "^[a-z]{2,}[a-zA-Z0-9]*$"),
        	"8:17: " + getCheckMessage(TypeNameCheck.class, "name.invalidPattern", "mPrivate", "^[a-z]{2,}[a-zA-Z0-9]*$"),
        	"10:16: " + getCheckMessage(TypeNameCheck.class, "name.invalidPattern", "_public", "^[a-z]{2,}[a-zA-Z0-9]*$"),
        	"11:19: " + getCheckMessage(TypeNameCheck.class, "name.invalidPattern", "_protected", "^[a-z]{2,}[a-zA-Z0-9]*$"),
        	"12:9: " + getCheckMessage(TypeNameCheck.class, "name.invalidPattern", "_package", "^[a-z]{2,}[a-zA-Z0-9]*$"),
        	"13:17: " + getCheckMessage(TypeNameCheck.class, "name.invalidPattern", "_private", "^[a-z]{2,}[a-zA-Z0-9]*$"),
        };
        
        Configuration checkConfig = builder.getCheckConfig("MemberName");
        String filePath = builder.getFilePath("MemberNameInput");
        
        verify(checkConfig, filePath, expected);
    }

    @Test
    public void simpleTest() throws IOException, Exception {
    	
    	String msg = getCheckMessage(TypeNameCheck.class, "name.invalidPattern", "", "^[a-z]{2,}[a-zA-Z0-9]*$");
        
        final String[] expected = {
            "37:17: " + getCheckMessage(TypeNameCheck.class, "name.invalidPattern", "mNumCreated1", "^[a-z]{2,}[a-zA-Z0-9]*$"),
            "39:19: " + getCheckMessage(TypeNameCheck.class, "name.invalidPattern", "mNumCreated2", "^[a-z]{2,}[a-zA-Z0-9]*$"),
            "42:19: " + getCheckMessage(TypeNameCheck.class, "name.invalidPattern", "mInts", "^[a-z]{2,}[a-zA-Z0-9]*$"),
            "56:9: " + getCheckMessage(TypeNameCheck.class, "name.invalidPattern", "mTest1", "^[a-z]{2,}[a-zA-Z0-9]*$"),
            "58:16: " + getCheckMessage(TypeNameCheck.class, "name.invalidPattern", "mTest2", "^[a-z]{2,}[a-zA-Z0-9]*$"),
        };
        
        Configuration checkConfig = builder.getCheckConfig("MemberName");
        String filePath = builder.getFilePath("MemberNameInput_Simple");
        
        verify(checkConfig, filePath, expected);
    }
}


