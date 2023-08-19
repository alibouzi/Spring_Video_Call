package com.alibouzid.videocall;

import com.alibouzid.videocall.user.User;
import com.alibouzid.videocall.user.Userservice;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VideocallApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideocallApplication.class, args);
	}
@Bean
	public CommandLineRunner commandLineRunner(	Userservice userservice){
return args -> {
	userservice.register(User.builder()
		.username("Ali")
		.email("alibouzid323@gmail.coom")
		.password("aaa")
		.build());
	userservice.register(User.builder()
			.username("Mohamed")
			.email("Mohamed323@gmail.coom")
			.password("aaa")
			.build());
	userservice.register(User.builder()
			.username("Chokri")
			.email("Chokri323@gmail.coom")
			.password("aaa")
			.build());
	userservice.register(User.builder()
			.username("Neji")
			.email("Neji323@gmail.coom")
			.password("aaa")
			.build());
};
	}
}
