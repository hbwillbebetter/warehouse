package springboot.mybatis.commonMapper.model;

import java.util.Date;

public class Stu {
	private int stuId;
	private String stuName;
	private boolean stuSex;
	private Date stuDate;
	
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public boolean getStuSex() {
		return stuSex;
	}
	public void setStuSex(boolean stuSex) {
		this.stuSex = stuSex;
	}
	public Date getStuDate() {
		return stuDate;
	}
	public void setStuDate(Date stuDate) {
		this.stuDate = stuDate;
	}
	@Override
	public String toString() {
		return "Stu [stuId=" + stuId + ", stuName=" + stuName + ", stuSex="
				+ stuSex + ", stuDate=" + stuDate + "]";
	}
	
	
	
}
