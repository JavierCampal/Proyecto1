package models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
public class Alumnado implements Serializable{
    
    @Id
    @GeneratedValue(strategy=IDENTITY)
    private long id;
    private String nombre;
    private String telefono;
    private String email;
    private Double ad;
    private Double di;
    
}