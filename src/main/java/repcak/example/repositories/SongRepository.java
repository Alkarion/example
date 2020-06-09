package repcak.example.repositories;

import repcak.example.model.Song;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SongRepository extends CrudRepository<Song, Long> {
    Optional<Song> getFirstByIsmn(String ismn);
}
