package com.example.mynavapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.mynavapp.MainActivity;
import com.example.mynavapp.R;


public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);

       // LinearLayout newclient = root.findViewById(R.id.newclientformTextView);

        //populating the dropdown menus with yes/no
        Spinner tca_spinner = (Spinner) root.findViewById(R.id.matchtca_spinner);
        Spinner adr_spinner = (Spinner) root.findViewById(R.id.adr_spinner);
        Spinner sexual_spinner = (Spinner) root.findViewById(R.id.sexualpartner_spinner);
        Spinner selftest_spinner = (Spinner) root.findViewById(R.id.issuedselftestkit_spinner);
        Spinner testresults_spinner = (Spinner) root.findViewById(R.id.testresults_spinner);
        Spinner stressful_spinner = (Spinner) root.findViewById(R.id.stressful_spinner);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.yes_no, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        tca_spinner.setAdapter(adapter);
        adr_spinner.setAdapter(adapter);
        sexual_spinner.setAdapter(adapter);
        selftest_spinner.setAdapter(adapter);
        testresults_spinner.setAdapter(adapter);
        stressful_spinner.setAdapter(adapter);

        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }


    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        //newFragment.show(getSupportFragmentManager(), "datePicker");
    }





}
