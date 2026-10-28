package com.example.processologin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SessioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sessio);

        TextView benvinguda = findViewById(R.id.txtBenvinguda);
        Button tancar = findViewById(R.id.btnTancarSessio);

        String nom = getIntent().getStringExtra("NOMBRE");
        benvinguda.setText("Benvingut/da, " + nom + "!");

        tancar.setOnClickListener(v -> {
            Intent intent = new Intent(SessioActivity.this, LogoutActivity.class);

            Bundle bundle = new Bundle();
            bundle.putString("NOMBRE", nom);
            bundle.putString("MISSATGE", "Fins aviat, " + nom + "!");
            intent.putExtras(bundle);

            startActivity(intent);
            finish();
        });
    }
}