package io.lexinor.formations.quarkus.dbaccess.jpa;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.sql.SQLException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class CustomerRepositoryTest {

  @Inject
  CustomerRepository customerRepository;

  @Test
  @TestTransaction
  public void shouldCreateAndFindAnArtist() throws SQLException {
    var customer = new Customer("first name", "last name", "email");
    customerRepository.persist(customer);
    Assertions.assertNotNull(customer.getId());

    var cust = customerRepository.findById(customer.getId());
    Assertions.assertEquals("first name", cust.getFirstName());
  }

}
