package com.example.vicky.bilgi_kaytuygulamas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DersDetayActivity extends AppCompatActivity {
    private TextView t_ders, t_ders_ortalama, t_ogrenci_sayi;
    private String ders, ders_ortalama, ogrenci_sayi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ders_detay);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
             ders = extras.getString("dersadi");
             ders_ortalama = extras.getString("dersortalama");
             ogrenci_sayi = extras.getString("ogrencisayi");
        }

        t_ders = (TextView) findViewById(R.id.ders_adi);
        t_ders_ortalama = (TextView) findViewById(R.id.ders_ortalama);
        t_ogrenci_sayi = (TextView) findViewById(R.id.ogrenci_sayi);

        t_ders.setText(ders);
        t_ders_ortalama.setText(ders_ortalama);
        t_ogrenci_sayi.setText(ogrenci_sayi);
    }
}
