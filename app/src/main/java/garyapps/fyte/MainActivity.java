package garyapps.fyte;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.LinearLayout;

import garyapps.fyte.ViewControllers.FitnessViewController;
import garyapps.fyte.ViewControllers.HomeViewController;
import garyapps.fyte.ViewControllers.TrackerViewController;

public class MainActivity extends AppCompatActivity {

    private LinearLayout container;

    private HomeViewController homeController;
    private TrackerViewController trackerController;
    private FitnessViewController fitnessController;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            container.removeAllViews();

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    container.addView(homeController.getView());
                    return true;
                case R.id.navigation_tracker:
                    container.addView(trackerController.getView());
                    return true;
                case R.id.navigation_fitness:
                    container.addView(fitnessController.getView());
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = findViewById(R.id.main_linear_layout);

        createViewControllers();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        container.addView(homeController.getView());
    }

    private void createViewControllers(){
        homeController = new HomeViewController(this);
        trackerController = new TrackerViewController(this);
        fitnessController = new FitnessViewController(this);
    }

}
