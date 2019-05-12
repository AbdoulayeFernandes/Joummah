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
               String url = "https://joummah.com/boutique/";

               Intent i = new Intent (Intent.ACTION_VIEW);
               i.setData(Uri.parse(url));
               startActivity(i);
           }
       });

        Button redirectionSiteProduitUn;

        redirectionSiteProduitUn = (Button) viewBoutique.findViewById(R.id.buttonProduitUn);
        redirectionSiteProduitUn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://joummah.com/produit/box-coran-rose-clair/";

                Intent i = new Intent (Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        Button redirectionSiteProduitDeux;

        redirectionSiteProduitDeux = (Button) viewBoutique.findViewById(R.id.buttonProduitDeux);
        redirectionSiteProduitDeux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://joummah.com/produit/muscbox-royale/";

                Intent i = new Intent (Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        Button redirectionSiteProduitTrois;

        redirectionSiteProduitTrois = (Button) viewBoutique.findViewById(R.id.buttonProduitTrois);
        redirectionSiteProduitTrois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://joummah.com/produit/box-medecine-prophetique/";

                Intent i = new Intent (Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });


        return viewBoutique;
    }
}
