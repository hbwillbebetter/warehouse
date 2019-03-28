package com.Listener.file;

import java.io.File;

//事件对象,封装的是文件对象
public class FileEvent {

	private File file;
	
	public FileEvent(){
		
	}
	
	public FileEvent(File file){
		this.file = file;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
}
