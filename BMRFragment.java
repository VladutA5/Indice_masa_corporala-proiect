package com.example.imc;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.*;
import android.widget.*;
import androidx.fragment.app.Fragment;

public class BMRFragment extends Fragment {
    private EditText etGreutate, etInaltime, etVarsta;
    private TextView tvRezultat;
    private RadioGroup sexGroup;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bmr, container, false);

        etGreutate = view.findViewById(R.id.etGreutate);
        etInaltime = view.findViewById(R.id.etInaltime);
        etVarsta = view.findViewById(R.id.etVarsta);
        sexGroup = view.findViewById(R.id.sexGroup);
        tvRezultat = view.findViewById(R.id.tvRezultat);
        Button btn = view.findViewById(R.id.btnCalculeaza);

        btn.setOnClickListener(v -> {
            String g = etGreutate.getText().toString();
            String i = etInaltime.getText().toString();
            String varstaString = etVarsta.getText().toString(); // Schimbă 'v' în 'varstaString'

            if (TextUtils.isEmpty(g) || TextUtils.isEmpty(i) || TextUtils.isEmpty(varstaString)) {
                tvRezultat.setText("Completează toate câmpurile!");
                return;
            }

            float greutate = Float.parseFloat(g);
            float inaltime = Float.parseFloat(i);
            int varsta = Integer.parseInt(varstaString); // Folosește 'varstaString'

            boolean masculin = (sexGroup.getCheckedRadioButtonId() == R.id.radio_m);
            double bmr = masculin
                    ? 10 * greutate + 6.25 * inaltime - 5 * varsta + 5
                    : 10 * greutate + 6.25 * inaltime - 5 * varsta - 161;

            tvRezultat.setText(String.format("Calorii zilnice: %.0f kcal", bmr));
        });

        return view;
    }
}
