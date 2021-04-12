package co.com.luis.supervapp.domain.models;

import co.com.luis.supervapp.enums.ElementosEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class TipoDeElemento {
    ElementosEnum elementosEnum;
    UUID idEstructura;
}
