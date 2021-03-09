package com.company;

public class Main {



    public static void main(String[] args)
    {
        Chatbot civicBot = new Chatbot();

        System.out.println(civicBot.getGreeting());
        System.out.println(">My mother and I talked last night.");
        System.out.println(civicBot.getResponse("My mother and I talked last night."));
        System.out.println(">I said no.");
        System.out.println(civicBot.getResponse("I said no!"));
        System.out.println(">The weather is nice.");
        System.out.println(civicBot.getResponse("The weather is nice."));
        System.out.println(">Do you know my brother?");
        System.out.println(civicBot.getResponse("Do you know my brother?"));
    }

}
