package com.example.demo.util;

import com.csvreader.CsvWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * 这是把数据转换成csv的工具类
 */
public class CsvUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(CsvUtil.class);

    public static void writeCSV() {
        // 定义一个CSV路径
        String csvFilePath = "/home/binfool/桌面/testFile/write2.csv";
        File file = new File(csvFilePath);
        CsvWriter csvWriter = null;
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            // 创建CSV写对象 例如:CsvWriter(文件路径，分隔符，编码格式);
            csvWriter = new CsvWriter(csvFilePath, ',', Charset.forName("UTF-8"));
            // 写表头
            String[] csvHeaders = { "编号", "姓名", "年龄" };
            csvWriter.writeRecord(csvHeaders);
            // 写内容
            for (int i = 0; i < 20; i++) {
                String[] csvContent = { i + "", "test", "1" + i };
                csvWriter.writeRecord(csvContent);
            }
            System.out.println("--------CSV文件已经写入--------");
        } catch (IOException e) {
            LOGGER.error("{}", e.getStackTrace());
        } finally {
            csvWriter.close();
        }
    }

    public static void main(String[] args) {

        writeCSV();
    }
}
