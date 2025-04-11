package entities;

import javax.persistence.*;

@Entity
@Table(name = "medias")
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "titre")
    private String titre;

    private String auteur;

    private boolean disponible;

    @ManyToOne
    @JoinColumn(name = "typeId")
    private TypeMedia typeMedia;

    public Media() {
    }

    public Media(String inception, String christopher_Nolan, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Getters & Setters

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getTitre() { return titre; }

    public void setTitre(String titre) { this.titre = titre; }

    public String getAuteur() { return auteur; }

    public void setAuteur(String auteur) { this.auteur = auteur; }

    public boolean isDisponible() { return disponible; }

    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    public TypeMedia getTypeMedia() { return typeMedia; }

    public void setTypeMedia(TypeMedia typeMedia) { this.typeMedia = typeMedia; }
}
