package com.fiverings.homeworkweb.listener;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.fiverings.homeworkweb.global.FileRootUtil;


@WebListener
public class FileRootLoadListener implements ServletContextListener {


    public FileRootLoadListener() {
        
    }


    public void contextDestroyed(ServletContextEvent arg0)  { 
        
    }

	
    public void contextInitialized(ServletContextEvent arg0) {
    	Properties prop = new Properties();   
    	InputStream is = this.getClass().getClassLoader().getResourceAsStream("fileLocation.properties");
    	
    	try {
			prop.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String fileRoot = prop.getProperty("file.root");
    	
        FileRootUtil.setFileRoot(fileRoot);
    }
	
}
