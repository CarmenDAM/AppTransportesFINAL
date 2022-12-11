package com.carmen.myapplication;
import java.util.List;

public class TrenRepositoryImpl implements TrenRepository {

    //Declaramos una variable global de nuestro DAO
    TrenDAO daoT;

    //Constructor que recibe una instancia de nuestro dao
    public TrenRepositoryImpl(TrenDAO daoT) {
        this.daoT = daoT;
    }

    //Obtiene la lista de todos los items de tipo Tren de la BBDD
    @Override
    public List<TablaTren> getAllTren() {
        return daoT.getAllTren();
    }

    //Inserta un registro en la tabla Tren
    @Override
    public void insertTren(TablaTren tren) {
        daoT.insertTren(tren);
    }

    //Elimina un registro de la tabla Tren
    @Override
    public void deleteTren(TablaTren tren) {
        daoT.deleteTren(tren);
    }

    //Obtiene el último registro de la tabla Tren
    @Override
    public TablaTren ultimoRegistroTren(){return daoT.ultimoRegistroTren();}
}


