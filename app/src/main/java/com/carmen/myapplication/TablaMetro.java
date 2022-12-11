package com.carmen.myapplication;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Metro") //Nombre parar referirse a la tabla
public class TablaMetro {

    //Creación de los campos de la tabla
    @PrimaryKey(autoGenerate = true)
    int idM; //Identificador
    String lineaM; //Línea del transporte
    float importeM; //Importe del viaje que se cobra
    String destinoM; //Destino al que se llega
    String fechaM; //Fecha en la que se realiza el registro
    float saldoM; //Saldo actualizado tras el registro

    public int getIdM() {
        return idM;
    } //Método para recuperar el ID
    public void setIdM(int idM) {
        this.idM = idM;
    } //Método para enviar el ID
    public String getLineaM() {
        return lineaM;
    } //Método para recuperar la Línea
    public void setLineaM(String lineaM) {
        this.lineaM = lineaM;
    } //Método para enviar la Línea
    public float getImporteM() {
        return importeM;
    } //Método para recuperar el Importe
    public void setImporteM(float importeM) {this.importeM = importeM;} //Método para enviar el Importe
    public String getDestinoM() {
        return destinoM;
    } //Método para recuperar el Destino
    public void setDestinoM(String destinoM) {this.destinoM = destinoM;} //Método para enviar el Destino
    public String getFechaM() {
        return fechaM;
    } //Método para recuperar la Fecha
    public void setFechaM(String fechaM) {
        this.fechaM = fechaM;
    } //Método para enviar la Fecha
    public float getSaldoM() {
        return saldoM;
    } //Método para recuperar el Saldo
    public void setSaldoM(float saldoM) {
        this.saldoM = saldoM;
    } //Método para enviar el Saldo
}
