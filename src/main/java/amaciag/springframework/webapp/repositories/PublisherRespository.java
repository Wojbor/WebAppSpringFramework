package amaciag.springframework.webapp.repositories;

import amaciag.springframework.webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRespository extends CrudRepository<Publisher, Long> {
}
