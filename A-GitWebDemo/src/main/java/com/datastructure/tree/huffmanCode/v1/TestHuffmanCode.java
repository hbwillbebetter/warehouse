package com.datastructure.tree.huffmanCode.v1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipFile;


//霍夫曼编码
public class TestHuffmanCode {
	//用于临时存储路径
	static StringBuilder sb = new StringBuilder();
	//用于存储霍夫曼编码
	static Map<Byte, String> huffCodes = new HashMap<>();
	public static void main(String[] args) {
//		strZipAndUnzip();
		String src = "img/1.bmp";
		String dst = "img/2.zip";
		try {
//			zipFile(src,dst);
			unZip(dst,"img/3.bmp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void unZip(String src, String dst) throws Exception {
		//创建一个输入流
		InputStream is = new FileInputStream(src);
		//因为压缩的时候，以对象流的形式压缩，那么读的时候，也以对象流的形式读取
		ObjectInputStream ois = new ObjectInputStream(is);
		//对象流的读取，和对象流之前的写入顺序要一致
		//读取byte数组
		byte[] b = (byte[]) ois.readObject();
		//读取霍夫曼编码表
		Map<Byte, String> codes = (Map<Byte, String>) ois.readObject();
		ois.close();
		is.close();
		//使用霍夫曼进行解码
		byte[] bytes = decode(codes, b);
		//创建一个输出流
		OutputStream os = new FileOutputStream(dst);
		//写出数据
		os.write(bytes);
		os.close();
	}

	/**
	 * 压缩文件
	 * @param src
	 * @param dst
	 * @throws IOException
	 */
	private static void zipFile(String src, String dst) throws IOException {
		//创建一个输入流
		InputStream is = new FileInputStream(src);
		//创建一个和输入流指向的文件大小一样的byte数组
		byte[] b = new byte[is.available()];
		//读取文件内容
		is.read(b);
		is.close();
		//使用霍夫曼编码进行编码
		byte[] byteZip = huffmanZip(b);
		//输出流
		OutputStream os = new FileOutputStream(dst);
		ObjectOutputStream oos = new ObjectOutputStream(os);
		//把压缩后的byte数组写入文件
		oos.writeObject(byteZip);
		//把霍夫曼编码表写入文件
		oos.writeObject(huffCodes);
		oos.close();
		os.close();
	}

	/**
	 * 字符串采用霍夫曼编码压缩、解压---能看到数据得到压缩
	 */
	public static void strZipAndUnzip(){
		String msg="can you can a can as a can canner can a can.";
		byte[] bytes = msg.getBytes();
		//进行霍夫曼编码压缩
		byte[] b = huffmanZip(bytes);
//		System.out.println("压缩前字节数组长度:"+bytes.length);
//		System.out.println("压缩后字节数组长度:"+b.length);
		//使用霍夫曼编码进行解码
		byte[] newBytes = decode(huffCodes,b);
		System.out.println(new String(newBytes));
	}
	
	/**
	 * 使用指定的霍夫曼编码表进行解码
	 * @param huffCodes2
	 * @param b
	 * @return
	 */
	private static byte[] decode(Map<Byte, String> huffCodes, byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		//把byte数组转为一个二进制字符串
		for(int i=0; i<bytes.length; i++){//因为bytes最后一个很特殊，有可能不满足上面的8位，需要特殊处理
			byte b = bytes[i];
			//是否是最后一个
			boolean flag = (i == bytes.length - 1);
			sb.append(byteToBitStr(!flag,b));
		}
		//把字符串按照指定的霍夫曼编码进行解码
		//把霍夫曼编码的键值进行调换
		Map<String, Byte> map = new HashMap<>();
		for(Map.Entry<Byte, String> entry : huffCodes.entrySet()){
			map.put(entry.getValue(), entry.getKey());
		}
		//创建一个集合，用于存储解码后的byte
		List<Byte> list = new ArrayList<>();
		//处理字符串
		for(int i=0; i<sb.length();){//11101001011010011011011001010111010010011011101001001110011100110111010010111010000110101110001011101001001101110100110111
			int count = 1;
			boolean flag = true;
			Byte b = null;
			//截取出一个byte
			while (flag) {
				String key = sb.substring(i, i+count);
				b = map.get(key);
				if (b == null) {
					count++;
				}else {
					flag = false;
				}
			}
			list.add(b);
			i+=count;
		}
		//把集合转为数组
		byte[] b = new byte[list.size()];
		for(int i=0; i<list.size();i++){
			b[i] = list.get(i);
		}
		return b;
	}
	
	/**
	 * byte转二进制字符串
	 * @param flag
	 * @param b
	 * @return
	 */
	private static String byteToBitStr(boolean flag, byte b) {
		int temp = b;
		if(flag){//不是最后一个byte的处理
			temp|=256;
		}
		String str = Integer.toBinaryString(temp);
		if(flag){//非最后一个byte处理
			return str.substring(str.length()-8);
		}else{
			return str;
		}
	}

	/**
	 * 进行霍夫曼编码压缩的方法
	 * @param bytes
	 * @return
	 */
	private static byte[] huffmanZip(byte[] bytes) {
		//先统计每一个byte出现的次数，并放入到一个集合中
		List<Node> nodes = getNodes(bytes);
//		System.out.println(nodes.toString());
		//创建一颗霍夫曼树
		Node tree = createHuffmanTree(nodes);
//		System.out.println(tree);
		//根据创建的霍夫曼树，创建一个霍夫曼编码表---如(97->01,101->110101)
		Map<Byte, String> huffCodes = getCodes(tree);
		//依据编码表，进行编码---此过程称之为压缩
		byte[] b = zip(bytes, huffCodes);
		return b;
	}
	/**
	 * 依据编码表，进行霍夫曼编码
	 * @param bytes
	 * @param huffCodes2
	 * @return
	 */
	private static byte[] zip(byte[] bytes, Map<Byte, String> huffCodes) {
		StringBuilder sb = new  StringBuilder();
		//把需要压缩的byte数组处理成一个二进制字符串
		for(byte b : bytes){
			sb.append(huffCodes.get(b));
		}
		//定义长度
		int len;
		if(sb.length()%8==0){
			len = sb.length()/8;
		}else {
			len = sb.length()/8 + 1;
		}
		//用于存储压缩后的byte
		byte[] by = new byte[len];
		//记录新byte的位置
		int index = 0;
		for(int i=0; i<sb.length(); i+=8){
			String strByte;
			if(i+8 > sb.length()){
				strByte = sb.substring(i);
			}else {
				strByte = sb.substring(i, i+8);
			}
			byte byt = (byte) Integer.parseInt(strByte, 2);
			by[index] = byt;
			index++;
		}
		return by;
	}

	/**
	 * 根据赫夫曼树获取赫夫曼编码
	 * @param tree
	 * @return
	 */
	private static Map<Byte, String> getCodes(Node tree) {
		if (tree == null) {
			return null;
		}
		//对根的左边进行编码
		getCodes(tree.left, "0", sb);
		//对根的右边进行编码
		getCodes(tree.right, "1", sb);
		
		return huffCodes;
	}
	
	private static void getCodes(Node node, String code, StringBuilder sb) {
		StringBuilder sb2 = new StringBuilder(sb);
		sb2.append(code);
		//非叶子节点，记录路径
		if(node.data == null){
			getCodes(node.left, "0", sb2);
			getCodes(node.right, "1", sb2);
		}else {
			//叶子节点，将路径存储到编码表
			huffCodes.put(node.data, sb2.toString());
		}
		
	}

	/**
	 * 创建霍夫曼树
	 * @param nodes
	 * @return
	 */
	private static Node createHuffmanTree(List<Node> nodes) {
		//霍夫曼树创建成功后，仅有一个节点
		while(nodes.size() > 1){//当集合中节点的数量多于1,不断地调整
			//排序
			Collections.sort(nodes);
//			System.out.println(nodes);
			//取出权值最低的二叉树
			Node left = nodes.get(nodes.size() - 1);
			Node right = nodes.get(nodes.size() - 2);
			//创建一个新二叉树
			Node parent = new Node(null, left.weight + right.weight);
			//把之前取出来的两颗二叉树设置为新创建的二叉树的子树
			parent.left = left;
			parent.right = right;
			//把前面取出的两颗二叉树删除
			nodes.remove(left);
			nodes.remove(right);
			//把新创建的二叉树放入集合中
			nodes.add(parent);
		}
		return nodes.get(0);
	}

	/**
	 * 把byte数组转为node集合
	 * @param bytes
	 * @return
	 */
	private static List<Node> getNodes(byte[] bytes) {
		//存储所有的节点
		List<Node> codes = new ArrayList<>();
		//存储每一个byte出现了多少次
		Map<Byte, Integer> counts = new HashMap<>();
		//统计每一个byte出现的次数
		for(byte b : bytes){
			if (counts.get(b) == null) {
				counts.put(b, 1);
			}else{
				counts.put(b, counts.get(b)+1);
			}
		}
		//遍历map---把每一个键值对转换为一个node对象
		for(Map.Entry<Byte, Integer> entry : counts.entrySet()){
			codes.add(new Node(entry.getKey(), entry.getValue()));
		}
		return codes;
	}

}
