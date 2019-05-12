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
import android.widget.ImageButton;

public class FormationsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View viewFormations = inflater.inflate(R.layout.fragment_formations, container, false);





        // ici c'est un test pour le boutton info du fragment khoutba //
        ImageButton infoEcranFormations;

        infoEcranFormations = (ImageButton) viewFormations.findViewById(R.id.info_ecran_formations);
        infoEcranFormations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), InfoUtilisationAppFormations.class));
            }
        });


        // Redirection vers le site www.joummah.com pour les formations (LOT 1 application)
        Button redirectionSiteJoummahFormations;

        redirectionSiteJoummahFormations = (Button) viewFormations.findViewById(R.id.buttonRedirectionSiteFormations);
        redirectionSiteJoummahFormations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url ="https://joummah.com/formations/";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        Button redirectionEbookOrgaPostMariage;

        redirectionEbookOrgaPostMariage = (Button) viewFormations.findViewById(R.id.buttonRedirectionEBookMariage);
        redirectionEbookOrgaPostMariage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url ="https://joummah.com/produit/guide-organisation-post-mariage/";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        /* CA SERA POUR LE LOT 2 ! (recycler view + ajout dynamique depuis serveur des formations)

        MaFormationPopulaire mFormationPopulaire = new MaFormationPopulaire("test", (float) 50.49);

        List<MaFormationPopulaire> listformationspopulaires = new ArrayList<>();
        listformationspopulaires.add(mFormationPopulaire);

        RecyclerView recyclerViewFormationsPopulaires = viewFormations.findViewById(R.id.recycler_view_formations_populaires);
        recyclerViewFormationsPopulaires.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewFormationsPopulaires.setAdapter(new RecyclerViewAdapter(listformationspopulaires));
        recyclerViewFormationsPopulaires.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        */

        return viewFormations;
    }


    /* CA SERA POUR LE LOT 2 ! (recycler view + ajout dynamique depuis serveur des formations)

    private class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private CardView mCardViewFormationsPopulaires;
        private TextView mTextViewTitreFormationsPopulaires;
        private TextView mPrixFormationsPopulaires;

        public RecyclerViewHolder (View itemView) {
            super (itemView);
        }

        public RecyclerViewHolder(LayoutInflater inflater, ViewGroup container) {
            super(inflater.inflate(R.layout.card_view_formations_populaires, container, false));

            mCardViewFormationsPopulaires = itemView.findViewById(R.id.recycler_view_formations_populaires);
            mTextViewTitreFormationsPopulaires = itemView.findViewById(R.id.titre_cardview_formationspopulaires);
            mPrixFormationsPopulaires = itemView.findViewById(R.id.prix_cardview_formationspopulaires);
        }
    }

    private class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

        private List<MaFormationPopulaire> mListFormationsPopulaires;

        public RecyclerViewAdapter(List<MaFormationPopulaire> listformationspopulaires) {
            this.mListFormationsPopulaires = listformationspopulaires;
        }

        @NonNull
        @Override
        public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            return new RecyclerViewHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

            MaFormationPopulaire formation = mListFormationsPopulaires.get(position);
            holder.mTextViewTitreFormationsPopulaires.setText(formation.getTitre());
            Float prixfloat = formation.getPrix();
            String prix = String.valueOf(prixfloat);
            holder.mPrixFormationsPopulaires.setText(prix + " €");
            // = holder.mPrixFormationsPopulaires.setText(String.valueOf(formation.getPrix()));

        }

        @Override
        public int getItemCount() {
            return mListFormationsPopulaires.size();
        }
    }

    */

}
