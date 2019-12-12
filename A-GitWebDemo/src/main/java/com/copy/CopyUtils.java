package com.copy;

import org.junit.Test;

public class CopyUtils {
	
	@Test
	public void test_System_arraycopy(){
		
		int services[] = new int[1];
		services[0] = 1;
		int results[] = new int[services.length + 1];
		// copy 旧的服务到新的数组中
		System.arraycopy(services, 0, results, 0, services.length);
		// 添加新的 service
        results[services.length] = 2;
        services = results;
		System.out.println("ok");
		
		
	}

}
