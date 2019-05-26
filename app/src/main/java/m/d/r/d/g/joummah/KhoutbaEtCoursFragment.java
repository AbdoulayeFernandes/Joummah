package m.d.r.d.g.joummah;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import m.d.r.d.g.joummah.mesobjets.MaKhoutba;
import m.d.r.d.g.joummah.services.PostService;


public class KhoutbaEtCoursFragment extends Fragment {


    // apparement dans un fagment ça c'est inutile//
    // apparemment dans un fragment le return doit être codé à la fin //

    /*

    premier exercice
    Déclarer list string
    qui va contenir des liens videos Youtube
    faire une boucle sur cette liste pour afficher les vidéos
    a chaque tour de boucle, créer un objet vidéo view pour afficher la nouvelle vidéo dans le layout en cardview ou layout personnalisé

    deuxieme exercice
    voir si sur youtube developpeur il y a pas un moyen de recuperer les vidéos Youtube


    troisieme exercice
    interroger le service youtube (google) pour récupérer les liens des vidéos de la chaine youtube

    GET = pour récupérer une valeur
    SET = pour changer une valeur

     */

    private SearchView mSearchViewKhoutba;
    private ImageButton mImageButtonPrecheFragmentBlog;
    private ImageButton mImageButtonSanteFragmentBlog;
    private ImageButton mImageButtonMeditationsFragmentBlog;
    private ImageButton mImageButtonFormationsFragmentBlog;
    private ImageButton mImageButtonBusinessEntreprendreFragmentBlog;


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1) // ça s'est ajouté tout seul //
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View viewKhoutba = inflater.inflate(R.layout.fragment_khoutbaetcours, container, false);

        final List<MaKhoutba> listkhoutba = chargementLien();


        // ici c'est un test pour le boutton info du fragment khoutba //
        ImageButton infoEcranKhoutba;

        infoEcranKhoutba = (ImageButton) viewKhoutba.findViewById(R.id.info_ecran_khoutba);
        infoEcranKhoutba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), InfoUtilisationAppKhoutba.class));
            }
        });


        final RecyclerView recyclerViewKhoutba = viewKhoutba.findViewById(R.id.recycler_view_khoutba);
        recyclerViewKhoutba.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(listkhoutba);
        recyclerViewKhoutba.setAdapter(recyclerViewAdapter);

        // SEARCHVIEW
        mSearchViewKhoutba = viewKhoutba.findViewById(R.id.searchview_ecrankhoutba);
        mSearchViewKhoutba.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.i("Chercher Khoutba", query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.i("Changer Khoutba", newText);
                newText = newText.toLowerCase();
                List<MaKhoutba> listTitre = new ArrayList<>();
                for (MaKhoutba notif : listkhoutba) {
                    String titre = notif.getTitre().toLowerCase();
                    Boolean nouveauTitre = titre.contains(newText);

                    String contenu = notif.getContenu().toLowerCase();
                    Boolean nouveauContenu = contenu.contains(newText);

                    if (nouveauTitre == true || nouveauContenu == true) {
                        listTitre.add(notif);
                    }
                }

                RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(listTitre);
                recyclerViewKhoutba.setAdapter(recyclerViewAdapter);

                return false;
            }
        });


        // Boutton catégorie qui filtre les articles
        mImageButtonPrecheFragmentBlog = viewKhoutba.findViewById(R.id.imageButton_categorie_preches_fragmentblog);
        mImageButtonPrecheFragmentBlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchViewKhoutba.setQuery("Prêches", false);
            }
        });

        mImageButtonBusinessEntreprendreFragmentBlog = viewKhoutba.findViewById(R.id.imageButton_categorie_business_entreprendre_fragmentblog);
        mImageButtonBusinessEntreprendreFragmentBlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchViewKhoutba.setQuery("Business, Entreprendre", false);
            }
        });

        mImageButtonFormationsFragmentBlog = viewKhoutba.findViewById(R.id.imageButton_categorie_formation_fragmentblog);
        mImageButtonFormationsFragmentBlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchViewKhoutba.setQuery("Formations", false);
            }
        });

        mImageButtonMeditationsFragmentBlog = viewKhoutba.findViewById(R.id.imageButton_categorie_meditations_fragmentblog);
        mImageButtonMeditationsFragmentBlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchViewKhoutba.setQuery("Méditations", false);
            }
        });

        mImageButtonSanteFragmentBlog = viewKhoutba.findViewById(R.id.imageButton_categorie_sante_fragmentblog);
        mImageButtonSanteFragmentBlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchViewKhoutba.setQuery("Santé", false);
            }
        });

        return viewKhoutba;
    }

    // récuparation infos posts
    private List<MaKhoutba> chargementLien() {
        PostService postService = new PostService();
        AsyncTask<Void, Void, String> task = postService.execute();

        List<MaKhoutba> listPost = new ArrayList<>();


        try {
            String resultat = task.get();
            Log.i("résultat", "résultat : "+resultat);
            JSONObject jsonObject = new JSONObject(resultat);
            JSONArray jsonArray = jsonObject.getJSONArray("records");

            for (int i = 0;i<jsonArray.length();i++){
                JSONObject jsonPost = jsonArray.getJSONObject(i);
                MaKhoutba khoutba = new MaKhoutba();
                khoutba.setTitre(jsonPost.getString("titre"));

                String lienImageOuVideo = "lien";

                khoutba.setContenu(jsonPost.getString("description"));
                khoutba.setLien(jsonPost.getString(lienImageOuVideo));

                listPost.add(khoutba);


            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return listPost;
    }


    private class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageViewPost;
        private TextView mTextViewTitreKhoutba;
        private Button mButtonPartager;
        private Intent shareIntent;
        private TextView mTextViewContenuKhoutba;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
        }

        public RecyclerViewHolder(LayoutInflater inflater, ViewGroup container) {
            super(inflater.inflate(R.layout.card_view_khoutba, container, false));

            mImageViewPost = itemView.findViewById(R.id.videoimage_cardview_khoutba);
            mTextViewTitreKhoutba = itemView.findViewById(R.id.titre_cardview_khoutba);
            mTextViewContenuKhoutba = itemView.findViewById(R.id.contenu_cardview_khoutba);
            mButtonPartager = itemView.findViewById(R.id.button_partager_khoutba);


            mButtonPartager.setOnClickListener(new View.OnClickListener() {

                @SuppressLint({"ResourceType", "NewApi"})
                @Override
                public void onClick (View view) {
                    shareIntent = new Intent (Intent.ACTION_SEND);
                    shareIntent.setAction(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Joummah");
                    // avant de modifier jsute après il faut que tu vois comment partager une vidéo(lien)
                    shareIntent.putExtra(Intent.EXTRA_TEXT, "http://www.youtube.com");
                    startActivity(Intent.createChooser(shareIntent, "Partager sur"));
                }
            });
        }
    }

    private class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

        private List<MaKhoutba> mListKhoutba;

        public RecyclerViewAdapter(List<MaKhoutba> listkhoutba) {
            this.mListKhoutba = listkhoutba;
        }


        @NonNull
        @Override
        public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            return new RecyclerViewHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

            MaKhoutba khoutba = mListKhoutba.get(position);
            holder.mTextViewTitreKhoutba.setText(khoutba.getTitre());
            holder.mTextViewContenuKhoutba.setText(khoutba.getContenu());
            Picasso.get().load(khoutba.getLien()).into(holder.mImageViewPost);
        }

        @Override
        public int getItemCount() {
            return mListKhoutba.size();
        }


    }
}

        /*
        LinearLayout layoutContenantCardView = (LinearLayout) viewKhoutba.findViewById(R.id.layoutcontenant_CardView_Khoutba);


        // ici on ajoute les liens dans l'ArrayList //
        listLiensVideosYoutube.add("Lien 1");
        listLiensVideosYoutube.add("Lien 2");
        listLiensVideosYoutube.add("Lien 3");
        listLiensVideosYoutube.add("Lien 4");

        // signification : pour chaque lien de ma listlienvideoyoutube //
        for (String lien : listLiensVideosYoutube) {
            Log.i("lien", lien);
            CardView cardViewKhoutba = new CardView(getContext());
            cardViewKhoutba.setMinimumHeight(460);
            cardViewKhoutba.setMinimumWidth(470);
            cardViewKhoutba.setCardElevation(8);
            cardViewKhoutba.setCardBackgroundColor(Color.parseColor("#FBFCFA"));

            // Création des paramètres de la layout qui va contenir la CardView + modifcation des paramètres pour adapter les margins
            ViewGroup.LayoutParams paramsLayout = new ViewGroup.MarginLayoutParams(layoutContenantCardView.getLayoutParams());
            ((ViewGroup.MarginLayoutParams) paramsLayout).setMargins(35, 5, 0, 5);
            cardViewKhoutba.setLayoutParams(paramsLayout);

            // Création LinearLayout, Détermination Orientation + largeur hauteur
            LinearLayout layoutDansCardView = new LinearLayout(getContext());
            layoutDansCardView.setOrientation(LinearLayout.VERTICAL);
            layoutDansCardView.setMinimumWidth(400);
            layoutDansCardView.setMinimumHeight(400);

            // Création Image, insertion Image dans layout, détermination caractéristique Image
            ImageView imageCardView = new ImageView(getContext());
            imageCardView.setImageResource(R.drawable.mecque_fondbleu);
            layoutDansCardView.addView(imageCardView);
            imageCardView.setMinimumHeight(200);
            imageCardView.setMinimumWidth(200);


            // Création TextView qui sera le tire de la CardView
            TextView titreCardView = new TextView(getContext());
            titreCardView.setText(lien);
            titreCardView.setPadding(20,0,0,0);
            titreCardView.setTextSize(20);
            titreCardView.setTextColor(Color.parseColor("#233646"));


            // Ajout du layout dans la cardview
            cardViewKhoutba.addView(layoutDansCardView);

            // ajout du titre dans la cardview
            layoutDansCardView.addView(titreCardView);

            layoutContenantCardView.addView(cardViewKhoutba);

            cardViewKhoutba.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity( new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=xBsDJGXtSOs")));
                }
            });
        }

        */