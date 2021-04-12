package co.com.luis.supervapp.builders;

import co.com.luis.supervapp.domain.models.Proyecto;
import co.com.luis.supervapp.infraestructures.entities.ProyectoEntity;

public class ProyectoBuilder {

    public ProyectoEntity convertirAEntity(Proyecto proyecto){
        ProyectoEntity proyectoEntity = new ProyectoEntity();
        if(proyecto != null){
            proyectoEntity.setId(proyecto.getIdProyecto());
            proyectoEntity.setNombre(proyecto.getNombre());
            proyectoEntity.setConstructura(proyecto.getConstructura());
        }
        return proyectoEntity;
    }

    public Proyecto convertirAModel(ProyectoEntity proyectoEntity){
        return new Proyecto(proyectoEntity.getId(), proyectoEntity.getNombre(), proyectoEntity.getConstructura());
    }
}
