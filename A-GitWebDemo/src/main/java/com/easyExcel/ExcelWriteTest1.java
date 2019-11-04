package com.easyExcel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;

/**
 * https://blog.csdn.net/jianggujin/article/details/80200400#commentBox
 * 首先，我们先来看看如何写Excel，写入Excel，我们可以通过com.alibaba.excel.ExcelWriter类实现，
 * 下面我们来看一下最简单的无表头的实现
 * @author B
 *
 */
public class ExcelWriteTest1 {

   /**
    * 每行数据是List<String>无表头
    * 
    * @throws IOException
    */
   @Test
   public void writeWithoutHead() throws IOException {
      try (OutputStream out = new FileOutputStream("withoutHead.xlsx");) {
         ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, false);
         Sheet sheet1 = new Sheet(1, 0);
         sheet1.setSheetName("sheet1");
         List<List<String>> data = new ArrayList<>();
         for (int i = 0; i < 100; i++) {
            List<String> item = new ArrayList<>();
            item.add("item0" + i);
            item.add("item1" + i);
            item.add("item2" + i);
            data.add(item);
         }
         writer.write0(data, sheet1);
         writer.finish();
      }
   }
}