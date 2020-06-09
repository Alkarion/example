package repcak.example.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import repcak.example.commands.SongCommand;
import repcak.example.model.Song;
import repcak.example.repositories.PublisherRepository;
import repcak.example.repositories.ArtistRepository;

@Component
public class SongCommandToSong implements Converter<SongCommand, Song> {

    private final PublisherRepository publisherRepository;
    private final ArtistRepository artistRepository;

    public SongCommandToSong(PublisherRepository publisherRepository, ArtistRepository artistRepository) {
        this.publisherRepository = publisherRepository;
        this.artistRepository = artistRepository;
    }

    @lombok.Synchronized
    @org.springframework.lang.Nullable
    @Override
    public repcak.example.model.Song convert(@javax.annotation.Nonnull repcak.example.commands.SongCommand source) {
        if (source == null) {
            return null;
        }

        final repcak.example.model.Song song = new repcak.example.model.Song();
        song.setId(source.getId());
        song.setTitle(source.getTitle());
        song.setGenre(source.getGenre());
        song.setYear(source.getYear());
        song.setIsmn(source.getIsmn());

        java.util.Optional<repcak.example.model.Publisher> publisher = publisherRepository.findById(source.getPublisherId());

        if (publisher.isPresent()) {
            song.setPublisher(publisher.get());
        } else {
            song.setPublisher(publisherRepository.getPublisherByName("Unknown").get());
        }

        java.util.Optional<repcak.example.model.Artist> artist = artistRepository.findById(source.getArtistId());

        if (artist.isPresent()) {
            song.getArtists().add(artist.get());
        }

        return song;
    }
}
