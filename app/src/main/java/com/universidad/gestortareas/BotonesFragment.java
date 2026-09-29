package com.universidad.gestortareas;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class BotonesFragment extends Fragment {
    private EditText etTituloTarea;
    private RadioGroup rgEstado;
    private TextView tvResultado;
    private SharedPreferences prefs;

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
        View view = inflater.inflate(R.layout.fragment_botones, container, false);
        etTituloTarea = view.findViewById(R.id.etTituloTarea);
        rgEstado = view.findViewById(R.id.rgEstado);
        tvResultado = view.findViewById(R.id.tvResultado);
        Button btnNueva = view.findViewById(R.id.btnNuevaTarea);
        Button btnDuplicar = view.findViewById(R.id.btnDuplicar);
        Button btnDescartar = view.findViewById(R.id.btnDescartar);
        prefs = getActivity().getSharedPreferences("gestor_tareas", 0);
        cargarUltimaTarea();
        btnNueva.setOnClickListener(v -> guardarTarea());
        btnDuplicar.setOnClickListener(v -> duplicarTarea());
        btnDescartar.setOnClickListener(v -> descartarTarea());
        rgEstado.setOnCheckedChangeListener((group, checkedId) -> actualizarVistaPrevia());
        return view;
    }

    private String estadoSeleccionado() {
        int id = rgEstado.getCheckedRadioButtonId();
        if (id == R.id.rbPausado) return "PAUSADO";
        if (id == R.id.rbArchivado) return "ARCHIVADO";
        return "ACTIVO";
    }

    private void guardarTarea() {
        String titulo = etTituloTarea.getText().toString().trim();
        if (titulo.isEmpty()) {
            etTituloTarea.setError("Escribe el título de la tarea");
            return;
        }
        String estado = estadoSeleccionado();
        prefs.edit().putString("titulo", titulo).putString("estado", estado).apply();
        tvResultado.setText("Tarea guardada: " + titulo + "\nEstado: " + estado);
        Toast.makeText(getActivity(), "Tarea guardada", Toast.LENGTH_SHORT).show();
    }

    private void duplicarTarea() {
        String titulo = etTituloTarea.getText().toString().trim();
        if (titulo.isEmpty()) titulo = prefs.getString("titulo", "Tarea");
        etTituloTarea.setText(titulo + " - copia");
        actualizarVistaPrevia();
    }

    private void descartarTarea() {
        etTituloTarea.setText("");
        rgEstado.check(R.id.rbActivo);
        prefs.edit().clear().apply();
        tvResultado.setText("Tarea descartada. Puedes crear una nueva.");
    }

    private void cargarUltimaTarea() {
        String titulo = prefs.getString("titulo", "");
        String estado = prefs.getString("estado", "ACTIVO");
        etTituloTarea.setText(titulo);
        if ("PAUSADO".equals(estado)) rgEstado.check(R.id.rbPausado);
        else if ("ARCHIVADO".equals(estado)) rgEstado.check(R.id.rbArchivado);
        else rgEstado.check(R.id.rbActivo);
        if (!titulo.isEmpty()) tvResultado.setText("Última tarea: " + titulo + "\nEstado: " + estado);
    }

    private void actualizarVistaPrevia() {
        String titulo = etTituloTarea.getText().toString().trim();
        if (!titulo.isEmpty()) tvResultado.setText("Vista previa: " + titulo + "\nEstado: " + estadoSeleccionado());
    }
}
