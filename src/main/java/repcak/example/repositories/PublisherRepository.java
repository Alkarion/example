package repcak.example.repositories;

import repcak.example.model.Publisher;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
    Optional<Publisher> getPublisherByName(String name);
}