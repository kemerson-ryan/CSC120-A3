import java.util.*;

class Conversation {

  public static void main(String[] arguments) {
    //Setting up arrays to use later

    //? How to make prior replacements not be overrridden by later ones
    // Makeshift dictionary to replace required words
    HashMap<String, String> map = new HashMap<String, String>();
    map.put("your", "my");
    map.put("my", "your");
    map.put("I", "you");
    map.put("you", "I");
    map.put("am", "are");
    map.put("me", "you");
    map.put("mine", "yours");
    map.put("yours", "mine");
    map.put(".", "?");

    // Creating canned messages
    ArrayList<String> canned_responses = new ArrayList<String>();
    canned_responses.add("Wow.");
    canned_responses.add("Jeez.");
    canned_responses.add("If you say so...");
    canned_responses.add("That's kinda rude.");
    canned_responses.add("I'm trying to understaind where you're coming from.");
    canned_responses.add("Okay...");
    canned_responses.add("No no I hear you.");
    canned_responses.add("It sounds like you're not taking responsibility for your part in it.");
    canned_responses.add("Anything else?");

    // Generate random numbers to choose a corresponding canned response
    Random rand = new Random(); 
    int upperbound = canned_responses.size();
    int int_random = rand.nextInt(upperbound); 
    //System.out.println("Random integer value from 0 to" + (upperbound-1) + " : "+ int_random);
    //credit the website for this code

    // Starting conversation here. How many times to ask for input
    System.out.println("How many times are we going to go over this?");
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    input.nextLine(); //to clear buffer

    // If answer is 0, print a goodbye message
    if (n == 0) {
      System.out.println("That's what I thought. I'm done.");
      input.close();
    }
    
    // If answer is not 0, begins chat, reducing value of n after each exchange
    else {
      //System.out.println("Okay, what do you have to say for yourself?");
      //String input1 = input.nextLine(); //for transcript will I be able to refer to this variable in this method?
      //System.out.println("Really? You're saying " + input1 +"?");
      //n = n-1;

      // If they didn't input 0, the for loop will provide a tailored message based on mirror words
      // If no mirror words detected, respond with randomized canned message
      for (int i=0; i<n; i++){
        String response = input.nextLine();
        String[] words = response.split(" ");

        for (int h=0; h <words.length; h++) { //? what are the normal for loop variables to use
          if(map.containsKey(words[h])) {
            response = response.replace(words[h], (String)map.get(words[h]));
          }

      //System.out.println(i + " " + n);
      //System.out.println("what else?"); 
      int_random = rand.nextInt(upperbound);
      System.out.println(canned_responses.get(int_random));
      //input.nextLine(); //save response as split --find throuhg string documentation--
      //String input3 = input.next();
      //String[] words=input2.split(" ");
      //System.out.println(input2);
      //string user  String[] words=userInput.split(" ") ...gives an array of individual words...
      }

      // Once n=0, goodbye message prints
      System.out.println("That's it. I'm done having this conversation.");
      input.close();
      
    
      /* set up dictionary... mhmm... okay and? I see what you're saying 
         I don't know about that
       * may need a separate class and thus file for that.
       * generate a random number used as a key for a dictionary
       * print dictionary term
       * ask for input again
       * LEVEL 3 wants to save transcript, so this may require
       * putting the input and what we've said into an array?
       * close input
       */
  
    }

    
  }


}
}