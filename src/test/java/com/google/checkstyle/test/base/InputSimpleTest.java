package com.google.checkstyle.test.base;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.Test;

import com.puppycrawl.tools.checkstyle.ConfigurationLoader;
import com.puppycrawl.tools.checkstyle.PropertiesExpander;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration;

public class InputSimpleTest extends BaseCheckTestSupport{
	
	 /** the underlying Properties object. */
	Properties mProperties;
	
    public Configuration getConfigurationFromXML(String aConfigName, Properties aProps) throws CheckstyleException {
    	try {
            return ConfigurationLoader.loadConfiguration(
            		aConfigName, new PropertiesExpander(aProps));
        }
        catch (final CheckstyleException e) {
            System.out.println("Error loading configuration file");
            e.printStackTrace(System.out);
            System.exit(1);
            return null;
        }
    }

    @Test
    public void emptyTest() throws IOException, Exception {
    	
    	File ROOT = new File("src/");
        System.out.println("Root is set to \"" + ROOT.getAbsolutePath() + "\".");
        
    	Configuration conf = getConfigurationFromXML("checkstyle_google_style.xml", System.getProperties());
    	
    	List<File> files = new ArrayList();
        listFiles(files, ROOT, "java");
        System.out.println("Found " + files.size() + " Java source files.");

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
        	String rootPath = ROOT.getAbsolutePath().substring(0, ROOT.getAbsolutePath().lastIndexOf("src"));
            String path = rootPath + getFilePath(files, "InputFallThrough");
			verify(getCheckConfig(conf, "FallThrough"), path, expected);
        
    }

    private Configuration getCheckConfig(Configuration aConfig, String aCheckName) {
    	for(Configuration config : aConfig.getChildren()) {
    	    if("TreeWalker".equals(config.getName())) {
    	    	for(Configuration checkConfig : config.getChildren()) {
    	    		if (aCheckName.equals(checkConfig.getName())) {
    	    			return checkConfig;
    	    		}
    	    	}
    	    } else if (aCheckName.equals(config.getName())) {
    	    	return config;
    	    }
    	}
        return null;    
    }
    
    private String getFilePath (List<File> aFiles, String aFileName) {
    	for (File file : aFiles) {
    		if (file.toString().contains(aFileName)) {
    			return file.toString();
    		}
    	}
    	return null;
    }
    
    private static void listFiles(final List<File> files, final File folder, final String extension) {
        if (folder.canRead()) {
            if (folder.isDirectory()) {
                for (final File f : folder.listFiles()) {
                    listFiles(files, f, extension);
                }
            } else if (folder.toString().endsWith("." + extension)) {
                files.add(folder);
            }
        }
    }
}


