package com.gestortareas.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;

import com.gestortareas.R;

/**
 * Reusable pill-shaped button component adhering to the design specifications
 * defined in the project mockups (height: 44-50dp, corner radius: 24dp).
 */
public class AppButton extends AppCompatButton {

    public enum Variant {
        PRIMARY(0),
        SECONDARY(1),
        SUCCESS(2),
        GHOST(3);

        final int id;
        Variant(int id) {
            this.id = id;
        }

        static Variant fromId(int id) {
            for (Variant v : values()) {
                if (v.id == id) return v;
            }
            return PRIMARY;
        }
    }

    private Variant currentVariant = Variant.PRIMARY;

    public AppButton(@NonNull Context context) {
        super(context);
        init(context, null);
    }

    public AppButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public AppButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(@NonNull Context context, @Nullable AttributeSet attrs) {
        // Enforce touch target height (44-50 dp)
        setMinHeight(getResources().getDimensionPixelSize(R.dimen.btn_height_default));
        setGravity(Gravity.CENTER);
        setAllCaps(false);

        // Read XML attributes
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AppButton);
            int variantOrdinal = a.getInt(R.styleable.AppButton_btnVariant, 0);
            currentVariant = Variant.fromId(variantOrdinal);
            a.recycle();
        }

        applyVariantStyle();
    }

    /**
     * Applies styling according to the selected button variant.
     */
    public void setVariant(Variant variant) {
        this.currentVariant = variant;
        applyVariantStyle();
    }

    public Variant getVariant() {
        return currentVariant;
    }

    private void applyVariantStyle() {
        switch (currentVariant) {
            case SECONDARY:
                setBackgroundResource(R.drawable.bg_button_secondary);
                setTextColor(ContextCompat.getColor(getContext(), R.color.btn_secondary_text));
                break;
            case SUCCESS:
                setBackgroundResource(R.drawable.bg_button_success);
                setTextColor(ContextCompat.getColor(getContext(), R.color.btn_success_text));
                break;
            case GHOST:
                setBackgroundResource(R.drawable.bg_button_ghost);
                setTextColor(ContextCompat.getColor(getContext(), R.color.btn_ghost_text));
                break;
            case PRIMARY:
            default:
                setBackgroundResource(R.drawable.bg_button_primary);
                setTextColor(ContextCompat.getColor(getContext(), R.color.btn_primary_text));
                break;
        }
    }
}
