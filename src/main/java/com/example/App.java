package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        try {
            Socket s = new Socket("localhost", 3000);
            System.out.println("Connessione effettuata");

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            int conv = 0;

            Scanner scanner = new Scanner(System.in);
            
            

            do {
                System.out.println("Inserisci il numero: ");
                String userNum = scanner.nextLine(); 
                out.writeBytes(userNum +"\n");
                System.out.println("--->");
                String risposta = in.readLine();               
                conv = Integer.parseInt(risposta);
                if (conv == 1) {
                    System.out.println("Numero troppo piccolo\n");
                }
                else if (conv == 2) {
                    System.out.println("Numero troppo grande\n");   
                }

            } while (conv != 3);            
            
            System.out.println("HAI INDOVINATO IN " + in.readLine() + "tentativi");

            s.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
            System.exit(1);
        }
    }
}
