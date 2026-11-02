package com.zehranur.egemuzerehberi;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    // EditText'leri en üstte tanımlıyoruz ki her yerden ulaşalım
    EditText etName, etEmail, etUser, etPass;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        dbHelper = new DatabaseHelper(this);

        // Kutucukları eşleştiriyoruz
        etName = findViewById(R.id.etRegFullName);
        etEmail = findViewById(R.id.etRegEmail);
        etUser = findViewById(R.id.etRegUsername);
        etPass = findViewById(R.id.etRegPassword);
    }

    // XML'deki android:onClick satırı doğrudan burayı çalıştırır
    public void kayitOlButonunaBasildi(View v) {

        String name = etName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String user = etUser.getText().toString().trim();
        String pass = etPass.getText().toString().trim();

        if (name.isEmpty() || email.isEmpty() || user.isEmpty() || pass.isEmpty()) {
            Toast.makeText(this, "Lütfen tüm alanları doldurun!", Toast.LENGTH_SHORT).show();
        } else {
            // VERİTABANINA KAYDETME İŞLEMİ
            boolean isInserted = dbHelper.addUser(name, email, user, pass);

            if (isInserted) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Başarılı");
                builder.setMessage("Bilgileriniz SQLite veritabanına kaydedildi!");
                builder.setPositiveButton("Tamam", new android.content.DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(android.content.DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.show();
            } else {
                Toast.makeText(this, "Kayıt sırasında bir hata oluştu!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}