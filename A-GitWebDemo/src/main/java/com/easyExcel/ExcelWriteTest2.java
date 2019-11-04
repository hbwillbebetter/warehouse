package com.easyExcel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.alibaba.excel.support.ExcelTypeEnum;
/**
 * 很多时候，我们在生成Excel的时候都是需要添加表头的，使用easyexcel可以很容易的实现，
 * 我们可以对上面的例子进行简单的改造，为其添加表头
 * @author B
 *
 */
public class ExcelWriteTest2 {

   @Test
   public void writeWithoutHead() throws IOException {
      try (OutputStream out = new FileOutputStream("withHead.xlsx");) {
         ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
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
         List<List<String>> head = new ArrayList<List<String>>();
         List<String> headCoulumn1 = new ArrayList<String>();
         List<String> headCoulumn2 = new ArrayList<String>();
         List<String> headCoulumn3 = new ArrayList<String>();
         headCoulumn1.add("第一列");
         headCoulumn2.add("第二列");
         headCoulumn3.add("第三列");
         head.add(headCoulumn1);
         head.add(headCoulumn2);
         head.add(headCoulumn3);
         Table table = new Table(1);
         table.setHead(head);
         writer.write0(data, sheet1, table);
         writer.finish();
      }
   }
}