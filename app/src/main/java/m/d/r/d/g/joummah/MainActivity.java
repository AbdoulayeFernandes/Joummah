package m.d.r.d.g.joummah;



import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new NotificationsFragment()).commit();


        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.buttom_nav_menu_notifcations:
                            selectedFragment = new NotificationsFragment();
                            break;

                        case R.id.buttom_nav_menu_formations:
                            selectedFragment = new FormationsFragment();
                            break;

                        case R.id.buttom_nav_menu_khoutbaetcours:
                            selectedFragment = new KhoutbaEtCoursFragment();
                            break;

                        case R.id.buttom_nav_menu_boutique:
                            selectedFragment = new BoutiqueFragment();
                            break;

                        case R.id.buttom_nav_menu_parametres:
                            selectedFragment = new ParametresFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();


                    return true;
                }
            };
}
