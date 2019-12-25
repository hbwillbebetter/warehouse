package springboot.mybatis.commonMapper.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

//服务器配置---从配置文件读取
@Component
@PropertySource({"classpath:resource.properties"})
@ConfigurationProperties//①
//@ConfigurationProperties(prefix="test")//②
public class ServerSettings {

	//名称
//	@Value("${name}")//②
	@Value("${test.name}")//①
	private String name;
	
	//域名地址
//	@Value("${domain}")//②
	@Value("${test.domain}")//①
	private String domain;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	@Override
	public String toString() {
		return "ServerSettings [name=" + name + ", domain=" + domain + "]";
	}
	
	
}
