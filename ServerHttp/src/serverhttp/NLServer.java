/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverhttp;

import Modulos.Concentradora;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author PLACOFF2015
 */
public class NLServer {
    
    public static void main(String[] args) throws IOException
    {
        int port = 81;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        System.out.println("SERVER INICIADO EN PUERTO: " + port);
        server.createContext("/", new RootHandler());
        server.createContext("/echoHeader", new EchoHeaderHandler());
        server.createContext("/echoGet", new EchoGetHandler());
        server.createContext("/echoPost", new EchoPostHandler());
        /*
        *
        *
        AQUI PODEMOS CREAR UNA LISTA DE MODULOS DE LOS DISPOSITIVOS QUE QUERAMOS CONTROLAR
        POR EJEMPLO DISPOSITIVOS SPEAKERCRAFT
        ****** server.createContex("/speackercraft", new Concentradora());// PRIMERAMENTE DEBERA ESTAR CREADO EL MODULO (CLASE)
        *
        *       
        */
        server.createContext("/concentradora", new Concentradora());// creado por mi manda llamar una clase y ejecuta el metdo handler        
        server.setExecutor(null);
        server.start();           
    }       
}
