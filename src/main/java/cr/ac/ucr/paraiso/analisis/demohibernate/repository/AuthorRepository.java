package cr.ac.ucr.paraiso.analisis.demohibernate.repository;

import java.util.List;

import cr.ac.ucr.paraiso.analisis.demohibernate.entity.Author;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional(readOnly = true)
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a JOIN FETCH a.books WHERE a.name = ?1")
    List<Author> findAuthorByName(String name);
}