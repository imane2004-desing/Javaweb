/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.User;
import entities.Media;
import entities.TypeMedia;
import entities.EmpruntMedia;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.Date;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            // Création d'un utilisateur
            User user = new User("imane", "imanekourari@gmail.com", "securePassword123");
            session.save(user);

            // Création d'un type de média
            TypeMedia typeMedia = new TypeMedia("Livre");
            session.save(typeMedia);

            // Création d'un média
            Media media = new Media();
            media.setTitre("Le Petit Prince");
            media.setAuteur("Antoine de Saint-Exupéry");
            media.setDisponible(true);
            media.setTypeMedia(typeMedia);
            session.save(media);

            // Création d'un emprunt
            EmpruntMedia emprunt = new EmpruntMedia();
            emprunt.setDateEmprunt(new Date());
            emprunt.setDateRetour(new Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000)); // 7 jours plus tard
            emprunt.setMedia(media);
            emprunt.setUser(user);
            session.save(emprunt);

            tx.commit();
            System.out.println("Emprunt enregistré avec succès !");

            // Interrogation des médias empruntés par l'utilisateur
            String hql = "SELECT e.media FROM EmpruntMedia e WHERE e.user.id = :userId";
            List<Media> mediaEmpruntes = session.createQuery(hql)
                .setParameter("userId", user.getId())
                .list();

            System.out.println("Médias empruntés par l'utilisateur :");
            for (Media m : mediaEmpruntes) {
                System.out.println(m.getTitre() + " par " + m.getAuteur());
            }

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        HibernateUtil.getSessionFactory().close();
    }
}
