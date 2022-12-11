package com.carmen.myapplication;


import java.util.List;

//Llamadas a los métodos creadas en BusDAO
public interface BusRepository {
    List<TablaBus> getAllBus(); //Obtener todos los datos de la tablas Bus

    void insertBus(TablaBus bus); //Insertar un nuevo registro en la tablas Bus

    void deleteBus(TablaBus bus); //Eliminar un registro de la tablas Bus

    TablaBus ultimoRegistroBus(); //Obtención del último registro de la tablas Bus
}

