package com.Jar.v1;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.apache.log4j.Logger;

import com.util.ExceptionUtils;


public class TestReadJar {
	private static Logger log = Logger.getLogger(TestReadJar.class);
	public static void main(String[] args) throws IOException {
		isJar();
		String jarPath = "E:\\run-jar\\a_newJarDir\\psbc.jar";
		readJarfile(jarPath);
		try {
			Properties prop = new Properties();
			jarPath = java.net.URLDecoder.decode(jarPath, "UTF-8");
			log.info("jarPath:"+jarPath);
			// 路径拼接
			URL url = new URL("jar:file:" + jarPath + "!/" + "resources/zmn/master.properties");
			log.info("url:"+url.toString());
			JarURLConnection jarConnection = (JarURLConnection) url.openConnection();
			// 标准输入流
			InputStream in = jarConnection.getInputStream();
			prop.load(in);
			log.info("加载成功");
		} catch (Exception e) {
			log.info("加载失败:\n"+ExceptionUtils.getExceptionAllinformation_02(e));
			e.printStackTrace();
		}
	}
	
	public static void readJarfile(String jarPath) throws IOException{
		JarFile jarFile = new JarFile(new File(jarPath));
		Enumeration<JarEntry> entries = jarFile.entries();

		while (entries.hasMoreElements()) {

			JarEntry entry = entries.nextElement();
			String entryName = entry.getName();
			// 读取文件后缀名为.java的文件
			if (!entry.isDirectory() && entryName.endsWith(".java")) {

				// 读取操作。。。。。。

			}

		}
	}
	
	/**
	 * 
	 * @param isJar	jar执行:true,class执行:false
	 * @param fileName	"./" + "zmn" + File.separator + "master.properties"
	 * @return
	 */
	public static Properties readProp(boolean isJar, String fileName) {
		Properties props = new Properties();
		InputStream in = null;
		log.info("0:"+fileName);
		try {
			if(!isJar){
				in = TestReadJar.class.getClassLoader().getResourceAsStream(fileName);
			}else{
				in = getJarInputStream(fileName);
			}
			InputStreamReader isr = new InputStreamReader(in, "UTF-8");
			props.load(isr);
			Enumeration en = props.propertyNames();
			while (en.hasMoreElements()) {
				String key = (String) en.nextElement();
				String value = props.getProperty(key).trim();
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("读取配置文件异常:\n"+ExceptionUtils.getExceptionAllinformation_02(e));
		}
		return props;
	}
	
	/**
	 * 获取jar包输入流
	 * @param fileName
	 * @return
	 */
	public static InputStream getJarInputStream(String fileName){
		InputStream in = null;
		try {
			//处理jar包内的文件名
			if (fileName.startsWith("./")) {
				fileName = fileName.substring(2);//去掉./
				log.info("1:"+fileName);
			}
			fileName = fileName.replaceAll("\\\\", "/");
			log.info("2:"+fileName);
			String jarPath = new TestReadJar().getClass().getProtectionDomain().getCodeSource().getLocation().getFile();
			URL url = new URL("jar:file:" + jarPath + "!/" + "resources/"+fileName);
			JarURLConnection jarConnection = (JarURLConnection) url.openConnection();
			// 标准输入流
			in = jarConnection.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
			log.error("处理文件:"+fileName+",获取jar的InputStream异常:\n"+ExceptionUtils.getExceptionAllinformation_02(e));
		}
		return in;
	}

	public static boolean isJar(){
		boolean isJar = false;
		//判断程序执行是否是jar执行
		String filePath = TestReadJar.class.getResource("TestReadJar.class").toString();
		//jar:file:/E:/run-jar/a_newJarDir/psbc.jar!/com/fahai/export/DataParser.class
		//file:/C:/java/eclipse-kepler-workspace/A-fahai-report-PSBC/target/classes/com/fahai/export/DataParser.class
		//true:jar文件启动
		//false:class文件启动
		isJar = filePath.startsWith("jar:file");
		if (isJar) {
			log.info("程序是jar文件启动！！！");
		}else{
			log.info("程序是class文件启动！！！");
		}
		return isJar;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}









