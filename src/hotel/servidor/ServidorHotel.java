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
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ServidorHotel extends UnicastRemoteObject implements GerenciadorQuartos {

    private final HashMap<Integer, Integer> quartosDisponiveis;
    private final HashMap<Integer, Double> precos;
    private final List<String> hospedes;

    public ServidorHotel() throws RemoteException {
        super();

        quartosDisponiveis = new HashMap<>();
        precos = new HashMap<>();
        hospedes = new ArrayList<>();

        quartosDisponiveis.put(0, 10);
        quartosDisponiveis.put(1, 20);
        quartosDisponiveis.put(2, 5);
        quartosDisponiveis.put(3, 3);
        quartosDisponiveis.put(4, 2);

        precos.put(0, 100.0);
        precos.put(1, 150.0);
        precos.put(2, 200.0);
        precos.put(3, 250.0);
        precos.put(4, 300.0);
    }

    @Override
    public synchronized String listagem() throws RemoteException {
        StringBuilder sb = new StringBuilder("QUARTOS DISPONÍVEIS:\n\n");

        for (int tipo : quartosDisponiveis.keySet()) {
            sb.append("Tipo " + tipo
                    + " | Restantes: " + quartosDisponiveis.get(tipo)
                    + " | Preço: R$" + precos.get(tipo)
                    + "\n");
        }

        return sb.toString();
    }

    @Override
    public synchronized String reserva(int tipo, String nomeHospede) throws RemoteException {
        if (!quartosDisponiveis.containsKey(tipo)) {
            return "Tipo de quarto inválido!";
        }

        int disponivel = quartosDisponiveis.get(tipo);

        if (disponivel > 0) {
            quartosDisponiveis.put(tipo, disponivel - 1);
            hospedes.add(nomeHospede);
            return "Reserva realizada com sucesso!\nHóspede: " + nomeHospede + "\nTipo de quarto: " + tipo;
        } else {
            return "Não há quartos disponíveis desse tipo.";
        }
    }

    @Override
    public synchronized List<String> hospede() throws RemoteException {
        return new ArrayList<>(hospedes);
    }
}

