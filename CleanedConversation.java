import java.util.Scanner;
import java.util.ArrayList;
//import java.util.Dictionary; 
import java.util.Random;

class CleanedConversation {

  public static void main(String[] arguments) {

    // Start the conversation here. How many times to ask for input
    System.out.println("How many times are we going to go over this?");
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(); //? need to put if else and a for loop asking for an integer rather than string, try 5 times then quit
    //? how to handle negative numners -> absolute value or make 0?
    input.nextLine();
    
    // If n is 0, print a goodbye message
    if (n==0) {
      System.out.println("That's what I thought. I'm done.");
      input.close();
    }
    
    // If n is not 0, begins chat, reducing value of n after each exchange
    else {
      System.out.println("Okay, what do you have to say for yourself?");
      String input1 = input.nextLine(); //for transcript will I be able to refer to this variable in this method?
      System.out.println("Really? You're saying " + input1 +"?");
      n = n-1;

      //String input2 = input.next(); 
      //String[] words=input2.split(" ");

      //? this above also only take first token of input
      //n =n-1;

      // Creating canned responses for if the answer was nonzero
      ArrayList<String> canned_responses = new ArrayList<String>();
      canned_responses.add("Wow.");
      canned_responses.add("Jeez.");
      canned_responses.add("If you say so...");
      canned_responses.add("That's kinda rude.");

      // Generate random numbers to choose a corresponding canned response
      Random rand = new Random(); 
      int upperbound = canned_responses.size();
      int int_random = rand.nextInt(upperbound); 
      //System.out.println("Random integer value from 0 to" + (upperbound-1) + " : "+ int_random);
      //Credit the website for this code

      // For loop will generate fields for input and create tailored responses
      for (int i=0; i<n; i++){
        String response = input.nextLine();
         if (response.contains("I")){
          //mirror words then
        }
        else {
          //canned responses
        } 

        //System.out.println(i + " " + n);
        //System.out.println("what else?"); 
        int_random = rand.nextInt(upperbound);
        System.out.println(canned_responses.get(int_random));
        input.nextLine(); //save response as split --find throuhg string documentation--
        //String input3 = input.next();
        //String[] words=input2.split(" ");
        //System.out.println(input2);
        //string user  String[] words=userInput.split(" ") ...gives an array of individual words...
      }
      // Once n=0, goodbye message prints
      System.out.println("That's it. I'm having this conversation.");
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
