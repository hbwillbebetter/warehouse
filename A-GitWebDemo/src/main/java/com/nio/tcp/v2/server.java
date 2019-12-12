//服务端代码
package com.nio.tcp.v2;
 
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
 
public class server {
	public static void main(String[] args) throws Exception {
		//0.创建选择器,选择器要唯一
		Selector selc = Selector.open();
		
		//1.创建ssc
		ServerSocketChannel ssc = ServerSocketChannel.open();
		//2.开启非阻塞模式
		ssc.configureBlocking(false);
		//3.绑定指定端口
		ssc.bind(new InetSocketAddress(44444));
		//4.等待客户端连接
		ssc.register(selc, SelectionKey.OP_ACCEPT);
		
		while(true){
			//5.在注册集合中查询有没有已经就绪的键(大喊一声,谁准备好了),如果没有任何就绪,则阻塞,直到有通道就绪为止,返回就绪的通道的数量
			selc.select();
			
			//6.获取就绪的键
			Set<SelectionKey> keys = selc.selectedKeys();
			
			//7.遍历就绪的键 依次处理
			Iterator<SelectionKey> it = keys.iterator();
			while(it.hasNext()){
				SelectionKey key = it.next();
				if(key.isAcceptable()){
					//--获取当前通道,完成ACCEPT操作
					ServerSocketChannel sscx = (ServerSocketChannel) key.channel();
					SocketChannel sc = null;
					while(sc==null){
						sc = sscx.accept();
					}
					//--设置非阻塞模式
					sc.configureBlocking(false);
					//--在选择器中注册读取数据操作
					sc.register(selc, SelectionKey.OP_READ);
				}
				if(key.isConnectable()){
					
				}
				if(key.isReadable()){
					//--获取当前通道,完成READ操作
					SocketChannel sc = (SocketChannel) key.channel();
					ByteBuffer buf = ByteBuffer.allocate(10);
					while(buf.hasRemaining()){
						sc.read(buf);
					}
					System.out.println("SSC收到消息:"+new String(buf.array()));
				}
				if(key.isWritable()){
					
				}
				//8.删除处理完成的键
				it.remove();
			}
		}
		
	}
}
