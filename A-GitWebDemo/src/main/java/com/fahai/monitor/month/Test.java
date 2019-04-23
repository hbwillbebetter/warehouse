package com.fahai.monitor.month;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.util.HttpUtil;
import com.util.HttpUtils;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class Test {
	private static Logger log = Logger.getLogger(Test.class);
    public static void main(String[] args) {

        Map<String, Object> argsMap = Maps.newHashMap();
        String openId = "f154c7860e4111e9840a000c29b8f523";
        argsMap.put("openId", openId);
        argsMap.put("quantity", 123);
        argsMap.put("addQuantity", 123);
        argsMap.put("description", "666");
        argsMap.put("feeItemNo", "J001");
        String systemId = "bank";
        String rt = String.valueOf(System.currentTimeMillis());

        String SIGN_KEY = "jbp_789";
        String sign = MD5(systemId + rt + openId+ SIGN_KEY);

        String json = JSON.toJSONString(argsMap);
        try {
            json = URLEncoder.encode(json,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String url = "http://192.168.6.31:8282/api/consume/consume?systemId="+systemId+"&rt="+rt+"&sign="+sign+"&args="+json;
        log.info(url);
        
        Map<String, Object> retMap = HttpUtils.URLPost(url, new HashMap<String,String>(), "UTF-8");
        if(retMap.size() != 0){
        	for(Map.Entry<String, Object> en : retMap.entrySet()){
        		log.info(en.getKey()+"---"+en.getValue());
        	}
        }
        
        //byte[] b = HttpUtil.doGet(url);
        //log.info("-------------------"+new String(b));
        
    }

    private static String MD5(String source) {
        if (StringUtils.isEmpty(source)) {
            return "";
        }
        return DigestUtils.md5Hex(source);
    }
}
