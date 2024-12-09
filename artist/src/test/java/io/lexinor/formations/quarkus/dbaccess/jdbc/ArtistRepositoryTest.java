package io.lexinor.formations.quarkus.dbaccess.jdbc;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.sql.DataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class ArtistRepositoryTest {

  @Inject
  ArtistRepository artistRepository;

  @Test
  public void shouldCreateAndFindAnArtist() throws SQLException {
    var artist = new Artist("name", "bio");
    artistRepository.persist(artist);
    Assertions.assertNotNull(artist.getId());

    var art = artistRepository.findById(artist.getId());
    Assertions.assertEquals("name", art.getName());
  }

}
