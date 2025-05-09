package com.example.imc;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.*;
import android.widget.*;
import androidx.fragment.app.Fragment;

public class IMCFragment extends Fragment {
    private EditText etGreutate, etInaltime;
    private TextView tvRezultat;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_imc, container, false);

        etGreutate = view.findViewById(R.id.etGreutate);
        etInaltime = view.findViewById(R.id.etInaltime);
        tvRezultat = view.findViewById(R.id.tvRezultat);
        Button btn = view.findViewById(R.id.btnCalculeaza);

        btn.setOnClickListener(v -> {
            String greutateStr = etGreutate.getText().toString();
            String inaltimeStr = etInaltime.getText().toString();

            if (TextUtils.isEmpty(greutateStr) || TextUtils.isEmpty(inaltimeStr)) {
                tvRezultat.setText("Completează toate câmpurile!");
                return;
            }

            float greutate = Float.parseFloat(greutateStr);
            float inaltime = Float.parseFloat(inaltimeStr);

            float imc = greutate / (inaltime * inaltime);
            tvRezultat.setText(String.format("IMC: %.2f", imc));
        });

        return view;
    }
}
