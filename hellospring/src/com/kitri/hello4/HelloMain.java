package com.kitri.hello4;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class HelloMain {
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(HelloServiceFactory.class); //HelloServiceFactory를 설정파일로 사용
		HelloService helloService = context.getBean("hs", HelloService.class); // 타입설정가능>> 형변환 필요 없음
		String msg = helloService.hello("고세라");

		System.out.println(msg);
			
	}
}
