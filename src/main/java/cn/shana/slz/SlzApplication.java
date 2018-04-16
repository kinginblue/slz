package cn.shana.slz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class SlzApplication {

	public static void main(String[] args) {
		SpringApplication.run(SlzApplication.class, args);
	}
}
