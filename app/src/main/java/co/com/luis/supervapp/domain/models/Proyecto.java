package co.com.luis.supervapp.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class Proyecto {

    UUID idProyecto;
    String nombre;
    String constructura;
}
