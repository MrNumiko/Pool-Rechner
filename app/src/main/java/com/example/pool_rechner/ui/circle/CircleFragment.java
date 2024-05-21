package com.example.pool_rechner.ui.circle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.pool_rechner.databinding.FragmentCircleBinding;

public class CircleFragment extends Fragment {
    private FragmentCircleBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CircleViewModel CircleViewModel =
                new ViewModelProvider(this).get(CircleViewModel.class);

        binding = FragmentCircleBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
