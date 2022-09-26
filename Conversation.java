/**
 * Author: Ryan (K) Emerson
 * Coding Buddies: Janna Gillesman and Chelsea Fowler
 * Date: 9/25/22
 * Resources: 
 *  https://www.educative.io/answers/how-to-generate-random-numbers-in-java
 */
import java.util.*;

class Conversation {
    public static void main(String[] arguments){

        /**
         * Setting up arrays to use within conversation:
         * Makeshift dictionary to replace mirror words
         */
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("your", "my"); 
        map.put("Your", "My");    
        map.put("my", "your");
        map.put("My", "Your");
        map.put("I", "you");
        map.put("you", "I");
        map.put("You", "I");
        map.put("am", "are");
        map.put("are","am");
        map.put("me", "you");
        map.put("Me", "You");
        map.put("mine", "yours");
        map.put("Mine", "Yours");
        map.put("yours", "mine");
        map.put("Yours", "Mine");

        /** 
         * Array of canned responses
        */
        ArrayList<String> cannedResponses = new ArrayList<String>();
        cannedResponses.add("Wow.");       
        cannedResponses.add("Jeez.");
        cannedResponses.add("If you say so...");
        cannedResponses.add("That's kinda rude.");
        cannedResponses.add("I'm trying to understaind where you're coming from.");
        cannedResponses.add("Okay...");
        cannedResponses.add("No no I hear you.");
        cannedResponses.add("It sounds like you're not taking responsibility for your part in it.");
        cannedResponses.add("Anything else?");

        /** 
         * Random integer generator for randomization of canned responses
         * Code from: https://www.geeksforgeeks.org/scanner-hasnextint-method-in-java-with-examples/
        */
        Random rand = new Random();
        int upperbound = cannedResponses.size();
        int randomInteger = rand.nextInt(upperbound);

        /**
         * Defining constant varriables used
         */

        String ASK_ROUNDS = "How many times are we going to go over this?";
        String GOODBYE_0_ROUNDS = "That's what I thought. I didn't even want to talk to you anyway.";
        String INITIAL_PROMPT = "So what do you have to say for yourself?";
        String GOODBYE_N_ROUNDS = "That's it. I'm done having this conversation.";

        /** 
         * Set up scanner
        */
        Scanner input = new Scanner(System.in);

        /** 
         * Set up transcript array
        */
        ArrayList<String> transcript = new ArrayList<String>();

        /** 
         * Ask how many rounds, clearing scanner buffer after
        */
        System.out.println(ASK_ROUNDS);
        transcript.add(ASK_ROUNDS);
        int n = input.nextInt();
        String number = String.valueOf(n);
        transcript.add(number);
        input.nextLine();       

        /** 
         * If n<=0 prints goodbye message and closes scanner
         */
        if(n <= 0){
            System.out.println(GOODBYE_0_ROUNDS);
            transcript.add(GOODBYE_0_ROUNDS);
            input.close();
        }
        
        /** 
         * If n>0 processes multiple inputs
        */
        else {
            System.out.println(INITIAL_PROMPT);
            transcript.add(INITIAL_PROMPT);
            for(int i = 0; i < n; i++){
                /** 
                 * Gathers input and splits line into separate strings
                */
                String typed = input.nextLine();
                transcript.add(typed);
                String typedWords[] = typed.split(" ");
                    /**
                     * Establishes mirroflag as false for later use
                     */
                    Boolean mirrorFlag = false;
                    /**
                     * For number of words in input, identifies and replaces mirror words
                     */ 
                    for(int j = 0; j < typedWords.length; j++){
                        if(map.containsKey(typedWords[j])){
                            mirrorFlag = true;
                            typedWords[j]= map.get(typedWords[j]);
                        }
                    }
                    /**
                     * If there were mirror words, joins string array words into string message and prints with ?
                    */
                    if(mirrorFlag){
                        String join = String.join(" ", typedWords);
                        String mirroredResponse = join +"?";
                        System.out.println(mirroredResponse);
                        transcript.add(mirroredResponse);
                    }
                    /**
                     * If no mirrored words, print canned response
                     */
                    else{
                        randomInteger = rand.nextInt(upperbound);
                        String randResponse = cannedResponses.get(randomInteger);
                        System.out.println(randResponse); 
                        transcript.add(randResponse);
                    }
            /**
             * Repeats for n rounds
             */ 
            }
            /**
             * Goodbye message and close scanner when n rounds have completed, print transcript
             */ 
            System.out.println(GOODBYE_N_ROUNDS);
            transcript.add(GOODBYE_N_ROUNDS);
            input.close();            
        } 
        /**
         * Print transcript header and transcript
        */
        System.out.println("TRANSCRIPT:");
        for(int k=0; k < transcript.size(); k++){
            System.out.println(transcript.get(k));
        }
    }   
}
