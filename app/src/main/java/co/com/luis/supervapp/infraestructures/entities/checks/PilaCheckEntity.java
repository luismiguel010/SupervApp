package co.com.luis.supervapp.infraestructures.entities.checks;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PilaCheckEntity {
    UUID idElemento;
    List<Integer> checks;
}
