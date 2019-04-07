package m.d.r.d.g.joummah;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class ParametresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parametre_container);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.parametres_container, new ParametresFragment())
                .commit();
    }
}
