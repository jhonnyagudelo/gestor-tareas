package com.gestortareas.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.gestortareas.R;

/**
 * Base view component providing the layout structure described in the mockups:
 * - Gradient header with title and section badge
 * - 104dp vertical navigation rail
 * - Dynamic content container
 */
public class BaseView extends FrameLayout {

    public interface OnNavigationRailClickListener {
        void onSectionSelected(String sectionName);
    }

    private TextView tvHeaderBadge;
    private TextView tvHeaderTitle;
    private LinearLayout navigationRail;
    private FrameLayout contentContainer;

    private OnNavigationRailClickListener railListener;

    public BaseView(@NonNull Context context) {
        super(context);
        init(context, null);
    }

    public BaseView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public BaseView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(@NonNull Context context, @Nullable AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.view_base_container, this, true);

        tvHeaderBadge = findViewById(R.id.tvHeaderBadge);
        tvHeaderTitle = findViewById(R.id.tvHeaderTitle);
        navigationRail = findViewById(R.id.navigationRail);
        contentContainer = findViewById(R.id.contentContainer);

        setupRailClickListeners();

        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.BaseView);
            String title = a.getString(R.styleable.BaseView_headerTitle);
            String badge = a.getString(R.styleable.BaseView_badgeText);
            boolean showRail = a.getBoolean(R.styleable.BaseView_showNavigationRail, true);

            if (title != null) setHeaderTitle(title);
            if (badge != null) setBadge(badge);
            setNavigationRailVisible(showRail);

            a.recycle();
        }
    }

    private void setupRailClickListeners() {
        bindRailItem(R.id.navItemProfile, "profile");
        bindRailItem(R.id.navItemPhotos, "photos");
        bindRailItem(R.id.navItemVideo, "video");
        bindRailItem(R.id.navItemWeb, "web");
        bindRailItem(R.id.navItemButtons, "buttons");
    }

    private void bindRailItem(int viewId, String section) {
        View item = findViewById(viewId);
        if (item != null) {
            item.setOnClickListener(v -> {
                if (railListener != null) {
                    railListener.onSectionSelected(section);
                }
            });
        }
    }

    public void setHeaderTitle(String title) {
        if (tvHeaderTitle != null) {
            tvHeaderTitle.setText(title);
        }
    }

    public void setBadge(String badge) {
        if (tvHeaderBadge != null) {
            tvHeaderBadge.setText(badge);
        }
    }

    public void setNavigationRailVisible(boolean visible) {
        if (navigationRail != null) {
            navigationRail.setVisibility(visible ? View.VISIBLE : View.GONE);
        }
    }

    public void setContentLayout(@LayoutRes int layoutResId) {
        if (contentContainer != null) {
            contentContainer.removeAllViews();
            LayoutInflater.from(getContext()).inflate(layoutResId, contentContainer, true);
        }
    }

    public void setContentView(View view) {
        if (contentContainer != null) {
            contentContainer.removeAllViews();
            contentContainer.addView(view, new FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
            ));
        }
    }

    public FrameLayout getContentContainer() {
        return contentContainer;
    }

    public void setOnNavigationRailClickListener(OnNavigationRailClickListener listener) {
        this.railListener = listener;
    }
}
