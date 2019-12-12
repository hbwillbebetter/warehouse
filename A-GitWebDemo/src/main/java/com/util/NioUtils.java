package com.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

import org.junit.Test;

public class NioUtils {
	
	/**
	 * NIO文件复制
	 * @throws IOException
	 */
	@Test
	public void test_NIO_Copy() throws IOException{
		String copy_file = "copy_a.txt";
		String file = "a.txt";
		//写文件通道
		FileOutputStream outputStream = new FileOutputStream(new File(copy_file));
		FileChannel wChannel = outputStream.getChannel();
		
		//读文件通道
		FileInputStream inputStream = new FileInputStream(new File(file));
		FileChannel rChannel = inputStream.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		while(rChannel.read(buffer) != -1){//文件内容从通道读取，然后写入缓冲区
			buffer.flip();//将buffer写模式改为读模式
			while(buffer.hasRemaining()){
				wChannel.write(buffer);//从缓冲区读取数据，写入通道
			}
			buffer.clear();//清空buffer，以便下一次读
			wChannel.close();
		}
		rChannel.close();
		System.out.println("ol");
		
		
		
	}
	
	@Test
	public void test_Scattering_Gathering() throws IOException{
		String path="b.txt";
		//聚集写
		ByteBuffer buffer1 = ByteBuffer.wrap("java是最棒的工具".getBytes(Charset.forName("UTF-8")));
		ByteBuffer buffer2 = ByteBuffer.wrap("像风一样".getBytes(Charset.forName("UTF-8")));
		//记录数据长度
		int len1 = buffer1.limit();
		int len2 = buffer2.limit();
		ByteBuffer[] byteBuffers = new ByteBuffer[]{buffer1,buffer2};
		FileOutputStream outputStream = new FileOutputStream(new File(path));
		FileChannel wchannel = outputStream.getChannel();
		wchannel.write(byteBuffers);
		wchannel.close();
		
		//散射读
		buffer1 = ByteBuffer.allocate(len1);
		buffer2 = ByteBuffer.allocate(len2);
		byteBuffers = new ByteBuffer[]{buffer1,buffer2};
		//获取通道
		FileInputStream inputStream =  new FileInputStream(new File(path));
		FileChannel rchannel = inputStream.getChannel();
		MappedByteBuffer map = rchannel.map(FileChannel.MapMode.READ_ONLY, 0, len1);
//		ByteBuffer asReadOnlyBuffer = map.asReadOnlyBuffer();
//		if (!rchannel.isOpen()) {
//			System.out.println("当前channel是关闭的");
//			rchannel = FileChannel.open(Paths.get(path), StandardOpenOption.READ);
//		}
		rchannel.read(byteBuffers);
		//读取
		System.out.println(new String(byteBuffers[0].array(),"UTF-8"));
		System.out.println(new String(byteBuffers[1].array(),"UTF-8"));
		rchannel.close();
		
		
	}
	
	/**
	 * 传统IO流实现文件复制
	 * @throws IOException
	 */
    @Test
    public void test_chuantongIO() throws IOException {
    	String path_copy = "copy_a.txt";
		String path = "a.txt";
        //缓冲输出流
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(path_copy)));
        //缓冲输入流
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(path)));
        byte[] bytes = new byte[1024];
        while (bufferedInputStream.read(bytes) != -1) {
            bufferedOutputStream.write(bytes);
        }
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
