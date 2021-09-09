/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulos;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.net.URI;
import com.fazecast.jSerialComm.*;

/**
 *
 * @author PLACOFF2015
 */
public class Concentradora implements HttpHandler {
    
    SerialPort sp;
    String requestedMethod = null;	// Almacena el nombre del metodo solicitado
    String argumentos = null;	// Almacena los argumentos que utilizara el metodo
    
    public void imprime(String url){System.out.println("Log->>> "+url);}

    @Override
    public void handle(HttpExchange he) throws IOException 
    {        
        String URL = he.getRequestURI().getPath();        
        String[] url = URL.split("/");        
        imprime("modulo: "+url[1]);//Imprime el nombre del modulo
        imprime("metodo: "+url[2]);//Imprime el nombre del metodo con los argumentos

            // Se separa el nombre del metodo de sus argumentos  metodo(a,2) = [metodo] [(a,2)]
            if (url[2].contains("("))
            {
                // Obtenemos el nombre del metodo
		int separador = url[2].indexOf("("); //obtenemos el valor de la posicion donde se encuentra el caracter "("
                requestedMethod = url[2].substring(0, separador); //substraemos el nombre del metodo desde la psocion 0 hasta el valor de la posicion donde empieza el caracter "("
                
                imprime("metodo: "+requestedMethod); //imprime solo el nombre del metodo

                //en estas lineas de lo que viene en metodo dentro de los parentecis
                //obtengo los argumentos separandolos por las comas y los voi guardando en un arreglo
                argumentos = url[2].substring(separador + 1);  //en argumentos obtengo el valor de lo que hay en la posicion de "(" +1 en adelante
		int finURL = argumentos.indexOf(")"); // en la variable fin obtengo el final de los argumentos determinado por la psocicion en donde se encuentra el caracter ")"
                argumentos = argumentos.substring(0, finURL); // ahora si ya en argumentos obtengo solo lo que hay dentro de los parentesis
                imprime("argumentos: "+argumentos);
                
                /*
                *
                *ESTE FRAGMENTO DE CODIGO LO USAREMOS PARA CUANDO NECESITEMOS MANDAR 2 O MAS PARAMETROS 
                *
                String[] argv = null; // este arreglo lo vamos a usar para almacenar cada valor de los argumentos
				
		int argc = 0;	// Contiene el numero de argumentos

                if (argumentos != "") // preguntamos si argumentos tiene algo
                {
                    argv = argumentos.split(","); // con el split separamos los argumentos por comas
                    imprime("arg0: "+argv[0]+" arg1: "+argv[1]); //imprimimos los valores de cada argumento
                    argc = argv.length;	// Obtenemos el numero de argumentos
                    imprime("numero de argumentos: "+argc); //imprimimos el numero de argumentos
                    turnOnActuador(argv[0],argv[1]);
                }*/  
                
                //AQUI HAY QUE CREAR UN SWICT O ALGUN CONTROL PARA
                //MANDAR LLAMAR EL METODO CORRESPONDIENTE
                //switch(metodo)
                //if
                //O ALGUN OTRO TIPO DE FLUJO DE OCNTROL 
                 switch(requestedMethod){
                    case "turnOnActuador":
                        turnOnActuador(argumentos);  
                    break;
                    case "turnOffActuador":
                        turnOffActuador(argumentos); 
                    break;
                    case "turnOnLedColor":
                    break;
                    default:
                        imprime("Acción no existe");
                    break;
                }       
                
                
                /*
                DESPUES DE RECIBIR Y PROCESAR EL REQUEST
                DEBEMOS ENVIAR UN RESPONSE A LA APP CLIENTE
                PUEDE SER UN SIMPLE "OK"
                */
                
            }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void turnOnActuador(String tarjeta)
    {
        // este metodo es para encender un actuador
        // pero primero hay que ir al diccionario o a un archivo
        // a consultar el valor del nombre de la tarjeta proporcionada
        // para concatenarlo al string y completar el comando
        byte[] buffer={0x00,0x00,0x34};
        sp = SerialPort.getCommPort("com3");
        sp.openPort();
        sp.writeBytes(buffer, buffer.length);
        sp.closePort();
        imprime("Enciendo la tarjeta: "+tarjeta);
    }
    
    public void turnOffActuador(String tarjeta)
    {
        // Esté metodo es para mandar el comando de apagar
        byte[] buffer={0x00,0x00,0x34};
        sp = SerialPort.getCommPort("com3");
        sp.openPort();
        sp.writeBytes(buffer, buffer.length);
        sp.closePort();
        imprime("Enciendo la tarjeta: "+tarjeta);
    }
    
    public void turnOnLedColor(String tarjeta, String color){
    
        // Esté metodo es para mandar el comando de encender en un color especifico
        byte[] buffer={0x00,0x00,0x34};
        sp = SerialPort.getCommPort("com3");
        sp.openPort();
        sp.writeBytes(buffer, buffer.length);
        sp.closePort();
        imprime("Enciendo la tarjeta: "+tarjeta);        
    }   
    
    public void sendComand(String comando)
    {        
        //este metodo es para enviar el comando a la tarjeta concentradora
        byte[] buffer={0x00,0x00,0x34};
        sp = SerialPort.getCommPort("com3");
        sp.openPort();
        sp.writeBytes(buffer, buffer.length);
        sp.closePort();
        imprime("envio comando: "+comando);        
    }    
}
