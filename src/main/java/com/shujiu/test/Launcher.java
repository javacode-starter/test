package com.shujiu.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 交藤
 * @since 2021/10/19
 */
@SpringBootApplication
public class Launcher {

    public static void main(String[] args) {
        new SpringApplication(Launcher.class).run(args);
    }
}
