package dao;

import entities.Media;
import entities.TypeMedia;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class MediaDao extends AbstractDao<Media> {

    public MediaDao() {
        super(Media.class);
    }
    
    // Rechercher des médias par titre
    public List<Media> findByTitre(String titre) {
        Session session = null;
        Transaction tx = null;
        List<Media> medias = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            medias = session.createNamedQuery("findByTitre", Media.class)
                            .setParameter("titre", "%" + titre + "%")
                            .getResultList();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return medias;
    }

    // Rechercher des médias par type de média
    public List<Media> findByTypeMedia(TypeMedia typeMedia) {
        Session session = null;
        Transaction tx = null;
        List<Media> medias = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            medias = session.createNamedQuery("findByTypeMedia", Media.class)
                            .setParameter("id", typeMedia.getId())
                            .getResultList();
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return medias;
    }

    public Iterable<Media> findByTypeMedia(TypeMedia findById) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
