package com.example.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.IOException;

public class DemoApplication {
	public static void main(String[] args) {
		ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
		GenericApplicationContext context = new GenericApplicationContext();
		context.registerBean(UserController.class);
		context.registerBean(PostController.class);
		context.refresh();

		WebServer webServer = serverFactory.getWebServer(servletContext -> {
			// UserController userController = new UserController();
			// PostController postController = new PostController();

			servletContext.addServlet("frontController", new HttpServlet() {
				@Override
				protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
					if (req.getRequestURL().equals("/signin") && req.getMethod().equals("POST")) {
						// 로그인 로직
						UserController userController = context.getBean(UserController.class);
						userController.signin();
					} else if (req.getRequestURL().equals("/signUp") && req.getMethod().equals("POST")) {
						// 회원가입 로직
						UserController userController = context.getBean(UserController.class);
						userController.signup();
					} else if (req.getRequestURL().equals("/") && req.getMethod().equals("POST")) {
						// 게시글 작성 로직
						PostController postController = context.getBean(PostController.class);
						postController.createPost();
					} else {
						// 에러 처리
					}
				}
			}).addMapping("/*");// 전체 url 매핑
		});
		webServer.start();
	}
}
