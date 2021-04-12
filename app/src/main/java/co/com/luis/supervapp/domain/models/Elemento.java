package co.com.luis.supervapp.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class Elemento {

    UUID idElemento;
    String nombre;
    Integer idTipoElemento;

}
