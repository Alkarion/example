package repcak.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import repcak.example.commands.ArtistCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import repcak.example.repositories.ArtistRepository;
import repcak.example.repositories.SongRepository;
import repcak.example.converter.ArtistsCommandToArtists;
import org.springframework.web.bind.annotation.*;
import repcak.example.model.Artist;

import java.util.Optional;

@Controller
public class ArtistController {

    private ArtistRepository artistRepository;
    private SongRepository songRepository;
    private ArtistsCommandToArtists artistCommandToArtists;

    public ArtistController(ArtistRepository artistRepository, SongRepository songRepository) {
        this.artistRepository = artistRepository;
        this.songRepository = songRepository;
    }

    @RequestMapping("/artist", "/artist/list")
    public String getArtist(Model model){

        model.addAttribute("artists", artistRepository.findAll());

        return "artist/list";
    }

    @GetMapping
    @RequestMapping("/artist/new")
    public String newSong(Model model){
        model.addAttribute("artist", new ArtistCommand());
        return "artist/addedit";
    }

    @PostMapping("artist")
    public String saveOrUpdate(@ModelAttribute ArtistCommand command){

        Optional<Artist> artistOptional = artistRepository.getFirstByFirstNameAndLastName(command.getFirstName(), command.getLastName());

        if (!artistOptional.isPresent()) {
            Artist detachedArtist = artistCommandToArtist.convert(command);
            Artist savedArtist = artistRepository.save(detachedArtist);
            return "redirect:/artist/" + savedArtist.getId() + "/show";
        } else {
            //TODO: error message to template
            System.out.println("Sorry, there's such artist in db");
            return "redirect:/artist/" + artistOptional.get().getId() + "/show";
        }
    }

    @RequestMapping("/artist/{id}/show")
    public String getArtistDetails(Model model, @PathVariable("id") Long id) {
        model.addAttribute("artist", artistRepository.findById(id).get());
        return "artist/show";
    }

    @RequestMapping("/artist/{id}/delete")
    public String deleteArtist(@PathVariable("id") Long id) {
        artistRepository.deleteById(id);
        return "redirect:/artists";
    }

}
