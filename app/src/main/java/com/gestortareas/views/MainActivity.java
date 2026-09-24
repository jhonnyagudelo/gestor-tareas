package com.gestortareas.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.gestortareas.R;
import com.gestortareas.components.AppButton;
import com.gestortareas.components.BaseView;

/**
 * Activity que carga la plantilla base y el componente de botón reutilizable.
 */
public class MainActivity extends AppCompatActivity {

    private BaseView baseViewTemplate;
    private AppButton btnComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencia a la plantilla y al componente de botón
        baseViewTemplate = (BaseView) findViewById(R.id.baseViewTemplate);
        btnComponent = (AppButton) findViewById(R.id.btnComponent);

        if (btnComponent != null) {
            btnComponent.setOnClickListener(v -> 
                Toast.makeText(this, "Click en componente AppButton", Toast.LENGTH_SHORT).show()
            );
        }
    }
}
