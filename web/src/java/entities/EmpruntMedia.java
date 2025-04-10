/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table(name = "empruntmedias")
public class EmpruntMedia {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
       private int id;
     @Column(name = "dateEmprunt")
    private Date dateEmprunt;
    private Date dateRetour;
    @OneToMany(mappedBy = "empruntMedia")
    private List<TypeMedia> typemedias;
    @OneToMany(mappedBy = "empruntMedia")
    private List<Media> medias;
    @OneToMany(mappedBy = "empruntMedia")
    private List<User> users;
    

    public EmpruntMedia() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public Date getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }

    public void setMedia(Media media) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
