package test;

import dao.*;
import entities.*;
import util.HibernateUtil;

import java.util.Date;

public class Test {

    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();

        UserDao userDao = new UserDao();
        MediaDao mediaDao = new MediaDao();
        EmpruntMediaDao empruntDao = new EmpruntMediaDao();

        // Création des utilisateurs
        User user1 = new User("Alice", "chayne", "alice@example.com", "securePassword") {};
        User user2 = new User("Bob","lom", "bob@example.com", "securePassword") {};
        User user3 = new User("Charlie","brad", "charlie@example.com", "securePassword") {};
        
        userDao.create(user1);
        userDao.create(user2);
        userDao.create(user3);

        System.out.println("Utilisateurs créés :");
        System.out.println(user1.getNom() + " - " + user1.getEmail());
        System.out.println(user2.getNom() + " - " + user2.getEmail());
        System.out.println(user3.getNom() + " - " + user3.getEmail());

        // Création des médias
        Media media1 = new Media();
        media1.setTitre("Le Petit Prince");
        media1.setAuteur("Antoine de Saint-Exupéry");
        media1.setDisponible(true);
        
        Media media2 = new Media();
        media2.setTitre("Inception");
        media2.setAuteur("Christopher Nolan");
        media2.setDisponible(true);
        
        Media media3 = new Media();
        media3.setTitre("1984");
        media3.setAuteur("George Orwell");
        media3.setDisponible(true);
        
        mediaDao.create(media1);
        mediaDao.create(media2);
        mediaDao.create(media3);

        System.out.println("Médias créés :");
        System.out.println(media1.getTitre() + " - Auteur : " + media1.getAuteur());
        System.out.println(media2.getTitre() + " - Auteur : " + media2.getAuteur());
        System.out.println(media3.getTitre() + " - Auteur : " + media3.getAuteur());

        // Création des emprunts
        EmpruntMedia emprunt1 = new EmpruntMedia();
        emprunt1.setDateEmprunt(new Date());
        emprunt1.setMedia(media1);
        emprunt1.setUser(user1);
        
        EmpruntMedia emprunt2 = new EmpruntMedia();
        emprunt2.setDateEmprunt(new Date());
        emprunt2.setMedia(media2);
        emprunt2.setUser(user2);
        
        empruntDao.create(emprunt1);
        empruntDao.create(emprunt2);

        System.out.println("\nRéservations des utilisateurs :");
        for (EmpruntMedia emprunt : empruntDao.findAll()) {
            System.out.println("Utilisateur: " + emprunt.getUser().getNom());
            System.out.println("Média: " + emprunt.getMedia().getTitre());
            System.out.println("Date d'emprunt: " + emprunt.getDateEmprunt());
        }

        System.out.println("\nMédias empruntés par Alice :");
        for (EmpruntMedia emprunt : empruntDao.findAll()) {
            if (emprunt.getUser().getId() == user1.getId()) {
                System.out.println(emprunt.getMedia().getTitre() + " le " + emprunt.getDateEmprunt());
            }
        }

        System.out.println("\nListe des Médias :");
        for (Media m : mediaDao.findAll()) {
            System.out.println(m.getTitre() + " - Auteur: " + m.getAuteur());
        }

        System.out.println("\nListe des Utilisateurs :");
        for (User u : userDao.findAll()) {
            System.out.println(u.getNom() + " - Email: " + u.getEmail());
        }
    }
}
