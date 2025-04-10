package entities;

import javax.persistence.*;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer id;

    @Column(name = "nom", nullable = false, length = 255)
    private String nom;

    @Column(name = "prenom", nullable = false, length = 255)
    private String prenom;

    @Column(name = "email", nullable = false, unique = true, length = 255)
    private String email;

    @Column(name = "motDePasse", nullable = false, length = 255)
    private String motDePasse;
    @OneToMany(mappedBy = "user")
       @ManyToOne
    @JoinColumn(name = "typeId")
    private EmpruntMedia empruntMedia;

    public User() {
    }

    public User(String nom, String prenom, String email, String motDePasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
}