package org.example.jxlstest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;

@SpringBootApplication
public class JxlsTestApplication {

    public static void main(String[] args) throws FileNotFoundException {
        SpringApplication.run(JxlsTestApplication.class, args);

    }

}
