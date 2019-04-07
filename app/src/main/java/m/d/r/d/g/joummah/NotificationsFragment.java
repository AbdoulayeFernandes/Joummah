package m.d.r.d.g.joummah;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
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

import java.util.ArrayList;
import java.util.List;

import m.d.r.d.g.joummah.mesobjets.MaNotification;

public class NotificationsFragment extends Fragment {


    private SearchView mSearchViewNotifications;
    private ImageButton mImageButtonScienceEtMiracle;
    private ImageButton mImageButtonLislam;
    private ImageButton mImageButtonVersetsCoran;
    private ImageButton mImageButtonCitations;
    private ImageButton mImageButtonHadiths;
    private ImageButton mImageButtonHadithsQudsi;
    private ImageButton mImageButtonCitadelleMusulman;
    private ImageButton mImageButtonCompagnons;
    private ImageButton mImageButtonSante;
    private ImageButton mImageButtonMeditations;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View viewNotif = inflater.inflate(R.layout.fragment_notifications, container, false);

        final List<MaNotification> list = initialisationList();

        final RecyclerView recyclerViewNotifications = viewNotif.findViewById(R.id.recycler_view_notifications);
            recyclerViewNotifications.setLayoutManager(new LinearLayoutManager(getActivity()));
            RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(list);
            recyclerViewNotifications.setAdapter(recyclerViewAdapter);
            // Pour le mettre en HORIZONTAL : recyclerViewNotifications.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));


        // SEARCHVIEW

        mSearchViewNotifications = viewNotif.findViewById(R.id.searchview_ecrannotif);
        mSearchViewNotifications.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.i("Chercher", query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.i("Changer", newText);
                newText = newText.toLowerCase();
                List<MaNotification> listContenu = new ArrayList<>();
                for (MaNotification notif : list) {
                    String contenu = notif.getContenu().toLowerCase();
                    Boolean nouveauText = contenu.contains(newText);

                    String titre = notif.getTitre().toLowerCase();
                    Boolean nouveauTitre = titre.contains(newText);

                    String categorie = notif.getCategorie().toLowerCase();
                    Boolean nouvelleCategorie = categorie.contains(newText);

                    if (nouveauText == true || nouveauTitre == true || nouvelleCategorie == true) {
                        listContenu.add(notif);
                    }
                }

                RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(listContenu);
                recyclerViewNotifications.setAdapter(recyclerViewAdapter);

                return false;
            }
        });


        // Boutton catégorie qui filtre les notifications
        mImageButtonScienceEtMiracle = viewNotif.findViewById(R.id.imageButton_categorie_scienceetmiracle);
        mImageButtonScienceEtMiracle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchViewNotifications.setQuery("Science & Miracle du Coran", false);
            }
        });

        mImageButtonLislam = viewNotif.findViewById(R.id.imageButton_categorie_islam);
        mImageButtonLislam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchViewNotifications.setQuery("L'islam", false);
            }
        });

        mImageButtonVersetsCoran = viewNotif.findViewById(R.id.imageButton_categorie_versets);
        mImageButtonVersetsCoran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchViewNotifications.setQuery("Versets du Coran", false);
            }
        });

        mImageButtonCitations = viewNotif.findViewById(R.id.imageButton_categorie_citations);
        mImageButtonCitations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchViewNotifications.setQuery("Citations", false);
            }
        });

        mImageButtonHadiths = viewNotif.findViewById(R.id.imageButton_categorie_hadiths);
        mImageButtonHadiths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchViewNotifications.setQuery("Hadiths", false);
            }
        });

        mImageButtonHadithsQudsi = viewNotif.findViewById(R.id.imageButton_categorie_hadiths_qudsi);
        mImageButtonHadithsQudsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchViewNotifications.setQuery("Hadiths Qudsi", false);
            }
        });

        mImageButtonCitadelleMusulman = viewNotif.findViewById(R.id.imageButton_categorie_citadelle);
        mImageButtonCitadelleMusulman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchViewNotifications.setQuery("Citadelle du Musulman", false);
            }
        });

        mImageButtonCompagnons = viewNotif.findViewById(R.id.imageButton_categorie_compagnons);
        mImageButtonCompagnons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchViewNotifications.setQuery("Compagnons", false);
            }
        });

        mImageButtonSante = viewNotif.findViewById(R.id.imageButton_categorie_sante);
        mImageButtonSante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchViewNotifications.setQuery("Santé", false);
            }
        });

        mImageButtonMeditations = viewNotif.findViewById(R.id.imageButton_categorie_meditations);
        mImageButtonMeditations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchViewNotifications.setQuery("Méditations", false);
            }
        });




        return viewNotif;
    }



    private List<MaNotification> initialisationList () {
        MaNotification mNotificationIdeale = new MaNotification(R.drawable.coran, getString(R.string.categorie_scienceetmiracle_coran), "Aucune modification du Coran 1/2",getString(R.string.miraclecoran_moficiationcoranA));
        MaNotification mNotificationIdeale2 = new MaNotification(R.drawable.coran, getString(R.string.categorie_scienceetmiracle_coran), "Aucune modification du Coran 2/2",getString(R.string.miraclecoran_moficiationcoranB));
        MaNotification mNotificationIdeale3 = new MaNotification(R.drawable.embryon_sangsue, getString(R.string.categorie_scienceetmiracle_coran), "Le développement embryonnaire humain 1/3",getString(R.string.miraclecoran_embryonA));
        MaNotification mNotificationIdeale4 = new MaNotification(R.drawable.embryon_sangsue, getString(R.string.categorie_scienceetmiracle_coran), "Le développement embryonnaire humain 2/3",getString(R.string.miraclecoran_embryonB));
        MaNotification mNotificationIdeale5 = new MaNotification(R.drawable.embryon_mache, getString(R.string.categorie_scienceetmiracle_coran), "Le développement embryonnaire humain 3/3",getString(R.string.miraclecoran_embryonC));
        MaNotification mNotificationIdeale6 = new MaNotification(R.drawable.mer_divisee, getString(R.string.categorie_scienceetmiracle_coran), "La mer divisée en deux", getString(R.string.mer_diviseendeux));
        MaNotification mNotificationIdeale7 = new MaNotification(R.drawable.montagne_piquet, getString(R.string.categorie_scienceetmiracle_coran), "Les montagnes1/2", getString(R.string.les_montagnesA));
        MaNotification mNotificationIdeale8 = new MaNotification(R.drawable.montagne_piquet, getString(R.string.categorie_scienceetmiracle_coran), "Les montagnes2/2", getString(R.string.les_montagnesB));
        MaNotification mNotificationIdeale9 = new MaNotification(R.drawable.nebuleuse, getString(R.string.categorie_scienceetmiracle_coran), "L'origine de l'univers 1/2", getString(R.string.origine_universA));
        MaNotification mNotificationIdeale10 = new MaNotification(R.drawable.nebuleuse, getString(R.string.categorie_scienceetmiracle_coran), "L'origine de l'univers 2/2", getString(R.string.origine_universB));
        MaNotification mNotificationIdeale11 = new MaNotification(R.drawable.cerveau, getString(R.string.categorie_scienceetmiracle_coran), "Le toupet, le devant de la tête", getString(R.string.toupet_devanttete));
        MaNotification mNotificationIdeale12 = new MaNotification(R.drawable.vagues_internes, getString(R.string.categorie_scienceetmiracle_coran), "Les mers profondes et les vagues internes 1/3", getString(R.string.mersprofondes_vaguesinternesA));
        MaNotification mNotificationIdeale13 = new MaNotification(R.drawable.vagues_internes, getString(R.string.categorie_scienceetmiracle_coran), "Les mers profondes et les vagues internes 2/3", getString(R.string.mersprofondes_vaguesinternesB));
        MaNotification mNotificationIdeale14 = new MaNotification(R.drawable.vagues_internes, getString(R.string.categorie_scienceetmiracle_coran), "Les mers profondes et les vagues internes 3/3", getString(R.string.mersprofondes_vaguesinternesC));
        MaNotification mNotificationIdeale15 = new MaNotification(R.drawable.cumulonimbus_3196011_960_720, getString(R.string.categorie_scienceetmiracle_coran), "Les nuages 1/2", getString(R.string.lesnuagesA));
        MaNotification mNotificationIdeale16 = new MaNotification(R.drawable.cumulonimbus_3196011_960_720, getString(R.string.categorie_scienceetmiracle_coran), "Les nuages 2/2", getString(R.string.lesnuagesB));
        MaNotification mNotificationIdeale17 = new MaNotification(R.drawable.citation , getString(R.string.categorie_scienceetmiracle_coran), "Citations sur les miracles du Coran", getString(R.string.citations_miraclecoran_A));
        MaNotification mNotificationIdeale18 = new MaNotification(R.drawable.citation, getString(R.string.categorie_scienceetmiracle_coran), "Citations sur les miracles du Coran 1/2", getString(R.string.citations_miraclecoran_B));
        MaNotification mNotificationIdeale19 = new MaNotification(R.drawable.citation, getString(R.string.categorie_scienceetmiracle_coran), "Citations sur les miracles du Coran 2/2", getString(R.string.citations_miraclecoran_C));
        MaNotification mNotificationIdeale20 = new MaNotification(R.drawable.citation, getString(R.string.categorie_scienceetmiracle_coran), "Citations sur les miracles du Coran", getString(R.string.citations_miraclecoran_D));
        MaNotification mNotificationIdeale21 = new MaNotification(R.drawable.citation, getString(R.string.categorie_scienceetmiracle_coran), "Citations sur les miracles du Coran", getString(R.string.citations_miraclecoran_E));
        MaNotification mNotificationIdeale22 = new MaNotification(R.drawable.citation, getString(R.string.categorie_scienceetmiracle_coran), "Citations sur les miracles du Coran 1/3", getString(R.string.citations_miraclecoran_F));
        MaNotification mNotificationIdeale23 = new MaNotification(R.drawable.citation, getString(R.string.categorie_scienceetmiracle_coran), "Citations sur les miracles du Coran 2/3", getString(R.string.citations_miraclecoran_G));
        MaNotification mNotificationIdeale24 = new MaNotification(R.drawable.citation, getString(R.string.categorie_scienceetmiracle_coran), "Citations sur les miracles du Coran 3/3", getString(R.string.citations_miraclecoran_H));
        MaNotification mNotificationIdeale25 = new MaNotification(R.drawable.bible, getString(R.string.categorie_scienceetmiracle_coran), "La bible : la venue de Muhammad 1/2", getString(R.string.bible_venuede_muhammadA));
        MaNotification mNotificationIdeale26 = new MaNotification(R.drawable.bible, getString(R.string.categorie_scienceetmiracle_coran), "La bible : la venue de Muhammad 2/2", getString(R.string.bible_venuede_muhammadB));
        MaNotification mNotificationIdeale27 = new MaNotification(R.drawable.fleche_arc, getString(R.string.categorie_scienceetmiracle_coran), "Predictions sur les Romains", getString(R.string.predictions_romains));
        MaNotification mNotificationIdeale28 = new MaNotification(R.drawable.coran, getString(R.string.categorie_versets_ducoran), "Petite médication : le bonheur", getString(R.string.meditation_lebonheur));
        MaNotification mNotificationIdeale29 = new MaNotification(R.drawable.coran, getString(R.string.categorie_versets_ducoran), "jesus (Issa) dans le Coran 1/2", getString(R.string.jesus_danslecoranA));
        MaNotification mNotificationIdeale30 = new MaNotification(R.drawable.coran, getString(R.string.categorie_versets_ducoran), "jesus (Issa) dans le Coran 2/2", getString(R.string.jesus_danslecoranB));
        MaNotification mNotificationIdeale31 = new MaNotification(R.drawable.mosque_1050478_960_720, getString(R.string.categorie_lislam), "Comment devenir musulman(e)", getString(R.string.comment_devenir_musulman));
        MaNotification mNotificationIdeale32 = new MaNotification(R.drawable.coran, getString(R.string.categorie_lislam), "De quoi le Coran parle-t-il ?", getString(R.string.dequoi_parle_lecoran));
        MaNotification mNotificationIdeale33 = new MaNotification(R.drawable.coran, getString(R.string.categorie_versets_ducoran), "Petite médication : les personnes âgées 1/2", getString(R.string.meditation_personnesageesA));
        MaNotification mNotificationIdeale34 = new MaNotification(R.drawable.coran, getString(R.string.categorie_versets_ducoran), "Petite médication : les personnes âgées 2/2", getString(R.string.meditation_personnesageesB));
        MaNotification mNotificationIdeale35 = new MaNotification(R.drawable.insulte, getString(R.string.categorie_lislam), "Les insultes, être grossier 1/2", getString(R.string.insultes_grossierA));
        MaNotification mNotificationIdeale36 = new MaNotification(R.drawable.insulte, getString(R.string.categorie_lislam), "Les insultes, être grossier 2/2", getString(R.string.insultes_grossierB));
        MaNotification mNotificationIdeale37 = new MaNotification(R.drawable.coran, getString(R.string.categorie_lislam), "La propagation de la science grâce aux musulmans", getString(R.string.propagationislam_science));
        MaNotification mNotificationIdeale38 = new MaNotification(R.drawable.coran, getString(R.string.categorie_versets_ducoran), "Petite médication : un peu de chiffre 1/2", getString(R.string.medication_chiffreA));
        MaNotification mNotificationIdeale39 = new MaNotification(R.drawable.coran, getString(R.string.categorie_versets_ducoran), "Petite médication : un peu de chiffre 2/2", getString(R.string.medication_chiffreB));


        // plus tu rajoutes du texte plus il se rajoutera automatiquement dans la list
        List<MaNotification> list = new ArrayList<>();
        list.add(mNotificationIdeale);
        list.add(mNotificationIdeale2);
        list.add(mNotificationIdeale3);
        list.add(mNotificationIdeale4);
        list.add(mNotificationIdeale5);
        list.add(mNotificationIdeale6);
        list.add(mNotificationIdeale7);
        list.add(mNotificationIdeale8);
        list.add(mNotificationIdeale9);
        list.add(mNotificationIdeale10);
        list.add(mNotificationIdeale11);
        list.add(mNotificationIdeale12);
        list.add(mNotificationIdeale13);
        list.add(mNotificationIdeale14);
        list.add(mNotificationIdeale15);
        list.add(mNotificationIdeale16);
        list.add(mNotificationIdeale17);
        list.add(mNotificationIdeale18);
        list.add(mNotificationIdeale19);
        list.add(mNotificationIdeale20);
        list.add(mNotificationIdeale21);
        list.add(mNotificationIdeale22);
        list.add(mNotificationIdeale23);
        list.add(mNotificationIdeale24);
        list.add(mNotificationIdeale25);
        list.add(mNotificationIdeale26);
        list.add(mNotificationIdeale27);
        list.add(mNotificationIdeale28);
        list.add(mNotificationIdeale29);
        list.add(mNotificationIdeale30);
        list.add(mNotificationIdeale31);
        list.add(mNotificationIdeale32);
        list.add(mNotificationIdeale33);
        list.add(mNotificationIdeale34);
        list.add(mNotificationIdeale35);
        list.add(mNotificationIdeale36);
        list.add(mNotificationIdeale37);
        list.add(mNotificationIdeale38);
        list.add(mNotificationIdeale39);

        return list;
    }

    private class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private CardView mCardViewNotifications;
        private ImageView mImageViewNotifications;
        private TextView mTextViewCategorieNotifications;
        private TextView mTextViewTitreNotifications;
        private TextView mTextViewContenuNotifications;
        private Button mButtonPartagerText;
        private Intent shareIntent;
        private Button mButtonPartagerImage;


        public RecyclerViewHolder(View itemView) {
            super(itemView);
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public RecyclerViewHolder(LayoutInflater inflater, ViewGroup container) {
            super(inflater.inflate(R.layout.card_view_notifications, container, false));

            mCardViewNotifications = itemView.findViewById(R.id.cardview_notifications);
            mImageViewNotifications = itemView.findViewById(R.id.imageNotif_cardView);
            mTextViewTitreNotifications = itemView.findViewById(R.id.titre_cardview_notitifications);
            mTextViewCategorieNotifications = itemView.findViewById(R.id.categorie_cardview_notifications);
            mTextViewContenuNotifications = itemView.findViewById(R.id.contenu_cardview_notifications);

            // Android studio ne supporte pas le texte justifié d'après internet même si il y a des gens qui le font avec leur technique


            mButtonPartagerText = itemView.findViewById(R.id.button_partagertexte_notifications);


            // partager le texte de la notification
            mButtonPartagerText.setOnClickListener(new View.OnClickListener() {

                @SuppressLint({"ResourceType", "NewApi"})
                @Override
                public void onClick (View view) {
                    shareIntent = new Intent (Intent.ACTION_SEND);
                    shareIntent.setAction(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Joummah");
                    shareIntent.putExtra(Intent.EXTRA_TEXT, mTextViewContenuNotifications.getText());
                    startActivity(Intent.createChooser(shareIntent, "Partager sur"));
                }
            });


            mButtonPartagerImage = itemView.findViewById(R.id.button_partagerimage_notifications);
            // partager la notification en image

        }
    }

    private class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

        private List<MaNotification> mListNotifications;

        public RecyclerViewAdapter(List<MaNotification> list) {
            this.mListNotifications = list;
        }


        @NonNull
        @Override
        public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
           LayoutInflater inflater = LayoutInflater.from(getActivity());
            return new RecyclerViewHolder(inflater, parent);
        }


        @Override
        public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
            MaNotification notif = mListNotifications.get(position);
            holder.mImageViewNotifications.setImageResource(notif.getImage());
            holder.mTextViewCategorieNotifications.setText(notif.getCategorie());
            holder.mTextViewTitreNotifications.setText(notif.getTitre());
            holder.mTextViewContenuNotifications.setText(notif.getContenu());
        }

        @Override
        public int getItemCount() {
            return mListNotifications.size();
        }
    }
}
