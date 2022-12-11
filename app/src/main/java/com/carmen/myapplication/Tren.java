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

public class Tren extends AppCompatActivity {

    //Declaración de variables
    private EditText txtLineaT;
    private EditText txtDestinoT;
    private EditText txtImporteT;
    private EditText txtFechaT;
    private TextView txtResultadoT;

    private Button btnInsertarT;
    private Button btnEliminarT;
    private Button btnConsultarT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tren);

        //Botón Atrás que nos devuelve al menú Home
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView atras = (ImageView) findViewById(R.id.imgAtrasT);
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Tren.this, Home.class));
            }

        });

        //Asignación de variables
        txtLineaT = (EditText)findViewById(R.id.txtLinT);
        txtDestinoT = (EditText)findViewById(R.id.txtDestT);
        txtImporteT = (EditText)findViewById(R.id.txtImportT);
        txtFechaT = (EditText)findViewById(R.id.txtFechT);
        txtResultadoT = (TextView)findViewById(R.id.txtResultadoT);

        btnInsertarT = (Button)findViewById(R.id.btnInsertarT);
        btnEliminarT = (Button)findViewById(R.id.btnEliminarT);
        btnConsultarT = (Button)findViewById(R.id.btnConsultarT);

        //Abrimos la Base de Datos
        TransportesBBDD Tdb = TransportesBBDD.getInstance(this.getApplicationContext());
        //Creamos un repositorio que nos guarde los registros en la tabla Tren
        TrenRepository repoT = new TrenRepositoryImpl(Tdb.TrenDAO());


//------------Inserción de un nuevo registro en la tabla Tren-------------------------
        btnInsertarT.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Declaración de los campos del registro
                String lin = txtLineaT.getText().toString();
                String dest = txtDestinoT.getText().toString();
                float imp = Float.parseFloat(txtImporteT.getText().toString());
                String fe = txtFechaT.getText().toString();
                float importeT= repoT.ultimoRegistroTren().getSaldoT();


                //Inserción del nuevo registro en la tabla Tren de la BBDD
                TablaTren nuevoRegistroT=new TablaTren();
                nuevoRegistroT.setLineaT(lin);
                nuevoRegistroT.setDestinoT(dest);
                nuevoRegistroT.setImporteT(imp);
                nuevoRegistroT.setFechaT(fe);
                nuevoRegistroT.setSaldoT(importeT-imp); //Resto el importe del viaje al saldo actual que se muestra en Home
                repoT.insertTren(nuevoRegistroT);

            }
        });


//------------Eliminamos el último registro de la tabla Tren al pulsar el botón----------
        btnEliminarT.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                repoT.deleteTren(repoT.ultimoRegistroTren());
            }
        });

//---------Mostramos en el textView todos los registros almacenados en la tabla Tren------
        btnConsultarT.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Obtenemos la lista de registros de la tabla Bus
                List<TablaTren> listaTren =repoT.getAllTren();
                txtResultadoT.setText("");

                //Recorremos la tabla Bus con un bucle
                for (TablaTren registro:listaTren ) {
                    String lin = registro.getLineaT();
                    String des = registro.getDestinoT();
                    float imp = registro.getImporteT();
                    String fe = registro.getFechaT();
                    float sal = registro.getSaldoT();

                    //Mostramos los registros en el textview
                    txtResultadoT.append("Línea: " + lin + ". Destino: " + des + ". Importe: " + imp + "€. Fecha: " + fe + ". Saldo Restante: " +sal+"€ "+"\n");

                }

            }
        });
    }


}
