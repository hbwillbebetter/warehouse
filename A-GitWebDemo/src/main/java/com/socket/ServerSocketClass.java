package com.socket;

import java.net.ServerSocket;

/**
 * https://www.cnblogs.com/xrq730/p/6910719.html
 * 
 * Java支持原生的Socket，我们可以写一段代码来验证一下。首先是一个普通的客户端Socket，模拟向本地的8888端口发起连接：
 * 接着是服务端Socket，监听8888端口，ServerSocket构造函数的第二个参数就是backlog的大小，如果backlog小于1或者不传会给一个默认值50，代码很简单：
 * 先把注释关闭，运行ServerSocketClass，先发起监听，再运行ClientSocketClass，运行结果为：
 *  Client:0
	Client:1
	Client:2
	Client:3
	Client:4
	Exception in thread "main" java.net.ConnectException: Connection refused: connect
	    at java.net.DualStackPlainSocketImpl.connect0(Native Method)
	    at java.net.DualStackPlainSocketImpl.socketConnect(DualStackPlainSocketImpl.java:79)
	    at java.net.AbstractPlainSocketImpl.doConnect(AbstractPlainSocketImpl.java:339)
	    at java.net.AbstractPlainSocketImpl.connectToAddress(AbstractPlainSocketImpl.java:200)
	    at java.net.AbstractPlainSocketImpl.connect(AbstractPlainSocketImpl.java:182)
	    at java.net.PlainSocketImpl.connect(PlainSocketImpl.java:172)
	    at java.net.SocksSocketImpl.connect(SocksSocketImpl.java:392)
	    at java.net.Socket.connect(Socket.java:579)
	    at java.net.Socket.connect(Socket.java:528)
	    at java.net.Socket.<init>(Socket.java:425)
	    at java.net.Socket.<init>(Socket.java:208)
	    at org.xrq.test.socket.ClientSocketClass.main(ClientSocketClass.java:11)
 * 
 *  看到Client只发起了五个请求，第六个请求发起被拒绝了，因为三次握手建立后，前五个请求占据了全连接队列并没有被处理，于是第六个请求进来，全连接队列中没有它的位置了，因此请求被拒绝。

	如果注释打开，又是不一样的效果：
 *  Client:0
	Client:1
	Client:2
	Client:3
	Client:4
	Client:5
	Client:6
	Client:7
	Client:8
	Client:9
	这里所有的十个客户端请求全部被接受，因为accept()方法从全连接队列中取出了连接请求进行处理。看得出来，backlog提供了容量限制功能，避免过多的客户端Socket占据大量的服务端资源。
	
 *
 */
public class ServerSocketClass {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8888, 5);
        
        while (true) {
            // server.accept();
        }
    }
    
}