/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Device;
/**
 *
 * @author PLACOFF2015
 */
//import Device.Device;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MostrarDevices {
    
    public static void main(String args[]){
    
        //Device dev = new Device();
        
        //dev.setNombreTarjeta("reflector");
        //dev.setNumerTarjeta(24);
        //dev.setCanal(2);
        
        Map<String,Device > devices = new TreeMap<String, Device>();
        
        
        byte t1 = 0x0c;byte t2 = 0x01;byte t3 = 0x01;byte t4 = 0x01;
        byte t5 = 0x01;byte t6 = 0x01;byte t7 = 0x01;byte t8 = 0x01;
        byte t9 = 0x01;byte t10 = 0x01;byte t11 = 0x01;byte t12 = 0x01;
        byte t13 = 0x01;byte t14 = 0x01;byte t15 = 0x01;byte t16 = 0x0c;                
                
        /*devices.put("reflector",new Device("reflector",t1,1));
        devices.put("reflector",new Device("reflector",t2,2));
        devices.put("reflector",new Device("reflector",t3,1));
        devices.put("reflector",new Device("reflector",t4,1));
        devices.put("reflector",new Device("reflector",t5,2));
        devices.put("reflector",new Device("reflector",t6,1));
        devices.put("reflector",new Device("reflector",t7,2));
        devices.put("reflector",new Device("reflector",t8,1));
        devices.put("reflector",new Device("reflector",t9,2));
        devices.put("reflector",new Device("reflector",t10,1));
        devices.put("reflector",new Device("reflector",t11,2));
        devices.put("reflector",new Device("reflector",t12,1));
        devices.put("reflector",new Device("reflector",t13,1));
        devices.put("reflector",new Device("reflector",t14,2));                
        devices.put("reflector",new Device("reflector",t15,1));
        devices.put("reflector",new Device("reflector",t16,2));*/
        
        devices.entrySet().forEach((device) -> {
            String clave = device.getKey();
            Device valor = device.getValue();
            System.out.println("Dispositivo: "+clave+"  ->  Nombre: "+valor.getNombreTarjeta()+"  Numero de tarjeta: "+valor.getNumeroTarjeta()+"  Canal: "+valor.getCanal());
        });    
    }
}
