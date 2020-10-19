package org.fit5042.pokemon.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pokemon")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pokemon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String power;

    public String getPower() {
        return power;
    }
    public void setPower(String power) {
        this.power = power;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}