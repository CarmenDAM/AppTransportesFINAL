package com.carmen.myapplication;

import java.util.List;

//Llamadas a los métodos creadas en MetroDAO
public interface MetroRepository {
    List<TablaMetro> getAllMetro(); //Obtener todos los datos de la tablas Metro

    void insertMetro(TablaMetro metro); //Insertar un nuevo registro en la tablas Metro

    void deleteMetro(TablaMetro metro); //Eliminar un registro de la tablas Metro

    TablaMetro ultimoRegistroMetro(); //Obtención del último registro de la tablas Metro
}
