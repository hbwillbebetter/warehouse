package com.Listener.file;

import java.io.File;

public class TestFileMain {

	public static void main(String[] args) throws InterruptedException {
		MonitorFile changeFile = new MonitorFile(new File("./a.txt"));
		changeFile.registerListener(new MyFileListener());
		while(true){
			changeFile.run();
			Thread.sleep(1000);
		}
	}

}
