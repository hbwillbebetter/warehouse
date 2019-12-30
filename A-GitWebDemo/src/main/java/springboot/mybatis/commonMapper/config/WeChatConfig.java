package springboot.mybatis.commonMapper.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class WeChatConfig {

	
	@Value("wx5beac15ca207cdd40c")
	private String appId;
	
	/**
	 * 公众号秘钥
	 */
	@Value("${wxpay.appsecret}")
	private String appsecret;
	
	@Value("${wxopen.appid}")
	private String openAppid;
	
	@Value("${wxopen.appsecret}")
	private String openAppsecret;
	
	@Value("${wxopen.redirect_url}")
	private String openRedirectUrl;
	
	private final static String OPEN_QRCODE_URL= "https://open.weixin.qq.com/connect/qrconnect?appid=%s&redirect_uri=%s&response_type=code&scope=snsapi_login&state=%s#wechat_redirect";
	
	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppsecret() {
		return appsecret;
	}

	public void setAppsecret(String appsecret) {
		this.appsecret = appsecret;
	}

	public String getOpenAppid() {
		return openAppid;
	}

	public void setOpenAppid(String openAppid) {
		this.openAppid = openAppid;
	}

	public String getOpenAppsecret() {
		return openAppsecret;
	}

	public void setOpenAppsecret(String openAppsecret) {
		this.openAppsecret = openAppsecret;
	}

	public String getOpenRedirectUrl() {
		return openRedirectUrl;
	}

	public void setOpenRedirectUrl(String openRedirectUrl) {
		this.openRedirectUrl = openRedirectUrl;
	}

	public static String getOpenQrcodeUrl() {
		return OPEN_QRCODE_URL;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
