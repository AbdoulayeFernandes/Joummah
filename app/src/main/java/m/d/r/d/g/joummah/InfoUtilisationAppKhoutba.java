package m.d.r.d.g.joummah;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class InfoUtilisationAppKhoutba extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_utilisation_khoutba);


        Button retourEcranKhoutba;

        retourEcranKhoutba = findViewById(R.id.button_retour_ecran_khoutba);
        retourEcranKhoutba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
