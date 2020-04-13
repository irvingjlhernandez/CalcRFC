package com.example.calcrfc;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MediaPlayer mp;
    EditText etFecNac, etNombre, etApPat, etApMat;
    ImageButton btnIr;
    String advertencia, cnombre, cappat, capmat, revision, campo, esvac,fecValida, turfc;
    private static final String CERO = "0";
    private static final String BARRA = "/";
    //Calendario para obtener fecha & hora
    public final Calendar c = Calendar.getInstance();

    //Variables para obtener la fecha
    final int mes = c.get(Calendar.MONTH);
    final int dia = c.get(Calendar.DAY_OF_MONTH);
    final int anio = c.get(Calendar.YEAR);
    String nombre = null, appat = null, apmat = null, dsaux = null, msaux = null, asaux = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        advertencia = getResources().getString(R.string.mensajeadv);
        cnombre = getResources().getString(R.string.nombre);
        cappat = getResources().getString(R.string.apepat);
        capmat = getResources().getString(R.string.apemat);
        revision = getResources().getString(R.string.revision);
        campo = getResources().getString(R.string.campo);
        esvac = getResources().getString(R.string.esvac);
        fecValida = getResources().getString(R.string.fecval);
        turfc = getResources().getString(R.string.turfc);

        mp = MediaPlayer.create(this, R.raw.mime);
        mp.start();

        etNombre = findViewById(R.id.etNombre);
        etApPat = findViewById(R.id.etApPat);
        etApMat = findViewById(R.id.etApMat);
        etFecNac = findViewById(R.id.etFecNac);
        btnIr = findViewById(R.id.btnIr);

        btnIr.setOnClickListener(this);
        etFecNac.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String saux = null;
        //int day = 0, month = 0, year = 0;
        switch (v.getId()){
            case R.id.etFecNac:
                obtenerFecha();
                break;
            case R.id.btnIr:
                try{

                    dsaux = etFecNac.getText().toString().substring(0,2);
                    msaux = etFecNac.getText().toString().substring(3,5);
                    asaux = etFecNac.getText().toString().substring(6,10);

                    saux = etNombre.getText().toString();
                    if(noEstaVacio(saux)){
                        Toast.makeText(MainActivity.this, campo+" "+cnombre+" "+esvac+".",Toast.LENGTH_SHORT).show();
                        break;
                    }
                    if(comprobar(saux)){
                        nombre = saux.substring(0,1);
                    }else{
                        Toast.makeText(MainActivity.this, advertencia+" "+cnombre+".",Toast.LENGTH_SHORT).show();
                        break;
                    }
                    saux = etApPat.getText().toString();
                    if(noEstaVacio(saux)){
                        Toast.makeText(MainActivity.this, campo+" "+cappat+" "+esvac+".",Toast.LENGTH_SHORT).show();
                        break;
                    }
                    if(comprobar(saux)){
                        appat = cortar(saux);
                    }else{
                        Toast.makeText(MainActivity.this, advertencia+" "+cappat+".",Toast.LENGTH_SHORT).show();
                        break;
                    }
                    saux = etApMat.getText().toString();
                    if(saux.equals(""))saux = "X";
                    if(comprobar(saux)){
                        apmat = saux.substring(0,1);
                    }else{
                        Toast.makeText(MainActivity.this, advertencia+" "+capmat+".",Toast.LENGTH_SHORT).show();
                        break;
                    }

                    if(dsaux.equals("DD")) {
                        Toast.makeText(MainActivity.this, fecValida+".",Toast.LENGTH_SHORT).show();
                        break;
                    }

                    Bundle bundle = new Bundle();
                    bundle.putString("dia",dsaux);
                    bundle.putString("mes",msaux);
                    bundle.putString("anio",asaux);
                    bundle.putString("cadenita",appat+apmat+nombre);
                    //Toast.makeText(MainActivity.this, turfc+" "+appat+apmat+nombre+asaux+msaux+dsaux+".",Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MainActivity.this, Resultado.class);
                    intent.putExtras(bundle);
                    startActivity(intent);

                }catch (Exception e){
                    Toast.makeText(MainActivity.this, revision+".",Toast.LENGTH_SHORT).show();
                    break;
                }
                break;
        }
    }

    private void obtenerFecha(){

        DatePickerDialog recogerFecha = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                //Esta variable lo que realiza es aumentar en uno el mes ya que comienza desde 0 = enero
                final int mesActual = month + 1;
                //Formateo el día obtenido: antepone el 0 si son menores de 10
                String diaFormateado = (dayOfMonth < 10)? CERO + String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);
                //Formateo el mes obtenido: antepone el 0 si son menores de 10
                String mesFormateado = (mesActual < 10)? CERO + String.valueOf(mesActual):String.valueOf(mesActual);
                //Muestro la fecha con el formato deseado
                etFecNac.setText(diaFormateado + BARRA + mesFormateado + BARRA + year);
            }
        },anio, mes, dia);
        //Muestro el widget
        recogerFecha.show();

    }

    protected boolean noEstaVacio(String s){
        if (s.equals("")) return true;
        return false;
    }

    protected boolean comprobar(String s){
        if (s.matches(".*[^A-Z ].*")) return false;
        return true;
    }

    protected String cortar(String s){
        String vocal = null, sub = s.substring(0,1);
        if(sub.equals("Ñ")) sub = "X";
        for (int x=1;x<s.length();x++)
            if((s.charAt(x)=='A') || (s.charAt(x)=='E') || (s.charAt(x)=='I') || (s.charAt(x)=='O') || (s.charAt(x)=='U')){
                vocal = Character.toString(s.charAt(x));
                break;
            }
        return sub+vocal;
    }

    @Override
    protected void onPause() {
        super.onPause();
        mp.pause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mp.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}