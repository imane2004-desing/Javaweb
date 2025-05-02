package services;

import dao.MediaDAO;
import entities.Media;
import entities.TypeMedia;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class MediaService {

    public static List<Media> getAllMedia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Media getMediaById(String mediaId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static List<Media> searchMedia(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @EJB
    private MediaDAO mediaDAO;
    
    public Media findById(int id) {
        return mediaDAO.find(id);
    }
    
    public List<Media> findAll() {
        return mediaDAO.findAll();
    }
    
    public List<Media> findByTitle(String title) {
        return mediaDAO.findByTitle(title);
    }
    
    public List<Media> findByAuthor(String author) {
        return mediaDAO.findByAuthor(author);
    }
    
    public List<Media> findByType(TypeMedia type) {
        return mediaDAO.findByType(type);
    }
    
    public List<Media> findAvailable() {
        return mediaDAO.findAvailable();
    }
    
    public void createMedia(Media media) {
        mediaDAO.save(media);
    }
    
    public void updateMedia(Media media) {
        mediaDAO.update(media);
    }
    
    public void deleteMedia(int id) {
        mediaDAO.deleteById(id);
    }
}