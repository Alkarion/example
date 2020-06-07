package repcak.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import repcak.example.repositories.ArtistRepository;
import repcak.example.model.Artist;

@Controller
public class ArtistController {

    @RequestMapping("/artists")
    public String getArtist(Model model){

        model.addAttribute("artists", ArtistRepository.findAll());

        return "songs";
    }

}
