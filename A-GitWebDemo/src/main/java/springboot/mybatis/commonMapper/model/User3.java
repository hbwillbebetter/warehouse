package springboot.mybatis.commonMapper.model;

import java.util.Date;

public class User3 {
private int age;
    
    private String pwd;
    
    private String phone;
    
    private Date createTime;

    public User3() {
        super();
    }

    public User3(int age, String pwd, String phone, Date createTime) {
        super();
        this.age = age;
        this.pwd = pwd;
        this.phone = phone;
        this.createTime = createTime;
    }
    
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    
}
