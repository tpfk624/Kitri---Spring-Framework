package com.kitri.hello4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration //설정파일로 사용해줘
public class HelloServiceFactory {

	@Bean(name = {"hs", "helloservice"}) //이름이 ~인 얘를 빈으로 사용할거야
	//@Scope(value = "prototype")
	public HelloService getHelloService() {
		return new HelloServiceKor();
	
	}
}
