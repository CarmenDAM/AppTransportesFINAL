package com.carmen.myapplication;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

//Creació de la Base de Datos y asignación de sus tablas
@Database(entities = {TablaBus.class, TablaMetro.class, TablaTren.class}, version= 1)
public abstract class TransportesBBDD extends RoomDatabase {

    //Creación de la instancia de la Base de Datos
    public static volatile TransportesBBDD INSTANCE;

    //Creación de los DAO de cada tabla
    public abstract BusDAO BusDAO();
    public abstract MetroDAO MetroDAO();
    public abstract TrenDAO TrenDAO();

    //Los datos de la base de datos se guardan en Transporte.db
    public static TransportesBBDD getInstance(Context context){
        if (INSTANCE==null){
            INSTANCE= Room.databaseBuilder(context, TransportesBBDD.class, "AppTransportes.db").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }

        //Devolvemos la Instancia de la Base de Datos
        return INSTANCE;
    }

}
