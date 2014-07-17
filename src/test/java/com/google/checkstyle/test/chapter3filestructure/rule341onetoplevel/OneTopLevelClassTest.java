package com.google.checkstyle.test.chapter3filestructure.rule341onetoplevel;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.checkstyle.test.base.BaseCheckTestSupport;
import com.google.checkstyle.test.base.ConfigurationBuilder;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration;
import com.puppycrawl.tools.checkstyle.checks.design.OneTopLevelClassCheck;

public class OneTopLevelClassTest extends BaseCheckTestSupport{
    
    static ConfigurationBuilder builder;
    
    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException {
        builder = new ConfigurationBuilder(new File("src/"),
                "checkstyle_google_style.xml");
    }

    @Test
    public void emptyTest() throws IOException, Exception {
    	
        
        final String[] expected = {
        	"25: " + getCheckMessage(OneTopLevelClassCheck.class, "one.top.level.class", "NoSuperClone"),
        	"33: " + getCheckMessage(OneTopLevelClassCheck.class, "one.top.level.class", "InnerClone"),
        	"50: " + getCheckMessage(OneTopLevelClassCheck.class, "one.top.level.class", "CloneWithTypeArguments"),
        	"55: " + getCheckMessage(OneTopLevelClassCheck.class, "one.top.level.class", "CloneWithTypeArgumentsAndNoSuper"),
        	"60: " + getCheckMessage(OneTopLevelClassCheck.class, "one.top.level.class", "MyClassWithGenericSuperMethod"),
        	"77: " + getCheckMessage(OneTopLevelClassCheck.class, "one.top.level.class", "AnotherClass"),
        };
        
        Configuration checkConfig = builder.getCheckConfig("OneTopLevelClass");
        String filePath = builder.getFilePath("OneTopLevelClassInput");
        
        verify(checkConfig, filePath, expected);
    }
}


