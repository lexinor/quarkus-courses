package io.lexinor.formations.quarkus.dbaccess.panache.repository;

import io.lexinor.formations.quarkus.dbaccess.jdbc.Artist;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import java.sql.SQLException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class ArtistRepositoryTest {

  @Inject
  ArtistRepository artistRepository;

  @Test
  @TestTransaction
  public void shouldCreateAndFindAnArtist() throws SQLException {
    var artist = new Artist("name", "bio");
    artistRepository.persist(artist);
    Assertions.assertNotNull(artist.getId());

    var art = artistRepository.findById(artist.getId());
    Assertions.assertEquals("name", art.getName());
  }

}
