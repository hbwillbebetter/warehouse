package com.Des3;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Test {
	public static void main(String[] args) throws Exception {
		String src = FileUtils.readFileToString(new File("H:/浙商银行/A_20181119_CUSTLIST.txt"));
		String res = Encrypt3DesUtil.decrypt(src);
		System.out.println(res);
		
	}
}
