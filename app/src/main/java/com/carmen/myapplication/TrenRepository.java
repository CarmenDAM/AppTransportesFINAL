package com.carmen.myapplication;

import java.util.List;

//Llamadas a los métodos creadas en TrenDAO
public interface TrenRepository {
    List<TablaTren> getAllTren(); //Obtener todos los datos de la tablas Tren

    void insertTren(TablaTren tren); //Insertar un nuevo registro en la tablas Tren

    void deleteTren(TablaTren tren); //Eliminar un registro de la tablas Tren

    TablaTren ultimoRegistroTren(); //Obtención del último registro de la tablas Tren
}
