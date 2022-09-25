import java.util.*;

class Conversation {
    public static void main(String[] arguments){
        //setting up arrays to use within conversation

        //makeshift dictionary to replace required words
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

        //creating canned responses
        ArrayList<String> cannedResponses = new ArrayList<String>();
        cannedResponses.add("Wow.");       //adding each response to array
        cannedResponses.add("Jeez.");
        cannedResponses.add("If you say so...");
        cannedResponses.add("That's kinda rude.");
        cannedResponses.add("I'm trying to understaind where you're coming from.");
        cannedResponses.add("Okay...");
        cannedResponses.add("No no I hear you.");
        cannedResponses.add("It sounds like you're not taking responsibility for your part in it.");
        cannedResponses.add("Anything else?");

        //generate random numbers to choose a corresponding canned response
        Random rand = new Random();     //initializing random class
        int upperbound = cannedResponses.size();       //sets range of values to choose from
        int randomInteger = rand.nextInt(upperbound);      //variable represents one randomly generated integer
        //credit the website for this code

        //define prompting variables used
        String ASK_ROUNDS = "How many times are we going to go over this?";
        String GOODBYE_0_ROUNDS = "That's what I thought. I didn't even want to talk to you anyway.";
        String INITIAL_PROMPT = "So what do you have to say for yourself?";
        String GOODBYE_N_ROUNDS = "That's it. I'm done having this conversation.";

        //set up scanner
        Scanner input = new Scanner(System.in);

        //set up transcript array
        ArrayList<String> transcript = new ArrayList<String>();

        //ask how many rounds
        System.out.println(ASK_ROUNDS);
        transcript.add(ASK_ROUNDS);
        int n = input.nextInt();
        String number = String.valueOf(n);
        transcript.add(number);
        input.nextLine();       //clear buffer of enter key above

        //if n<=0 prints goodbye message and closes scanner
        if(n <= 0){
            System.out.println(GOODBYE_0_ROUNDS);
            transcript.add(GOODBYE_0_ROUNDS);
            input.close();
        }
        //if n>0 processes multiple inputs
        else {
            System.out.println(INITIAL_PROMPT);
            transcript.add(INITIAL_PROMPT);
            for(int i = 0; i < n; i++){
                //gathers input and splits line into separate strings
                String typed = input.nextLine();
                transcript.add(typed);
                String typedWords[] = typed.split(" ");        //deal with punctuation?
                    //establishes mirroflag as false for later use
                    Boolean mirrorFlag = false;
                    //for number of words in input, identifies and replaces mirror words
                    for(int j = 0; j < typedWords.length; j++){
                        if(map.containsKey(typedWords[j])){
                            mirrorFlag = true;
                            typedWords[j]= map.get(typedWords[j]);
                        }
                    }
                    //If there were mirror words, joins string array words into string message and prints with ?
                    if(mirrorFlag){
                        String join = String.join(" ", typedWords);
                        String mirroredResponse = join +"?";
                        System.out.println(mirroredResponse);
                        transcript.add(mirroredResponse);
                    }
                    //If no mirrored words, print canned response
                    else{
                        randomInteger = rand.nextInt(upperbound);
                        String randResponse = cannedResponses.get(randomInteger);
                        System.out.println(randResponse); 
                        transcript.add(randResponse);
                    }
            //repeats for n number of rounds
            }
            //goodbye message and close scanner when n rounds have completed, print transcript
            System.out.println(GOODBYE_N_ROUNDS);
            transcript.add(GOODBYE_N_ROUNDS);
            input.close();            
        } 
        System.out.println("TRANSCRIPT:");
        for(int k=0; k < transcript.size(); k++){
            System.out.println(transcript.get(k));
        }
    }   
}
