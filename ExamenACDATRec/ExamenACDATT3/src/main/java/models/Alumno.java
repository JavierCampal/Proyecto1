
package models;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Alumno implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private String nombre;
    private String telefono;
    private String email;
    private double ad;
    private double di;   
    
}
