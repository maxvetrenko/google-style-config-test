package com.google.checkstyle.test.chapter2filebasic.rule21filename;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.checkstyle.test.base.BaseCheckTestSupport;
import com.google.checkstyle.test.base.ConfigurationBuilder;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration;

public class FallThrowTest extends BaseCheckTestSupport{
	
	static ConfigurationBuilder builder;
	
	@BeforeClass
	public static void setConfigurationBuilder() throws CheckstyleException {
		builder = new ConfigurationBuilder(new File("src/"),
				"checkstyle_google_style.xml");
	}
	
    @Test
    public void emptyTest() throws IOException, Exception {
    	
        final String[] expected = {
        		"14:13: Fall through from previous branch of the switch statement.",
        		"38:13: Fall through from previous branch of the switch statement.",
        		"53:13: Fall through from previous branch of the switch statement.",
        		"70:13: Fall through from previous branch of the switch statement.",
        		"87:13: Fall through from previous branch of the switch statement.",
        		"105:13: Fall through from previous branch of the switch statement.",
        		"123:13: Fall through from previous branch of the switch statement.",
        		"369:11: Fall through from previous branch of the switch statement.",
        		"372:11: Fall through from previous branch of the switch statement.",
        		"374:40: Fall through from previous branch of the switch statement.",
        		};
        
		Configuration checkConfig = builder.getCheckConfig("FallThrough");
		String filePath = builder.getFilePath("InputFallThrough");
		
		verify(checkConfig, filePath, expected);
    }
}


