package com.Des3;
import java.io.File;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

public class ThreeDES_TEST {
    public static void main(String[] args) throws Exception {
        final String key = "ADW231IEOOAC031213ADW231IEOOAC03";
        // 加密流程
        String telePhone = "15629551180";
        ThreeDES threeDES = new ThreeDES();
        String telePhone_encrypt = "";
        telePhone_encrypt = threeDES.encryptThreeDESECB(URLEncoder.encode(telePhone, "UTF-8"), key);
        System.out.println(telePhone_encrypt);// nWRVeJuoCrs8a+Ajn/3S8g==

        // 解密流程
        String tele_decrypt = threeDES.decryptThreeDESECB(telePhone_encrypt, key);
        System.out.println("模拟代码解密:" + tele_decrypt);
    	
    }
    
    @Test
    public void testJiam() throws Exception{
    	final String key = "ADW231IEOOAC031213ADW231IEOOAC03";
        // 加密流程
        String telePhone = FileUtils.readFileToString(new File("H:/浙商银行/a.txt"));
        ThreeDES threeDES = new ThreeDES();
        String telePhone_encrypt = "";
        telePhone_encrypt = threeDES.encryptThreeDESECB(URLEncoder.encode(telePhone, "UTF-8"), key);
        System.out.println(telePhone_encrypt);//w0T8Fh7oyM+m2QNRvRior1gs4QlFKb6BKk7fdGVw7q+U13J/c5zq3w==
    }
    @Test
    public void testJiem() throws Exception{
    	final String key = "ADW231IEOOAC031213ADW231IEOOAC03";
    	String src = "w0T8Fh7oyM+m2QNRvRior1gs4QlFKb6BKk7fdGVw7q+U13J/c5zq3w==";
    	ThreeDES threeDES = new ThreeDES();
    	// 解密流程
    	String tele_decrypt = threeDES.decryptThreeDESECB(src, key);
    	System.out.println("模拟代码解密:\n" + URLDecoder.decode(tele_decrypt, "UTF-8"));
    }
    

}
