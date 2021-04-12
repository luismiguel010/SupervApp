package co.com.luis.supervapp.builders;

import co.com.luis.supervapp.domain.models.Estructura;
import co.com.luis.supervapp.infraestructures.entities.EstructuraEntity;

public class EstructuraBuilder {

    public EstructuraEntity convertirAEntity(Estructura estructura){
        EstructuraEntity estructuraEntity = new EstructuraEntity();
        if(estructura != null){
            estructuraEntity.setId(estructura.getIdEstructura());
            estructuraEntity.setNombre(estructura.getNombre());
            estructuraEntity.setId_proyecto(estructura.getIdProyecto());
        }
        return estructuraEntity;
    }

    public Estructura convertirAModel(EstructuraEntity estructuraEntity){
        return new Estructura(estructuraEntity.getId(), estructuraEntity.getNombre(), estructuraEntity.getId_proyecto());
    }
}
