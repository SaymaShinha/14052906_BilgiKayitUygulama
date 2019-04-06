package com.example.vicky.bilgi_kaytuygulamas;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class InformationActivity extends AppCompatActivity {

    private static final int REQUEST_PHONE_CALL = 2;
    private String ad, soyad, tc_kimlik_no, telefon, email;
    private TextView t_ad, t_soyad, t_tc_kimlik_no, t_telefon, t_email;
    private RecyclerView recyclerView;
    private List<DersList> dersListList = new ArrayList<>();
    private DersListesiAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setVisibility(View.INVISIBLE);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            ad = extras.getString("ad");
            soyad = extras.getString("soyad");
            tc_kimlik_no = extras.getString("tc_kimlik_no");
            telefon = extras.getString("telefon");
            email = extras.getString("email");
        }

        t_ad = (TextView) findViewById(R.id.name);
        t_soyad = (TextView) findViewById(R.id.surname);
        t_tc_kimlik_no = (TextView) findViewById(R.id.TcKimlikNo);
        t_telefon = (TextView) findViewById(R.id.telephone);
        t_email = (TextView) findViewById(R.id.Email);

        t_ad.setText("Ad :   " + ad);
        t_soyad.setText("SoyAd :   " + soyad);
        t_tc_kimlik_no.setText("TC Kimlik No :   " + tc_kimlik_no);
        t_telefon.setText("Telefon :   " + telefon);
        t_email.setText("Email :   " + email);
    }

    public void Call(View view) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + telefon));

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_PHONE_CALL);
        }
        else
        {
            startActivity(intent);
        }
    }

    public void SendEmail(View view)
    {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        intent.setType("text/plain");
        intent.setType("message/rfc822");
        intent.putExtra(Intent.EXTRA_EMAIL  , new String[]{email});

        try {
            startActivity(Intent.createChooser(intent, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }

    public void DersListe(View view)
    {
        recyclerView.setVisibility(View.VISIBLE);
        mAdapter = new DersListesiAdapter(dersListList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareDersList();
    }

    public class DersListesiAdapter extends RecyclerView.Adapter<DersListesiAdapter.MyViewHolder> {

        private List<DersList> dersLists;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView dersnot;
            public Button ders;
            List<String> noteOrtalama;

            public MyViewHolder(View view) {
                super(view);
                dersnot = (TextView) view.findViewById(R.id.ders_notu);
                ders = (Button) view.findViewById(R.id.ders_button);
            }
        }


        public DersListesiAdapter(List<DersList> dersLists) {
            this.dersLists = dersLists;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.ders_listesi, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            final DersList derses = dersLists.get(position);
            holder.ders.setText(derses.getDers());
            holder.dersnot.setText(derses.getDersnot());

            holder.ders.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), DersDetayActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("dersadi",derses.getDers());
                    bundle.putString("dersortalama",derses.getDersOrtalama());
                    bundle.putString("ogrencisayi",derses.getOgrenciSayi());
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return dersLists.size();
        }
    }

    private void prepareDersList() {
        DersList ders = new DersList("Ders", "DersNotu", "", "");
        dersListList.add(ders);

        ders = new DersList("Mathematics 1", "60", "60", "70");
        dersListList.add(ders);

        ders = new DersList("Mathematics 2", "70", "50", "70");
        dersListList.add(ders);

        ders = new DersList("Mathematics 3", "65", "60","70");
        dersListList.add(ders);

        ders = new DersList("Physics", "70", "60","70");
        dersListList.add(ders);

        ders = new DersList("Chemistry", "80","60", "70");
        dersListList.add(ders);

        ders = new DersList("Programming language", "70", "60","70");
        dersListList.add(ders);

        ders = new DersList("Lineer Algebra", "70", "60","70");
        dersListList.add(ders);

        ders = new DersList("Geometry", "70", "60","70");
        dersListList.add(ders);



        mAdapter.notifyDataSetChanged();
    }

}
