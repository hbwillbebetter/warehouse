package com.util;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionUtils {
	/**
	 * 下面的三个方法都是获取异常的详细信息，或许的异常详细信息以字符串的形式返回，保持栈堆载的风格
	 * @param ex
	 * @return
	 */
	//方法一：
	public static String getExceptionAllinformation_01(Exception ex){
	        String sOut = "";
	        StackTraceElement[] trace = ex.getStackTrace();
	        for (StackTraceElement s : trace) {
	            sOut += "\tat " + s + "\r\n";
	        }
	        return sOut;
	 }

	//方法二：
	 public static String getExceptionAllinformation_02(Exception ex) {
	         ByteArrayOutputStream out = new ByteArrayOutputStream();
	         PrintStream pout = new PrintStream(out);
	         ex.printStackTrace(pout);
	         String ret = new String(out.toByteArray());
	         pout.close();
	         try {
	              out.close();
	         } catch (Exception e) {
	         }
	         return ret;
	 }

	//方法三：
    private static String toString_03(Throwable e){   
            StringWriter sw = new StringWriter();   
            PrintWriter pw = new PrintWriter(sw, true);   
            e.printStackTrace(pw);   
            pw.flush();   
            sw.flush();   
            return sw.toString();   
    } 
}
