package com.universidad.gestortareas;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class VideoFragment extends Fragment {
    private static final int REQ_VIDEO = 102;
    private VideoView videoView;
    private TextView tvVideoEstado;

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
        View view = inflater.inflate(R.layout.fragment_video, container, false);
        videoView = view.findViewById(R.id.videoView);
        tvVideoEstado = view.findViewById(R.id.tvVideoEstado);
        Button btnElegirVideo = view.findViewById(R.id.btnElegirVideo);
        MediaController controller = new MediaController(getActivity());
        controller.setAnchorView(videoView);
        videoView.setMediaController(controller);
        btnElegirVideo.setOnClickListener(v -> seleccionarVideo());
        return view;
    }

    private void seleccionarVideo() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("video/*");
        startActivityForResult(intent, REQ_VIDEO);
    }

    @Override public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_VIDEO && resultCode == android.app.Activity.RESULT_OK && data != null) {
            Uri uri = data.getData();
            if (uri != null) {
                videoView.setVideoURI(uri);
                videoView.start();
                tvVideoEstado.setText("Reproduciendo video seleccionado");
            }
        }
    }
}
