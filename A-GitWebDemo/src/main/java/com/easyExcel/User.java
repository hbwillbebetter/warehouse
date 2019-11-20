package com.easyExcel;

import java.io.Serializable;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

public class User extends BaseRowModel implements Serializable {
    /**
     * value: 表头名称
     * index: 列的号, 0表示第一列
     *
     */
    /**
     * 入库时间
     */

    @ExcelProperty(value = "姓名", index = 0)
    private String name;
    /**
     * 供应商
     */
    @ExcelProperty(value = "年龄", index = 1)
    private String age;
    /**
     * 纸筒编号
     */
    @ExcelProperty(value = "性别", index = 2)
    private String sex;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
    
    
 
}
