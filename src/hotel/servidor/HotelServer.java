/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Stefano
 */
package hotel.servidor;

import hotel.GerenciadorQuartos;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import hotel.servidor.ServidorHotel;

public class HotelServer {

    public static void main(String[] args) {
        try {
            GerenciadorQuartos servidor = new ServidorHotel();

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("HotelService", servidor);

            System.out.println("Servidor do Hotel iniciado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

