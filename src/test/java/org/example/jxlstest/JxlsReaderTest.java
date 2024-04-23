package org.example.jxlstest;

import org.junit.jupiter.api.Test;
import org.jxls.reader.ReaderBuilder;
import org.jxls.reader.XLSReadStatus;
import org.jxls.reader.XLSReader;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Ocean
 * @date 2024/4/23 10:43
 * 通过readBuilder类使用XML映射文件和departmentdata.xls构建xlsReader对象
 * xlsReader对象读取xls中的数据,填充响应Java Bean代码
 */
public class JxlsReaderTest {

    @Test
    public  void test() {
        try {
            // getClass().getResourceAsStream("/templates/employee.xml"),  resources 路径为根路径
            try (InputStream xmlInputStream = new BufferedInputStream(new ClassPathResource("/templates/reader/employee.xml").getInputStream())){
                final XLSReader reader = ReaderBuilder.buildFromXML(xmlInputStream);
                try (InputStream xlsInputStream = new BufferedInputStream(new ClassPathResource("/static/report.xlsx").getInputStream())) {
                    List<Employee> employeeList = new ArrayList<>();
                    Map<String, Object> beans = new HashMap<>();
                    beans.put("employeeList", employeeList);
                    XLSReadStatus read = reader.read(xlsInputStream, beans);
                    System.out.println(employeeList);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}