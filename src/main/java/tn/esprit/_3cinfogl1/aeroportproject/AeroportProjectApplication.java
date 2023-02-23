package tn.esprit._3cinfogl1.aeroportproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableAspectJAutoProxy
@SpringBootApplication
public class AeroportProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AeroportProjectApplication.class, args);
	}

}
