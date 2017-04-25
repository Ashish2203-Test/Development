package hello;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by admin on 2/12/17.
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

}
