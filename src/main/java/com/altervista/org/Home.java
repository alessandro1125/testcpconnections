package com.altervista.org;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "HomeServlet",
        urlPatterns = {"/"}
)
public class Home extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){



        try {
            RequestDispatcher view;
            view = req.getRequestDispatcher("index_main.jsp");
            view.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){

        doGet(req, resp);
        /*
        while (true) {
            try {
                BufferedReader stream = req.getReader();

                String line = stream.readLine();
                String result = "";
                while (line != null) {
                    result.concat(line);
                    line = stream.readLine();
                }
                System.out.println(result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
    }
}
