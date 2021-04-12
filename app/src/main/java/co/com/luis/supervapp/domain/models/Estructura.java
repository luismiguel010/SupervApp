package co.com.luis.supervapp.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class Estructura {

    UUID idEstructura;
    String nombre;
    UUID idProyecto;

}
