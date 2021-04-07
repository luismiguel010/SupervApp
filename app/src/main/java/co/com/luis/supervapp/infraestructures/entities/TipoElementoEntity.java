package co.com.luis.supervapp.infraestructures.entities;

import java.io.Serializable;

public class TipoElementoEntity implements Serializable {

    Integer tipoElemento;
    Integer idEstructura;

    public TipoElementoEntity() {
    }

    public TipoElementoEntity(Integer tipoElemento, Integer idEstructura) {
        this.tipoElemento = tipoElemento;
        this.idEstructura = idEstructura;
    }

    public Integer getTipoElemento() {
        return tipoElemento;
    }

    public void setTipoElemento(Integer tipoElemento) {
        this.tipoElemento = tipoElemento;
    }

    public Integer getIdEstructura() {
        return idEstructura;
    }

    public void setIdEstructura(Integer idEstructura) {
        this.idEstructura = idEstructura;
    }
}
