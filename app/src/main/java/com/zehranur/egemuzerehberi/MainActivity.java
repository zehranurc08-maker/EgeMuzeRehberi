package com.zehranur.egemuzerehberi;

import android.content.Intent; // Eksik olan buydu
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //DEĞİŞKEN TANIMLAMA ALANI
    EditText etUser, etPass;
    Button btnLogin;
    TextView tvRegister;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  BAĞLAMA ALANI
        etUser = findViewById(R.id.etLoginUsername);
        etPass = findViewById(R.id.etLoginPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvRegister = findViewById(R.id.tvGoToRegister);

        dbHelper = new DatabaseHelper(this);

        //  GİRİŞ YAP BUTONU
        btnLogin.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = etUser.getText().toString().trim();
                String pass = etPass.getText().toString().trim();

                if (user.isEmpty() || pass.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Boş alan bırakmayın!", Toast.LENGTH_SHORT).show();
                } else {
                    if (dbHelper.checkUser(user, pass) || (user.equals("admin") && pass.equals("123"))) {
                        // Hem veritabanındaki bilgilerle, hem de admin/123 ile girebilirsin.
                        Toast.makeText(MainActivity.this, "Giriş Başarılı!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(MainActivity.this, "Hatalı Kullanıcı!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        // KAYIT OL YAZISINA TIKLANDIĞINDA (Sayfa Geçişi)
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }
}