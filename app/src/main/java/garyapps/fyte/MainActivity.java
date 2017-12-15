package garyapps.fyte;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import garyapps.fyte.ViewControllers.UserGymsViewController;
import garyapps.fyte.ViewControllers.HomeViewController;
import garyapps.fyte.ViewControllers.TrackerViewController;

public class MainActivity extends AppCompatActivity {

    private LinearLayout container;

    private HomeViewController homeController;
    private TrackerViewController trackerController;
    private UserGymsViewController gymController;

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
                case R.id.navigation_mygym:
                    container.addView(gymController.getView());
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
    }

    private void createViewControllers(){
        homeController = new HomeViewController(this);
        trackerController = new TrackerViewController(this);
        gymController = new UserGymsViewController(this);
        View homeView = getLayoutInflater().inflate(R.layout.home_view, null);
    }

}
