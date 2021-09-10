/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulos;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author samue
 */
public class LecturaFichero {
    
    // metodo statico para buscar el fiechero
    public static String buscarCodigo(String buscar){
        ArrayList<String> nombres = new ArrayList<String>();
        File fichero = new File("DB.txt");
        Scanner s = null;
        String codigoTarjeta = "";
        
        try{
            // Leemos el contenido del fichero
			System.out.println("... Leemos el contenido del fichero ...");
			s = new Scanner(fichero);

            // Leemos linea a linea el fichero
			while (s.hasNextLine()) {
				String linea = s.nextLine(); 	// Guardamos la linea en un String
				//System.out.println(linea);
                nombres.add(linea);      // Imprimimos la linea
			}
            
            for(int i=0; i<nombres.size();i++){
                String[] tarjeta = nombres.get(i).split(":");
                if(tarjeta[0].equals(buscar)){
                    System.out.println(tarjeta[1]);
                    codigoTarjeta = tarjeta[1];
                }
            }


        }catch(Exception ex){
            System.out.println("Mensaje: " + ex.getMessage());

        }finally{
            // Cerramos el fichero tanto si la lectura ha sido correcta o no
			try {
				if (s != null)
					s.close();
			} catch (Exception ex2) {
				System.out.println("Mensaje 2: " + ex2.getMessage());
			}
        }
        return codigoTarjeta;
    }
}
