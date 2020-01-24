package burgeonapp;

import java.util.Arrays;

import org.slf4j.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.*;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BurgeonApp {

	private static final Logger LOG = LoggerFactory.getLogger(BurgeonApp.class);

	// TODO provide meta data maximize-column
	// TODO setup the maximize-column and check that every data-table is correctly shown
	// TODO add pages
	// TODO Update the 'retrieve' adding a footer to navigate pages as explained here: https://material.io/guidelines/components/data-tables.html
	// TODO create a form to add an item
	// TODO implement item addition
	// TODO add support of editing
	// TODO add support of deletion
	// TODO externalize messageSource
	// TODO try to find a way to customize backend operations of the application
	// TODO auto-determine 'maximizeColumn'

	public static void main(String[] args) {
		SpringApplication.run(BurgeonApp.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			LOG.debug("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				LOG.debug("    +-- {}", beanName);
			}

		};
	}

	@Bean
	public MessageSource messageSource() {
		AutoDefaultMessageSource messageSource = new AutoDefaultMessageSource();
		messageSource.setBasename("classpath:messages");
		messageSource.setCacheSeconds(30);
		return messageSource;
	}

}
