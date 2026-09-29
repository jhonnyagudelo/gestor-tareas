package com.universidad.gestortareas;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class WebFragment extends Fragment {
    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
        View view = inflater.inflate(R.layout.fragment_web, container, false);
        Button btnDocs = view.findViewById(R.id.btnDocs);
        Button btnSprint = view.findViewById(R.id.btnSprint);
        Button btnEstado = view.findViewById(R.id.btnEstado);
        btnDocs.setOnClickListener(v -> abrirUrl("https://developer.android.com/"));
        btnSprint.setOnClickListener(v -> abrirUrl("https://github.com/"));
        btnEstado.setOnClickListener(v -> abrirUrl("https://www.google.com/"));
        return view;
    }

    private void abrirUrl(String url) {
        try { startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url))); }
        catch (Exception e) { Toast.makeText(getActivity(), "No hay navegador disponible", Toast.LENGTH_SHORT).show(); }
    }
}
