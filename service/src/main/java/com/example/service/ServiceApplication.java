package com.example.service;

import com.example.service.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@SpringBootApplication
//This annotation is not actually needed
//https://stackoverflow.com/a/31993406
@EnableDiscoveryClient
public class ServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}

	@Component
	class MyCommandLineRunner implements CommandLineRunner {

		@Autowired
		private CustomerRepository customerRepository;

		@Override
		public void run(String... args) throws Exception {
			Stream.of("vahid", "vahid", "vahid", "vahid")
					.forEach(name -> customerRepository
							//when we preform the repository operations, the validations will apply
							.save(Customer.builder()
									.customerName(name)
									.test(5)
									.build()));
		}
	}
}
