package kz.finance.islam.islamfinanceapp;

import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import kz.finance.islam.islamfinanceapp.Fragments.FragmentCosts;
import kz.finance.islam.islamfinanceapp.Fragments.FragmentIncomes;
import kz.finance.islam.islamfinanceapp.Fragments.FragmentReport;

public class MainActivity extends AppCompatActivity {

    FragmentCosts fragmentCosts;
    FragmentIncomes fragmentIncomes;
    FragmentReport fragmentReport;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentCosts = new FragmentCosts();
        fragmentIncomes = new FragmentIncomes();
        fragmentReport = new FragmentReport();

        fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.ll_container, fragmentCosts);
        fragmentTransaction.commit();

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_menu);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                fragmentTransaction = getFragmentManager().beginTransaction();
                switch (item.getItemId()) {
                    case R.id.action_costs:
                        fragmentTransaction.replace(R.id.ll_container, fragmentCosts);
                        fragmentTransaction.commit();
                        break;
                    case R.id.action_incomes:
                        fragmentTransaction.replace(R.id.ll_container, fragmentIncomes);
                        fragmentTransaction.commit();
                        break;
                    case R.id.action_report:
                        fragmentTransaction.replace(R.id.ll_container, fragmentReport);
                        fragmentTransaction.commit();
                        break;
                }
                return true;
            }
        });

    }
}
