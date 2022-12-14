package controller.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ServletConfig.requestVars;
import controller.Util;
import model.dao.PlayerDAO;

@WebServlet("/players")
public class Players extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public Players() {
    super();
  }

  @Override
  protected void doGet(
    HttpServletRequest request,
    HttpServletResponse response
  ) throws ServletException, IOException {
    HttpSession session = request.getSession();
    Connection connection;
    //String currentSeason = Util.checkCurrentSeason(session, connection);
    try {
      connection = Util.checkConnection(session);
      request.setAttribute(
        requestVars.PLAYERS.name(),
        PlayerDAO.getAll(connection)
      );
    } catch (Exception e) {
      // TODO: 500 page
      e.printStackTrace();
    }

    RequestDispatcher dispatcher = request.getRequestDispatcher("players.jsp");
    dispatcher.forward(request, response);
  }

  @Override
  protected void doPost(
    HttpServletRequest request, HttpServletResponse response
  ) throws ServletException, IOException {
    doGet(request, response);
  }
}
