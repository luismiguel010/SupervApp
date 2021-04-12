package co.com.luis.supervapp.builders.checks;

import co.com.luis.supervapp.domain.models.cheks.PilaCheck;
import co.com.luis.supervapp.infraestructures.entities.checks.PilaCheckEntity;

import java.util.ArrayList;
import java.util.List;

public class PilaCheckBuilder {

    public PilaCheckEntity convertirAEntity(PilaCheck pilaCheck){
        PilaCheckEntity pilaCheckEntity = new PilaCheckEntity();
        if(pilaCheck != null){
            pilaCheckEntity.setIdElemento(pilaCheck.getIdElemento());
            List<Integer> checkList = new ArrayList<>();
            for(int i = 0; i < pilaCheck.getChecks().size(); i++){
                if(!pilaCheck.getChecks().get(i)){
                    checkList.add(0);
                }else {
                    checkList.add(1);
                }
            }
            pilaCheckEntity.setChecks(checkList);
        }
        return pilaCheckEntity;
    }

    public PilaCheck convertirADomain(PilaCheckEntity pilaCheckEntity){
        List<Boolean> checkList = new ArrayList<>();
        for(int i = 0; i < pilaCheckEntity.getChecks().size(); i++){
            if(pilaCheckEntity.getChecks().get(i) == 0){
                checkList.add(false);
            }else{
                checkList.add(true);
            }
        }
        return new PilaCheck(pilaCheckEntity.getIdElemento(), checkList);
    }
}
