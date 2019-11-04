package com.easyExcel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.alibaba.excel.support.ExcelTypeEnum;
/**
 * 除了上面添加表头的方式，我们还可以使用实体类，
 * 为其添加com.alibaba.excel.annotation.ExcelProperty注解来生成表头，实体类数据作为Excel数据
 * @author B
 *
 */
public class ExcelWriteTest3 {

   @Test
   public void writeWithHead() throws IOException {
      try (OutputStream out = new FileOutputStream("withHead.xlsx");) {
         ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
         Sheet sheet1 = new Sheet(1, 0, ExcelPropertyIndexModel.class);
         sheet1.setSheetName("sheet1");
         List<ExcelPropertyIndexModel> data = new ArrayList<>();
         for (int i = 0; i < 100; i++) {
            ExcelPropertyIndexModel item = new ExcelPropertyIndexModel();
            item.name = "name" + i;
            item.age = "age" + i;
            item.email = "email" + i;
            item.address = "address" + i;
            item.sax = "sax" + i;
            item.heigh = "heigh" + i;
            item.last = "last" + i;
            data.add(item);
         }
         writer.write(data, sheet1);
         writer.finish();
      }
   }

   public static class ExcelPropertyIndexModel extends BaseRowModel {

      @ExcelProperty(value = "姓名", index = 0)
      private String name;

      @ExcelProperty(value = "年龄", index = 1)
      private String age;

      @ExcelProperty(value = "邮箱", index = 2)
      private String email;

      @ExcelProperty(value = "地址", index = 3)
      private String address;

      @ExcelProperty(value = "性别", index = 4)
      private String sax;

      @ExcelProperty(value = "高度", index = 5)
      private String heigh;

      @ExcelProperty(value = "备注", index = 6)
      private String last;

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

      public String getEmail() {
         return email;
      }

      public void setEmail(String email) {
         this.email = email;
      }

      public String getAddress() {
         return address;
      }

      public void setAddress(String address) {
         this.address = address;
      }

      public String getSax() {
         return sax;
      }

      public void setSax(String sax) {
         this.sax = sax;
      }

      public String getHeigh() {
         return heigh;
      }

      public void setHeigh(String heigh) {
         this.heigh = heigh;
      }

      public String getLast() {
         return last;
      }

      public void setLast(String last) {
         this.last = last;
      }
   }
}