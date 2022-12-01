package controller.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.servlet.ServletConfig.requestVars;
import model.dao.JokeDAO;

public class Root extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public Root() { super(); }

  @Override
  protected void doGet(
    HttpServletRequest request,
    HttpServletResponse response
  ) throws ServletException, IOException {
    HttpSession session = request.getSession();
    Connection connection;
    try {
      connection = ServletUtils.checkConnection(session);
      request.setAttribute(
        requestVars.JOKES.name(),
        JokeDAO.get(connection)
      );
    } catch (Exception e) {
      // TODO: 500 page
      e.printStackTrace();
    }
  }

  @Override
  protected void doPost(
    HttpServletRequest request, HttpServletResponse response
  ) throws ServletException, IOException {
    doGet(request, response);
  }
}
