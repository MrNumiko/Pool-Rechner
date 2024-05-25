package com.example.pool_rechner.ui.rectangle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.pool_rechner.databinding.FragmentRectangleBinding;

import java.text.DecimalFormat;

public class RectangleFragment extends Fragment {
    private FragmentRectangleBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentRectangleBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnCalcRectangle.setOnClickListener(v -> performCalculation());
    }

    private void performCalculation() {
        // Get entered values
        String in_length = binding.nbLengthRectangle.getText().toString();
        String in_width = binding.nbWidthRectangle.getText().toString();
        String in_height = binding.nbHeightRectangle.getText().toString();

        // Check if either input field is empty
        if (in_length.isEmpty() || in_width.isEmpty() || in_height.isEmpty()) {
            Toast.makeText(getActivity(), "Please enter all numbers", Toast.LENGTH_SHORT).show();
            return; // Exit the method to prevent calculations with empty inputs
        }

        // Convert Strings to doubles
        double length = Double.parseDouble(in_length);
        double width = Double.parseDouble(in_width);
        double height = Double.parseDouble(in_height);

        // Calculate result, convert to decimalFormat and set text
        double result = length * width * height;
        DecimalFormat df = new DecimalFormat("#.##");
        binding.inputSizeRectangle.setText(df.format(result));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
