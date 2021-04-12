package co.com.luis.supervapp.domain.models.cheks;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class PilaCheck {
    UUID idElemento;
    List<Boolean> checks;
}
