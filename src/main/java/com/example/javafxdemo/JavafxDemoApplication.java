package com.example.javafxdemo;

import com.example.javafxdemo.fx.AbstractFxApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: #{auth}
 * @Mail: #{email}
 * @Date: 2023/11/06
 * @Version: 1.0
 * @Description:
 */
@SpringBootApplication
public class JavafxDemoApplication extends AbstractFxApplication {

	public static void main(String[] args) {
		run(JavafxDemoApplication.class,args);
	}
}
