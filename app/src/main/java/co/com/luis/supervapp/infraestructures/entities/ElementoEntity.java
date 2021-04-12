package co.com.luis.supervapp.infraestructures.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ElementoEntity implements Serializable {

    private UUID id;
    private String nombre;
    private Integer idElemento;
}
