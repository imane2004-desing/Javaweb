package controllers;

import entities.EmpruntMedia;
import entities.Media;
import entities.User;
import services.EmpruntService;
import services.MediaService;
import services.UserService;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "EmpruntController", urlPatterns = {"/emprunts/*"})
public class EmpruntController extends HttpServlet {
    
    @EJB
    private EmpruntService empruntService;
    
    @EJB
    private MediaService mediaService;
    
    @EJB
    private UserService userService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String pathInfo = request.getPathInfo();
        
        // Vérifier si l'utilisateur est connecté
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("user");
        
        if (currentUser == null) {
            response.sendRedirect(request.getContextPath() + "/users/login");
            return;
        }
        
        if (pathInfo == null || pathInfo.equals("/")) {
            // Liste des emprunts
            request.setAttribute("emprunts", empruntService.findAll());
            request.getRequestDispatcher("/WEB-INF/views/emprunts/list.jsp").forward(request, response);
        } else if (pathInfo.equals("/actifs")) {
            // Liste des emprunts actifs
            request.setAttribute("emprunts", empruntService.findActiveLoans());
            request.getRequestDispatcher("/WEB-INF/views/emprunts/list.jsp").forward(request, response);
        } else if (pathInfo.equals("/retard")) {
            // Liste des emprunts en retard
            request.setAttribute("emprunts", empruntService.findOverdueLoans());
            request.getRequestDispatcher("/WEB-INF/views/emprunts/list.jsp").forward(request, response);
        } else if (pathInfo.equals("/new")) {
            // Formulaire d'emprunt
            request.setAttribute("users", userService.findAll());
            request.setAttribute("medias", mediaService.findAvailable());
            request.getRequestDispatcher("/WEB-INF/views/emprunts/form.jsp").forward(request, response);
        } else if (pathInfo.startsWith("/view/")) {
            try {
                int id = Integer.parseInt(pathInfo.substring(6));
                EmpruntMedia emprunt = empruntService.findById(id);
                if (emprunt != null) {
                    request.setAttribute("emprunt", emprunt);
                    request.getRequestDispatcher("/WEB-INF/views/emprunts/view.jsp").forward(request, response);
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
        
        // Vérifier si l'utilisateur est connecté
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("user");
        
        if (currentUser == null) {
            response.sendRedirect(request.getContextPath() + "/users/login");
            return;
        }
        
        if (pathInfo == null || pathInfo.equals("/")) {
            // Création d'un emprunt
            try {
                int userId = Integer.parseInt(request.getParameter("userId"));
                int mediaId = Integer.parseInt(request.getParameter("mediaId"));
                
                User user = userService.findById(userId);
                Media media = mediaService.findById(mediaId);
                
                if (user == null || media == null) {
                    throw new IllegalArgumentException("Utilisateur ou média invalide");
                }
                
                EmpruntMedia emprunt = empruntService.emprunterMedia(user, media);
                
                if (emprunt == null) {
                    request.setAttribute("error", "Le média n'est pas disponible");
                    request.setAttribute("users", userService.findAll());
                    request.setAttribute("medias", mediaService.findAvailable());
                    request.getRequestDispatcher("/WEB-INF/views/emprunts/form.jsp").forward(request, response);
                } else {
                    response.sendRedirect(request.getContextPath() + "/emprunts");
                }
            } catch (Exception e) {
                request.setAttribute("error", "Erreur lors de la création de l'emprunt: " + e.getMessage());
                request.setAttribute("users", userService.findAll());
                request.setAttribute("medias", mediaService.findAvailable());
                request.getRequestDispatcher("/WEB-INF/views/emprunts/form.jsp").forward(request, response);
            }
        } else if (pathInfo.equals("/retourner")) {
            try {
                int mediaId = Integer.parseInt(request.getParameter("mediaId"));
                Media media = mediaService.findById(mediaId);
                
                if (media == null) {
                    throw new IllegalArgumentException("Média invalide");
                }
                
                boolean success = empruntService.retournerMedia(media);
                
                if (!success) {
                    request.setAttribute("error", "Le média n'est pas actuellement emprunté");
                }
                
                response.sendRedirect(request.getContextPath() + "/emprunts");
            } catch (Exception e) {
                request.setAttribute("error", "Erreur lors du retour du média: " + e.getMessage());
                response.sendRedirect(request.getContextPath() + "/emprunts");
            }
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
