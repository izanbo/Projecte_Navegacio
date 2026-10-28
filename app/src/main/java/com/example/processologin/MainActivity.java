package com.example.processologin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText usuari = findViewById(R.id.nom);
        EditText contra = findViewById(R.id.contra);
        Button button = findViewById(R.id.login);

        button.setOnClickListener(v -> {
            String user = usuari.getText().toString().trim();
            String pass = contra.getText().toString().trim();

            if (user.isEmpty() || pass.isEmpty()) {
                Toast.makeText(MainActivity.this,
                        "Has d'omplir tots els camps", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(MainActivity.this, SessioActivity.class);
            intent.putExtra("NOMBRE", user);
            startActivity(intent);
            finish();
        });
    }
}