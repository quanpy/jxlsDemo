package org.example.jxlstest;

import org.junit.jupiter.api.Test;
import org.jxls.builder.JxlsOutputFile;
import org.jxls.reader.ReaderBuilder;
import org.jxls.reader.XLSReadStatus;
import org.jxls.reader.XLSReader;
import org.jxls.transform.poi.JxlsPoiTemplateFillerBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

@SpringBootTest
class JxlsWritterTests {

    @Test
    void contextLoads() {
    }

    @Test
    public  void test() throws IOException {
        Employee employee = new Employee();
        employee.setName("xx");
        employee.setPayment(BigDecimal.valueOf(34434));
        employee.setBirthDate(new Date());

        Employee employee2 = new Employee();
        employee2.setName("xx");
        employee2.setPayment(BigDecimal.valueOf(34434));
        employee2.setBirthDate(new Date());

        Map<String, Object> data = new HashMap<>();
        List<Employee> employees = List.of(employee, employee2);

        data.put("employees", employees);
        File file = new File("C:\\Users\\Administrator\\Documents\\github-code\\jxlsTest\\jxlsTest\\src\\main\\resources\\static\\report.xlsx");
//        String exportPath = "C:\\Users\\Administrator\\Documents\\github-code\\jxlsTest\\jxlsTest\\src\\main\\resources\\templates\\report.xlsx";
//        OutputStream out = new FileOutputStream(exportPath);
        JxlsOutputFile jxlsOutputFile = new JxlsOutputFile(file);
        JxlsPoiTemplateFillerBuilder.newInstance()
                .withTemplate(new ClassPathResource("/templates/writter/test.xlsx").getInputStream())
                .build()
                .fill(data,  jxlsOutputFile);
    }
}
