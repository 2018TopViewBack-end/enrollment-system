package org.topview.util;

public class RelativePathUtil {

	/**
	 *根据相对路径获得enrollment-system的上级目录
	 * @return
	 */
	public static String getRootPath() {
		//因为类名为"RelativePathUtil"，因此" RelativePathUtil.class"一定能找到
		String result = RelativePathUtil.class.getResource("RelativePathUtil.class").toString();
		int index = result.indexOf("WEB-INF");
		if(index == -1){
			index = result.indexOf("bin");
		}
		result = result.substring(0,index);
		if(result.startsWith("jar")){
			// 当class文件在jar文件中时，返回"jar:file:/F:/ ..."样的路径
			result = result.substring(10);
		}else if(result.startsWith("file")){
			// 当class文件在class文件中时，返回"file:/F:/ ..."样的路径
			result = result.substring(6);
		}
		if(result.endsWith("/"))result = result.substring(0,result.length()-1);//不包含最后的"/"
		index = result.indexOf("enrollment-system");
		result = result.substring(0,index);
		return result;
	}

}
