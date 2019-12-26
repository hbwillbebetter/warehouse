package springboot.mybatis.commonMapper.model;

//新建异常类，继承RuntimeException运行时异常最高类。这里一定要继承RuntimeException
public class MyException extends RuntimeException {
	private String code;
	private String msg;

	public MyException() {
		super();
	}
	public MyException(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
