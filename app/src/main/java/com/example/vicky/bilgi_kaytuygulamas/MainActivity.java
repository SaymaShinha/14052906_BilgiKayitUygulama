package com.example.vicky.bilgi_kaytuygulamas;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout Admin, Password, Ad, Soyad, TCKimlikNo, Telefon, E_mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Admin = (TextInputLayout) findViewById(R.id.kullancı_adı);
        Password = (TextInputLayout) findViewById(R.id.password);
        Ad = (TextInputLayout) findViewById(R.id.ad);
        Soyad = (TextInputLayout) findViewById(R.id.soyad);
        TCKimlikNo = (TextInputLayout) findViewById(R.id.tc_kimlik_No);
        Telefon = (TextInputLayout) findViewById(R.id.telefon);
        E_mail = (TextInputLayout) findViewById(R.id.e_mail);
    }

    public void ResimBilgilerininKayidi(View view)
    {
        String admin = Objects.requireNonNull(Admin.getEditText()).getText().toString();
        String password = Objects.requireNonNull(Password.getEditText()).getText().toString();
        String ad = Objects.requireNonNull(Ad.getEditText()).getText().toString();
        String soyad = Objects.requireNonNull(Soyad.getEditText()).getText().toString();
        String tc_kimlik_no = Objects.requireNonNull(TCKimlikNo.getEditText()).getText().toString();
        String telefon = Objects.requireNonNull(Telefon.getEditText()).getText().toString();
        String email = Objects.requireNonNull(E_mail.getEditText()).getText().toString();

        Admin.setErrorEnabled(true);
        Admin.setError(null);

        Password.setErrorEnabled(true);
        Password.setError(null);

        if((Admin.getEditText().getText() == null || admin.trim().equals("")) &&
                (Password.getEditText().getText() == null || password.trim().equals("")))
        {
            Admin.setErrorEnabled(false);
            Admin.setError("Cant be blank");

            Password.setErrorEnabled(false);
            Password.setError("Cant be blank");
        }

        else if(Admin.getEditText().getText() == null || admin.trim().equals(""))
        {
            Admin.setErrorEnabled(false);
            Admin.setError("Cant be blank");
        }

        else if(Password.getEditText().getText() == null || password.trim().equals(""))
        {
            Password.setErrorEnabled(false);
            Password.setError("Cant be blank");
        }

        else
        {
            Intent Goruntulu_Ekren_Intent = new Intent(this, InformationActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("ad",ad);
            bundle.putString("soyad",soyad);
            bundle.putString("tc_kimlik_no",tc_kimlik_no);
            bundle.putString("telefon",telefon);
            bundle.putString("email",email);

            Goruntulu_Ekren_Intent.putExtras(bundle);
            startActivity(Goruntulu_Ekren_Intent);
        }
    }

    public  void CleanAll(View view)
    {
        Objects.requireNonNull(Admin.getEditText()).setText(null);
        Objects.requireNonNull(Password.getEditText()).setText(null);
        Objects.requireNonNull(Ad.getEditText()).setText(null);
        Objects.requireNonNull(Soyad.getEditText()).setText(null);
        Objects.requireNonNull(TCKimlikNo.getEditText()).setText(null);
        Objects.requireNonNull(Telefon.getEditText()).setText(null);
        Objects.requireNonNull(E_mail.getEditText()).setText(null);

        Admin.setErrorEnabled(true);
        Admin.setError(null);

        Password.setErrorEnabled(true);
        Password.setError(null);
    }
}
