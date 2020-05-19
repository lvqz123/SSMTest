package com.lvqz.lab13.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author: lvqz
 * @date: 2020/5/19
 * @time: 11:06
 */
@Configuration
@ComponentScan("com.lvqz.lab13")
@EnableAspectJAutoProxy
public class SpringConfig {
}
