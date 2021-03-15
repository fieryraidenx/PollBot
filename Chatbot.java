package com.company;

public class Chatbot {
    private final String[] jokeCheck = new String[]{"joke", "humour", "sad", "funny", "laugh", "!", "happy"};
    private final String[] presidentCheck = new String[]{"president", "joe", "biden", "vice", "donald", "trump"};
    private final String[] electionCheck = new String[]{"election", "vote", "poll"};


    public String getGreeting() {
        return "Hello, let's talk.";
    }

    private boolean checkArray(String statement, String[] array) {
        for(String s : array){
            if(statement.contains(s)){return true;}
        }
        return false;
    }


    public String getResponse(String statement) throws Exception {
        String response = "";
        statement = statement.toLowerCase();

        if(statement.trim().length() == 0){
            response = "Please say something.";
        }

        else if (statement.contains("no ") || statement.contains(" no")) {
            response = "If this is not a comfortable topic, we can talk about another one.";
        }

        else if(checkArray(statement, electionCheck)){
            CivicInfo ci = new CivicInfo();
            response = String.format("Here are some local elections running around here: \n%s", ci.getInfo());
        }

        else if (statement.contains("mother")
                || statement.contains("father")
                || statement.contains("sister")
                || statement.contains("brother")) {
            response = "Tell me more about your family.";
        }

        else if (checkArray(statement, presidentCheck)){
            /*TODO: Add information on the website*/
            response = "For more information on U.S Presidents, please check out this website: https://www.whitehouse.gov/about-the-white-house/presidents/";
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
                "What is the difference between capitalism and socialism?\nIn a capitalist society, man exploits man,  and in a socialist one, it’s the other way around!",
                "How did we know communism was doomed from the beginning?\nWhy, there were already many red flags!",
                "Here's food for thought: If con is the opposite of pro, then isn’t Congress the opposite of progress?"
        };
        return jokeList[(int) (Math.random() * jokeList.length)];
    }

    private String fallBack() {
        /*TODO: Add a couple of fallback statements*/
        String[] fallback = new String[]{
                "Interesting, tell me more.", "Do you really think so?", "Hmmm.", "You don't say.",
                "Nice! If you want to hear a joke, ?"
        };
        return fallback[(int) (Math.random() * fallback.length)];
    }
}
