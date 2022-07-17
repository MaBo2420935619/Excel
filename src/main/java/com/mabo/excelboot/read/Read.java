package com.mabo.excelboot.read;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.excel.util.ListUtils;
import com.mabo.excelboot.entity.DemoData;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Read {
    public static void main(String[] args) {

        String fileName = "writeDemo.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, DemoData.class, new PageReadListener<DemoData>(dataList -> {
            for (DemoData demoData : dataList) {
                System.out.println(demoData.toString());
            }
        })).sheet().doRead();
    }

    private static List data() {
        ArrayList<DemoData> list = ListUtils.newArrayList();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setString("字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }
}
