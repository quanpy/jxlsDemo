package org.example.jxlstest;

import org.jxls.builder.JxlsOutput;
import org.jxls.builder.JxlsOutputFile;
import org.jxls.transform.poi.JxlsPoiTemplateFillerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class JxlsTestApplication {

    public static void main(String[] args) throws FileNotFoundException {
//        SpringApplication.run(JxlsTestApplication.class, args);
        Employee employee = new Employee();
        employee.setName("xx");
        employee.setPayment(BigDecimal.valueOf(34434));
        employee.setBirthDate(new Date());

        Map<String, Object> data = new HashMap<>();
        List<Employee> employees = List.of(employee);

        data.put("employees", employees);
        File file = new File("C:\\Users\\Administrator\\Desktop\\文档\\report.xlsx");
//        String exportPath = "C:\\Users\\Administrator\\Documents\\github-code\\jxlsTest\\jxlsTest\\src\\main\\resources\\templates\\report.xlsx";
//        OutputStream out = new FileOutputStream(exportPath);
        JxlsOutputFile jxlsOutputFile = new JxlsOutputFile(file);
        JxlsPoiTemplateFillerBuilder.newInstance()
                .withTemplate("C:\\Users\\Administrator\\Documents\\github-code\\jxlsTest\\jxlsTest\\src\\main\\resources\\templates\\test.xlsx")
                .build()
                .fill(data,  jxlsOutputFile);
    }

}
