package com.uzabase.shadow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;

/**
 * Contents API application to run project
 * <p>
 * Created by Trung-Vu on 2017/05/01.
 */
@SpringBootApplication
@Import(JpaConfiguration.class)
@EntityScan(basePackages = {"com.uzabase.shadow.entity.common.speeda"})
@EnableCaching
public class ContentsApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContentsApiApplication.class, args);
    }
}
