package repcak.example.converter;

import lombok.Synchronized;
import org.springframework.stereotype.Component;
import repcak.example.model.Artist;
import repcak.example.commands.ArtistCommand;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

@Component
public class ArtistCommandToArtist implements Converter<ArtistCommand, Artist> {

    @Synchronized
    @Nullable
    @Override
    public Artist convert(ArtistCommand source){
        if(source == null){
            return null;
        }

        final Artist artist = new Artist();
        artist.setFirstName(source.getFirstName());
        artist.setLastName(source.getLastName());
        artist.setNick(source.getNick());

        return artist;
    }

}
