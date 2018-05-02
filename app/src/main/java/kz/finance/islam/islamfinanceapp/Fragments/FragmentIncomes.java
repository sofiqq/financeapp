package kz.finance.islam.islamfinanceapp.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kz.finance.islam.islamfinanceapp.R;

public class FragmentIncomes extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {



        return inflater.inflate(R.layout.fragment_incomes, null);
    }
}
