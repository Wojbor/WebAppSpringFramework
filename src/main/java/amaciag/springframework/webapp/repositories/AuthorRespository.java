package amaciag.springframework.webapp.repositories;

import amaciag.springframework.webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRespository extends CrudRepository<Author, Long>{

}
