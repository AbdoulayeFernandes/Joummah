package m.d.r.d.g.joummah.mesobjets;

public class MaKhoutba {

    private String titre;
    private String contenu;

    public MaKhoutba() {

    }

    public MaKhoutba(String titre) {
        this.titre = titre;
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

}
