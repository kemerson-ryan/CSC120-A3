import java.util.*;
import java.util.Arrays;

class Conversation {
    public static void main(String[] arguments){
        //Setting up arrays to use within conversation

        //? How to make prior replacements not be overrridden by later ones
        // Makeshift dictionary to replace required words
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
        map.put(".", "?");

        // Creating canned responses
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

        // Generate random numbers to choose a corresponding canned response
        Random rand = new Random();     //initializing random class
        int upperbound = canned_responses.size();       //sets range of values to choose from
        int int_random = rand.nextInt(upperbound);      //variable represents one randomly generated integer
        //credit the website for this code

        Scanner input = new Scanner(System.in);

        //Ask how many rounds
        System.out.println("How many times are we going to go over this?");
        int n = input.nextInt();
        input.nextLine();       //clear buffer of enter key above

        if(n == 0){     //if user didn't want to talk 
            System.out.println("That's what I thought. I didn't even want to talk to you anyway");
            input.close();
        }
        else {
            System.out.println("So what do you have to say for yourself?");
            for(int i = 0; i < n; i++){
                String typed = input.nextLine();
                String typed_words[] = typed.split(" ");
                    //System.out.println(Arrays.toString(typed_words));
                    Boolean mirrorflag = false;
                    for(int j = 0; j < typed_words.length; j++){
                        if(map.containsKey(typed_words[j])){
                            mirrorflag = true;
                            typed_words[j]= map.get(typed_words[j]);
                            //typed_words.replace(typed_words[j], (String) map.get(typed_words[j])); 
                            System.out.println(Arrays.toString(typed_words));
                        }
                    }
                    if(mirrorflag){
                        //going to print string from typed_words[] array
                    }
                    if(!mirrorflag){
                        int_random = rand.nextInt(upperbound);
                        System.out.println(canned_responses.get(int_random)); 
                    }
            }
            System.out.println("That's it. I'm done having this conversation");
            input.close();
        } 
    }   
}
