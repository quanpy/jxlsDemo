package org.example.jxlstest;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.jxls.builder.JxlsOutputFile;
import org.jxls.builder.JxlsStreaming;
import org.jxls.transform.poi.JxlsPoiTemplateFillerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@Slf4j
class JxlsWritterTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void test() throws IOException {
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
        Logger log = LoggerFactory.getLogger(JxlsWritterTests.class);
        JxlsOutputFile jxlsOutputFile = new JxlsOutputFile(file);
        // 开启 stream 使用 POI SXSSF 处理大数据量，这需要的内存明显减少，处理速度更快，
        // 并非所有功能都可以在流式处理模式下使用。简而言之，流式处理只能用于大型简单数据列表。
        JxlsPoiTemplateFillerBuilder.newInstance()
                .withTemplate(new ClassPathResource("/templates/writter/test.xlsx").getInputStream())
                .withLogger(new Slf4jJxlsLogger(log))
                .withStreaming(JxlsStreaming.STREAMING_OFF)
                .build()
                .fill(data, jxlsOutputFile);
    }
}
