package com.Des3;

/**  
 * Copyright © 2017鼎泰智源科技有限公司. All rights reserved.
 *
 * @Title: AesEncodeUtil.java
 * @Prject: InterfaceWeb
 * @Package: com.fahai.cc.interf.util
 * @Description: TODO
 * @author: Aaron.ye  
 * @date: 2017年8月26日 下午8:51:15
 * @version: V1.0  
 */
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @ClassName: Encrypt3DesUtil
 * @Description: TODO
 * @author: Aaron.ye
 * @date: 2017年8月26日 下午8:51:15
 */
public class Encrypt3DesUtil {

	// 密钥是32位长度的byte[]进行Base64转换后得到的字符串
	public static String key = "ADW231IEOOAC031213ADW231IEOOAC03";

	/**
	 * <li>方法名称:encrypt</li>
	 * <li>加密方法
	 * 
	 * @param xmlStr
	 *            需要加密的消息字符串
	 * @return 加密后的字符串
	 */
	public static String encrypt(String xmlStr) {
		byte[] encrypt = null;

		try {
			// 取需要加密内容的utf-8编码。
			encrypt = xmlStr.getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		// 取密钥和偏转向量
		byte[] key = new byte[24];
		byte[] iv = new byte[8];
		getKeyIV(Encrypt3DesUtil.key, key, iv);
		SecretKeySpec deskey = new SecretKeySpec(key, "DESede");

		IvParameterSpec ivParam = new IvParameterSpec(iv);

		// 使用3DES算法使用加密消息体
		byte[] temp = null;
		try {
			temp = Encrypt3DesUtil.TripleDES_CBC_Encrypt(encrypt, deskey, ivParam);

		} catch (Exception e) {
			e.printStackTrace();
		}

		// 使用Base64加密后返回
		return new BASE64Encoder().encode(temp);
	}

	/**
	 * <li>方法名称:encrypt</li>
	 * <li>功能描述:
	 * 
	 * <pre>
	 * 
	 * 解密方法
	 * </pre>
	 * 
	 * </li>
	 * 
	 * @param xmlStr
	 *            需要解密的消息字符串
	 * @return 解密后的字符串
	 * @throws Exception
	 */
	public static String decrypt(String xmlStr) throws Exception {
		// base64解码
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] encBuf = null;
		try {
			encBuf = decoder.decodeBuffer(xmlStr);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 取密钥和偏转向量
		byte[] key = new byte[24];
		byte[] iv = new byte[8];
		getKeyIV(Encrypt3DesUtil.key, key, iv);

		SecretKeySpec deskey = new SecretKeySpec(key, "DESede");
		IvParameterSpec ivParam = new IvParameterSpec(iv);
		// 使用3DES算法解密

		byte[] temp = null;
		try {

			temp = Encrypt3DesUtil.TripleDES_CBC_Decrypt(encBuf, deskey, ivParam);

		} catch (Exception e) {
			e.printStackTrace();
		}

		// 返回解密后的数组
		return new String(temp, "utf-8");
	}

	/**
	 * <li>方法名称:TripleDES_CBC_Encrypt</li>
	 * <li>功能描述:
	 * 
	 * <pre>
	 *  
	 * 经过封装的三重DES/CBC加密算法，如果包含中文，请注意编码。
	 * </pre>
	 * 
	 * </li>
	 * 
	 * @param sourceBuf
	 *            需要加密内容的字节数组。
	 * @param deskey
	 *            KEY 由24位字节数组通过SecretKeySpec类转换而成。
	 * @param ivParam
	 *            IV偏转向量，由8位字节数组通过IvParameterSpec类转换而成。
	 * @return 加密后的字节数组
	 * @throws Exception
	 */
	public static byte[] TripleDES_CBC_Encrypt(byte[] sourceBuf, SecretKeySpec deskey, IvParameterSpec ivParam)
			throws Exception {
		byte[] cipherByte;
		// 使用DES对称加密算法的CBC模式加密
		Cipher encrypt = Cipher.getInstance("TripleDES/CBC/PKCS5Padding");

		encrypt.init(Cipher.ENCRYPT_MODE, deskey, ivParam);

		cipherByte = encrypt.doFinal(sourceBuf, 0, sourceBuf.length);
		// 返回加密后的字节数组
		return cipherByte;
	}

	/**
	 * <li>方法名称:TripleDES_CBC_Decrypt</li>
	 * <li>功能描述:
	 * 
	 * <pre>
	 * 
	 * 经过封装的三重DES / CBC解密算法
	 * </pre>
	 * 
	 * </li>
	 * 
	 * @param sourceBuf
	 *            需要解密内容的字节数组
	 * @param deskey
	 *            KEY 由24位字节数组通过SecretKeySpec类转换而成。
	 * @param ivParam
	 *            IV偏转向量，由6位字节数组通过IvParameterSpec类转换而成。
	 * @return 解密后的字节数组
	 * @throws Exception
	 */
	public static byte[] TripleDES_CBC_Decrypt(byte[] sourceBuf, SecretKeySpec deskey, IvParameterSpec ivParam)
			throws Exception {

		byte[] cipherByte;
		// 获得Cipher实例，使用CBC模式。
		Cipher decrypt = Cipher.getInstance("TripleDES/CBC/PKCS5Padding");
		// 初始化加密实例，定义为解密功能，并传入密钥，偏转向量
		decrypt.init(Cipher.DECRYPT_MODE, deskey, ivParam);

		cipherByte = decrypt.doFinal(sourceBuf, 0, sourceBuf.length);
		// 返回解密后的字节数组
		return cipherByte;
	}

	/**
	 * <li>方法名称:getKeyIV</li>
	 * <li>功能描述:
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * 
	 * </li>
	 * 
	 * @param encryptKey
	 * @param key
	 * @param iv
	 */
	public static void getKeyIV(String encryptKey, byte[] key, byte[] iv) {
		// 密钥Base64解密
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] buf = null;
		try {
			buf = decoder.decodeBuffer(encryptKey);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 前24位为key
		int i;
		for (i = 0; i < key.length; i++) {
			key[i] = buf[i];
		}
		// 第8位开始取为iv向量
		for (i = 0; i < iv.length; i++) {
			iv[i] = buf[i + 8];
		}
	}

	public static void main(String[] args) {

		String tt = "浙商银行Test%￥1234";
		String qe = encrypt(tt);
		System.out.println("3DES加密后:" + qe);
		try {
			String kj = decrypt(qe);
			System.out.println("3DES解密后:" + kj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

