package io.lexinor.formations.quarkus.dbaccess.jpa;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.sql.DataSource;

@ApplicationScoped
public class CustomerRepository {

  @Inject
  EntityManager em;

  public void persist(Customer customer) throws SQLException {
    em.persist(customer);
  }

  public Customer findById(Long id) throws SQLException {
    return em.find(Customer.class, id);
  }

}
