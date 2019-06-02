package m.d.r.d.g.joummah.mesobjets;

public class MaKhoutba {


    private String titre;
    private String contenu;
    private String lienImageOuVideo;
    private String lienPost;

    public MaKhoutba() {

    }

    public MaKhoutba(String titre, String contenu) {
        this.titre = titre;
        this.contenu = contenu;
    }


    public String getTitre() {
        return titre;
    }

    public void setTitre (String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu (String contenu) {
        this.contenu = contenu;
    }

    public String getLienImageOuVideo() {
        return lienImageOuVideo;
    }

    public void setLienImageOuVideo (String lien) {
        this.lienImageOuVideo = lien;
    }

    public String getLienPost () {
        return lienPost;
    }

    public void setLienPost (String lienPost) {
        this.lienPost = lienPost;
    }

}
