
package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table(name = "medias")
public class Media {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "titre")
    private  String titre;
    private  String auteur;
    private boolean disponible;
      @OneToMany(mappedBy = "media")
       @ManyToOne
    @JoinColumn(name = "typeId")
    private TypeMedia typeMedia;
 @OneToMany(mappedBy = "media")
       @ManyToOne
    @JoinColumn(name = "typeId")
    private EmpruntMedia empruntMedia;
    public Media() {
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

    public void setTypeMedia(TypeMedia typeMedia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
