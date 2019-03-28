package com.Listener.file;

import java.io.File;

public class MyFileListener implements FileListener {

	@Override
	public long listenerFileLen(FileEvent fileEvent) {//监听文件的长度
		File file = fileEvent.getFile();
		System.out.println("监听中...文件长度:"+file.length());
		return file.length();
	}

}
