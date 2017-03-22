package com.springboot.api;

import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@SpringBootApplication
public class AppRestControllerBackEnd {

	private String message;
	private String backendServiceHost;
	private int backendServicePort;

	public static void main(String[] args) {
		SpringApplication.run(AppRestControllerBackEnd.class, args);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/host", produces = "text/plain")
	public String exposeHost() throws UnknownHostException {
		String backendServiceUrl = String.format("http://%s:%d/host?exposeHost={message}", backendServiceHost,
				backendServicePort);
		System.out.println("Sending to: " + backendServiceUrl);
		return backendServiceUrl;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
