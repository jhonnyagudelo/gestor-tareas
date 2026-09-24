package com.gestortareas.views;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.gestortareas.R;
import com.gestortareas.components.AppButton;
import com.gestortareas.components.BaseView;

/**
 * Main activity displaying the mockup controls and demonstrating the
 * BaseView container and AppButton component in action.
 */
public class MainActivity extends AppCompatActivity {

    private BaseView baseView;
    private AppButton btnNewTask;
    private AppButton btnDuplicate;
    private AppButton btnUploadPhoto;
    private AppButton btnDiscard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        baseView = findViewById(R.id.baseView);
        btnNewTask = findViewById(R.id.btnNewTask);
        btnDuplicate = findViewById(R.id.btnDuplicate);
        btnUploadPhoto = findViewById(R.id.btnUploadPhoto);
        btnDiscard = findViewById(R.id.btnDiscard);

        setupListeners();
    }

    private void setupListeners() {
        if (baseView != null) {
            baseView.setOnNavigationRailClickListener(sectionName -> {
                Toast.makeText(this, "Navigating to: " + sectionName, Toast.LENGTH_SHORT).show();
            });
        }

        if (btnNewTask != null) {
            btnNewTask.setOnClickListener(v ->
                    Toast.makeText(this, "Nueva tarea clicked", Toast.LENGTH_SHORT).show()
            );
        }

        if (btnDuplicate != null) {
            btnDuplicate.setOnClickListener(v ->
                    Toast.makeText(this, "Duplicar clicked", Toast.LENGTH_SHORT).show()
            );
        }

        if (btnUploadPhoto != null) {
            btnUploadPhoto.setOnClickListener(v ->
                    Toast.makeText(this, "Subir foto clicked", Toast.LENGTH_SHORT).show()
            );
        }

        if (btnDiscard != null) {
            btnDiscard.setOnClickListener(v ->
                    Toast.makeText(this, "Descartar clicked", Toast.LENGTH_SHORT).show()
            );
        }
    }
}
