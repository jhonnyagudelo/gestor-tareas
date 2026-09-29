package com.universidad.gestortareas;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FotosFragment extends Fragment {
    private static final int REQ_FOTO = 101;
    private ImageView imgSeleccionada;
    private TextView tvFotoEstado;

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
        View view = inflater.inflate(R.layout.fragment_fotos, container, false);
        imgSeleccionada = view.findViewById(R.id.imgSeleccionada);
        tvFotoEstado = view.findViewById(R.id.tvFotoEstado);
        Button btnSubirFoto = view.findViewById(R.id.btnSubirFoto);
        btnSubirFoto.setOnClickListener(v -> seleccionarFoto());
        return view;
    }

    private void seleccionarFoto() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("image/*");
        startActivityForResult(intent, REQ_FOTO);
    }

    @Override public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_FOTO && resultCode == android.app.Activity.RESULT_OK && data != null) {
            Uri uri = data.getData();
            if (uri != null) {
                imgSeleccionada.setImageURI(uri);
                tvFotoEstado.setText("Foto seleccionada correctamente");
            }
        }
    }
}
