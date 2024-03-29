package com.xskj.LicenseTips;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;



//@SpringBootApplication
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)

@ComponentScan("com.xskj.*")
public class LicenseTipsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LicenseTipsApplication.class, args);
		
	}	

}
