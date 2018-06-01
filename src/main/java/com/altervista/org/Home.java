package com.altervista.org;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Null;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        BufferedReader stream = null;

        //Get the output stream
        ServletOutputStream out = null;
        try {
            out = resp.getOutputStream();
        }catch (IOException e){
            e.printStackTrace();
        }

        try {
            //stream = req.getReader();
            System.out.println("Starting");
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            while (/*stream != null &&*/ req.getInputStream().read() != -1) {
                /*try {
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
                }*/

                try {
                    assert out != null;
                    out.write("Hello World".getBytes());
                    out.flush();
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                System.out.println("APP");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
