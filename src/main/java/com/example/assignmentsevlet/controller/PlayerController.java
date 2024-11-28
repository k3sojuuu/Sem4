package com.example.assignmentsevlet.controller;

import com.example.assignmentsevlet.dao.PlayerDAO;
import com.example.assignmentsevlet.entity.Player;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/players")
public class PlayerController extends HttpServlet {
    private PlayerDAO playerDAO;

    @Override
    public void init() {
        playerDAO = new PlayerDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Player> players = playerDAO.getAllPlayers();
        request.setAttribute("players", players);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/playerList.jsp");
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String fullName = request.getParameter("full_name");
        String age = request.getParameter("age");
        long indexId = Long.parseLong(request.getParameter("index_id"));

        Player player = new Player();
        player.setName(name);
        player.setFullName(fullName);
        player.setAge(age);
        player.setIndexId(indexId);

        playerDAO.addPlayer(player);
        response.sendRedirect("players");
    }
}
