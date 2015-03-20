package views.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.daos.DaoFactory;
import models.daos.jpa.DaoJpaFactory;
import models.entities.TemaEntity;

@WebServlet("/jsp/*")
public class Dispatcher extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static String PATH_ROOT_VIEW = "/jspViews/";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	DaoFactory.setFactory(new DaoJpaFactory());
        String action = request.getPathInfo().substring(1);

        String view;
        switch (action) {
        case "addTema":
            AddTemaViewBean addTemaViewBean = new AddTemaViewBean();
            request.setAttribute(action, addTemaViewBean);
            view = action;
            break;
        case "temas":
            TemasViewBean temasViewBean = new TemasViewBean();
            request.setAttribute(action, temasViewBean);
            view = action;
            break;
        default:
            view = "home";
        }

        this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
                .forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	DaoFactory.setFactory(new DaoJpaFactory());
        String action = request.getPathInfo().substring(1);
        String view = "home";
        switch (action) {
        case "addTema":
        	AddTemaViewBean addTemaViewBean = new AddTemaViewBean();
        	String nombre = request.getParameter("nombre");
        	String pregunta = request.getParameter("pregunta");
            addTemaViewBean.setNombre(nombre);
            addTemaViewBean.setPregunta(pregunta);
            request.setAttribute(action, addTemaViewBean);
            view = addTemaViewBean.process();
            break;
        case "temas":
            TemasViewBean temasViewBean = new TemasViewBean();
            request.setAttribute(action, temasViewBean);
            break;
        }

        this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
                .forward(request, response);
    }

}
