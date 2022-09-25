import java.util.*;

class Conversation {
    public static void main(String[] arguments){
        //setting up arrays to use within conversation

        //makeshift dictionary to replace required words
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("your", "my");     
        map.put("my", "your");
        map.put("I", "you");
        map.put("you", "I");
        map.put("am", "are");
        map.put("are","am");
        map.put("me", "you");
        map.put("mine", "yours");
        map.put("yours", "mine");
        //deal with punctuation?

        //creating canned responses
        ArrayList<String> canned_responses = new ArrayList<String>();
        canned_responses.add("Wow.");       //adding each response to array
        canned_responses.add("Jeez.");
        canned_responses.add("If you say so...");
        canned_responses.add("That's kinda rude.");
        canned_responses.add("I'm trying to understaind where you're coming from.");
        canned_responses.add("Okay...");
        canned_responses.add("No no I hear you.");
        canned_responses.add("It sounds like you're not taking responsibility for your part in it.");
        canned_responses.add("Anything else?");

        //generate random numbers to choose a corresponding canned response
        Random rand = new Random();     //initializing random class
        int upperbound = canned_responses.size();       //sets range of values to choose from
        int int_random = rand.nextInt(upperbound);      //variable represents one randomly generated integer
        //credit the website for this code

        //set up scanner
        Scanner input = new Scanner(System.in);

        //ask how many rounds
        System.out.println("How many times are we going to go over this?");
        int n = input.nextInt();
        input.nextLine();       //clear buffer of enter key above

        //if n<=0 prints goodbye message and closes scanner
        if(n <= 0){
            System.out.println("That's what I thought. I didn't even want to talk to you anyway");
            input.close();
        }
        //if n>0 processes multiple inputs
        else {
            System.out.println("So what do you have to say for yourself?");
            for(int i = 0; i < n; i++){
                //gathers input and splits line into separate strings
                String typed = input.nextLine();
                String typed_words[] = typed.split(" ");        //deal with punctuation?
                    //establishes mirroflag as false for later use
                    Boolean mirrorflag = false;
                    //for number of words in input, identifies and replaces mirror words
                    for(int j = 0; j < typed_words.length; j++){
                        if(map.containsKey(typed_words[j])){
                            mirrorflag = true;
                            typed_words[j]= map.get(typed_words[j]);
                            //System.out.println(Arrays.toString(typed_words)); for testing
                        }
                    }
                    //If there were mirror words, joins string array words into string message and prints with ?
                    if(mirrorflag){
                        String join = String.join(" ", typed_words);
                        System.out.println(join + "?");
                    }
                    //If no mirrored words, print canned response
                    else{
                        int_random = rand.nextInt(upperbound);
                        System.out.println(canned_responses.get(int_random)); 
                    }
            //repeats for n number of rounds
            }
            //goodbye message and close scanner when n rounds have completed
            System.out.println("That's it. I'm done having this conversation");
            input.close();
        } 
    }   
}
