package com.solienlac.khoaluan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class KhoaLuanApplication {

    public static void main(String[] args) {
        SpringApplication.run(KhoaLuanApplication.class, args);
    }

}
