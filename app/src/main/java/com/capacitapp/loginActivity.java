package com.capacitapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class loginActivity extends AppCompatActivity {

    BaseDeDatos mibd;
    EditText emailEditText, passwordEditText;
    private ImageView imgBackArrow;

    //EditText tvEmail, tvPass;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        mibd = new BaseDeDatos(this);
        emailEditText = findViewById(R.id.editTextTextEmailAddress);
        passwordEditText = findViewById(R.id.editTextTextPassword);

        imgBackArrow = findViewById(R.id.btn_back);

        //tvEmail = findViewById(R.id.editTextTextEmailAddress);
        //tvPass = findViewById(R.id.editTextTextPassword);
        btn = findViewById(R.id.button2);

        TextView registrarseTextView = findViewById(R.id.textV_registrarse_login);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                    Toast.makeText(loginActivity.this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (mibd.verificarUsuario(email, password)) {
                    Toast.makeText(loginActivity.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(loginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(loginActivity.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        registrarseTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginActivity.this, RegistroActivity.class);
                startActivity(intent);
            }
        });

        imgBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(loginActivity.this, InicioActivity.class);
                startActivity(intent);

            }
        });

    }


    /*public void login() {
        String useremail = tvEmail.getText().toString();
        String password = tvPass.getText().toString();

        if (useremail.equals("") || password.equals("")) {
            Toast.makeText(loginActivity.this, "Email o contraseña no ingresado", Toast.LENGTH_LONG).show();
        } else if (useremail.equals("admin@email.com") && password.equals("1234")) {
            Intent i = new Intent(loginActivity.this, MainActivity.class);
            startActivity(i);
        } else {
            Toast.makeText(loginActivity.this, "Email o Password erroneos", Toast.LENGTH_LONG).show();
        }

    }*/
}