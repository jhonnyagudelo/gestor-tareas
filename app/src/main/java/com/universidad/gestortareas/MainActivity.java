package com.universidad.gestortareas;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends Activity {
    private Button btnPerfil, btnFotos, btnVideo, btnWeb, btnBotones;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vincularVistas();
        declararEventos();
        if (savedInstanceState == null) mostrarFragmento(new PerfilFragment());
    }

    private void vincularVistas() {
        btnPerfil = findViewById(R.id.btnPerfil);
        btnFotos = findViewById(R.id.btnFotos);
        btnVideo = findViewById(R.id.btnVideo);
        btnWeb = findViewById(R.id.btnWeb);
        btnBotones = findViewById(R.id.btnBotones);
    }

    private void declararEventos() {
        btnPerfil.setOnClickListener(v -> mostrarFragmento(new PerfilFragment()));
        btnFotos.setOnClickListener(v -> mostrarFragmento(new FotosFragment()));
        btnVideo.setOnClickListener(v -> mostrarFragmento(new VideoFragment()));
        btnWeb.setOnClickListener(v -> mostrarFragmento(new WebFragment()));
        btnBotones.setOnClickListener(v -> mostrarFragmento(new BotonesFragment()));
    }

    public void mostrarPanelTareas() { mostrarFragmento(new BotonesFragment()); }

    private void mostrarFragmento(Fragment fragment) {
        getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, fragment).commit();
    }
}
