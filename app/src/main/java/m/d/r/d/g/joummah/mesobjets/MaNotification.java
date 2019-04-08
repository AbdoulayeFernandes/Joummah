package m.d.r.d.g.joummah.mesobjets;

import android.net.Uri;

public class MaNotification {
    private String categorie;
    private String titre;
    private String contenu;
    private int image;
    private Uri imagepourpartage;

    public MaNotification() {
    }

    public MaNotification(String categorie, String titre, String contenu) {
        this.categorie = categorie;
        this.titre = titre;
        this.contenu = contenu;
    }

    public MaNotification(Integer imageid, String categorie, String titre, String contenu) {
        this.image = imageid;
        this.categorie = categorie;
        this.titre = titre;
        this.contenu = contenu;
    }

    public MaNotification(Integer imageid, String categorie, String titre, String contenu, Uri imageapartager) {
        this.image = imageid;
        this.categorie = categorie;
        this.titre = titre;
        this.contenu = contenu;
        this.imagepourpartage = imageapartager;
    }


    public Integer getImage () {
        return image;
    }

    public void setImage (Integer imageid){
        this.image = imageid;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Uri getImagepourpartage() {
        return imagepourpartage;
    }

    public void setImagepourpartage(Uri imageapartager) {
        this.imagepourpartage = imageapartager;
    }

}
