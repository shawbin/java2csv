package com.example.demo.util;

import com.example.demo.pojo.DO.Person;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * open csv读写csv工具
 * @author
 * @date
 */
public class OpenCsvUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(OpenCsvUtil.class);

    public static void writeCsv(List<Person> dataList, String filePath) {

        FileOutputStream out = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            File finalCSVFile = new File(filePath);
            if (!finalCSVFile.exists()) {
                finalCSVFile.getParentFile().mkdirs();
            }
            out = new FileOutputStream(finalCSVFile);
            osw = new OutputStreamWriter(out, "UTF-8");
            // 手动加上BOM标识
            osw.write(new String(new byte[] { (byte) 0xEF, (byte) 0xBB, (byte) 0xBF }));
            bw = new BufferedWriter(osw);
            /**
             * 往CSV中写新数据
             */
            String title = "";
            title = "名字,年龄,性别";
            bw.append(title).append("\r");

            if (dataList != null && !dataList.isEmpty()) {
                for (Person data : dataList) {
                    bw.append(data.getName() + ",");
                    bw.append(data.getAge() + ",");
                    if (data.getSex() == 1) {
                        bw.append("男,");
                    } else if (data.getSex() == 0) {
                        bw.append("女,");
                    } else {
                        bw.append(" ,");
                    }
                    bw.append("\r");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                    bw = null;
                } catch (IOException e) {
                    LOGGER.error("{}", e.getStackTrace());
                }
            }
            if (osw != null) {
                try {
                    osw.close();
                    osw = null;
                } catch (IOException e) {
                    LOGGER.error("{}", e.getStackTrace());
                }
            }
            if (out != null) {
                try {
                    out.close();
                    out = null;
                } catch (IOException e) {
                    LOGGER.error("{}", e.getStackTrace());
                }
            }

        }
        LOGGER.info("{}", "数据导出成功");
    }

    /**
     * 对象写出csv
     * @param dataList
     * @param finalPath
     */
    public static void writeCSV2(List<Person> dataList, String finalPath) {

        try {
            Writer writer = new FileWriter(finalPath);
            writer.write(new String(new byte[] { (byte) 0xEF, (byte) 0xBB, (byte) 0xBF }));

            StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                    .withEscapechar('\\').build();
            beanToCsv.write(dataList);
            writer.close();
        } catch (IOException e) {
            LOGGER.error("{}", e.getStackTrace());
        } catch (CsvDataTypeMismatchException e) {
            LOGGER.error("{}", e.getStackTrace());
        } catch (CsvRequiredFieldEmptyException e) {
            LOGGER.error("{}", e.getStackTrace());
        }
        LOGGER.info("{}", "数据导出成功");
    }

    public static void main(String[] args) {

        String filePath = "/home/binfool/桌面/testFile/write3.csv";
        String filePath2 = "/home/binfool/桌面/testFile/write4.csv";

        List<Person> dataList = new ArrayList<>();
        Person person1 = new Person("test1", 12, 1);
        Person person2 = new Person("test2", 13, 0);
        Person person3 = new Person("test3", 14, 1);
        Person person4 = new Person("test4", 15, 1);
        Person person5 = new Person("test5", 16, 0);
        Person person6 = new Person("test6", 17, 0);
        dataList.add(person1);
        dataList.add(person2);
        dataList.add(person3);
        dataList.add(person4);
        dataList.add(person5);
        dataList.add(person6);
        writeCsv(dataList, filePath);
        writeCSV2(dataList, filePath2);
    }
}
