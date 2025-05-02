package controllers;

import entities.Media;
import entities.TypeMedia;
import services.MediaService;
import services.TypeMediaService;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MediaController", urlPatterns = {"/medias/*"})
public class MediaController extends HttpServlet {
    
    @EJB
    private MediaService mediaService;
    
    @EJB
    private TypeMediaService typeMediaService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String pathInfo = request.getPathInfo();
        
        if (pathInfo == null || pathInfo.equals("/")) {
            // Liste des médias
            List<Media> medias;
            
            // Filtrer selon les paramètres
            String searchTerm = request.getParameter("search");
            String typeId = request.getParameter("type");
            String disponibleOnly = request.getParameter("disponible");
            
            if (searchTerm != null && !searchTerm.isEmpty()) {
                // Recherche par titre ou auteur
                medias = mediaService.findByTitle(searchTerm);
                if (medias.isEmpty()) {
                    medias = mediaService.findByAuthor(searchTerm);
                }
            } else if (typeId != null && !typeId.isEmpty()) {
                // Filtrer par type
                try {
                    TypeMedia type = typeMediaService.findById(Integer.parseInt(typeId));
                    if (type != null) {
                        medias = mediaService.findByType(type);
                    } else {
                        medias = mediaService.findAll();
                    }
                } catch (NumberFormatException e) {
                    medias = mediaService.findAll();
                }
            } else if (disponibleOnly != null && disponibleOnly.equals("true")) {
                // Afficher seulement les médias disponibles
                medias = mediaService.findAvailable();
            } else {
                // Liste complète
                medias = mediaService.findAll();
            }
            
            request.setAttribute("medias", medias);
            request.setAttribute("types", typeMediaService.findAll());
            request.getRequestDispatcher("/WEB-INF/views/medias/list.jsp").forward(request, response);
        } else if (pathInfo.equals("/new")) {
            // Formulaire de création de média
            request.setAttribute("types", typeMediaService.findAll());
            request.getRequestDispatcher("/WEB-INF/views/medias/form.jsp").forward(request, response);
        } else if (pathInfo.startsWith("/view/")) {
            try {
                int id = Integer.parseInt(pathInfo.substring(6));
                Media media = mediaService.findById(id);
                if (media != null) {
                    request.setAttribute("media", media);
                    request.getRequestDispatcher("/WEB-INF/views/medias/view.jsp").forward(request, response);
                } else {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND);
                }
            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }
        } else if (pathInfo.startsWith("/edit/")) {
            try {
                int id = Integer.parseInt(pathInfo.substring(6));
                Media media = mediaService.findById(id);
                if (media != null) {
                    request.setAttribute("media", media);
                    request.setAttribute("types", typeMediaService.findAll());
                    request.getRequestDispatcher("/WEB-INF/views/medias/form.jsp").forward(request, response);
                } else {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND);
                }
            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String pathInfo = request.getPathInfo();
        
        if (pathInfo == null || pathInfo.equals("/")) {
            // Création d'un média
            try {
                String titre = request.getParameter("titre");
                String auteur = request.getParameter("auteur");
                int typeId = Integer.parseInt(request.getParameter("typeId"));
                
                TypeMedia type = typeMediaService.findById(typeId);
                if (type == null) {
                    throw new IllegalArgumentException("Type de média invalide");
                }
                
                Media media = new Media(titre, auteur, type);
                mediaService.createMedia(media);
                
                response.sendRedirect(request.getContextPath() + "/medias");
            } catch (Exception e) {
                request.setAttribute("error", "Erreur lors de la création du média: " + e.getMessage());
                request.setAttribute("types", typeMediaService.findAll());
                request.getRequestDispatcher("/WEB-INF/views/medias/form.jsp").forward(request, response);
            }
        } else if (pathInfo.startsWith("/edit/")) {
            try {
                int id = Integer.parseInt(pathInfo.substring(6));
                Media media = mediaService.findById(id);
                
                if (media != null) {
                    String titre = request.getParameter("titre");
                    String auteur = request.getParameter("auteur");
                    int typeId = Integer.parseInt(request.getParameter("typeId"));
                    String disponibleStr = request.getParameter("disponible");
                    
                    TypeMedia type = typeMediaService.findById(typeId);
                    if (type == null) {
                        throw new IllegalArgumentException("Type de média invalide");
                    }
                    
                    media.setTitre(titre);
                    media.setAuteur(auteur);
                    media.setType(type);
                    
                    // Mettre à jour la disponibilité seulement si non null
                    if (disponibleStr != null) {
                        boolean disponible = disponibleStr.equals("true");
                        media.setDisponible(disponible);
                    }
                    
                    mediaService.updateMedia(media);
                    response.sendRedirect(request.getContextPath() + "/medias");
                } else {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND);
                }
            } catch (Exception e) {
                request.setAttribute("error", "Erreur lors de la mise à jour du média: " + e.getMessage());
                request.setAttribute("types", typeMediaService.findAll());
                
                // Récupérer à nouveau les informations du média
                try {
                    int id = Integer.parseInt(pathInfo.substring(6));
                    request.setAttribute("media", mediaService.findById(id));
                } catch (NumberFormatException ex) {
                    // Ignore
                }
                
                request.getRequestDispatcher("/WEB-INF/views/medias/form.jsp").forward(request, response);
            }
        } else if (pathInfo.equals("/delete")) {
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                mediaService.deleteMedia(id);
                response.sendRedirect(request.getContextPath() + "/medias");
            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}