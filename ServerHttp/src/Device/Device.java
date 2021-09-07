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
public class Device {
    
    private String nombreTarjeta;
    private byte numeroTarjeta;
    private int canal;
    
    public Device(String nombreTarjeta, byte numeroTarjeta, int canal){
        this.nombreTarjeta = nombreTarjeta;
        this.numeroTarjeta = numeroTarjeta;
        this.canal = canal;
    }

    /**
     * @return the nombreTarjeta
     */
    public String getNombreTarjeta() {
        return nombreTarjeta;
    }

    /**
     * @param nombreTarjeta the nombreTarjeta to set
     */
    public void setNombreTarjeta(String nombreTarjeta) {
        this.nombreTarjeta = nombreTarjeta;
    }

    /**
     * @return the numeroTarjeta
     */
    public byte getNumeroTarjeta() {
        return numeroTarjeta;
    }

    /**
     * @param numeroTarjeta the numeroTarjeta to set
     */
    public void setNumeroTarjeta(byte numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    /**
     * @return the canal
     */
    public int getCanal() {
        return canal;
    }

    /**
     * @param canal the canal to set
     */
    public void setCanal(int canal) {
        this.canal = canal;
    }   
        
}
