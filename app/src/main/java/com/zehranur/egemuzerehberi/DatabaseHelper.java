package com.zehranur.egemuzerehberi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Veritabanı Bilgileri
    private static final String DATABASE_NAME = "EgeMuze.db";

    private static final int DATABASE_VERSION = 1;

    // Tablo ve Sütun İsimleri
    private static final String TABLE_USERS = "users";
    private static final String COL_ID = "id";
    private static final String COL_NAME = "full_name";
    private static final String COL_EMAIL = "email";
    private static final String COL_USERNAME = "username";
    private static final String COL_PASSWORD = "password";

    public DatabaseHelper(Context context) {

        super(context, DATABASE_NAME ,null,DATABASE_VERSION );
    }

    // Veritabanı ilk kez oluşturulduğunda çalışır
    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE = "CREATE TABLE " + TABLE_USERS + "("
                + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COL_NAME + " TEXT,"
                + COL_EMAIL + " TEXT,"
                + COL_USERNAME + " TEXT,"
                + COL_PASSWORD + " TEXT" + ")";
        db.execSQL(CREATE_TABLE);
    }

    // Veritabanı güncellendiğinde (versiyon arttığında) çalışır
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    // YENİ KULLANICI EKLEME METODU (Kayıt ekranı için)
    public boolean addUser(String name, String email, String user, String pass) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NAME, name);
        values.put(COL_EMAIL, email);
        values.put(COL_USERNAME, user);
        values.put(COL_PASSWORD, pass);

        long result = db.insert(TABLE_USERS, null, values);
        return result != -1; // Kayıt başarılıysa true döner
    }
    // KULLANICI GİRİŞ KONTROLÜ (Login için)
    public boolean checkUser(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        // Sorguyu daha net yazalım
        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE username = ? AND password = ?", new String[]{username, password});

        int count = cursor.getCount();
        cursor.close(); // Belleği yormamak için her zaman kapatmalıyız

        return count > 0;
    }
    }
