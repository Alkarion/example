package repcak.example.repositories;

import repcak.example.model.Song;
import repcak.example.model.Artist;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SongRepository extends CrudRepository<Song, Long> {
    List<Song> getAllByArtistsIsContaining(Artist artist);
}
