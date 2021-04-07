package co.com.luis.supervapp.builders;

import co.com.luis.supervapp.domain.models.TipoDeElemento;
import co.com.luis.supervapp.enums.ElementosEnum;
import co.com.luis.supervapp.infraestructures.entities.TipoElementoEntity;

public class TipoElementoBuilder {

    public TipoElementoEntity convertirAEntity(TipoDeElemento tipoDeElemento){
        TipoElementoEntity tipoElementoEntity = new TipoElementoEntity();
        if(tipoDeElemento != null){
            tipoElementoEntity.setTipoElemento(convertirEnumAInteger(tipoDeElemento.getElementosEnum()));
            tipoElementoEntity.setIdEstructura(tipoDeElemento.getIdEstructura());
        }
        return tipoElementoEntity;
    }

    public TipoDeElemento convertirAModelo(TipoElementoEntity tipoElementoEntity){
        return new TipoDeElemento(convertirIntegerAEnum(tipoElementoEntity.getTipoElemento()), tipoElementoEntity.getIdEstructura());
    }

    public ElementosEnum convertirIntegerAEnum(Integer tipoElemento) {
        ElementosEnum elementosEnum = null;
        switch (tipoElemento){
            case 0:
                elementosEnum = ElementosEnum.PILAS;
                break;
            case 1:
                elementosEnum = ElementosEnum.ZAPATAS;
                break;
            case 2:
                elementosEnum = ElementosEnum.MICROPILOTES;
                break;
            case 3:
                elementosEnum = ElementosEnum.VIGASDEFUNDACION;
                break;
            case 4:
                elementosEnum = ElementosEnum.LOSASDEFUNDACION;
                break;
            case 5:
                elementosEnum = ElementosEnum.MUROSDECONTENCION;
                break;
            case 6:
                elementosEnum = ElementosEnum.MUROSESTRUCTURALES;
                break;
            case 7:
                elementosEnum = ElementosEnum.COLUMNAS;
                break;
            case 8:
                elementosEnum = ElementosEnum.LOSAS;
                break;
            case 9:
                elementosEnum = ElementosEnum.MAMPOSTERIANOESTRUCTURAL;
                break;
            case 10:
                elementosEnum = ElementosEnum.MAMPOSTERIAESTRUCTURAL;
                break;
        }
        return elementosEnum;
    }

    public Integer convertirEnumAInteger(ElementosEnum elementosEnum) {
        Integer resultado = 0;
        switch (elementosEnum){
            case PILAS:
                resultado = 0;
                break;
            case ZAPATAS:
                resultado = 1;
                break;
            case MICROPILOTES:
                resultado = 2;
                break;
            case VIGASDEFUNDACION:
                resultado = 3;
                break;
            case LOSASDEFUNDACION:
                resultado = 4;
                break;
            case MUROSDECONTENCION:
                resultado = 5;
                break;
            case MUROSESTRUCTURALES:
                resultado = 6;
                break;
            case COLUMNAS:
                resultado = 7;
                break;
            case LOSAS:
                resultado = 8;
                break;
            case MAMPOSTERIANOESTRUCTURAL:
                resultado = 9;
                break;
            case MAMPOSTERIAESTRUCTURAL:
                resultado = 10;
                break;
        }
        return resultado;
    }
}
