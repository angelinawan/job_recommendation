package com.jobrecommendation.job.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jobrecommendation.job.db.MySQLConnection;
import com.jobrecommendation.job.entity.LoginRequestBody;
import com.jobrecommendation.job.entity.LoginResponseBody;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        LoginRequestBody body = mapper.readValue(request.getReader(), LoginRequestBody.class);
        MySQLConnection connection = new MySQLConnection();
        LoginResponseBody loginResponseBody;

        if (connection.verifyLogin(body.userId, body.password)) {
            HttpSession session = request.getSession();
            session.setAttribute("user_id", body.userId);
            loginResponseBody = new LoginResponseBody("OK", body.userId, connection.getFullname(body.userId));
        } else {
            loginResponseBody = new LoginResponseBody("Login failed, user id and passcode do not exist.", null, null);
            response.setStatus(401);
        }
        connection.close();
        response.setContentType("application/json");
        mapper.writeValue(response.getWriter(), loginResponseBody);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        HttpSession session = request.getSession(false); // don't creat new session, only creat when log-in and clear at log out
        LoginResponseBody loginResponseBody;
        if (session != null) {
            MySQLConnection connection = new MySQLConnection();
            String userId = session.getAttribute("user_id").toString();
            loginResponseBody = new LoginResponseBody("OK", userId, connection.getFullname(userId));
            connection.close();
        } else {
            loginResponseBody = new LoginResponseBody("Invalid Session.", null, null);
            response.setStatus(403);
        }
        response.setContentType("application/json");
        mapper.writeValue(response.getWriter(), loginResponseBody);
    }

}
