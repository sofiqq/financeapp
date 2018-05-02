package kz.finance.islam.islamfinanceapp.Fragments;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.zip.Inflater;

import kz.finance.islam.islamfinanceapp.R;

import static android.content.Context.MODE_PRIVATE;

public class FragmentIncomes extends Fragment {

    SharedPreferences sPref;

    TextView tvIncomes;
    ImageView ivAdd;
    EditText etSum;

    int currentIncomes;

    final String SAVED_INCOMES = "saved_incomes";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_incomes, container, false);
        tvIncomes = (TextView) rootView.findViewById(R.id.tv_incomes);
        ivAdd = (ImageView) rootView.findViewById(R.id.iv_add);
        etSum = (EditText) rootView.findViewById(R.id.et_sum);

        sPref = getActivity().getPreferences(MODE_PRIVATE);

        currentIncomes = sPref.getInt(SAVED_INCOMES, 0);
        tvIncomes.setText(currentIncomes + " тг.");

        ivAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etSum.getText().equals("") && etSum != null) {
                    currentIncomes += Integer.parseInt(etSum.getText().toString());
                    tvIncomes.setText(currentIncomes + " тг.");
                    etSum.setText("");
                    SharedPreferences.Editor ed = sPref.edit();
                    ed.putInt(SAVED_INCOMES, currentIncomes);
                    ed.commit();
                }
            }
        });

        return rootView;
    }
}
