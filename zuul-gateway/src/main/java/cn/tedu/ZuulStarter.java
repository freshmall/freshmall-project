package cn.tedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;
//启动客户端进程
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZuulStarter {
	public static void main(String[] args) {
		SpringApplication.run(ZuulStarter.class, args);
	}
}
