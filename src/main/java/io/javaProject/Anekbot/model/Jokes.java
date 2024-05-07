package io.javaProject.Anekbot.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "jokes")
@Table(name = "jokes")
public class Jokes {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "joke_seq_gen")
    @SequenceGenerator(name = "joke_seq_gen", sequenceName = "joke_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "joke")
    private String joke;

    @Column(name = "joke_download")
    private Date date_of_birth;

    @Column(name = "joke_change")
    private Date date_of_change;

    @OneToMany(mappedBy = "jokeId", cascade = CascadeType.ALL)
    private List<JokesHistory> jokesHistory;

    public Jokes(String joke, Date date_of_birth) {
        this.joke = joke;
        this.date_of_birth = date_of_birth;
    }
}
