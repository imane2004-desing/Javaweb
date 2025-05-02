package services;


import dao.EmpruntMediaDAO;
import dao.MediaDAO;
import entities.EmpruntMedia;
import entities.Media;
import entities.User;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class EmpruntService {

    public static Object getEmpruntById(String empruntId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static List<Emprunt> getEmpruntHistory() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @EJB
    private EmpruntMediaDAO empruntMediaDAO;
    
    @EJB
    private MediaDAO mediaDAO;
    
    public EmpruntMedia findById(int id) {
        return empruntMediaDAO.find(id);
    }
    
    public List<EmpruntMedia> findAll() {
        return empruntMediaDAO.findAll();
    }
    
    public List<EmpruntMedia> findActiveLoans() {
        return empruntMediaDAO.findActiveLoans();
    }
    
    public List<EmpruntMedia> findActiveLoansForUser(User user) {
        return empruntMediaDAO.findActiveLoansForUser(user);
    }
    
    public List<EmpruntMedia> findOverdueLoans() {
        return empruntMediaDAO.findOverdueLoans();
    }
    
    public EmpruntMedia emprunterMedia(User user, Media media) {
        // Vérifier si le média est disponible
        if (!media.isDisponible()) {
            return null;
        }
        
        // Créer l'emprunt
        EmpruntMedia emprunt = new EmpruntMedia(user, media);
        empruntMediaDAO.save(emprunt);
        
        // Mettre à jour le statut du média
        media.setDisponible(false);
        mediaDAO.update(media);
        
        return emprunt;
    }
    
    public boolean retournerMedia(Media media) {
        EmpruntMedia emprunt = empruntMediaDAO.findActiveForMedia(media);
        if (emprunt == null) {
            return false;
        }
        
        // Mettre à jour l'emprunt
        emprunt.setDateRetour(new Date());
        empruntMediaDAO.update(emprunt);
        
        // Mettre à jour le statut du média
        media.setDisponible(true);
        mediaDAO.update(media);
        
        return true;
    }
}
