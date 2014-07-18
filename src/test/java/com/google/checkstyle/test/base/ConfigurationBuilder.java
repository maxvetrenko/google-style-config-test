package com.google.checkstyle.test.base;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.puppycrawl.tools.checkstyle.ConfigurationLoader;
import com.puppycrawl.tools.checkstyle.PropertiesExpander;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration;

public class ConfigurationBuilder extends BaseCheckTestSupport{
	
    private File mROOT;	

    private List<File> mFiles = new ArrayList<File>();
    
    Configuration mConfig;
	
    public ConfigurationBuilder(File aROOT, String aXMLName)
    		throws CheckstyleException {
	    this.mROOT = aROOT;
	    mConfig = getConfigurationFromXML(aXMLName,
	    		System.getProperties());
	    listFiles(mFiles, mROOT, "java");
    }
    
	private Configuration getConfigurationFromXML(String aConfigName,
			Properties aProps) throws CheckstyleException {
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

	 public Configuration getCheckConfig(String aCheckName) {
	    	for(Configuration config : mConfig.getChildren()) {
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

	 public String getFilePath (String aFileName) {
		String absoluteRootPath = mROOT.getAbsolutePath();
		String rootPath = absoluteRootPath.substring(0,
				absoluteRootPath.lastIndexOf("src"));
		for (File file : mFiles) {
			if (file.toString().contains(aFileName)) {
				return rootPath + file.toString();
			}
		}
		return null;
	}

    private static void listFiles(final List<File> files,
    		final File folder, final String extension) {
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
	    
	public File getROOT() {
	    return mROOT;
	}
}
