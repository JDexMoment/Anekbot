package io.javaProject.Anekbot.model;
import jakarta.persistence.*;
import lombok.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

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
    private LocalDateTime date_of_birth;

    @Column(name = "joke_change")
    private LocalDateTime date_of_change;

    @PrePersist
    protected void onCreate() {
        date_of_birth = LocalDateTime.now(); // Устанавливаем текущую дату и время при создании записи
    }

    @PreUpdate
    protected void onUpdate() {
        date_of_change = LocalDateTime.now(); // Устанавливаем текущую дату и время при обновлении записи
    }


}
