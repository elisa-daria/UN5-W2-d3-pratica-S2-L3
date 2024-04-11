package elisadaria.UN5W2d3praticaS2L3.repositories;

import elisadaria.UN5W2d3praticaS2L3.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorDAO extends JpaRepository<Author,Integer> {
    Optional<Author> findByEmail(String email);
}
