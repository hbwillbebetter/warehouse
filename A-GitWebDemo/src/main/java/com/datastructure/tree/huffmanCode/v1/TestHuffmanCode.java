package com.datastructure.tree.huffmanCode.v1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.core.appender.rolling.action.ZipCompressAction;


//霍夫曼编码
public class TestHuffmanCode {
	//用于临时存储路径
	static StringBuilder sb = new StringBuilder();
	//用于存储霍夫曼编码
	static Map<Byte, String> huffCodes = new HashMap<>();
	public static void main(String[] args) {
		String msg="can you can a can as a can canner can a can.";
		byte[] bytes = msg.getBytes();
		//进行霍夫曼编码压缩
		byte[] b = huffmanZip(bytes);
//		System.out.println("压缩前字节数组长度:"+bytes.length);
//		System.out.println("压缩后字节数组长度:"+b.length);
		
		
		
		
		
		
		
		System.out.println();
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
