package com.carmen.myapplication;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "Bus") //Nombre parar referirse a la tabla
public class TablaBus {
    //Creación de los campos de la tabla
    @PrimaryKey(autoGenerate = true)
    int idB; //Identificador
    String lineaB; //Línea del transporte
    float importeB; //Importe del viaje que se cobra
    String destinoB; //Destino al que se llega
    String fechaB; //Fecha en la que se realiza el registro
    float saldoB; //Saldo actualizado tras el registro

    public int getIdB() {
        return idB;
    } //Método para recuperar el ID
    public void setIdB(int idB) {
        this.idB = idB;
    } //Método para enviar el ID
    public String getLineaB() {
        return lineaB;
    } //Método para recuperar la Línea
    public void setLineaB(String lineaB) {
        this.lineaB = lineaB;
    } //Método para enviar la Línea
    public float getImporteB() {
        return importeB;
    } //Método para recuperar el Importe
    public void setImporteB(float importeB) {this.importeB = importeB;} //Método para enviar el Importe
    public String getDestinoB() {
        return destinoB;
    } //Método para recuperar el Destino
    public void setDestinoB(String destinoB) {this.destinoB = destinoB;} //Método para enviar el Destino
    public String getFechaB() {
        return fechaB;
    } //Método para recuperar la Fecha
    public void setFechaB(String fechaB) {
        this.fechaB = fechaB;
    } //Método para enviar la Fecha
    public float getSaldoB() {
        return saldoB;
    } //Método para recuperar el Saldo
    public void setSaldoB(float saldoB) {
        this.saldoB = saldoB;
    } //Método para enviar el Saldo
}