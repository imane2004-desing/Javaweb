/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author hp
 */


import dao.MediaDao;
import dao.TypeMediaDao;
import dao.UserDao;
import entities.Media;
import entities.TypeMedia;
import entities.User;

public class Test1 {
    public static void main(String[] args) {
        // HibernateUtil.getSessionFactory();
        
        // Création
        UserDao userDao = new UserDao();
        TypeMediaDao typeMediaDao = new TypeMediaDao();
        MediaDao mediaDao = new MediaDao();
        
        /*
        userDao.create(new User("Ali", "Amal", "amal@gmail.com", "amal123"));
        userDao.create(new User("Elk", "Imane", "imane@gmail.com", "imane123"));
        
        typeMediaDao.create(new TypeMedia("Électronique"));
        typeMediaDao.create(new TypeMedia("Mécanique"));
        
        mediaDao.create(new Media("Alternateur", "Auteur 1", true, typeMediaDao.findById(2)));
        mediaDao.create(new Media("Câble", "Auteur 2", true, typeMediaDao.findById(1)));
        */
        
        // Modification
        /*       
        User user = userDao.findById(2);
        user.setNom("Elkourari");
        userDao.update(user);
        
        TypeMedia typeMedia = typeMediaDao.findById(1);
        typeMedia.setNom("Électrique");
        typeMediaDao.update(typeMedia);
        
        Media media = mediaDao.findById(1);
        media.setDisponible(false);
        mediaDao.update(media);
        */
        
        // Suppression
        /*       
        userDao.delete(userDao.findById(1));
        typeMediaDao.delete(typeMediaDao.findById(1));
        mediaDao.delete(mediaDao.findById(2));
        */
        
        /*
        // Afficher tous les utilisateurs
        for (User u : userDao.findAll()) {
            System.out.println(u.getNom());
        }
        
        // Afficher les médias de chaque type
        for (Media m : typeMediaDao.findById(2).getMediass()) {
            System.out.println(m.getTitre());
        }
        */
        
        // Rechercher des médias par type
        for (Media m : mediaDao.findByTypeMedia(typeMediaDao.findById(1))) {
            System.out.println(m.getTitre());
        }

        // Rechercher des médias par titre
        for (Media m : mediaDao.findByTitre("Câble")) {
            System.out.println(m.getTitre());
        }
    }
}
