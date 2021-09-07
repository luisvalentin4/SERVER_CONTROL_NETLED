/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverhttp;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author PLACOFF2015
 */
public class RootHandler implements HttpHandler{
    
    public void handle(HttpExchange he) throws IOException {
                     
        int port = 81;
                 String response = "Server start success if you see this message" + " Port: " + port;
                 he.sendResponseHeaders(200, response.length());
                 OutputStream os = he.getResponseBody();
                 os.write(response.getBytes());                 
                 os.close();
         }
    
}
