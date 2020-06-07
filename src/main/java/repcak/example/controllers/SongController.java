package repcak.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import repcak.example.repositories.SongRepository;
import repcak.example.model.Song;

@Controller
public class SongController {


    @RequestMapping("/songs")
    public String getSongs(Model model){

        model.addAttribute("songs", SongRepository.findAll());

        return "songs";
    }

}
