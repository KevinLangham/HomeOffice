package com.klangham.homeoffice.restsample.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * The Class WebConfig. Sets up Spring-MVC components, scanning for @Controller
 * annotated classes
 * 
 * @author klangham
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.klangham.homeoffice.restsample.web.controller, com.klangham.homeoffice.restsample.service" })
public class WebConfig {
}
