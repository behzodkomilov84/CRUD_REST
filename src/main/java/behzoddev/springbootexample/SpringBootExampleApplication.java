package behzoddev.springbootexample;

import behzoddev.springbootexample.dao.CarRepository;
import behzoddev.springbootexample.dao.HumanRepository;
import behzoddev.springbootexample.entity.Car;
import behzoddev.springbootexample.entity.Human;
import behzoddev.springbootexample.service.HumanService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringBootExampleApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringBootExampleApplication.class, args);

//        HumanRepository bean = run.getBean(HumanRepository.class);
//        bean.save(Human.builder().name("Behzod").age(42).build());
//        List<Human> humanWithWolkswagen = bean.findHumanWithModel("Wolkswagen");
//        List<Human> humanWithoutCar = bean.findHumanWithoutCar();

//        List<Human> behzod = bean.findHumansByCarsEmptyAndAgeBetweenAndNameEquals(10, 50, "Behzod");

        HumanService humanService = run.getBean(HumanService.class);
//        humanService.soutAllHumansCars();

        humanService.saveHumanWithLog(Human.builder().name("Osiyo").age(4).build());
        System.out.println("\n\n");
//        System.out.println(humanWithWolkswagen);
//        System.out.println(humanWithoutCar);
//        System.out.println(behzod);


        System.out.println("\n\n");


//        CarRepository carRepository = run.getBean(CarRepository.class);
//        carRepository.save(Car.builder().model("Nexia_2").year(2012L).build());
    }

}
