package com.carmen.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


public class Home extends AppCompatActivity {

    //Asignación de variables
    private EditText et1, et2, et3, et4, et5,et6;
    private Button btnSumarB,btnSumarM,btnSumarT;
    public float resultado, resultadoM, resultadoT;
    public TransportesBBDD Tdb;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        //Abrimos la Base de Datos
        TransportesBBDD Tdb = TransportesBBDD.getInstance(this.getApplicationContext());
        //Creamos un repositorio que nos guarde los registros en la tabla Bus
        BusRepository repoB = new BusRepositoryImpl(Tdb.BusDAO());
        //Creamos un repositorio que nos guarde los registros en la tabla Metro
        MetroRepository repoM = new MetroRepositoryImpl(Tdb.MetroDAO());
        //Creamos un repositorio que nos guarde los registros en la tabla Tren
        TrenRepository repoT = new TrenRepositoryImpl(Tdb.TrenDAO());

        //La primera vez que iniciamos la BBDD las tablas están vacías y da un error
        //Este if asigna el valos 0 al primer registro para corregir el error

        //Correción del error en la tabla Bus
        if (repoB.ultimoRegistroBus()==null) {
            TablaBus nuevoB = new TablaBus();
            nuevoB.setSaldoB(0);
            repoB.insertBus(nuevoB);
        }

        //Correción del error en la tabla Metro
        if (repoM.ultimoRegistroMetro()==null) {
                TablaMetro nuevoM = new TablaMetro();
                nuevoM.setSaldoM(0);
                repoM.insertMetro(nuevoM);
        }

        //Correción del error en la tabla Tren
        if (repoT.ultimoRegistroTren()==null) {
            TablaTren nuevoT = new TablaTren();
            nuevoT.setSaldoT(0);
            repoT.insertTren(nuevoT);
        }


        //Botón Bus que nos envía al menú del Bus
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView IMGbus = (ImageView) findViewById(R.id.imgBus);
        IMGbus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, Buss.class));
            }

        });

        //Botón Metro que nos envía al menú del Metro
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView IMGmetro = (ImageView) findViewById(R.id.imgMetro);
        IMGmetro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, Metroo.class));
            }

        });

        //Botón Tren que nos envía al menú del Tren
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView IMGtren = (ImageView) findViewById(R.id.imgTren);
        IMGtren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, Tren.class));
            }

        });



        //Declaración de las variables para el saldo del Bus
        et1 = (EditText) findViewById(R.id.editTextSaldoBus);
        et2 = (EditText) findViewById(R.id.editTextAnadirBus);
        btnSumarB = (Button) findViewById(R.id.bAnadirBus);

        //Declaración de las variables para el saldo del Metro
        et3 = (EditText) findViewById(R.id.editTextSaldoMetro);
        et4 = (EditText) findViewById(R.id.editTextAnadirMetro);
        btnSumarM = (Button) findViewById(R.id.bAnadirMetro);

        //Declaración de las variables para el saldo del Tren
        et5 = (EditText) findViewById(R.id.editTextSaldoTren);
        et6 = (EditText) findViewById(R.id.editTextAnadirTren);
        btnSumarT = (Button) findViewById(R.id.bAnadirTren);

        et1.setText(""+repoB.ultimoRegistroBus().getSaldoB());
        et3.setText(""+repoM.ultimoRegistroMetro().getSaldoM());
        et5.setText(""+repoT.ultimoRegistroTren().getSaldoT());

        //Botón que añade saldo al registro del Bus
        btnSumarB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Recojo el Importe del último registro del Bus
                    float aux1= repoB.ultimoRegistroBus().getSaldoB();
                    //Añado manualmente cuánto dinero añado
                    float aux2;// = Float.valueOf(et2.getText().toString());
//Evita el cierre de laaplicación al dejar el campo en el que añadimos saldo vacío
                    String importB=et2.getText().toString()+"";
                    if (importB=="") {
                        aux2 = 0;
                    }else{
                        aux2 = Float.parseFloat(importB);
                    }

                    //Resultado suma el saldo añadido al saldo que había guardado
                    resultado = aux1 + aux2;

                    //Creo un nuevo registro en el que Resultado sobreescribe al saldo actual
                    TablaBus nuevoRegistro=new TablaBus();
                    nuevoRegistro.setSaldoB(resultado);
                    repoB.insertBus(nuevoRegistro);

                    //Bucle para poder realizar varios ingresos seguidos
                    do {
                        et1.setText("" + resultado);
                    }while (et1 == null);

                }
            });

        //Botón que añade saldo al registro del Metro
        btnSumarM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Recojo el Importe del último registro del Metro
                float aux3= repoM.ultimoRegistroMetro().getSaldoM();
                //Añado manualmente cuánto dinero añado
                float aux4;// = Float.valueOf(et4.getText().toString());

//Evita el cierre de la aplicación al dejar el campo en el que añadimos saldo vacío
                String importM=et4.getText().toString()+"";
                if (importM=="") {
                    aux4 = 0;
                }else{
                    aux4 = Float.parseFloat(importM);
                }

                //Resultado suma el saldo añadido al saldo que había guardado
                resultadoM = aux3 + aux4;

                //Creo un nuevo registro en el que Resultado sobreescribe al saldo actual
                TablaMetro nuevoRegistroM=new TablaMetro();
                nuevoRegistroM.setSaldoM(resultadoM);
                repoM.insertMetro(nuevoRegistroM);

                //Bucle para poder realizar varios ingresos seguidos
                do {
                    et3.setText("" + resultadoM);
                }while (et3 == null);

            }
        });

        //Botón que añade saldo al registro del Tren
        btnSumarT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Recojo el Importe del último registro del Metro
                float aux5= repoT.ultimoRegistroTren().getSaldoT();
                //Añado manualmente cuánto dinero añado
                float aux6;// = Float.valueOf(et6.getText().toString());

//Evita el cierre de laaplicación al dejar el campo en el que añadimos saldo vacío
                String importT=et6.getText().toString()+"";
                if (importT=="") {
                    aux6 = 0;
                }else{
                    aux6 = Float.parseFloat(importT);
                }

                //Resultado suma el saldo añadido al saldo que había guardado
                resultadoT = aux5 + aux6;

                //Creo un nuevo registro en el que Resultado sobreescribe al saldo actual
                TablaTren nuevoRegistroT=new TablaTren();
                nuevoRegistroT.setSaldoT(resultadoT);
                repoT.insertTren(nuevoRegistroT);

                //Bucle para poder realizar varios ingresos seguidos
                do {
                    et5.setText("" + resultadoT);
                }while (et5 == null);

            }
        });

    }

    }
