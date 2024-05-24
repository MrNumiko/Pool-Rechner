package com.example.pool_rechner.ui.imprint;

import android.graphics.Color;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.pool_rechner.R;
import com.example.pool_rechner.databinding.FragmentImprintBinding;

public class ImprintFragment extends Fragment {

    private FragmentImprintBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ImprintViewModel ImprintViewModel =
                new ViewModelProvider(this).get(ImprintViewModel.class);

        binding = FragmentImprintBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Text view number 1 to add hyperlink
        TextView linkTextView = requireActivity().findViewById(R.id.imprint_web);

        // method to redirect to provided link
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());

        // method to change color of link
        linkTextView.setLinkTextColor(Color.BLUE);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
