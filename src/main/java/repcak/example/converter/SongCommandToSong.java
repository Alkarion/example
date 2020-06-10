package repcak.example.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import repcak.example.commands.SongCommand;
import repcak.example.model.Song;
import repcak.example.repositories.PublisherRepository;
import repcak.example.repositories.ArtistRepository;
import lombok.Synchronized;
import org.springframework.lang.Nullable;

@Component
public class SongCommandToSong implements Converter<SongCommand, Song> {

    @Synchronized
    @Nullable
    @Override
    public Song convert(SongCommand source) {
        if (source == null) {
            return null;
        }

        final Song song = new Song();
        song.setId(source.getId());
        song.setTitle(source.getTitle());
        song.setGenre(source.getGenre());
        song.setYear(source.getYear());
        song.setIsmn(source.getIsmn());

        return song;
    }
}
