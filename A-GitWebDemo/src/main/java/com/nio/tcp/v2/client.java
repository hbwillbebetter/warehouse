//客户端代码
package com.nio.tcp.v2;
 
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
 /**
  * https://blog.csdn.net/qq_39169545/article/details/85315948
  * @author B
  *
  */
public class client {
	public static void main(String[] args) throws Exception {
		//0.创建选择器
		Selector selc = Selector.open();
		//1.创建客户端
		SocketChannel sc = SocketChannel.open();
		//2.设置非阻塞模式
		sc.configureBlocking(false);
		//3.连接服务器
		sc.connect(new InetSocketAddress("127.0.0.1",44444));
		//4.连接服务器
		sc.register(selc, SelectionKey.OP_CONNECT);
		
		while(true){
			//5.在注册集合中查询有没有已经就绪的键(大喊一声,谁准备好了),如果没有任何就绪,则阻塞,直到有通道就绪为止,返回就绪的通道的数量
			selc.select();
			//6.获取就绪的键
			Set<SelectionKey> keys = selc.selectedKeys();
			//7.遍历键进行处理
			Iterator<SelectionKey> it = keys.iterator();
			while(it.hasNext()){
				SelectionKey key = it.next();
				if(key.isAcceptable()){
					
				}
				if(key.isConnectable()){
					//--获取当前通道,完成CONNECT操作
					SocketChannel scx = (SocketChannel) key.channel();
					while(!scx.isConnected()){
						scx.finishConnect();
					}
					scx.register(selc, SelectionKey.OP_WRITE);
				}
				if(key.isReadable()){
					
				}
				if(key.isWritable()){
					//--获取当前通道,完成WRITE操作
					SocketChannel scx = (SocketChannel) key.channel();
					ByteBuffer buf = ByteBuffer.wrap("hello nix~".getBytes());
					while(buf.hasRemaining()){
						scx.write(buf);
					}
					//--删除当前注册的键集
					key.cancel();
				}
				//8.删除处理完成键
				it.remove();
			}
		}	
		
	}
}
