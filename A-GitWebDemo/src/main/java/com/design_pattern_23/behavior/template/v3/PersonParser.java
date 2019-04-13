package com.design_pattern_23.behavior.template.v3;

import com.design_pattern_23.behavior.template.v3.enumType.EnvType;

public abstract class PersonParser extends DataParser {

	@Override
	protected void readConf(EnvType type) {
		EnvType envType = type;
		if (envType == EnvType.DEV) {
			System.out.println(""+envType);
		}else if(envType == EnvType.TEST){
			System.out.println(""+envType);
		}else if(envType == EnvType.PROD){
			System.out.println(""+envType);
		}else{
//			System.out.println(""+envType);
		}
	}
	
}
