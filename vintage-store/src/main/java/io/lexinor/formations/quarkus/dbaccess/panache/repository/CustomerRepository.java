package io.lexinor.formations.quarkus.dbaccess.panache.repository;

import io.lexinor.formations.quarkus.dbaccess.jdbc.Artist;
import io.lexinor.formations.quarkus.dbaccess.jpa.Customer;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer> {

}
