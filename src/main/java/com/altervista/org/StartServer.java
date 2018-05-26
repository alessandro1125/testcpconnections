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
        name = "HomeServlet",
        urlPatterns = {"/start_server/"}
)
public class StartServer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){

        ServerSocket welcomeSocket = null;
        assert welcomeSocket != null;
        new Thread(() -> {
            while (true){
                String clientSentence;
                String capitalizedSentence = "ciao";
                try {
                    Socket connectionSocket = welcomeSocket.accept();
                    BufferedReader inFromClient =
                            new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                    DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
                    clientSentence = inFromClient.readLine();
                    System.out.println("Received: " + clientSentence);
                    //capitalizedSentence = clientSentence.toUpperCase() + '\n';
                    outToClient.writeBytes(capitalizedSentence);
                    //connectionSocket.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        /*
        try {
            RequestDispatcher view;
            view = req.getRequestDispatcher("index_main.jsp");
            view.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
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