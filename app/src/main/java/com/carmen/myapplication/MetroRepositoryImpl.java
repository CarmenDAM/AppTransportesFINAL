package com.carmen.myapplication;
import java.util.List;

public class MetroRepositoryImpl implements MetroRepository {

    //Declaramos una variable global de nuestro DAO
    MetroDAO daoM;

    //Constructor que recibe una instancia de nuestro dao
    public MetroRepositoryImpl(MetroDAO daoM) {
        this.daoM = daoM;
    }

    //Obtiene la lista de todos los items de tipo Metro de la BBDD
    @Override
    public List<TablaMetro> getAllMetro() {
        return daoM.getAllMetro();
    }

    //Inserta un registro en la tabla Metro
    @Override
    public void insertMetro(TablaMetro metro) {
        daoM.insertMetro(metro);
    }

    //Elimina un registro de la tabla Metro
    @Override
    public void deleteMetro(TablaMetro metro) {
        daoM.deleteMetro(metro);
    }

    //Obtiene el último registro de la tabla Metro
    @Override
    public TablaMetro ultimoRegistroMetro(){return daoM.ultimoRegistroMetro();}
}

