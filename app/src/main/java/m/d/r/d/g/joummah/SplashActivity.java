package m.d.r.d.g.joummah;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    private static int SPASH_TIME_OUT = 300;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // SLASHSCREEN : pour que ça marche tu as inversé dans le Manifest la ligne 14 et 15 (main activity et splashactivity)
        // Ensuite tu as mis ce code pour le splashscreen ici, alors que à la base tu l'avais mis dans la Class Main Acvitity
        // Voir avec Abraham si c'est une méthode propre ou si c'est une méthode pas propre
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(homeIntent);
                finish();
            }
        }, SPASH_TIME_OUT );

    }
}
