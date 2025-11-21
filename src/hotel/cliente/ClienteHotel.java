/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Stefano
 */
package hotel.cliente;

import hotel.GerenciadorQuartos;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

public class ClienteHotel {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            GerenciadorQuartos hotel = (GerenciadorQuartos) registry.lookup("HotelService");

            Scanner sc = new Scanner(System.in);
            int opcao = -1;

            while (opcao != 0) {
                System.out.println("\n--- MENU DO HOTEL ---");
                System.out.println("1 - Listar quartos");
                System.out.println("2 - Reservar quarto");
                System.out.println("3 - Listar hóspedes");
                System.out.println("0 - Sair");
                System.out.print("Escolha: ");

                opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.println(hotel.listagem());
                        break;

                    case 2:
                        System.out.print("Tipo de quarto (0 a 4): ");
                        int tipo = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Nome do hóspede: ");
                        String nome = sc.nextLine();
                        System.out.println(hotel.reserva(tipo, nome));
                        break;

                    case 3:
                        List<String> lista = hotel.hospede();
                        System.out.println("\nHóspedes cadastrados:");
                        lista.forEach(System.out::println);
                        break;

                    case 0:
                        System.out.println("Saindo...");
                        break;

                    default:
                        System.out.println("Opção inválida.");
                }
            }

            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

