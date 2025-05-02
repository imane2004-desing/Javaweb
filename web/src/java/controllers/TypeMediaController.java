package controllers;

import entities.TypeMedia;
import services.TypeMediaService;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TypeMediaController", urlPatterns = {"/types/*"})
public class TypeMediaController extends HttpServlet {
    
    @EJB
    private TypeMediaService typeMediaService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         List<TypeMedia> types = TypeMediaService.getAllTypes();
        request.setAttribute("types", types);
        RequestDispatcher dispatcher = request.getRequestDispatcher("type_media_list.jsp");
        dispatcher.forward(request, response);
        
        
        
        
        
        
        
        String pathInfo = request.getPathInfo();
        
        if (pathInfo == null || pathInfo.equals("/")) {
            // Liste des types de média
            request.setAttribute("types", typeMediaService.findAll());
            request.getRequestDispatcher("/WEB-INF/views/types/list.jsp").forward(request, response);
        } else if (pathInfo.equals("/new")) {
            // Formulaire de création de type
            request.getRequestDispatcher("/WEB-INF/views/types/form.jsp").forward(request, response);
        } else if (pathInfo.startsWith("/edit/")) {
            try {
                int id = Integer.parseInt(pathInfo.substring(6));
                TypeMedia type = typeMediaService.findById(id);
                if (type != null) {
                    request.setAttribute("type", type);
                    request.getRequestDispatcher("/WEB-INF/views/types/form.jsp").forward(request, response);
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
            // Création d'un type de média
            String nom = request.getParameter("nom");
            
            TypeMedia type = new TypeMedia(nom);
            typeMediaService.createTypeMedia(type);
            
            response.sendRedirect(request.getContextPath() + "/types");
        } else if (pathInfo.startsWith("/edit/")) {
            try {
                int id = Integer.parseInt(pathInfo.substring(6));
                TypeMedia type = typeMediaService.findById(id);
                
                if (type != null) {
                    type.setNom(request.getParameter("nom"));
                    typeMediaService.updateTypeMedia(type);
                    response.sendRedirect(request.getContextPath() + "/types");
                } else {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND);
                }
            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }
        } else if (pathInfo.equals("/delete")) {
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                typeMediaService.deleteTypeMedia(id);
                response.sendRedirect(request.getContextPath() + "/types");
            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}