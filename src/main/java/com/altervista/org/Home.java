package com.altervista.org;


import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@WebServlet(
        name = "HomeServlet",
        urlPatterns = {"/"}
)
public class Home extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){

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
        }

/*
        try {
            RequestDispatcher view;
            view = req.getRequestDispatcher("index.jsp");
            view.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        doGet(req, resp);
    }
}