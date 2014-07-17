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
    	
        
        final String[] expected = {
        	"8:5: " + getCheckMessage(DeclarationOrderCheck.class, "declaration.order.access"),
        	"13:5: " + getCheckMessage(DeclarationOrderCheck.class, "declaration.order.access"),
        	"18:5: " + getCheckMessage(DeclarationOrderCheck.class, "declaration.order.access"),
        	"21:5: " + getCheckMessage(DeclarationOrderCheck.class, "declaration.order.access"),
        	"27:5: " + getCheckMessage(DeclarationOrderCheck.class, "declaration.order.static"),
        	"27:5: " + getCheckMessage(DeclarationOrderCheck.class, "declaration.order.access"),
        	"34:9: " + getCheckMessage(DeclarationOrderCheck.class, "declaration.order.access"),
        	"45:9: " + getCheckMessage(DeclarationOrderCheck.class, "declaration.order.static"),
        	"45:9: " + getCheckMessage(DeclarationOrderCheck.class, "declaration.order.access"),
        	"54:5: " + getCheckMessage(DeclarationOrderCheck.class, "declaration.order.constructor"),
        	
        	"80:5: " + getCheckMessage(DeclarationOrderCheck.class, "declaration.order.instance"),
        	"92:9: " + getCheckMessage(DeclarationOrderCheck.class, "declaration.order.access"),
        	"100:9: " + getCheckMessage(DeclarationOrderCheck.class, "declaration.order.static"),
        	"100:9: " + getCheckMessage(DeclarationOrderCheck.class, "declaration.order.access"),
        	"106:5: " + getCheckMessage(DeclarationOrderCheck.class, "declaration.order.access"),
        	"111:5: " + getCheckMessage(DeclarationOrderCheck.class, "declaration.order.access"),
        	"116:5: " + getCheckMessage(DeclarationOrderCheck.class, "declaration.order.access"),
        	"119:5: " + getCheckMessage(DeclarationOrderCheck.class, "declaration.order.access"),
        	"125:5: " + getCheckMessage(DeclarationOrderCheck.class, "declaration.order.static"),
        	"125:5: " + getCheckMessage(DeclarationOrderCheck.class, "declaration.order.access"),
        	
        	"132:9: " + getCheckMessage(DeclarationOrderCheck.class, "declaration.order.access"),
        	"143:9: " + getCheckMessage(DeclarationOrderCheck.class, "declaration.order.static"),
        	"143:9: " + getCheckMessage(DeclarationOrderCheck.class, "declaration.order.access"),
        	"152:5: " + getCheckMessage(DeclarationOrderCheck.class, "declaration.order.constructor"),
        	"178:5: " + getCheckMessage(DeclarationOrderCheck.class, "declaration.order.instance"),
        	"203:9: " + getCheckMessage(DeclarationOrderCheck.class, "declaration.order.overloads"),
        	"215:9: " + getCheckMessage(DeclarationOrderCheck.class, "declaration.order.overloads"),
        };
        
        Configuration checkConfig = builder.getCheckConfig("DeclarationOrder");
        String filePath = builder.getFilePath("DeclarationOrderInput");
        
        verify(checkConfig, filePath, expected);
    }
}


