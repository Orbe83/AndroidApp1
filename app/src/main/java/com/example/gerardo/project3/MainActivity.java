package com.example.gerardo.project3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.graphics.Color;
import android.content.res.Resources;
import android.util.TypedValue;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Se crea un nuevo Layout dentro del MainActivity
        RelativeLayout rLayout = new RelativeLayout(this);
        rLayout.setBackgroundColor(Color.GREEN);

        //Se crea un nuevo botón en el MainActivity
        Button button = new Button(this);
        button.setText("Click Me!");
        button.setBackgroundColor(Color.RED);

        //Se crea un nuevo EditText en el MainActivity
        EditText username = new EditText(this);

        //Asignar Id's
        button.setId(1);
        username.setId(2);

        //Se crea un objeto buttonDetails el cual contendrá las medidas horizontales y verticales de la pantalla del celular
        RelativeLayout.LayoutParams buttonDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        //Se crea un objeto usernameDetails el cual contendrá las medidas horizontales y verticales de la pantalla del celular
        RelativeLayout.LayoutParams usernameDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        //Se asignan reglas para posicionar username arriba del button, centrado horizontalmente y con un margen de 50 entre los dos
        usernameDetails.addRule(RelativeLayout.ABOVE, button.getId());
        usernameDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        usernameDetails.setMargins(0, 0, 0, 50);

        //Se asignan reglas para centrar el próximo botón
        buttonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonDetails.addRule(RelativeLayout.CENTER_VERTICAL);

        //Obtener Resources de la aplicación
        Resources r = getResources();

        //Guardar los pixeles a usar. Mediante el método applyDimension se obtiene la conversión de los DIP que damos a pixeles
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,200,
                r.getDisplayMetrics()
                );

        //Se especifica el ancho del EditText username
        username.setWidth(px);

        //Se agrega el widget del botón y username con las reglas a seguir al agregarlos (button y username ahora son hijos de rLayout)
        rLayout.addView(button, buttonDetails);
        rLayout.addView(username, usernameDetails);

        //Se asigna rLayout para su vista
        setContentView(rLayout);
    }
}
