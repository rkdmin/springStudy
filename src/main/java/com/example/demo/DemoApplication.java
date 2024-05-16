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
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.IOException;

public class DemoApplication {
	public static void main(String[] args) {
		ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
		WebServer webServer = serverFactory.getWebServer(servletContext -> {
			// 핸들러 의존하여 사용
			UserController userController = new UserController();
			PostController postController = new PostController();

			servletContext.addServlet("frontController", new HttpServlet() {
				@Override
				protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
					// 공통 로직
					if (req.getRequestURL().equals("/signin") && req.getMethod().equals("POST")) {
						// 로그인 로직
						userController.signin();
					} else if (req.getRequestURL().equals("/signUp") && req.getMethod().equals("POST")) {
						// 회원가입 로직
						userController.signup();
					} else if (req.getRequestURL().equals("/") && req.getMethod().equals("POST")) {
						// 게시글 작성 로직
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
