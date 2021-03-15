package com.company;

import java.util.Scanner;

public class Main {



    public static void main(String[] args)
    {
        Chatbot civicBot = new Chatbot();
        System.out.println("Welcome to the Alameda Civics Bot! To stop chatting with our bot, type 'EXIT'\n");
        System.out.println(civicBot.getGreeting());

        String response = ""; Scanner in = new Scanner(System.in);;
        while (true){
            System.out.print(">");
            response = in.nextLine();
            if(response.toUpperCase().equals("EXIT")){break;}
            System.out.println(civicBot.getResponse(response));
        }
        in.close();
    }

}
