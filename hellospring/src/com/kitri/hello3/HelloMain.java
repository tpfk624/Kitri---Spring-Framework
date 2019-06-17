package com.kitri.hello3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.kitri.hello3.HelloService;

public class HelloMain {
	public static void main(String[] args) {
//   HelloService helloService = new HelloServiceKor(); 

		// HelloService helloService = new HelloServiceEng(); //interface로 implements를
		// 했기 때문에 위에 어떤 하위객체를 선택할 지만 고르면 된다.
		// String msg = helloService.hello("박미래"); //=> 느슨한 결합 >>바꿔야하는 양이 줄어 들었음
		// 다른 문제점 : 클래스가 여러개다 => spring사용

		// 스프링이 만든거 가져다가 쓸거야
		// applicationContentext를 접근해야 함 -> factory pattern 사용

		// spring 2.x
		// BeanFactory : interface >> ClassPathXmlApplicationContext 하위 클래스로 생성//하지만
		// 2점대니까 일단은 XmlBeanFactory 사용
		//   org.springframework.core.io.Resource resource = new ClassPathResource("com/kitri/hello3/applicationContext.xml"); // /는 경로 사용, .은 package접근 
		//                                                                  //> xml입장에서는 경로를 찾아서 가져와야 하므로
		//   BeanFactory factory = new XmlBeanFactory(resource);
		//   HelloService helloService = (HelloService)factory.getBean("hs"); //Bean에서 hs 객체 가져와라 

		
		// spring 3.x
		System.out.println("프로그램 시작!!!");
		ApplicationContext context = new ClassPathXmlApplicationContext("com/kitri/hello3/applicationContext.xml");
		System.out.println("설정파일 읽었다!!");
		HelloService helloService = context.getBean("hs", HelloService.class); // 타입설정가능>> 형변환 필요 없음
		System.out.println("service 얻어왔다!!");
		String msg = helloService.hello("고세라");

		System.out.println(msg);
		
		HelloService h1 = new HelloServiceKor();
		HelloService h2 = new HelloServiceKor();
		System.out.println(h1 + "   " + h2);

		HelloService h3 = context.getBean("hs", HelloService.class);
		System.out.println("11111111111111111111111111111111");
		HelloService h4 = context.getBean("hs", HelloService.class);
		System.out.println(h3 + "   " + h4);
		
		
	}
}
