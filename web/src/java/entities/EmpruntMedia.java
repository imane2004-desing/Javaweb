package entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "empruntmedias")
public class EmpruntMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "dateEmprunt")
    private Date dateEmprunt;

    private Date dateRetour;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "media_id")
    private Media media;

   

    // Getters & Setters

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public Date getDateEmprunt() { return dateEmprunt; }

    public void setDateEmprunt(Date dateEmprunt) { this.dateEmprunt = dateEmprunt; }

    public Date getDateRetour() { return dateRetour; }

    public void setDateRetour(Date dateRetour) { this.dateRetour = dateRetour; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Media getMedia() { return media; }

    public void setMedia(Media media) { this.media = media; }
}
