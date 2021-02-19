import java.util.*;
public class Quiz {
  private static int responsibility;
  private static int decency;
  private static int selfishness;
  private static int determination;
  private static int confidence;
  private static int cheer;
  private static String q1options = "(1) try to rush and finish the paper correctly.\n"
    + "(2) fill in random answers\n" 
    + "(3) Homework? who DOES that nowadays?\n"
    + "(4) I\'m too cool for homework. Do you think I\'m TRYING to look like a nerd?\n" 
    + "(5) Ask the teacher if you can go to the restroom and try to finish it there.\n" 
    + "(6) yawn and fall asleep on top of your paper, hoping she'll pass you by."; 
 
  private static String q3options = "(1) Book a doctor's appointment.\n(2) Get someone else to book your doctor's appointment.\n(3) Wait for it to go away."; 
  
  private static String q6options = "(1) outgoing\n(2) mean\n(3) hilarious\n(4) selfish\n(5) snooty\n(6) confident"; 
  
  private static String q7options = "(1) scream at the person to stop.\n" 
    +"(2) try your hardest to save them, but...you're not a super hero and have no magic powers. but you'll do what you can!\n" 
    + "(3) do everything, even if it means giving your own life in place of it.\n" 
    + "(4) gasp and say, \"how sad!\" before continuing in your everyday life.\n" 
    + "(5) look away. you don't want to pollute your mind.\n" 
    + "(6) call 911 and leave it to the pros."; 
  
  private static String q14options = "(1) probably\n(2) no\n(3) definitely";

	private static String q12options = "(1) approachable\n(2) very friendly\n(3) ok - I don't really notice\n(4) unapproachable";
  
  private static String q16options = "(1) Tell them you don't want to.\n"
     + "(2) Say you have other plans. A white lie never hurts anyone.\n"
     + "(3) Go anyway. You wouldn't want to hurt his/her feelings."; 

  private static String q20options = "(1) Work with the group\n(2) Do most of the project myself\n(3) Don't do anything. I just help present";

  private static Question q1 = new Question("In Chemistry, you realize you forgot to do your homework, and the teacher is coming around to check it now. You:\n", q1options);
  private static Question q2 = new Question("Are you optimistic about your life?\n");
  private static Question q3 = new Question("You\'ve not been feeling well for a few days. What do you do?\n", q3options); 
  private static Question q4 = new Question("Are you satisfied with your finances, relationships, and career?\n");
  private static Question q5 = new Question("If you have something on your mind, do you always say it?\n"); 
  private static Question q6 = new Question("Pick the word that most describes you.\n", q6options);
  private static Question q7 = new Question("A person you don't know is going to be killed or tortured. you:\n", q7options);  
  private static Question q8 = new Question("If a colleague wrote a book that you aren't that intrested in, would you read it?\n"); 
  private static Question q9 = new Question("Do you like to give or receive more?\n", "(1) give.\n(2) recieve.");
  private static Question q10 = new Question("Would you help a friend study for an important test if they asked?\n");
  private static Question q11 = new Question("You have $5,000 in your account,a friend asks to borrow $1,200-would you let them?\n");
  private static Question q12 = new Question("When you're out and about, do you generally find other people:\n", q12options);
  private static Question q13 = new Question("Would you be President if you could?\n");
  private static Question q14 = new Question("Do you think that you’re more intelligent than the average person?\n", q14options);
  private static Question q15 = new Question("Do you think that you are a particularly positive person?\n");
  private static Question q16 = new Question("Someone asks you to come over but you really don't want to. What do you do?\n", q16options);
	private static Question q17 = new Question("Do you value things that don't come easy?\n");
	private static Question q18 = new Question("Are you stubborn?\n");
	private static Question q19 = new Question("Do you struggle to meet deadlines?\n");
	private static Question q20 = new Question("In group projects, you:\n", q20options);
  
  
  public static void quiz() {
    Scanner input1 = new Scanner(System.in);
    System.out.println(q1);
    int answer1 = input1.nextInt();
    if (answer1 == 1) {
      determination++;
      confidence--;
    } else if (answer1 == 2) {
      determination--;
      responsibility--;
      confidence++;
    } else if (answer1 == 3) {
      responsibility--;
      selfishness++;
    } else if (answer1 == 4) {
      responsibility--;
      confidence--;
      selfishness--;
    } else if (answer1 == 5) {
      confidence--;
      selfishness--;
    } else {
      determination--;
      responsibility--;
    }
    
    
    Scanner input2 = new Scanner(System.in);
    System.out.println(q2);
    int answer2 = input2.nextInt();
    if (answer2 == 1) {
      cheer++;
      decency++;
      confidence++;
    } else {
      cheer--;
      decency--;
    }
    
    
    Scanner input3 = new Scanner(System.in);
    System.out.println(q3);
    int answer3 = input3.nextInt();
    if (answer3 ==1) {
      responsibility++;
      selfishness--;
    } else if (answer3 == 2) {
      responsibility--;
      selfishness++;
    } else {
      responsibility++;
      confidence--;
    }     
    
    
    Scanner input4 = new Scanner(System.in);
    System.out.println(q4);
    int answer4 = input4.nextInt();
    if (answer4 == 1) {
      cheer++;
      decency++;
      confidence++;
    } else {
      cheer--;
      decency--;
      confidence--;
      selfishness--;
    }
    
    Scanner input5 = new Scanner(System.in);
    System.out.println(q5);
    int answer5 = input5.nextInt();
    if (answer5 == 1) {
      confidence++;
    } else {
      confidence--;
    }
    
     
    
    Scanner input6 = new Scanner(System.in);
    System.out.println(q6);
    int answer6 = input6.nextInt();
    if (answer6 == 1) {
      decency+=2;
    } else if (answer6 == 2) {
      decency-=2;
    } else if (answer6 == 3) {
      decency+= 2;
      confidence++;
    } else if (answer6 == 4) {
      selfishness+= 2;
    } else if (answer6 == 5) {
      responsibility--;
      selfishness++;
    } else {
      confidence+=2;
    }

    
    
    Scanner input7 = new Scanner(System.in);
    System.out.println(q7);
    int answer7 = input7.nextInt();
    if (answer7 == 1) {
      determination--;
      confidence--;
      responsibility--;
    } else if (answer7 == 2) {
      confidence++;
      determination++;
    } else if (answer7 == 3) {
      selfishness--;
      determination++;
    } else if (answer7 == 4) {
      determination--;
      selfishness++;
    } else if (answer7 == 5) {
      confidence--;
      selfishness--;
    } else {
      determination--;
      responsibility++;
    }
  
    Scanner input8 = new Scanner(System.in);
    System.out.println(q8);
    int answer8 = input8.nextInt();
    if (answer8 == 1) {
      selfishness--;
      decency++;
    } else {
      selfishness++;
    }
    
    
    Scanner input9 = new Scanner(System.in);
    System.out.println(q9);
    int answer9 = input9.nextInt();
    if (answer9 == 1) {
      selfishness--;
      decency++;
      confidence++;
    } else {
      selfishness++;
    }
    
    Scanner input10 = new Scanner(System.in);
    System.out.println(q10);
    int answer10 = input10.nextInt();
    if (answer10 == 1) {
      selfishness--;
      decency++;
    } else {
      selfishness++;
      decency--;
    }
    
    Scanner input11 = new Scanner(System.in);
    System.out.println(q11);
    int answer11 = input11.nextInt();
    if (answer11 == 1) {
      selfishness--;
      decency+=2;
      responsibility--;
    } else {
      responsibility++;
      selfishness++;
			determination++;
    }
   
   	Scanner input12 = new Scanner(System.in);
    System.out.println(q12);
    int answer12 = input12.nextInt();
    if (answer12 == 1) {
      confidence++;
			decency++;
    } else if (answer12 == 2) {
      confidence++;
			cheer++;
    } else if (answer12 == 3) {
			cheer--;
			selfishness--;
		} else {
      cheer--;
			confidence--;
    } 
    
    Scanner input13 = new Scanner(System.in);
    System.out.println(q13);
    int answer13 = input13.nextInt();
    if (answer13 == 1) {
       confidence++;
       responsibility++;
			 determination++;
    } else {
      confidence--;
      decency++;
    }
    
    Scanner input14 = new Scanner(System.in);
    System.out.println(q14);
    int answer14 = input14.nextInt();
    if (answer14 == 1) {
       confidence--;
       responsibility++;
    } else if( answer14 == 2) {
      selfishness++;
    } else {
      confidence++;
      responsibility++;
    }
    
    Scanner input15 = new Scanner(System.in);
    System.out.println(q15);
    int answer15 = input15.nextInt();
    if (answer15 == 1) {
       cheer++;
    } else {
      cheer--;
    }
 
    
    Scanner input16 = new Scanner(System.in);
    System.out.println(q16);
    int answer16 = input16.nextInt();
    if (answer16 == 1) {
       decency--;
       selfishness++;
    } else if( answer16 == 2) {
       decency--;
       selfishness--;
    } else {
       decency++;
       selfishness--;
    }

		Scanner input17 = new Scanner(System.in);
		System.out.println(q17);
    int answer17 = input17.nextInt();
    if (answer17 == 1) {
       determination++;
    } else {
      determination--;
			selfishness--;
    }

		Scanner input18 = new Scanner(System.in);
		System.out.println(q18);
    int answer18 = input18.nextInt();
    if (answer18 == 1) {
       determination++;
    } else {
      determination--;
    }

		Scanner input19 = new Scanner(System.in);
		System.out.println(q19);
    int answer19 = input19.nextInt();
    if (answer19 == 1) {
       determination++;
			 responsibility--;
    } else {
      determination--;
			responsibility++;
    }
    

		Scanner input20 = new Scanner(System.in);
		System.out.println(q20);
    int answer20 = input20.nextInt();
    if (answer20 == 1) {
       determination++;
			 cheer++;
    } else if (answer20 == 2) {
       determination += 2;
			 decency++;
    } else {
			determination--;
			selfishness++;
		}
    
  }

  
  
  
  /** 
   * @return int
   */
  public static int getResponsibility() {
    return responsibility;
  }
  
  
  /** 
   * @return int
   */
  public static int getDecency() {
    return decency; 
  }
  
  
  /** 
   * @return int
   */
  public static int getSelfishness() {
    return selfishness;
  }
  
  
  /** 
   * @return int
   */
  public static int getDetermination() {
    return determination;
  }
  
  
  /** 
   * @return int
   */
  public static int getConfidence() {
    return confidence;
  }
  
  
  /** 
   * @return int
   */
  public static int getCheer() {
    return cheer;
  }
  
  /*outcomes 
  Nice //customers come back more            1            Mean //customer come back less
    
  Selfish //chefs like you more              2
  Empathic //chef like you less
    
  Responsible //debt is smaller              3
  Irresponsible //debt is bigger       
  
    
  Determined //more customers come in        4
  Undetermined //less customers come in 
    
    
  Confident  //customers will like the management     5
  Shy //customers will not like the managment


  Cheerful//Customers will like the food more        6
  Gloomy //customes will like the food less

    */
    
}
  
  