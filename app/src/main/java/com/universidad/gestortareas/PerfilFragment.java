package com.universidad.gestortareas;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class PerfilFragment extends Fragment {
    private TextView tvPendientes, tvBalance;
    private Button btnAbrirPanel;

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);
        tvPendientes = view.findViewById(R.id.tvPendientes);
        tvBalance = view.findViewById(R.id.tvBalance);
        btnAbrirPanel = view.findViewById(R.id.btnAbrirPanel);
        btnAbrirPanel.setOnClickListener(v -> ((MainActivity) getActivity()).mostrarPanelTareas());
        return view;
    }
}
