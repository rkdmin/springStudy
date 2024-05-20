package com.example.demo;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@ComponentScan
public class DemoApplication {
	public static void main(String[] args) {
		ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext ();
		context.register(DemoApplication.class);

		// 직접 빈으로 등록하지 않음
//		context.registerBean(PostController.class);
//		context.registerBean(PostService.class);
//		context.registerBean(PostRepository.class);
		context.refresh();

		WebServer webServer = serverFactory.getWebServer(servletContext -> {
			// 스프링 컨테스트를 인자로 받는 DispatcherServlet으로 변경(*)
			servletContext.addServlet("dispatcherServlet", new DispatcherServlet(context)
					).addMapping("/*");
		});
		webServer.start();
	}
}
