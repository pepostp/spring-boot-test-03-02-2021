package com.example;

import ch.qos.logback.classic.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.DataAccessException;

@SpringBootApplication(scanBasePackages={"com.example.*"})

public class SpringBootTestApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootTestApplication.class);

	public static void main(String[] args) {
		setLoggingLevel(Level.INFO);
		try {
			SpringApplication.run(SpringBootTestApplication.class, args);
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	private static void setLoggingLevel(ch.qos.logback.classic.Level level) {
		ch.qos.logback.classic.Logger root = (ch.qos.logback.classic.Logger) org.slf4j.LoggerFactory.getLogger(ch.qos.logback.classic.Logger.ROOT_LOGGER_NAME);
		root.setLevel(level);
	}

}
