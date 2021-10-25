package com.example.samplefragment2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ListFragment extends Fragment {
    public static interface ImageSelectionCallback {
        public void onImageSelected(int position);
    }
    public ImageSelectionCallback callback;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ImageSelectionCallback) {callback = (ImageSelectionCallback) context;}
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_list, container, false);
        Button btn1 = rootView.findViewById(R.id.button);
        btn1.setOnClickListener(v -> {
                if (callback != null) {callback.onImageSelected(0);}
        });

        Button btn2 = rootView.findViewById(R.id.button2);
        btn2.setOnClickListener(v-> {
                if (callback != null) {callback.onImageSelected(1);}
        });

        Button btn3 = rootView.findViewById(R.id.button3);
        btn3.setOnClickListener(v-> {
                if (callback != null) {callback.onImageSelected(2);}
        });
        return rootView;
    }
}