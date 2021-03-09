package com.company;

public class Chatbot {
    private final String[] jokeCheck = new String[]{"joke", "humour", "sad", "funny", "laugh", "!", "happy"};
    private final String[] presidentCheck = new String[]{"president", "joe", "biden", "vice", "donald", "trump"};


    public String getGreeting() {
        return "Hello, let's talk.";
    }

    private boolean checkArray(String statement, String[] array) {
        for(String s : array){
            if(statement.contains(s)){return true;}
        }
        return false;
    }


    public String getResponse(String statement) {
        String response = "";
        statement = statement.toLowerCase();

        if(statement.trim().length() == 0){
            response = "Please say something.";
        }

        else if (statement.contains("no ") || statement.contains(" no")) {
            response = "If this is not a comfortable topic, we can talk about another one.";
        }

        else if (statement.contains("mother")
                || statement.contains("father")
                || statement.contains("sister")
                || statement.contains("brother")) {
            response = "Tell me more about your family.";
        }

        else if (checkArray(statement, presidentCheck)){
            /*TODO: Add information on the website*/
            response = "For more information on our current president, please check out this website: {}";
        }

        else if (checkArray(statement, jokeCheck)){
            response = getRandomJoke();
        }

        else {
            response = fallBack();
        }

        return response;
    }

    private String getRandomJoke() {
        /*TODO: Add a couple of jokes*/
        String[] jokeList = new String[]{
                "Joke1", "Joke2", "Joke3"
        };
        return jokeList[(int) (Math.random() * jokeList.length)];
    }

    private String fallBack() {
        /*TODO: Add a couple of fallback statements*/
        String[] fallback = new String[]{
                "Interesting, tell me more.", "Do you really think so?", "Hmmm.", "You don't say."
        };
        return fallback[(int) (Math.random() * fallback.length)];
    }
}
