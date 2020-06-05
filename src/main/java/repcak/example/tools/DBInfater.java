package repcak.example.tools;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.context.ApplicationListener;
import repcak.example.model.Song;
import repcak.example.model.Artist;
import repcak.example.model.Publisher;
import repcak.example.repositories.ArtistRepository;
import repcak.example.repositories.SongRepository;
import repcak.example.repositories.PublisherRepository;

@Component
public class DBInfater implements ApplicationListener<ContextRefreshedEvent>{

    private SongRepository songRepository;
    private ArtistRepository artistRepository;
    private PublisherRepository publisherRepository;

    public DBInfater(SongRepository songRepository, ArtistRepository artistRepository) {
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){
        initData();
    }

    public void initData(){
        Artist johnny = new Artist("Johnny", "Cash", "cash");
        Publisher columbia = new Publisher("Columbia Records");
        Song aBoyNamedSue = new Song("A Boy Named Sue", "country", "1983129873", "1969", columbia);
        johnny.getSongs().add(aBoyNamedSue);
        aBoyNamedSue.getArtists().add(johnny);
        publisherRepository.save(columbia);
        artistRepository.save(johnny);
        songRepository.save(aBoyNamedSue);


        Artist bob = new Artist("Bob", "Marley", "BoB");
        Publisher island = new Publisher("Island Records");
        Song threeLittleBirds = new Song("Three little birds", "Raegge", "98172391123", "1977", island);
        bob.getSongs().add(threeLittleBirds);
        threeLittleBirds.getArtists().add(bob);
        publisherRepository.save(island);
        artistRepository.save(bob);
        songRepository.save(threeLittleBirds);



        Artist freddie = new Artist("Freddie", "Mercury", "Freddie");
        Publisher emi = new Publisher("EMI");
        Song callingAllGirls = new Song("Calling All Girls", "Many", "09309823091", "1982", emi);
        freddie.getSongs().add(callingAllGirls);
        callingAllGirls.getArtists().add(freddie);
        publisherRepository.save(emi);
        artistRepository.save(freddie);
        songRepository.save(callingAllGirls);
    }
}
