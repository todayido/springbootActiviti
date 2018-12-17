package com.example.demo.loader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.logging.Logger;

@Component
public class StartConfig implements CommandLineRunner {

    private static final Log logger = LogFactory.getLog(StartConfig.class);

    @Override
    public void run(String... args) throws Exception {
        logger.debug("系统正在启动，加载参数......");
        System.out.println(("系统正在启动，加载参数......"));
        while (true) {
            logger.debug("同步数据，每五分钟执行一次......");
            System.out.println(("同步数据，每五分钟执行一次......"));
            Thread.sleep(1000 * 60 * 5);
        }
    }
}
