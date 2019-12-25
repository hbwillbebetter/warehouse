package springboot.mybatis.commonMapper.model;

public class Role {
	
	public Role() {
		super();
	}
	public Role(String uid, String rname) {
		super();
		this.uid = uid;
		this.rname = rname;
	}
	private String uid;
	private String rname;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	@Override
	public String toString() {
		return "Role [uid=" + uid + ", rname=" + rname + "]";
	}
	
}
