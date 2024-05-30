package com.example.pool_rechner.ui.circle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.pool_rechner.databinding.FragmentCircleBinding;

import java.text.DecimalFormat;

public class CircleFragment extends Fragment {
    private FragmentCircleBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentCircleBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);

        binding.btnCalcCircle.setOnClickListener(v -> performCalculation());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            requireActivity().getOnBackPressedDispatcher().onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    private void performCalculation() {
        // Get entered values
        String in_radius = binding.nbRadiusCircle.getText().toString();
        String in_height = binding.nbHeightCircle.getText().toString();

        // Check if either input field is empty
        if (in_radius.isEmpty() || in_height.isEmpty()) {
            Toast.makeText(getActivity(), "Please enter all numbers", Toast.LENGTH_SHORT).show();
            return; // Exit the method to prevent calculations with empty inputs
        }

        // Convert Strings to doubles
        double radius = Double.parseDouble(in_radius);
        double height = Double.parseDouble(in_height);

        // Calculate result, convert to decimalFormat and set text
        double result = Math.PI * Math.pow(radius, 2) * height;
        DecimalFormat df = new DecimalFormat("#.##");
        binding.inputSizeCircle.setText(df.format(result));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
