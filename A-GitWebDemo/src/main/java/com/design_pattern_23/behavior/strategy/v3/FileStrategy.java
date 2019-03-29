package com.design_pattern_23.behavior.strategy.v3;

import java.io.File;

public interface FileStrategy {

	void readFile(File file);
	
	void writeFile(File file);
}
