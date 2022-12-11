package com.carmen.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Metroo extends AppCompatActivity {

    //Declaración de variables
    private EditText txtLineaM;
    private EditText txtDestinoM;
    private EditText txtImporteM;
    private EditText txtFechaM;
    private TextView txtResultadoM;

    private Button btnInsertarM;
    private Button btnEliminarM;
    private Button btnConsultarM;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metroo);

        //Botón Atrás que nos devuelve al menú Home
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView atras = (ImageView) findViewById(R.id.imgAtrasMM);
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Metroo.this, Home.class));
            }

        });

        //Asignación de variables
        txtLineaM = (EditText)findViewById(R.id.txtLinM);
        txtDestinoM = (EditText)findViewById(R.id.txtDestM);
        txtImporteM = (EditText)findViewById(R.id.txtImportM);
        txtFechaM = (EditText)findViewById(R.id.txtFechM);
        txtResultadoM = (TextView)findViewById(R.id.txtResultadoM);

        btnInsertarM = (Button)findViewById(R.id.btnInsertarM);
        btnEliminarM = (Button)findViewById(R.id.btnEliminarM);
        btnConsultarM = (Button)findViewById(R.id.btnConsultarM);

        //Abrimos la Base de Datos
        TransportesBBDD Tdb = TransportesBBDD.getInstance(this.getApplicationContext());
        //Creamos un repositorio que nos guarde los registros en la tabla Metro
        MetroRepository repoM = new MetroRepositoryImpl(Tdb.MetroDAO());


//------------Inserción de un nuevo registro en la tabla Metro-----------------------------
        btnInsertarM.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Declaración de los campos del registro
                String lin = txtLineaM.getText().toString();
                String dest = txtDestinoM.getText().toString();
                float imp = Float.parseFloat(txtImporteM.getText().toString());
                String fe = txtFechaM.getText().toString();
                float importeM= repoM.ultimoRegistroMetro().getSaldoM();

                //Inserción del nuevo registro en la tabla Metro de la BBDD
                TablaMetro nuevoRegistroM=new TablaMetro();
                nuevoRegistroM.setLineaM(lin);
                nuevoRegistroM.setDestinoM(dest);
                nuevoRegistroM.setImporteM(imp);
                nuevoRegistroM.setFechaM(fe);
                nuevoRegistroM.setSaldoM(importeM-imp); //Resto el importe del viaje al saldo actual que se muestra en Home
                repoM.insertMetro(nuevoRegistroM);


            }
        });


//------------Eliminamos el último registro de la tabla Metro al pulsar el botón-----------
        btnEliminarM.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                repoM.deleteMetro(repoM.ultimoRegistroMetro());
            }
        });

//---------Mostramos en el textView todos los registros almacenados en la tabla Metro------
        btnConsultarM.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Obtenemos la lista de registros de la tabla Metro
                List<TablaMetro> listaMetro =repoM.getAllMetro();
                txtResultadoM.setText("");

                //Recorremos la tabla Bus con un bucle
                for (TablaMetro registro:listaMetro ) {
                    String lin = registro.getLineaM();
                    String des = registro.getDestinoM();
                    float imp = registro.getImporteM();
                    String fe = registro.getFechaM();
                    float sal = registro.getSaldoM();

                    //Mostramos los registros en el textview
                    txtResultadoM.append("Línea: " + lin + ". Destino: " + des + ". Importe: " + imp + "€. Fecha: " + fe + ". Saldo Restante: " +sal+"€ "+"\n");

                }

            }
        });
    }



}
