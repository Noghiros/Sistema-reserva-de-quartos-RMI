/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Stefano
 */
package hotel;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface GerenciadorQuartos extends Remote {
    String listagem() throws RemoteException;
    String reserva(int tipo, String nomeHospede) throws RemoteException;
    List<String> hospede() throws RemoteException;
}

