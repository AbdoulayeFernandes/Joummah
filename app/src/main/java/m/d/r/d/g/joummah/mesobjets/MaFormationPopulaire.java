package m.d.r.d.g.joummah.mesobjets;

public class MaFormationPopulaire {

    private String titre;
    private Float prix;

    public MaFormationPopulaire() {

    }

    public MaFormationPopulaire (String titre, Float prix){
        this.titre = titre;
        this.prix = prix;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre (String titre) {
        this.titre = titre;
    }

    public Float getPrix () {
        return prix;
    }

    public void setPrix (Float prix) {
        this.prix = prix;
    }
}
