package io.lexinor.formations.quarkus.dbaccess.jdbc;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.sql.DataSource;

@ApplicationScoped
public class ArtistRepository {

  @Inject
  DataSource dataSource;

  public void persist(final Artist artist) throws SQLException {
    Connection conn = dataSource.getConnection();
    var sql = "INSERT INTO t_artists (id, name, bio, created_date) VALUES (?, ?, ?, ?)";
    artist.setId(Math.abs(new SecureRandom().nextLong()));
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setLong(1, artist.getId());
      ps.setString(2, artist.getName());
      ps.setString(3, artist.getBio());
      ps.setTimestamp(4, Timestamp.from(artist.getCreatedDate()));
      ps.executeUpdate();
    }
    conn.close();
  }

  public Artist findById(Long id) throws SQLException {
    Connection conn = dataSource.getConnection();
    var sql = "SELECT id, name, bio, created_date FROM t_artists WHERE id = ?";
    var artist = new Artist();
    try(PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setLong(1, id);
      var res = ps.executeQuery();
      if (res.next()) {
        artist.setId(res.getLong(1));
        artist.setName(res.getString(2));
        artist.setBio(res.getString(3));
        artist.setCreatedDate(res.getTimestamp(4).toInstant());
      }
    }
    conn.close();
    return artist;
  }

}
