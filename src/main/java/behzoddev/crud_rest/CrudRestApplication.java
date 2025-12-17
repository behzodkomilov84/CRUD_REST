package behzoddev.crud_rest;

import behzoddev.crud_rest.entity.Human;
import behzoddev.crud_rest.service.HumanService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CrudRestApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(CrudRestApplication.class, args);

        HumanService humanService = run.getBean(HumanService.class);

        humanService.saveHumanWithLog(Human.builder().name("Osiyo").age(4).build());

        System.out.println("\n\n");


    }

}
