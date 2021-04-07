package co.com.luis.supervapp.domain.models;

import co.com.luis.supervapp.enums.ElementosEnum;

public class TipoDeElemento {

    ElementosEnum elementosEnum;
    Integer idEstructura;

    public TipoDeElemento(ElementosEnum elementosEnum, Integer idEstructura) {
        this.elementosEnum = elementosEnum;
        this.idEstructura = idEstructura;
    }

    public ElementosEnum getElementosEnum() {
        return elementosEnum;
    }

    public void setElementosEnum(ElementosEnum elementosEnum) {
        this.elementosEnum = elementosEnum;
    }

    public Integer getIdEstructura() {
        return idEstructura;
    }

    public void setIdEstructura(Integer idEstructura) {
        this.idEstructura = idEstructura;
    }
}
