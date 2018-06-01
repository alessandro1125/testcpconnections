package com.altervista.org;


import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

@WebServlet(
        name = "Start Servlet",
        urlPatterns = {"/start_server/"}
)
public class StartServer extends HttpServlet {

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

        BufferedReader stream = null;

        try {
            stream = req.getReader();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            while (stream != null) {
                try {
                    String line = stream.readLine();
                    String result = "";
                    while (line != null) {
                        result = result.concat(line);
                        line = stream.readLine();
                    }
                    System.out.println(result);

                } catch (IOException e) {
                    e.printStackTrace();
                }

                try{
                    stream = req.getReader();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}