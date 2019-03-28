package com.Listener.file;

import java.io.File;

//事件源
public class MonitorFile {

	private long len;//文件长度
	private File file;//被监控的文件
	
	public MonitorFile(){
		
	}
	public MonitorFile(File file){//监控的文件
		this.file = file;
		this.len = this.file.length();//初始文件的大小
	}
	
	private FileListener fileListener;
	
	//注册事件监听器
	public void registerListener(FileListener fileListener){
		this.fileListener = fileListener;
	}
	
	public void run(){//监控文件
		long listenerFileLen = len;
		if(fileListener != null){
			FileEvent fileEvent = new FileEvent(file);
			listenerFileLen = this.fileListener.listenerFileLen(fileEvent);//监听后文件的长度
			
		}
		if(len == listenerFileLen){
			System.out.println("文件:"+file.getName()+",未发生变化!-----当前长度:"+listenerFileLen+",原长度:"+len);
		}else{
			System.err.println("文件:"+file.getName()+",已发生变化!-----当前长度:"+listenerFileLen+",原长度:"+len);
			len = listenerFileLen;//当发现文件变化后，重置初始值
		}
		
		
	}
	
}
