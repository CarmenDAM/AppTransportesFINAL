package com.carmen.myapplication;
import java.util.List;

public class BusRepositoryImpl implements BusRepository {

    //Declaramos una variable global de nuestro DAO
    BusDAO daoB;

    //Constructor que recibe una instancia de nuestro dao
    public BusRepositoryImpl(BusDAO dao) {
        this.daoB = dao;
    }

    //Obtiene la lista de todos los items de tipo Bus de la BBDD
    @Override
    public List<TablaBus> getAllBus() {
        return daoB.getAllBus();
    }

    //Inserta un registro en la tabla Bus
    @Override
    public void insertBus(TablaBus bus) {
        daoB.insertBus(bus);
    }

    //Elimina un registro de la tabla Bus
    @Override
    public void deleteBus(TablaBus bus) {
        daoB.deleteBus(bus);
    }

    //Obtiene el último registro de la tabla Bus
    @Override
    public TablaBus ultimoRegistroBus(){return daoB.ultimoRegistroBus();}
}
