package com.example.imc;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.*;
import android.widget.*;
import androidx.fragment.app.Fragment;

public class WaterFragment extends Fragment {
    private EditText etGreutate;
    private TextView tvRezultat;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_water, container, false);

        etGreutate = view.findViewById(R.id.etGreutate);
        tvRezultat = view.findViewById(R.id.tvRezultat);
        Button btn = view.findViewById(R.id.btnCalculeaza);

        btn.setOnClickListener(v -> {
            String g = etGreutate.getText().toString();

            if (TextUtils.isEmpty(g)) {
                tvRezultat.setText("Introdu greutatea ta!");
                return;
            }

            float greutate = Float.parseFloat(g);
            float litri = greutate * 0.033f;

            tvRezultat.setText(String.format("Apă recomandată: %.2f litri/zi", litri));
        });

        return view;
    }
}
