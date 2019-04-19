package com.Des3;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.io.FileUtils;

public class Test {
	public static void main(String[] args) throws Exception {
//		String src = FileUtils.readFileToString(new File("H:/浙商银行/A_20181119_CUSTLIST.txt"));
		String src = FileUtils.readFileToString(new File("H:/浙商银行/GI_20190417_CUSTLIST.txt"));
		String res = Encrypt3DesUtil.decrypt(src);
		String[] arr = res.split("\n");
		Set<String> set = new HashSet<String>(Arrays.asList(arr));
		System.out.println(res);
	}
//	public static void main(String[] args) throws Exception {
//		String src = FileUtils.readFileToString(new File("H:/浙商银行/哈哈哈.txt"));
//		String[] arr = src.split("\n");
//		Set<String> set = new HashSet<String>(Arrays.asList(arr));
//		System.out.println();
//	}
}
