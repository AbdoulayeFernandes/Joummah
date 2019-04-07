package m.d.r.d.g.joummah;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class InfoUtilisationAppFormations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.info_utilisation_formations);

        Button retourEcranFormations;

        retourEcranFormations = findViewById(R.id.button_retour_ecran_formations);
        retourEcranFormations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                onBackPressed();
            }
        });
    }
}
