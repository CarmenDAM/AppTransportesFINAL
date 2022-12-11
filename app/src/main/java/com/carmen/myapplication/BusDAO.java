package com.carmen.myapplication;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

//Creación de la Interfaz Bus DAO

@Dao
public interface BusDAO {

    //Esta Query nos devuelve una lista con los datos de la tabla Bus
    @Query("select * from Bus")
    List<TablaBus> getAllBus();

    //Esta Query nos devuelve una lista con los importes de los viajes de la tabla Bus
    @Query("select * from Bus where importeB= :importeB")
    TablaBus findByImporteB(int importeB);

   //Inserción de un nuevo registro en la tabla Bus
    @Insert
    void insertBus(TablaBus bus);

    //Eliminación del último registro de la tabla Bus
    @Delete
    void deleteBus(TablaBus bus);

    //Obtención del último registro de la tabla Bus
    @Query("SELECT * FROM Bus ORDER BY idB DESC")
    TablaBus ultimoRegistroBus();

}

