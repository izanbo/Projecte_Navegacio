package com.example.processologin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class LogoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_logout);

        TextView txtRes = findViewById(R.id.txtRes);
        Button button = findViewById(R.id.logout);

        Bundle bundle = getIntent().getExtras();
        String missatge = (bundle != null) ? bundle.getString("MISSATGE") : "";
        txtRes.setText("Sessió tancada. " + missatge);

        button.setOnClickListener(v -> {
            Intent intent = new Intent(LogoutActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // evita acumulación en la pila
        });
    }
}