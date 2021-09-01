package amaciag.springframework.webapp.repositories;

import amaciag.springframework.webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRespository extends CrudRepository<Book, Long> {
}
