package io.javaProject.Anekbot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Jokes_History")
public class JokesHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jokes_history_seq_gen")
    @SequenceGenerator(name = "jokes_history_seq_gen", sequenceName = "jokes_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "joke_id")
    private Jokes jokeId;

    @Column(name = "date")
    private Date date;
}
