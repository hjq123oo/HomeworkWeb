package com.fiverings.homeworkweb.global;

public class FileRootUtil {
	private static String fileRoot=null;
	private static String fileTemp=null;
	
	public static String getFileRoot() {
		return fileRoot;
	}

	public static String getFileTemp() {
		return fileTemp;
	}

	public static void setFileTemp(String fileTemp) {
		FileRootUtil.fileTemp = fileTemp;
	}

	public static void setFileRoot(String fileRoot) {
		FileRootUtil.fileRoot = fileRoot;
	}
	
}
