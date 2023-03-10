package org.pzj.assistant;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AssistantApplication {

    public static void main(String[] args) {
        // 使用TrayIcon要这样启动
        SpringApplicationBuilder builder = new SpringApplicationBuilder(AssistantApplication.class);
        builder.headless(false);
        ConfigurableApplicationContext context = builder.run(args);
    }

}
