package br.com.letscode.zoo;

import br.com.letscode.zoo.component.CategoryComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ZooApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(ZooApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ZooApplication.class, args);

		CategoryComponent categories = context.getBean(CategoryComponent.class);
		categories.getList().forEach(System.out::println);
	}

}
