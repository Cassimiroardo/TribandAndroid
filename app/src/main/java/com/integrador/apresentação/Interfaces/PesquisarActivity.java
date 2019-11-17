package com.integrador.apresentação.Interfaces;

import android.Manifest;
import android.app.TimePickerDialog;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.DialogFragment;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.integrador.apresentação.Fragments.TimePickerFragment;
import com.integrador.apresetação.R;
import com.integrador.model.Estudio;
import com.integrador.model.Localizacao;
import com.integrador.services.EstudioService;
import com.integrador.services.RetrofitUtils;

import java.sql.Time;
import java.util.ArrayList;

public class PesquisarActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    private EditText etBarato;
    private CheckBox cbPerto;
    private EditText etPesquisar;
    private Button btPesquisar;
    private TextView tvFim;
    private TextView tvInicio;
    private DialogFragment timePicker = new TimePickerFragment();
    private FusedLocationProviderClient client;

    private ArrayList<Estudio> estudios = new ArrayList<>();
    private EstudioService estudioService;

    private Time inicio;
    private Time fim;

    private Double latitude;
    private Double longitude;
    private Float raio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisar);
        inicializa();
    }

    private void inicializa() {
        this.client = LocationServices.getFusedLocationProviderClient(this);
        this.estudioService = RetrofitUtils.retrofit.create(EstudioService.class);
        this.tvFim = findViewById(R.id.tv_fim);
        this.tvInicio = findViewById(R.id.tv_inicio);
        this.btPesquisar = findViewById(R.id.bt_send);
        this.etBarato = findViewById(R.id.et_barato);
        this.cbPerto = findViewById(R.id.cb_proximo);
        this.etPesquisar = findViewById(R.id.et_pesquisa);
    }

    private void timePickerInicio(View view) {
        this.timePicker.show(getSupportFragmentManager(), "Inicio");
    }

    private void timePickerFim(View view) {
        this.timePicker.show(getSupportFragmentManager(), "Fim");
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        if (this.tvInicio.getText().toString().equalsIgnoreCase("hora inicio")) {
            this.tvInicio.setText(i + ":" + i1);
        } else if (this.tvFim.getText().toString().equalsIgnoreCase("hora fim")) {
            this.tvFim.setText(i + ":" + i1);
        } else {
            this.tvInicio.setText("HORA INICIO");
            this.tvFim.setText("HORA FIM");
        }
    }

    private void busca() {
        this.btPesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                boolean in = !tvInicio.getText().toString().equalsIgnoreCase("hora inicio");
                boolean fi = !tvFim.getText().toString().equalsIgnoreCase("hora fim");



                if (cbPerto.isChecked() && in && fi) {
                    // pesquisa por todos

                   if (ActivityCompat.checkSelfPermission(PesquisarActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
                        return;
                    }

                    client.getLastLocation()
                            .addOnSuccessListener(new OnSuccessListener<Location>() {
                                @Override
                                public void onSuccess(Location location) {
                                if(location != null){
                                    latitude = location.getLatitude();
                                    longitude = location.getLongitude();
                                    raio = location.getAccuracy();
                                }else{
                                    Toast.makeText(PesquisarActivity.this, "Localização null!!", Toast.LENGTH_SHORT).show();
                                }
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                        }
                    });

               // estudios = estudioService.buscarPorFiltro(latitude,longitude,raio,);

                }
            }
        });
    }


}
