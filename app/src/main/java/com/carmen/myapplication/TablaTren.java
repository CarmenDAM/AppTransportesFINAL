package com.carmen.myapplication;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Tren") //Nombre parar referirse a la tabla
public class TablaTren {

    //Creación de los campos de la tabla
    @PrimaryKey(autoGenerate = true)
    int idT; //Identificador
    String lineaT; //Línea del transporte
    float importeT; //Importe del viaje que se cobra
    String destinoT; //Destino al que se llega
    String fechaT; //Fecha en la que se realiza el registro
    float saldoT; //Saldo actualizado tras el registro

    public int getIdT() {
        return idT;
    } //Método para recuperar el ID
    public void setIdT(int idT) {
        this.idT = idT;
    } //Método para enviar el ID
    public String getLineaT() {
        return lineaT;
    } //Método para recuperar la Línea
    public void setLineaT(String lineaT) {
        this.lineaT = lineaT;
    } //Método para enviar la Línea
    public float getImporteT() {
        return importeT;
    } //Método para recuperar el Importe
    public void setImporteT(float importeT) {this.importeT = importeT;} //Método para enviar el Importe
    public String getDestinoT() {
        return destinoT;
    } //Método para recuperar el Destino
    public void setDestinoT(String destinoT) {this.destinoT = destinoT;} //Método para enviar el Destino
    public String getFechaT() {
        return fechaT;
    } //Método para recuperar la Fecha
    public void setFechaT(String fechaT) {
        this.fechaT = fechaT;
    } //Método para enviar la Fecha
    public float getSaldoT() {
        return saldoT;
    } //Método para recuperar el Saldo
    public void setSaldoT(float saldoT) {
        this.saldoT = saldoT;
    } //Método para enviar el Saldo
}

