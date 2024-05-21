package com.example.pool_rechner.ui.rectangle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.pool_rechner.databinding.FragmentRectangleBinding;

public class RectangleFragment extends Fragment {
    private FragmentRectangleBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        RectangleViewModel RectangleViewModel =
                new ViewModelProvider(this).get(RectangleViewModel.class);

        binding = FragmentRectangleBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
