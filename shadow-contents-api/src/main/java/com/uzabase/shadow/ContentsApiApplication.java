package com.uzabase.shadow;

import com.uzabase.shadow.shareholder.ShareholdersController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Contents API application to run project
 * <p>
 * Created by Trung-Vu on 2017/05/01.
 */
@SpringBootApplication
@ComponentScan(basePackageClasses = ShareholdersController.class)
public class ContentsApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContentsApiApplication.class, args);
    }
}
