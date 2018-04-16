package cn.shana.slz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.shana.slz.mapper")
public class SlzApplication {

	public static void main(String[] args) {
		SpringApplication.run(SlzApplication.class, args);
	}
}
