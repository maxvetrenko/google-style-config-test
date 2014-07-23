package com.google.checkstyle.test.chapter3filestructure.rule3421overloadsplit;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.checkstyle.test.base.BaseCheckTestSupport;
import com.google.checkstyle.test.base.ConfigurationBuilder;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration;
import com.puppycrawl.tools.checkstyle.checks.coding.DeclarationOrderCheck;
import com.puppycrawl.tools.checkstyle.checks.design.OneTopLevelClassCheck;

public class DeclarationOrderTest extends BaseCheckTestSupport{
    
    static ConfigurationBuilder builder;
    
    @BeforeClass
    public static void setConfigurationBuilder() throws CheckstyleException {
        builder = new ConfigurationBuilder(new File("src/"),
                "checkstyle_google_style.xml");
    }

    @Test
    public void emptyTest() throws IOException, Exception {
    	
        
        Class<DeclarationOrderCheck> clazz = DeclarationOrderCheck.class;

		String msgAccess = getCheckMessage(clazz, "declaration.order.access");
		String msgStatic = getCheckMessage(clazz, "declaration.order.static");
		String msgCtor = getCheckMessage(clazz, "declaration.order.constructor");
		String msgInstance = getCheckMessage(clazz, "declaration.order.instance");
		String msgOverloads = getCheckMessage(clazz, "declaration.order.overloads");

		final String[] expected = {
        	"8:5: " + msgAccess,
        	"13:5: " + msgAccess,
        	"18:5: " + msgAccess,
        	"21:5: " + msgAccess,
        	"27:5: " + msgStatic,
        	"27:5: " + msgAccess,
        	"34:9: " + msgAccess,
        	"45:9: " + msgStatic,
        	"45:9: " + msgAccess,
        	"54:5: " + msgCtor,
        	
        	"80:5: " + msgInstance,
        	"92:9: " + msgAccess,
        	"100:9: " + msgStatic,
        	"100:9: " + msgAccess,
        	"106:5: " + msgAccess,
        	"111:5: " + msgAccess,
        	"116:5: " + msgAccess,
        	"119:5: " + msgAccess,
        	"125:5: " + msgStatic,
        	"125:5: " + msgAccess,
        	
        	"132:9: " + msgAccess,
        	"143:9: " + msgStatic,
        	"143:9: " + msgAccess,
        	"152:5: " + msgCtor,
        	"178:5: " + msgInstance,
        	"203:9: " + msgOverloads,
        	"215:9: " + msgOverloads,
        };
        
        Configuration checkConfig = builder.getCheckConfig("DeclarationOrder");
        String filePath = builder.getFilePath("DeclarationOrderInput");
        
        verify(checkConfig, filePath, expected);
    }
}


