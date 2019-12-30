package cn.fahai.mybatis.entity;

import java.io.Serializable;
import java.util.Date;

public class Video implements Serializable {
    private Integer id;

    private String title;

    private String summary;

    private String converImg;

    private Integer price;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getConverImg() {
        return converImg;
    }

    public void setConverImg(String converImg) {
        this.converImg = converImg == null ? null : converImg.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}