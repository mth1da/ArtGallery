package com.miage.app;

import com.miage.app.services.Connexion;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="LoginServlet",urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>");
        out.println("</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("Hello I am your Servlet ");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/artGallery","root","");

            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from user where email='"+email+"' and password='"+password+"'");

            if(rs.next()) {
                //si l'email et le mdp sont bon alors on est dirigé vers la page Home.html
                response.sendRedirect("Home.jsp");
            } else {
                //mdp et email incorrect
                out.println("Mot de passe et email incorrects...");
            }

            //ici on ferme la connection
            con.close();

        } catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
