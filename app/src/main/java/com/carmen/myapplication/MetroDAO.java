package com.carmen.myapplication;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

//Creación de la Interfaz Metro DAO
@Dao
public interface MetroDAO {

    //Esta Query nos devuelve una lista con los datos de la tabla Metro
    @Query("select * from Metro")
    List<TablaMetro> getAllMetro();

    //Esta Query nos devuelve una lista con los importes de los viajes de la tabla Bus
    @Query("select * from Metro where importeM= :importeM")
    TablaMetro findByImporteM(int importeM);

    //Inserción de un nuevo registro en la tabla Bus
    @Insert
    void insertMetro(TablaMetro metro);

    //Eliminación del último registro de la tabla Bus
    @Delete
    void deleteMetro(TablaMetro metro);

    //Obtención del último registro de la tabla Bus
    @Query("SELECT * FROM Metro ORDER BY idM DESC")
    TablaMetro ultimoRegistroMetro();

}

