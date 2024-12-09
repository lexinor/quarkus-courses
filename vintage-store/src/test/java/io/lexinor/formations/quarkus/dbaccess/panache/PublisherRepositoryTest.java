package io.lexinor.formations.quarkus.dbaccess.panache;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.transaction.Transactional;
import java.sql.SQLException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class PublisherRepositoryTest {

  @Test
  @TestTransaction
  public void shouldCreateAndFindAnArtist() throws SQLException {
    var publisher = new Publisher("name");
    Publisher.persist(publisher);
    Assertions.assertNotNull(publisher.id);

    publisher = Publisher.findById(publisher.id);
    Assertions.assertEquals("name", publisher.name);
  }

}
