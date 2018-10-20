package com.robertkiszelirk.androidquiz;

/**
 * Created by ivan on 18/10/2018.
 */

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;



public class MainActivityMail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mail);

        Button btnSend = (Button) findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //obtenemos los datos para el envío del correo
                EditText etEmail           = (EditText) findViewById(R.id.etEmail);
                EditText etSubject         = (EditText) findViewById(R.id.etSubject);

                //es necesario un intent que levante la actividad deseada
                Intent itSend = new Intent(android.content.Intent.ACTION_SEND);

                //vamos a enviar texto plano a menos que el checkbox esté marcado
                itSend.setType("plain/text");

                //colocamos los datos para el envío
                itSend.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{
                        etEmail.getText().toString()});
                itSend.putExtra(android.content.Intent.EXTRA_SUBJECT,
                        etSubject.getText().toString());
                itSend.putExtra(Intent.EXTRA_TEXT, new String("Las respuestas en orden son las siguientes: \n\n"+
                        "1.-¿Cuántos bits hay en una dirección ipv4?\n" +
                        "R= 32 \n\n " +
                        "2.-¿Cuál es el equivalente decimal del número hexadecimal 0x3f?\n" +
                        "R= 63 \n\n " +
                        "3.-¿Cuántos bits tiene un byte?\n" +
                        "R= 8 \n\n " +
                        "4.-¿A cuántos bytes equivale 16 bits?\n" +
                        "R= 2 \n\n " +
                        "5.-¿Cuántos bits hay en una dirección ipv6?\n" +
                        "R= 128 \n\n " +
                        "6.-¿Cuántos octetos tiene una dirección ipv4?\n" +
                        "R= 4 \n\n"+
                        "7.-¿Cómo se llama el dispositivo que se muestra en pantalla?\n" +
                        "R= Conmutador, hub, firewall, portatil, router, servidor \n\n " +
                        "8.-¿Comando para ver la configuracion ip en una computadora windows?\n" +
                        "R= ip info \n\n " +
                        "9.-3 características de los switches en la capa de acceso:\n" +
                        "R= Velocidad de reenvío, Alimentación por ethernet y Densidad de puertos \n\n " +
                        "10.-La información de la vlan de rango extendido se almacena en el archivo: \n" +
                        "R= running config \n\n " +
                        "11.-Seleccione las características básicas para configurar spanning-tree\n" +
                        "R= modo, dominio y contraseña \n\n " +
                        "12.-¿Cuál de las siguientes interfaces es la SVI predeterminada en un switch cisco?\n" +
                        "R= VLAN1 \n\n " +
                        "13.-Tipo De Vlan Se Identifica Mediante Una Id De Vlan Entre 1006 Y 4094\n" +
                        "R= Extendida \n\n " +
                        "14.-Protocolo de routing sin Clase que admite VLSM Y Cidr\n" +
                        "R= RIPv2 \n\n " +
                        "15.-Protocolo diseñado por la organización internacional de normalización (ISO):\n" +
                        "R= Sistema intermedio a sistema intermedio (IS-IS) \n\n " +
                        "16.-¿Cuál es la extensión de los programas de cisco?\n" +
                        "R= .pkt \n\n " +
                        "17.-¿Con etherchannel, qué tipo de conexión lógica usan las interfaces de múltiples links físicos? :\n" +
                        "R= Canal de puertos \n\n " ));
                //revisamos si el checkbox está marcado enviamos el ícono de la aplicación como adjunto

                //iniciamos la actividad
                startActivity(itSend);
            }
        });




    }
}



