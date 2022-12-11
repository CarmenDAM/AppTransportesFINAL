package com.carmen.myapplication;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

//Creación de la Interfaz Tren DAO
@Dao
public interface TrenDAO {

    //Esta Query nos devuelve una lista con los datos de la tabla Tren
    @Query("select * from Tren")
    List<TablaTren> getAllTren();

    //Esta Query nos devuelve una lista con los importes de los viajes de la tabla Tren
    @Query("select * from Tren where importeT= :importeT")
    TablaTren findByImporteT(int importeT);

    //Inserción de un nuevo registro en la tabla Tren
    @Insert
    void insertTren(TablaTren tren);

    //Eliminación del último registro de la tabla Bus
    @Delete
    void deleteTren(TablaTren tren);

    //Obtención del último registro de la tabla Bus
    @Query("SELECT * FROM Tren ORDER BY idT DESC")
    TablaTren ultimoRegistroTren();

}
