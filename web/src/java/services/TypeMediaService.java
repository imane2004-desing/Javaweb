package services;

import dao.TypeMediaDAO;
import entities.TypeMedia;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class TypeMediaService {

    public static List<TypeMedia> getAllTypes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @EJB
    private TypeMediaDAO typeMediaDAO;
    
    public TypeMedia findById(int id) {
        return typeMediaDAO.find(id);
    }
    
    public List<TypeMedia> findAll() {
        return typeMediaDAO.findAll();
    }
    
    public TypeMedia findByName(String name) {
        return typeMediaDAO.findByName(name);
    }
    
    public void createTypeMedia(TypeMedia typeMedia) {
        typeMediaDAO.save(typeMedia);
    }
    
    public void updateTypeMedia(TypeMedia typeMedia) {
        typeMediaDAO.update(typeMedia);
    }
    
    public void deleteTypeMedia(int id) {
        typeMediaDAO.deleteById(id);
    }
}
