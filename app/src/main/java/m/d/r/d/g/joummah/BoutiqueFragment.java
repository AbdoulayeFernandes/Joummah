package m.d.r.d.g.joummah;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class BoutiqueFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View viewBoutique = inflater.inflate(R.layout.fragment_boutique, container, false);


       Button redirectionSiteJoummahBoutique;

       redirectionSiteJoummahBoutique = (Button) viewBoutique.findViewById(R.id.buttonRedirectionSiteBoutique);
       redirectionSiteJoummahBoutique.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String url = "http://www.google.com";

               Intent i = new Intent (Intent.ACTION_VIEW);
               i.setData(Uri.parse(url));
               startActivity(i);
           }
       });




        return viewBoutique;
    }
}
