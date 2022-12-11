package com.carmen.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;


public class Buss extends AppCompatActivity {

    //Declaración de variables
    private EditText txtLineaB;
    private EditText txtDestinoB;
    private EditText txtImporteB;
    private EditText txtFechaB;
    private TextView txtResultadoB;

    private Button btnInsertarB;
    private Button btnEliminarB;
    private Button btnConsultarB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buss);

        //Botón Atrás que nos devuelve al menú Home
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView atras = (ImageView) findViewById(R.id.imgAtrasB);
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Buss.this, Home.class));
            }

        });

        //Asignación de variables
        txtLineaB = (EditText)findViewById(R.id.txtLinB);
        txtDestinoB = (EditText)findViewById(R.id.txtDestB);
        txtImporteB = (EditText)findViewById(R.id.txtImportB);
        txtFechaB = (EditText)findViewById(R.id.txtFechB);
        txtResultadoB = (TextView)findViewById(R.id.txtResultadoB);

        btnInsertarB = (Button)findViewById(R.id.btnInsertarB);
        btnEliminarB = (Button)findViewById(R.id.btnEliminarB);
        btnConsultarB = (Button)findViewById(R.id.btnConsultarB);

        //Abrimos la Base de Datos
        TransportesBBDD Tdb = TransportesBBDD.getInstance(this.getApplicationContext());
        //Creamos un repositorio que nos guarde los registros en la tabla Bus
        BusRepository repoB = new BusRepositoryImpl(Tdb.BusDAO());


//------------Inserción de un nuevo registro en la tabla Bus-------------------------------
        btnInsertarB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Declaración de los campos del registro
                String lin = txtLineaB.getText().toString();
                String dest = txtDestinoB.getText().toString();
                float imp = Float.parseFloat(txtImporteB.getText().toString());
                String fe = txtFechaB.getText().toString();
                float importeB= repoB.ultimoRegistroBus().getSaldoB();
                //float sal = Float.parseFloat(editTextSaldoBus.getText().toString());

                //Inserción del nuevo registro en la tabla Bus de la BBDD
                TablaBus nuevoRegistroB=new TablaBus();
                nuevoRegistroB.setLineaB(lin);
                nuevoRegistroB.setDestinoB(dest);
                nuevoRegistroB.setImporteB(imp);
                nuevoRegistroB.setFechaB(fe);
                nuevoRegistroB.setSaldoB(importeB-imp); //Resto el importe del viaje al saldo actual que se muestra en Home
                repoB.insertBus(nuevoRegistroB);

            }
        });


//------------Eliminamos el último registro de la tabla Bus al pulsar el botón-----------
        btnEliminarB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                repoB.deleteBus(repoB.ultimoRegistroBus());
            }
        });


//---------Mostramos en el textView todos los registros almacenados en la tabla Bus--------
        btnConsultarB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Obtenemos la lista de registros de la tabla Bus
                List<TablaBus>listaBus =repoB.getAllBus();
                txtResultadoB.setText("");

                //Recorremos la tabla Bus con un bucle
                    for (TablaBus registro:listaBus ) {
                        String lin = registro.getLineaB();
                        String des = registro.getDestinoB();
                        float imp = registro.getImporteB();
                        String fe = registro.getFechaB();
                        float sal = registro.getSaldoB();

                        //Mostramos los registros en el textview
                        txtResultadoB.append("Línea: " + lin + ". Destino: " + des + ". Importe: " + imp + "€. Fecha: " + fe + ". Saldo Restante: " +sal+"€ "+"\n");
                    }
            }
        });
    }


}
