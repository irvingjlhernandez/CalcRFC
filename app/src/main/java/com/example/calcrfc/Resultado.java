package com.example.calcrfc;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Resultado extends AppCompatActivity {

    TextView tvPresentacion, tvZodiaco, tvZodiacoCh;
    ImageView ivZodiaco, ivZodCh;
    MediaPlayer mp;
    String tuRfc = null;
    int day = 0, month = 0, year = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        tvPresentacion = findViewById(R.id.tvPresentacion);
        tvZodiaco = findViewById(R.id.tvZodiaco);
        tvZodiacoCh = findViewById(R.id.tvZodiacoCh);
        ivZodiaco = findViewById(R.id.ivZodiaco);
        ivZodCh = findViewById(R.id.ivZodCh);

        tuRfc = getResources().getString(R.string.turfc);

        mp = MediaPlayer.create(this, R.raw.saint);
        mp.start();
        Bundle bundle = new Bundle();
        bundle = getIntent().getExtras();

        String dia = null, mes = null, anio = null;
        String cadenita = null;

        //Log.d("DEPURACION",bundle.getInt("dia")+".");

        dia = bundle.getString("dia");
        mes = bundle.getString("mes");
        anio = bundle.getString("anio");
        cadenita = bundle.getString("cadenita");
        //Toast.makeText(Resultado.this, tuRfc+" "+cadenita+anio+mes+dia+".",Toast.LENGTH_LONG).show();

        day = Integer.parseInt(dia);
        month = Integer.parseInt(mes);
        year = Integer.parseInt(anio);
        Log.d("DEPURACION","El anio es: "+year+" y el modulo es: "+verificarZodiacoChino(year)+".");

        tvPresentacion.setText(tuRfc+" "+cadenita+anio.substring(2,4)+mes+dia);

        switch(verificarZodiaco(month,day)){
            case 1:
                tvZodiaco.setText(getResources().getString(R.string.tusino)+" "+getResources().getString(R.string.aries));
                ivZodiaco.setImageResource(R.drawable.aries);
                break;
            case 2:
                tvZodiaco.setText(getResources().getString(R.string.tusino)+" "+getResources().getString(R.string.tauro));
                ivZodiaco.setImageResource(R.drawable.tauro);
                break;
            case 3:
                tvZodiaco.setText(getResources().getString(R.string.tusino)+" "+getResources().getString(R.string.geminis));
                ivZodiaco.setImageResource(R.drawable.geminis);
                break;
            case 4:
                tvZodiaco.setText(getResources().getString(R.string.tusino)+" "+getResources().getString(R.string.cancer));
                ivZodiaco.setImageResource(R.drawable.cancer);
                break;
            case 5:
                tvZodiaco.setText(getResources().getString(R.string.tusino)+" "+getResources().getString(R.string.leo));
                ivZodiaco.setImageResource(R.drawable.leo);
                break;
            case 6:
                tvZodiaco.setText(getResources().getString(R.string.tusino)+" "+getResources().getString(R.string.virgo));
                ivZodiaco.setImageResource(R.drawable.virgo);
                break;
            case 7:
                tvZodiaco.setText(getResources().getString(R.string.tusino)+" "+getResources().getString(R.string.libra));
                ivZodiaco.setImageResource(R.drawable.libra);
                break;
            case 8:
                tvZodiaco.setText(getResources().getString(R.string.tusino)+" "+getResources().getString(R.string.escorpio));
                ivZodiaco.setImageResource(R.drawable.escorpio);
                break;
            case 9:
                tvZodiaco.setText(getResources().getString(R.string.tusino)+" "+getResources().getString(R.string.sagitario));
                ivZodiaco.setImageResource(R.drawable.sagitario);
                break;
            case 10:
                tvZodiaco.setText(getResources().getString(R.string.tusino)+" "+getResources().getString(R.string.capricornio));
                ivZodiaco.setImageResource(R.drawable.capricornio);
                break;
            case 11:
                tvZodiaco.setText(getResources().getString(R.string.tusino)+" "+getResources().getString(R.string.acuario));
                ivZodiaco.setImageResource(R.drawable.acuario);
                break;
            case 12:
                tvZodiaco.setText(getResources().getString(R.string.tusino)+" "+getResources().getString(R.string.piscis));
                ivZodiaco.setImageResource(R.drawable.piscis);
                break;
            default:
                Toast.makeText(Resultado.this, " "+"Error"+".",Toast.LENGTH_LONG).show();
                break;
        }

        switch(verificarZodiacoChino(year)){
            case 1:
                tvZodiacoCh.setText(getResources().getString(R.string.zodiacoch)+" "+getResources().getString(R.string.mono));
                ivZodCh.setImageResource(R.drawable.infernape);
                break;
            case 2:
                tvZodiacoCh.setText(getResources().getString(R.string.zodiacoch)+" "+getResources().getString(R.string.gallo));
                ivZodCh.setImageResource(R.drawable.blaziken);
                break;
            case 3:
                tvZodiacoCh.setText(getResources().getString(R.string.zodiacoch)+" "+getResources().getString(R.string.perro));
                ivZodCh.setImageResource(R.drawable.arcanine);
                break;
            case 4:
                tvZodiacoCh.setText(getResources().getString(R.string.zodiacoch)+" "+getResources().getString(R.string.cerdo));
                ivZodCh.setImageResource(R.drawable.emboar);
                break;
            case 5:
                tvZodiacoCh.setText(getResources().getString(R.string.zodiacoch)+" "+getResources().getString(R.string.rata));
                ivZodCh.setImageResource(R.drawable.raticate);
                break;
            case 6:
                tvZodiacoCh.setText(getResources().getString(R.string.zodiacoch)+" "+getResources().getString(R.string.buey));
                ivZodCh.setImageResource(R.drawable.tauros);
                break;
            case 7:
                tvZodiacoCh.setText(getResources().getString(R.string.zodiacoch)+" "+getResources().getString(R.string.tigre));
                ivZodCh.setImageResource(R.drawable.incineroar);
                break;
            case 8:
                tvZodiacoCh.setText(getResources().getString(R.string.zodiacoch)+" "+getResources().getString(R.string.conejo));
                ivZodCh.setImageResource(R.drawable.cinderace);
                break;
            case 9:
                tvZodiacoCh.setText(getResources().getString(R.string.zodiacoch)+" "+getResources().getString(R.string.dragon));
                ivZodCh.setImageResource(R.drawable.charizard);
                break;
            case 10:
                tvZodiacoCh.setText(getResources().getString(R.string.zodiacoch)+" "+getResources().getString(R.string.serpiente));
                ivZodCh.setImageResource(R.drawable.serperior);
                break;
            case 11:
                tvZodiacoCh.setText(getResources().getString(R.string.zodiacoch)+" "+getResources().getString(R.string.caballo));
                ivZodCh.setImageResource(R.drawable.mudsdale);
                break;
            case 12:
                tvZodiacoCh.setText(getResources().getString(R.string.zodiacoch)+" "+getResources().getString(R.string.cabra));
                ivZodCh.setImageResource(R.drawable.gogoat);
                break;
            default:
                Toast.makeText(Resultado.this, " "+"Error"+".",Toast.LENGTH_LONG).show();
                break;
        }
    }

    protected int verificarZodiaco(int month, int day){
        int selector = 0;
        if ((month==3&&day>20)||(month==4&&day<21)) return 1;
        if ((month==4&&day>20)||(month==5&&day<21)) return 2;
        if ((month==5&&day>20)||(month==6&&day<22)) return 3;
        if ((month==6&&day>21)||(month==7&&day<23)) return 4;
        if ((month==7&&day>22)||(month==8&&day<23)) return 5;
        if ((month==8&&day>22)||(month==9&&day<23)) return 6;
        if ((month==9&&day>22)||(month==10&&day<22)) return 7;
        if ((month==10&&day>21)||(month==11&&day<23)) return 8;
        if ((month==11&&day>22)||(month==12&&day<22)) return 9;
        if ((month==12&&day>21)||(month==1&&day<21)) return 10;
        if ((month==1&&day>20)||(month==2&&day<19)) return 11;
        if ((month==2&&day>18)||(month==3&&day<21)) return 12;
        return 0;
    }

    protected int verificarZodiacoChino(int year){
        int selector = year % 12;
        return selector+1;
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