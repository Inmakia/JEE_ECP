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
import models.utils.Studies;

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
        case "deleteTema":
        	DeleteTemaViewBean deleteTemaViewBean = new DeleteTemaViewBean();
        	deleteTemaViewBean.setId(Integer.parseInt(request.getParameter("id")));
        	deleteTemaViewBean.update();
        	request.setAttribute(action, deleteTemaViewBean);
        	view = action;
        	break;
        case "votarTema":
        	VotarTemaViewBean votarTemaViewBean = new VotarTemaViewBean();
        	votarTemaViewBean.setId(Integer.parseInt(request.getParameter("id")));
        	votarTemaViewBean.update();
        	request.setAttribute(action, votarTemaViewBean);
        	view = action;
        	break;
        case "votos":
        	ViewVotesViewBean viewVotesViewBean = new ViewVotesViewBean();
        	viewVotesViewBean.setId(Integer.parseInt(request.getParameter("id")));
        	viewVotesViewBean.update();
        	request.setAttribute(action, viewVotesViewBean);
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
        case "deleteTema":
        	DeleteTemaViewBean deleteTemaViewBean = new DeleteTemaViewBean();
        	deleteTemaViewBean.setId(Integer.parseInt(request.getParameter("id")));
        	deleteTemaViewBean.setPerm(request.getParameter("perm"));
        	request.setAttribute(action, deleteTemaViewBean);
        	view = deleteTemaViewBean.process();
        	break;
        case "votarTema":
        	VotarTemaViewBean votarTemaViewBean = new VotarTemaViewBean();
        	votarTemaViewBean.setId(Integer.parseInt(request.getParameter("id")));
        	votarTemaViewBean.setStudies(Studies.valueOf(request.getParameter("studies")));
        	votarTemaViewBean.setVote(Double.valueOf(request.getParameter("vote")));
        	votarTemaViewBean.setIpUser(request.getRemoteAddr());
        	votarTemaViewBean.update();
        	request.setAttribute(action, votarTemaViewBean);
        	view = votarTemaViewBean.process();
        	break;
        case "votos":
        	ViewVotesViewBean viewVotesViewBean = new ViewVotesViewBean();
        	viewVotesViewBean.setId(Integer.parseInt(request.getParameter("id")));
        	viewVotesViewBean.setStudies(Studies.valueOf(request.getParameter("studies")));
        	viewVotesViewBean.update();
        	request.setAttribute(action, viewVotesViewBean);
        	view = action;
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
