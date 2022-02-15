package fr.sorbonne.paris.nord.university.api.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "team")
public class TeamEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;
    private String slogan;

    @OneToMany(mappedBy = "team", cascade=CascadeType.ALL)
    private List<Player> players;

    @ManyToOne
    private Sport sport;


}
