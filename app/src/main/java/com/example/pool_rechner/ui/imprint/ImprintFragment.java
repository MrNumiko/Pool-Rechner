package com.example.pool_rechner.ui.imprint;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.pool_rechner.R;
import com.example.pool_rechner.databinding.FragmentImprintBinding;

public class ImprintFragment extends Fragment {

    private FragmentImprintBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentImprintBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Send email
        binding.imprintEmail.setLinkTextColor(Color.BLUE);
        binding.imprintEmail.setOnClickListener(v -> sendEmail());

        // Text view to add hyperlink
        TextView linkTextView = requireActivity().findViewById(R.id.imprint_web);

        // method to redirect to provided link
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());

        // method to change color of link
        linkTextView.setLinkTextColor(Color.BLUE);
    }

    @SuppressLint("IntentReset")
    protected void sendEmail() {
        Log.i("Send email", "");

        // Define mail address and cc
        String[] TO = {"support@hmnj.de"};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        // Define type to plain text
        emailIntent.setType("text/plain");
        // Convert uri to accepted email format
        emailIntent.setData(Uri.parse("mailto:"));

        // Set mail address and cc
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);

        // Send mail with error handling if no email client available on the device
        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            requireActivity().finish();
            Log.i("Finished sending email...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getActivity(),
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
