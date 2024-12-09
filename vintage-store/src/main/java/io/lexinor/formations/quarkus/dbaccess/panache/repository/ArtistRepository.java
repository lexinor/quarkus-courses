package io.lexinor.formations.quarkus.dbaccess.panache.repository;

import io.lexinor.formations.quarkus.dbaccess.jdbc.Artist;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ArtistRepository implements PanacheRepository<Artist> {

}
