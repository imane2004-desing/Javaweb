package entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name = "findByTitre", query = "SELECT m FROM Media m WHERE m.titre LIKE :titre"),
    @NamedQuery(name = "findByTypeMedia", query = "SELECT m FROM Media m WHERE m.typeMedia.id = :id")
})
@Table(name = "media")
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titre;
    private String auteur;
    private boolean disponible;
    
    @ManyToOne
    private TypeMedia typeMedia;
    
    @OneToMany(mappedBy = "media", fetch = FetchType.EAGER)
    private List<EmpruntMedia> empruntMedias;
            
    public Media() {
    }

    public Media(String titre, String auteur, boolean disponible, TypeMedia typeMedia) {
        this.titre = titre;
        this.auteur = auteur;
        this.disponible = disponible;
        this.typeMedia = typeMedia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public TypeMedia getTypeMedia() {
        return typeMedia;
    }

    public void setTypeMedia(TypeMedia typeMedia) {
        this.typeMedia = typeMedia;
    }

    public List<EmpruntMedia> getEmpruntMedias() {
        return empruntMedias;
    }

    public void setEmpruntMedias(List<EmpruntMedia> empruntMedias) {
        this.empruntMedias = empruntMedias;
    }
}
