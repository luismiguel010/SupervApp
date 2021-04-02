package co.com.luis.supervapp.builders;

import co.com.luis.supervapp.domain.models.Elemento;
import co.com.luis.supervapp.infraestructures.entities.ElementoEntity;

public class ElementoBuilder {

    public ElementoEntity convertirAEntity(Elemento elemento){
        ElementoEntity elementoEntity = new ElementoEntity();
        if(elemento != null){
            elementoEntity.setNombre(elemento.getNombre());
            elementoEntity.setIdEstructura(elemento.getIdEstructura());
        }
        return elementoEntity;
    }

    public Elemento convertirAModel(ElementoEntity elementoEntity){
        return new Elemento(elementoEntity.getNombre(), elementoEntity.getIdEstructura());
    }


}