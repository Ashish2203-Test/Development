package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by admin on 2/12/17.
 */

@SpringBootApplication
public class Application {

    private static final Logger log= LoggerFactory.getLogger(Application.class);

    public static void main(String[] args){
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository repository){
        return (args)->{
            repository.save(new Customer("Azizjon", "Rizayev"));
            repository.save(new Customer("Mamurahon", "Rizaeva"));
            repository.save(new Customer("Abdullajon", "Avazov"));
            repository.save(new Customer("Akbarjon", "Avazov"));

            log.info("Customers found:");
            log.info("-------------------------------------");
            for(Customer customer: repository.findAll())
                log.info(customer.toString());

            Customer customer=repository.findOne(1L);
            log.info(customer.toString());


            for(Customer avazov: repository.findByLastName("Avazov"))
                log.info(customer.toString());


        };
    }
}
