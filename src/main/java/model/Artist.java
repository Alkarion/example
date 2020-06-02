package repcak.example.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(of = {"id"})
@Entity
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String nick;

    @ManyToMany(mappedBy = "artists")
    private Set<Song> songs = new HashSet<>();

    public Artist() {
    }

    public Artist(String firstName, String lastName, String nick) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nick = nick;
    }
    public Artist(String firstName, String lastName, String nick, Set<Song> songs) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nick = nick;
        this.songs = songs;
    }

}
