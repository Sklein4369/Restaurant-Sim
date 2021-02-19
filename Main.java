import java.util.*;
public class Main{
  private static int day = 1;
  private static int week = 1;
  private static boolean cont = true;
  private static Dish[] menu;
  private static int numOfCustomersInDay = 3;
  private static Customer[] allCustomers;
  private static Restaurant restaurant;
  private static int[] starsGivenToday;
  private static int[] moneyFromEachCustomer;
  private static String[] dishesOrderedToday;
  private static boolean exitDay;
  private static int maxNewDishes;
  private static double chance;
  private static int customerIndex;
  private static boolean firstChefAdd = false;
  private static boolean secondChefAdd = false;
  private static boolean thirdChefAdd = false;
  private static boolean fourthChefAdd = false;
  private static boolean fifthChefAdd = false;
  private static double averageStar;
  private static int dishesOrderedIndex;
  private static Chef[] chefOrder;
  private static Chef noChef = new Chef("", "", 0, 0, 0, false);
  private static Dish emptyDish = new Dish ("No dish ordered", "no dish type", 0 ,0);
  static {
    //made an array of all the customers
    allCustomers = new Customer [20];
    allCustomers[0] = new Customer("Leonardo Di Caprio", 18, true, "He", "his");
    allCustomers[1] = new Customer("Tobey Maguire", 21, false, "He", "his");
    allCustomers[2] = new Customer("Muhammed Ali Schwartz", 17, false, "He", "his");
    allCustomers[3] = new Customer("Nick Horton", 14, true, "They", "their");
    allCustomers[4] = new Customer("Isaiah Christ", 17, false, "He", "his");
    allCustomers[5] = new Customer("King Kylie", 35, false, "She", "her");
    allCustomers[6] = new Customer("Santa Claus", 19, false, "He", "his");
    allCustomers[7] = new Customer("Jack Frost", 15, true, "They", "their");
    allCustomers[8] = new Customer("Rebekah Mikaelson", 13, true, "She", "her"); 
    allCustomers[9] = new Customer("Bart Simpson", 15, false, "He", "his");
    allCustomers[10] = new Customer("Lisa Simpson Barnett", 21, false, "She", "her");
    allCustomers[11] = new Customer("Homer Simpson", 24, false, "He", "its");
    allCustomers[12] = new Customer("Marge Simpson", 29, false, "She", "her");
    allCustomers[13] = new Customer("Abe Simpson", 13, false, "He","his");
    allCustomers[14] = new Customer("Justin Bieber", 23, true, "They", "their");
    allCustomers[15] = new Customer("Dianna Ball", 20, false, "She", "her");
    allCustomers[16] = new Customer("Bruno Mars", 32, true, "He", "his");
    allCustomers[17] = new Customer("Mr. Holmer", 14, false, "he", "him");
    allCustomers[18] = new Customer("Donald Duck", 30, true, "He", "his");
    allCustomers[19] = new Customer("Ronald Model", 18, false, "He", "his");
  }
  
  /** 
   * @param args
   */
  public static void main(String[] args) {
    System.out.println("In this game you will learn how to manage a resturaunt, you will learn the ups and downs of running a business in our society " 
                         + "and hopefully give you a new respect for the workers next time you go out to eat. More than 60 percent of restaurants fail in their first year, so should you decide to go into the cullinary industry this game will help you out.");
    slowTypewriter("\nLet's begin!                 \n");
    restaurant = new Restaurant(nameYourRestaurant(),locationOfRestaurant());
    typewriter("The location of your restaurant: " + restaurant.getLocation() + "\n          \n");
    System.out.println("Time to create your menu. You can start by puting 5 dishes on your menu.");
    menu = setMenu();
    System.out.println("Menu is set.\n");
    typewriter("You will now be asked some questions to determine the ambiance of you restaurant and what type of boss you are.");
    slowTypewriter("\n\n\n");
    Quiz.quiz();
		slowTypewriter("\n\n\n");
    System.out.println("You can only start out with one chef.");
    System.out.println("Your executive chef is " + restaurant.getChef1().getName() + "\n\n");
    System.out.println("Congratulations! " + restaurant.getName() + " is now open for business! Try to get your restaurant rating up to 5 stars.\n");
    while (cont) {
      System.out.println("Day " + day + "\n");
      startOfDay();
      restaurant.resetDailyVariables();
      eachDay();
      slowTypewriter("\n\n\n\n\n");
      if (!firstChefAdd && restaurant.getRating() >= 1) {
            System.out.println("Yay! You get to add a chef.");
            Scanner c = new Scanner(System.in);
            Chef op1_1 = new Chef("Dave Winter", "Sous Chef", 18, 3, 2, true);
            Chef op2_1 = new Chef("Fiona Gallagher", "Sous Chef", 16, 5, 2, true);
            System.out.println("{ " + op1_1 + " }    { " + op2_1 + " }\nWhich of these chefs would you like to employ? (Write the name)");
            String pic1 = c.nextLine();  
            if (op1_1.getName().equals(pic1)) {
              restaurant.setChef2(op1_1);
            } else if (op2_1.getName().equals(pic1)) {
             restaurant.setChef2(op2_1);
            } else {
              System.out.println("You did not hire a chef.");
            }
            firstChefAdd = true;
            for(Customer x: allCustomers) {
              x.setCash((int)(x.getCash()*1.5));
            }
            System.out.println("\n\n\n\n\n");
         }
      if (restaurant.getRatingDouble() > 2 && divisible(day, 2)) {
         if (!secondChefAdd) { 
          System.out.println("Yay! You can to add to your workforce again.");
          Scanner c2 = new Scanner(System.in);
          Chef op1_2 = new Chef("Will Schuester", "Line Cook", 18, 2, 3, true);
          Chef op2_2 = new Chef("John McDonald", "Line Cook", 17, 2, 3, true);
          System.out.println("{ " + op1_2 + " }    { " + op2_2 + " }\nChoose a line cook?");
          String pic2 = c2.nextLine();
          if (op1_2.getName().equals(pic2)) {
              restaurant.setChef3(op1_2);
            } else if (op2_2.getName().equals(pic2)) {
              restaurant.setChef3(op2_2);
            } else {
              System.out.println("You did not hire a chef.");
            }
            secondChefAdd = true;
            for(Customer x: allCustomers) {
              x.setCash((int)(x.getCash()*1.5));
            }
            System.out.println("\n\n\n\n\n");
         }
      }
         if (!thirdChefAdd && restaurant.getRatingDouble() > 3 && day > 6) {
           System.out.println("Yay! You can make an unemployed citizen into an employed citized.");
           Scanner c3 = new Scanner(System.in);
           Chef op1_3 = new Chef("Julien Ramsey", "Line Cook", 20, 6, 4, true);  
           Chef op2_3 = new Chef ("Lip Gallagher", "Line Cook",12, 2, 4, true);
           System.out.println("{ " + op1_3 + " }    { " + op2_3 + " }\nWho do you want to make employed?");
           String pic3 = c3.nextLine();
           if (op1_3.getName().equals(pic3)) {
              restaurant.setChef4(op1_3);
            } else if (op2_3.getName().equals(pic3)) {
              restaurant.setChef4(op2_3);
            } else {
              System.out.println("You did not employ a chef.");
            }
            thirdChefAdd = true;
            for(Customer x: allCustomers) {
              x.setCash((int)(x.getCash()*1.5));
            }
            System.out.println("\n\n\n\n\n");
         }
         if (!fourthChefAdd && restaurant.getRatingDouble() > 4.2 && day > 9) {
            System.out.println("Yay! You can now add your last chef.");
            Scanner c4 = new Scanner(System.in);
            Chef op1_4 = new Chef("Carl Gallagher", "Line Cook", 14, 3, 5, true);
            Chef op2_4 = new Chef("Martin Buren", "Line Cook", 15, 4, 5, true);
            System.out.println("{ " + op1_4 + " }    { " + op2_4 + " }\nNeed some more help?");
            String pic4 = c4.nextLine();
            if (op1_4.getName().equals(pic4)) {
              restaurant.setChef5(op1_4);
            } else if (op2_4.getName().equals(pic4)) {
              restaurant.setChef5(op2_4);
            } else {
              System.out.println("You did not hire a chef.");
            }
            fourthChefAdd = true;
            for(Customer x: allCustomers) {
              x.setCash((int)(x.getCash()*1.5));
            }
            System.out.println("\n\n\n\n\n");
         }
         if (!fifthChefAdd && restaurant.getCategory() > 1) {
            System.out.println("Yay! You can now add another chef.");
            Scanner c5 = new Scanner(System.in);
            Chef op1_5 = new Chef("Debbie Gallagher", "Line Cook", 19, 5, 6, true);
            Chef op2_5 = new Chef("Idaho Rain", "Line Cook", 15, 4, 6, true);
            System.out.println("{ " + op1_5 + " }    { " + op2_5 + " }\nWho is going to be added to the team?");
            String pic5 = c5.nextLine();
            if (op1_5.getName().equals(pic5)) {
              restaurant.setChef6(op1_5);
            } else if (op2_5.getName().equals(pic5)) {
              restaurant.setChef6(op2_5);
            } else {
              System.out.println("You did not hire a chef.");
            }
            fifthChefAdd = true;
            for(Customer x: allCustomers) {
              x.setCash((int)(x.getCash()*1.5));
            }
            System.out.println("\n\n\n\n\n");
         }
        
      restaurant.anyChefsQuit();
			restaurant.doneWithQuits();
			Chef cb1 = new Chef("Vincent Chen", "Line Cook", 13, 2, 1, true);
	    Chef cb2 = new Chef("Bryant Zheng", "Line Cook", 10, 2, 1, true);
			Chef cb3 = new Chef("Stanley Chopra", "Line Cook", 11, 3, 1, true);
			Chef cb4 = new Chef("Halil Akca", "Line Cook", 13, 1, 1, true);
			Chef cb5 = new Chef("Arina Vardanyan", "Line Cook", 11, 3, 1, true);
			Chef cb6 = new Chef("David Newman", "Line Cook", 20, 2, 1, true);
			Chef cb7 = new Chef("Micheal Romashov", "Line Cook", 7, 1, 1, true);
			Chef cb8 = new Chef("Elijah Shohat", "Line Cook", 14, 4, 1, true);
			Chef cb9 = new Chef("Guijun Dhang", "Line Cook", 13, 3, 1, true);
			Chef cb10 = new Chef("Jake Paul", "Line Cook", 18, 1, 1, true);
			Chef cb11 = new Chef("Logan Paul", "Line Cook", 17, 2, 1, true);
			Chef cb12 = new Chef("Harriet Tubman", "Line Cook", 24, 6, 1, true);
	    Chef[] chefBackup = {cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8, cb8, cb9, cb10, cb11, cb12};
			if (restaurant.getChefQuit()) {
				Scanner replaceInput = new Scanner(System.in);
				System.out.println("You must replace this chef as soon as possibly, luckily there are some options already available:");
				if (restaurant.getRatingDouble() > 3) {
					for (int i = 1; i < chefBackup.length+1; i++) {
						System.out.println(" (" + i + ") " + chefBackup[i-1]);
					}
				} else {
					for (int i = 1; i < chefBackup.length-5; i++) {
						System.out.println(" (" + i + ") " + chefBackup[i-1]);
					}
				}
				int replace = replaceInput.nextInt();
				for (int i = 1; i < chefBackup.length+1; i++) {
						if (replace == i) {
							restaurant.replaceChef(chefBackup[i-1]);
							chefBackup = remove(chefBackup, i-1);
							return;
						}
					} 
			}
      if (day % 7 == 0) {
        restaurant.chefHourSatisfaction();
				if (Quiz.getResponsibility() > 3) {
					restaurant.addDebt((int)(restaurant.getChefsOwed() * 1.1));
				} else if (Quiz.getResponsibility() < 0) {
					restaurant.addDebt((int)(restaurant.getChefsOwed() * 1.5));
				}	else {
        	restaurant.addDebt((int)(restaurant.getChefsOwed() * 1.3));
				}
        System.out.println("Today is payday. All together, you must pay $" + restaurant.getDebt() + ". $" + restaurant.getChefsOwed() + "is to pay your chefs.");
        System.out.println("You have $" + restaurant.getMoney() + ".");
        restaurant.payDebt();
        typewriter("Running transactions");
        try {
          Thread.sleep(1000);
        } catch (Exception e) {
           Thread.currentThread().interrupt();
         }
        System.out.print(". ");
        try {
          Thread.sleep(1000);
        } catch (Exception e) {
           Thread.currentThread().interrupt();
         }
        System.out.print(".");
        try {
          Thread.sleep(1000);
        } catch (Exception e) {
           Thread.currentThread().interrupt();
         }
        System.out.println("\n\n\n");
        if (restaurant.getDebt() > 0) {
            System.out.println("You are still have a debt to pay of $" + restaurant.getDebt() + ".");
            Scanner preI = new Scanner(System.in);
            System.out.println("There are precauctions you can take to not go further into debt, like lowering the number of chefs working, decreasing the salary of your chefs, or decreasing the hours the restaurant is open.");
        }
        restaurant.resetWeekVariables();
      }
      restaurant.training();
			for(Customer x: allCustomers) {
					x.setNumberOrdered();
      }
			if (day%4 == 0) {
				restaurant.halfwayThruWeek();
			}
      day++;  
      if (day%20 == 0) {
        Scanner e = new Scanner(System.in);
        System.out.println("would you like to continue?");
        String end = e.nextLine();
        if (end.equals("no")) {
          cont = false;
        }
      }
      if (restaurant.getMoney() - restaurant.getDebt() < -1000 && day%7 == 0) {
        cont = false;
        System.out.println("Your restaurant is falling too far into debt. " + restaurant.getName() + " is being shut down.");
      }
 
    }

  }
  
  
  /** 
   * @return String
   */
  public static String nameYourRestaurant() {
    Scanner name = new Scanner(System.in);
    System.out.println("What do you want to name your restaurant?");
    return name.nextLine();
  }
 
  
  /** 
   * @return Location
   */
  public static Location locationOfRestaurant() {
    boolean us = false;
    Scanner uInput = new Scanner(System.in);
    System.out.println("In what country would you like to locate your restaurant?");
    String u = uInput.nextLine();
    String s = null;
    if (u.equals("United States") || u.equals("USA") || u.equals("US") || u.equals("United States of America") || u.equals("America")) {
      us = true;
      Scanner sInput = new Scanner(System.in);
      System.out.println("What state in the United States do you want to base your restaurant?");
      s = sInput.nextLine();
      while(!ifContains(States.getStates(), s)){
        System.out.println("Please enter a valid state, or if you are trying to open in a territory, write Minor Outlying Territory");
        s = sInput.nextLine();
      }
    }
    Scanner cInput = new Scanner(System.in);
    System.out.println("What city do you want the restaurant in?");
    String c = cInput.nextLine();
    if (us) {
      return new Location(c, s, u);
    }
    return new Location(c, u);
  } 
    
  
  /** 
   * @return Dish
   */
  private static Dish createDish() {
     Scanner dishI = new Scanner(System.in);
     System.out.println("Dish: ");
     String info = dishI.nextLine();
     String name = info.substring(0,info.indexOf(","));
     int i = info.indexOf(",") + 1;
     int index2 = 0;
     while(i < info.length()-1) {
       if (info.substring(i,i+1).equals(",")) {
         index2 = i;
       }
       i++;
     }
     String type = info.substring(info.indexOf(",") + 2, index2);
     String c = info.substring(index2+2);
     int cost = Integer.parseInt(c);
     Scanner diffI = new Scanner(System.in);
     System.out.print("On a scale on 1 to 10, how difficult do you think making this dish is?");
     int d = diffI.nextInt();
     return new Dish(name,type,cost,d); 
    }
  
  
  /** 
   * @return Dish[]
   */
  public static Dish[] setMenu() {
    System.out.println("Please enter the dish in the format: dish name, dish type, cost. \nex: \"Churros, dessert, 13\"");
    Dish[] dishes = new Dish [5];
    for (int i = 0; i < dishes.length; i++)
    {
      dishes[i] = createDish();
    }
    return dishes;
  }
    
  public static void startOfDay() {
    if (restaurant.getCategory() < 1 && restaurant.getRating() < 3){
      typewriter("Your restaurant is not succeeding as a " + restaurant.getStringCategory());
      restaurant.categoryDecrease();
      typewriter("It is being bumped back down to a " + restaurant.getStringCategory() + ".");
    }
    if (day%7 == 0 && restaurant.getRating() > 3) {
      restaurant.categoryIncrease();
      System.out.println("Your restaurant is now classified as a " + restaurant.getStringCategory());
    }
    maxNewDishes = 0;
    if (restaurant.getCategory() == 1) {
      maxNewDishes = 1;
    }
    if (restaurant.getCategory() == 2) {
      maxNewDishes = 2;
    }
     if (restaurant.getCategory() == 2) {
      maxNewDishes = 3;
    }
     if (restaurant.getRating() == 5) {
      maxNewDishes++;
    }
    if (restaurant.getStarIncrease() && restaurant.getRatingDouble() >= 3) {
      typewriter(restaurant.getName() + " is getting great reviews and you can now add to your menu!\nYour resturant is a " 
                   + restaurant.getStringCategory() + ", which means you can add " + maxNewDishes + ". ");
      Scanner b = new Scanner(System.in);
      System.out.println("How many dishes would you like to add to the menu?");
      int newDishes = b.nextInt();
      if (!(newDishes <= maxNewDishes)) {
        Scanner b2 = new Scanner(System.in);
        System.out.println("Nope, try that again");
        newDishes = b2.nextInt();      
        if (!(newDishes <= maxNewDishes)) {
        System.out.println("Lost your chance to add more dishes.");
      } 
     }
     Dish[] newMenu = new Dish[menu.length + newDishes];
     for (int i = 0; i < menu.length; i++) {
       newMenu[i] = menu[i];
     }
     for (int n = menu.length; n < newMenu.length; n++) {
       newMenu[n] = createDish();
     }
    }
    if (day == 4) {
      System.out.println("Increase your prices as your restaurant becomes more successful because you need to be able to pay the chefs. Your customers are becoming loyal and they are willing to spend more money. If you do not increase revenue and fail to  make profit, the restaurant will have to close");
    }
		if (day%4 == 0) {
			for (Customer c: allCustomers) {
				if (c.getChanceOfGoing() >= 60) {
					c.setMoreMoney();
				}		
			}
		}
    Scanner a = new Scanner(System.in);
    System.out.println("Would you like to (1) edit menu or (2) view resturant report before you open? To just continue write 3.");
    int action = a.nextInt();
    if (action == 1) {
      editMenu();
      System.out.println("\n\n\n\n");
    }
    if (action == 2) {
      restaurantReport();
      System.out.println("\n\n\n\n");
    }
   }
  
    
   private static Chef workingChef1; //each day these variables change
   private static Chef workingChef2;
   private static Chef workingChef3;
   private static int numOfWorkingChefs;
   private static int chef1Index = 0;
   private static int chef2Index = 0;
   private static int chef3Index = 0;
   
   public static void eachDay() {
    restaurant.setHoursOpen();
    Chef[] chefs = new Chef[Chef.getNumberOfChefs()];
     for (int i = 0; i < chefs.length; i++) {
       if (i == 0) {
       chefs[i] = restaurant.getChef1();
       }
       if (i == 1) {
       chefs[i] = restaurant.getChef2();
       }
       if (i == 2) {
       chefs[i] = restaurant.getChef3();
       }
       if (i == 3) {
       chefs[i] = restaurant.getChef4();

       }
       if (i == 4) {
       chefs[i] = restaurant.getChef5();
       }
       if (i == 5) {
       chefs[i] = restaurant.getChef6();
       }
     } 
     if (chefs.length >= 3) {
       numOfWorkingChefs = 4;
       while (numOfWorkingChefs > 3) {
         Scanner numOfChefsInput = new Scanner(System.in);
         System.out.println("How many chefs would you like to put on today's shift?");
         numOfWorkingChefs = numOfChefsInput.nextInt();
         if (numOfWorkingChefs > 3) {
            System.out.println("You can not put that many. Try again.");
         }
      }
      if (numOfWorkingChefs == 1) {
         String chefsAvailable = "Which chefs?\n (1) " + restaurant.getChef1() + "\n (2) " + restaurant.getChef2() + "\n (3) " + restaurant.getChef3();
          if (chefs.length >= 4) {
           chefsAvailable = chefsAvailable + "\n (4) " + restaurant.getChef4();
         }
         if (chefs.length >= 5) {
           chefsAvailable = chefsAvailable + "\n (5) " + restaurant.getChef5();
         }
         if (chefs.length >= 5) {
           chefsAvailable = chefsAvailable + "\n (6) " + restaurant.getChef6();
         }
         Scanner chefToWork1nput = new Scanner(System.in);
         System.out.println(chefsAvailable);
         chef1Index = chefToWork1nput.nextInt();
         for (Chef x: chefs) {
           if (x.getEmployeeNumber() == chef1Index ) {
             x.working();
             workingChef1 = x;
						 x.lowerSatisfaction();
           }
         }
         workingChef2 = null;
         workingChef3 = null;
      } else if (numOfWorkingChefs == 2) {
         String chefsAvailable = "Which chef?\n (1) " + restaurant.getChef1() + "\n (2) " + restaurant.getChef2() + "\n (3) " + restaurant.getChef3();
          if (chefs.length >= 4) {
           chefsAvailable = chefsAvailable + "\n (4) " + restaurant.getChef2();
         }
         if (chefs.length >= 5) {
           chefsAvailable = chefsAvailable + "\n (5) " + restaurant.getChef5();
         }
         if (chefs.length >= 5) {
           chefsAvailable = chefsAvailable + "\n (6) " + restaurant.getChef6();
         }
         Scanner chefToWork1nput = new Scanner(System.in);
         Scanner chefToWork2nput = new Scanner(System.in);
         System.out.println(chefsAvailable);
         chef1Index = chefToWork1nput.nextInt();
         chef2Index = chefToWork2nput.nextInt();
         for (Chef x: chefs) {
           if (x.getEmployeeNumber() == chef1Index ) {
             x.working();
             workingChef1 = x;
           }
           if (x.getEmployeeNumber() == chef2Index ) {
             x.working();
             workingChef2 = x;
           }
         }
         workingChef3 = null;
      } else {
         String chefsAvailable = "Which chef?\n (1) " + restaurant.getChef1() + "\n (2) " + restaurant.getChef2() + "\n (3) " + restaurant.getChef3();
          if (chefs.length >= 4) {
           chefsAvailable = chefsAvailable + "\n (4) " + restaurant.getChef2();
         }
         if (chefs.length >= 5) {
           chefsAvailable = chefsAvailable + "\n (5) " + restaurant.getChef5();
         }
         if (chefs.length >= 5) {
           chefsAvailable = chefsAvailable + "\n (6) " + restaurant.getChef6();
         }
         Scanner chefToWork1nput = new Scanner(System.in);
         Scanner chefToWork2nput = new Scanner(System.in);
         Scanner chefToWork3nput = new Scanner(System.in);
         System.out.println(chefsAvailable);
         chef1Index = chefToWork1nput.nextInt();
         chef2Index = chefToWork2nput.nextInt();
         chef3Index = chefToWork3nput.nextInt();
         for (Chef x: chefs) {
           if (x.getEmployeeNumber() == chef1Index ) {
             x.working();
             workingChef1 = x;
						 x.setSatisfaction(2);
           }
           if (x.getEmployeeNumber() == chef2Index ) {
             x.working();
             workingChef2 = x;
						 x.setSatisfaction(2);
           }
           if (x.getEmployeeNumber() == chef3Index ) {
             x.working();
             workingChef3 = x;
						 x.setSatisfaction(2);
           }
        }
      }
     } else if (chefs.length == 2) {
       numOfWorkingChefs = 2;
       workingChef1 = restaurant.getChef1();
       workingChef2 = restaurant.getChef2();
       workingChef3 = null;
     } else {
       numOfWorkingChefs = 1;
       workingChef1 = restaurant.getChef1();
			 restaurant.lowerSatisfaction(workingChef1);
       workingChef2 = null;
       workingChef3 = null;
     }
     if ( day == 5 || day == 7 || day == 11 || day == 13 || day == 21 || day == 28) {
       numOfCustomersInDay++;
     }
     workingChef1.resetDailyServes();
     if (workingChef2 != null) {
       workingChef2.resetDailyServes();
     }
     if (workingChef3 != null) {
       workingChef3.resetDailyServes();
     }
     starsGivenToday = new int[numOfCustomersInDay];
     moneyFromEachCustomer = new int[numOfCustomersInDay];
     dishesOrderedToday = new String[numOfCustomersInDay];
     chefOrder = new Chef[numOfCustomersInDay];
		 dishesOrderedIndex = 0;
     for (int c = 0; c < numOfCustomersInDay; c++) {
       dishesOrderedIndex++;
       eachCustomer();
       starsGivenToday[c] = restaurant.getCurrentCustomer().getStarRating();
       moneyFromEachCustomer[c] = restaurant.getCurrentCustomer().getMoneySpent();
       dishesOrderedToday[c] = restaurant.getCurrentCustomer().getDishOrdered().getFoodName();
       chefOrder[c] = restaurant.getCurrentCustomer().getCook();
     }
     for (Chef x: chefs) {
       if (x.getOnTheJob()) {
         x.setWeeklyHours(restaurant.getHoursOpen());
         x.setAmountOwed(x.getWage() * restaurant.getHoursOpen());
				 restaurant.setChefsOwed(x.getAmountOwed());
       }
       x.notWorking();
		 }
     double averageStar = mean(starsGivenToday);
     if (numOfWorkingChefs == 1) {
       restaurant.setStaffReflection("The average stars of "+ workingChef1.getName() + " was " + averageStar + ".");
     }
     if (numOfWorkingChefs == 2) {
       for (int t = 0; t < chefOrder.length; t++) {
         if (chefOrder[t].getName().equals(workingChef1.getName())) {
           workingChef1.setSumDailyStars(starsGivenToday[t]);
           workingChef1.setDailyDishesMade();
         }
       }
       for (int t = 0; t < chefOrder.length; t++) {
         if (chefOrder[t].getName().equals(workingChef2.getName())) {
           workingChef2.setSumDailyStars(starsGivenToday[t]);
           workingChef2.setDailyDishesMade();
         }
       }
       restaurant.setStaffReflection("The average stars of "+ workingChef1.getName() + " was " + workingChef1.getSumDailyStars()/workingChef1.getDailyDishesMade() + ".\nThe average stars of "+ workingChef2.getName() + " was " + workingChef2.getSumDailyStars()/workingChef2.getDailyDishesMade()  + ".\n");
     }
     if (numOfWorkingChefs == 3) {
       for (int t = 0; t < chefOrder.length; t++) {
         if (chefOrder[t].getName().equals(workingChef1.getName())) {
           workingChef1.setSumDailyStars(starsGivenToday[t]);
           workingChef1.setDailyDishesMade();
         }
       }
       for (int t = 0; t < chefOrder.length; t++) {
         if (chefOrder[t].getName().equals(workingChef2.getName())) {
           workingChef2.setSumDailyStars(starsGivenToday[t]);
           workingChef2.setDailyDishesMade();
         }
       }
       for (int t = 0; t < chefOrder.length; t++) {
         if (chefOrder[t].getName().equals(workingChef3.getName())) {
           workingChef3.setSumDailyStars(starsGivenToday[t]);
           workingChef3.setDailyDishesMade();
         }
       }
       restaurant.setStaffReflection("The average stars of "+ workingChef1.getName() + " was " + workingChef1.getSumDailyStars()/workingChef1.getDailyDishesMade() + ".\nThe average stars of "+ workingChef2.getName() + " was " + workingChef2.getSumDailyStars()/workingChef2.getDailyDishesMade() + ".\nThe average stars of "+ workingChef3.getName() + " was " + workingChef3.getSumDailyStars()/workingChef3.getDailyDishesMade() + ".\n");
     }
     System.out.println("The average stars you were given today is " + averageStar + ".");
     if (averageStar > restaurant.getRating()) {
      double previous = restaurant.getRating();
      double i = (averageStar - restaurant.getRating()) / 5;
      restaurant.increaseRatingDouble(i);
      if ( ((int)(restaurant.getRatingDouble()*10/10) - (int)(previous*10/10)) >= 1 ) {
        restaurant.increaseRating();
      }
     }
     if (averageStar < restaurant.getRating()) {
      double previous = restaurant.getRating();
      double d = (restaurant.getRating() - averageStar) / 5;
      restaurant.decreaseRatingDouble(d);
      if (((int)(previous*10/10) - (int)(restaurant.getRatingDouble()*10/10)) >= 1 ) {
        restaurant.decreaseRating();
      }
     }
   }
   
   public static void eachCustomer() {
     exitDay = false;
     Chef chefOnOrder = restaurant.getChef1();
     customerIndex = (int)(Math.random() * allCustomers.length); //figure out which customer is there
     chance = Math.random() * 9 + 1;
     allCustomers[customerIndex].resetVisitsToday();
     if (chance >= allCustomers[customerIndex].getChanceOfGoing()/10.0) {
        try {
           Thread.sleep(2000);
       } catch (Exception e) {
           Thread.currentThread().interrupt();
      } 
      System.out.print(allCustomers[customerIndex].getName() + " walked in but was not intersted in ordering anything.");
      System.out.println("\n\n\n\n\n");
       customerIndex = (int)(Math.random() * allCustomers.length);
       chance = Math.random() * 9 + 1;
       if (chance >= allCustomers[customerIndex].getChanceOfGoing()/10.0) {
         try {
           Thread.sleep(2000);
         } catch (Exception e) {
            Thread.currentThread().interrupt();
         } 
          allCustomers[customerIndex].setStarRating(0);
          allCustomers[customerIndex].setMoneySpent(0);
          allCustomers[customerIndex].setDishOrdered(emptyDish);
          allCustomers[customerIndex].setCook(noChef);
          restaurant.setCurrentCustomer(allCustomers[customerIndex]);
					allCustomers[customerIndex].setPastRating(0);
          System.out.println("\n\n\n\n\n");
       } 
     }
     allCustomers[customerIndex].resetVisitsToday();
     allCustomers[customerIndex].visit();
     if (allCustomers[customerIndex].getVisits() == 1) {
       slowTypewriter("\n" + allCustomers[customerIndex].getName() + " walks in.\n");
       slowTypewriter("This is " + allCustomers[customerIndex].getPosessivePronoun() + " first time here!\n");
     } else if (allCustomers[customerIndex].getVisitsToday() > 1) {
          if (allCustomers[customerIndex].getStarRating() <= 4) {
            eachCustomer();
            return;
         }
         slowTypewriter("\n" + allCustomers[customerIndex].getName() + " walks in.\n");
         slowTypewriter(allCustomers[customerIndex].getPronoun() + " has already been here today!\n");
     } else {
       slowTypewriter("\n" + allCustomers[customerIndex].getName() + " walks in.\n");
     }
     try {
         Thread.sleep(1500);
     } catch (Exception e) {
         Thread.currentThread().interrupt();
     }
     int dishIndex = (int)(Math.random() * menu.length);
     int timesChanged = 0; // statement execution count
     while (menu[dishIndex].getCost() > allCustomers[customerIndex].getCash() && timesChanged <= 5) {
        dishIndex = (int)(Math.random() * menu.length);
        timesChanged++;
        if (timesChanged > 5) {
          System.out.println(allCustomers[customerIndex].getPronoun() + " thinks the dishes on the menu are to expensive. " + allCustomers[customerIndex].getPronoun() 
                                + " leaves a review of " + allCustomers[customerIndex].getStarRating() + " stars, but " + allCustomers[customerIndex].getPronoun().toLowerCase()
                                + " is open to returning when he has more money and definitely if you lower the prices.");
                                allCustomers[customerIndex].setMoneySpent(0); 
                                allCustomers[customerIndex].setStarRating(0);
                                allCustomers[customerIndex].setDishOrdered(emptyDish);
                                allCustomers[customerIndex].setCook(noChef);
                                restaurant.setCurrentCustomer(allCustomers[customerIndex]);
																allCustomers[customerIndex].setPastRating(0);
                                exitDay = true;
        }
     }
     if (exitDay) {
       System.out.println("\n\n\n\n\n");
       return;
     }
     if (allCustomers[customerIndex].getNumberOrdered() > 1) {
       int dishIndex2 = (int)(Math.random() * menu.length);
       int dishIndex3 = (int)(Math.random() * menu.length);
       dishesOrderedToday = new String[dishesOrderedToday.length + allCustomers[customerIndex].getNumberOrdered()];
       String dishes;
       dishes =  menu[dishIndex].getFoodName().toLowerCase();
       if (allCustomers[customerIndex].getNumberOrdered() >= 3) {
         while (dishIndex == dishIndex2) {
           dishIndex2 = (int)(Math.random() * menu.length);
         }
         while (dishIndex == dishIndex3) {
           dishIndex3 = (int)(Math.random() * menu.length);
         }
         while (dishIndex == dishIndex3) {
           dishIndex3 = (int)(Math.random() * menu.length);
         }
         dishes = dishes + ", " + menu[dishIndex2].getFoodName().toLowerCase() + ", and " + menu[dishIndex3].getFoodName().toLowerCase();
         dishesOrderedIndex++;
         dishesOrderedToday[dishesOrderedIndex] = menu[dishIndex2].getFoodName();
         dishesOrderedIndex++;
         dishesOrderedToday[dishesOrderedIndex] = menu[dishIndex3].getFoodName();
       } else if (allCustomers[customerIndex].getNumberOrdered() >= 2) {
         while (dishIndex == dishIndex2) {
           dishIndex2 = (int)(Math.random() * menu.length);
         }
         dishes = dishes + " and " + menu[dishIndex2].getFoodName().toLowerCase();
         dishesOrderedIndex++;
       }
       System.out.println(allCustomers[customerIndex].getPronoun() + " has ordered " + dishes + ".");
      if (numOfWorkingChefs == 3) {
        Scanner chefInput = new Scanner(System.in);
        System.out.println("Which chef would you like to hand this order to?" + " Your chefs that are working are: " + workingChef1.getName() + ", " +  workingChef2.getName() + ", " + workingChef3.getName() + ".");
        String chef = chefInput.nextLine();
         if (workingChef1.getName().contains(chef)) {
           chefOnOrder = workingChef1;
        }
         if (workingChef2.getName().contains(chef)) {
           chefOnOrder = workingChef2;
         }
        if (workingChef3.getName().contains(chef)) {
          chefOnOrder = workingChef3;
         }
       } else if (numOfWorkingChefs == 2) {
        Scanner chefInput = new Scanner(System.in);
        System.out.println("Which chef would you like to hand this order to?" + " Your chefs that are working are " + workingChef1.getName() + " and " + workingChef2.getName() + ".");
         String chef = chefInput.nextLine();
         if (workingChef1.getName().contains(chef)) {
         chefOnOrder = workingChef1;
        }
        if (workingChef2.getName().contains(chef)) {
          chefOnOrder = workingChef2;
        }
      } else {
        chefOnOrder = restaurant.getChef1();
       }
       chefOnOrder.resetDailyServes();
       restaurant.chefCooking(chefOnOrder);
       typewriter("Chef " + chefOnOrder.getName() + " is currently cooking the " +  dishes + " for "  + allCustomers[customerIndex].getName() + ". " );
      try {
          Thread.sleep(1000);
      } catch (Exception e) {
          Thread.currentThread().interrupt();
       }
       System.out.print(". ");
      try {
          Thread.sleep(1000);
      } catch (Exception e) {
          Thread.currentThread().interrupt();
       }
      System.out.print(".");
      try {
          Thread.sleep(1000);
      } catch (Exception e) {
          Thread.currentThread().interrupt();
      }
       System.out.println("\n\nOrder up!!!");
      menu[dishIndex].setQuality(chefOnOrder);
      if (allCustomers[customerIndex].getNumberOrdered() >= 3) {
          menu[dishIndex2].setQuality(chefOnOrder);
          menu[dishIndex3].setQuality(chefOnOrder);
          System.out.println(allCustomers[customerIndex].threeDishReaction(menu[dishIndex], menu[dishIndex2], menu[dishIndex3]));
         restaurant.addEarnings(menu[dishIndex].getCost() + menu[dishIndex2].getCost() + menu[dishIndex3].getCost());
         allCustomers[customerIndex].setMoneySpent(menu[dishIndex].getCost() +  menu[dishIndex2].getCost() + menu[dishIndex3].getCost());
      } else if (allCustomers[customerIndex].getNumberOrdered() >= 2) {
          menu[dishIndex2].setQuality(chefOnOrder);
          System.out.println(allCustomers[customerIndex].twoDishReaction(menu[dishIndex], menu[dishIndex2]));
          restaurant.addEarnings(menu[dishIndex].getCost() + menu[dishIndex2].getCost());
           allCustomers[customerIndex].setMoneySpent(menu[dishIndex].getCost() + menu[dishIndex2].getCost());
      }
      slowTypewriter(restaurant.getName() + " has recieved "  + allCustomers[customerIndex].getStarRating() + " stars from " + allCustomers[customerIndex].getName() + ".\n") ;
      try {
         Thread.sleep(3000);
      } catch (Exception e) {
          Thread.currentThread().interrupt();
       }
         allCustomers[customerIndex].setDishOrdered(menu[dishIndex]);
         allCustomers[customerIndex].setCook(chefOnOrder);
         restaurant.setCurrentCustomer(allCustomers[customerIndex]);
				 allCustomers[customerIndex].setPastRating(allCustomers[customerIndex].getStarRating());
        System.out.println("\n\n\n\n\n");
     } else {
      System.out.println(allCustomers[customerIndex].getPronoun() + " has ordered " + menu[dishIndex].getFoodName().toLowerCase() + ".");
      if (numOfWorkingChefs == 3) {
        Scanner chefInput = new Scanner(System.in);
        System.out.println("Which chef would you like to hand this order to?" + " Your chefs that are working are: " + workingChef1.getName() + ", " +  workingChef2.getName() + ", " + workingChef3.getName() + ".");
        String chef = chefInput.nextLine();
         if (workingChef1.getName().contains(chef)) {
           chefOnOrder = workingChef1;
        }
         if (workingChef2.getName().contains(chef)) {
           chefOnOrder = workingChef2;
         }
        if (workingChef3.getName().contains(chef)) {
          chefOnOrder = workingChef3;
         }
       } else if (numOfWorkingChefs == 2) {
        Scanner chefInput = new Scanner(System.in);
        System.out.println("Which chef would you like to hand this order to?" + " Your chefs that are working are " + workingChef1.getName() + " and " + workingChef2.getName() + ".");
         String chef = chefInput.nextLine();
         if (workingChef1.getName().contains(chef)) {
         chefOnOrder = workingChef1;
        }
        if (workingChef2.getName().contains(chef)) {
          chefOnOrder = workingChef2;
        }
      } else {
        chefOnOrder = restaurant.getChef1();
       }
       chefOnOrder.resetDailyServes();
       restaurant.chefCooking(chefOnOrder);
       typewriter("Chef " + chefOnOrder.getName() + " is currently cooking the " +  menu[dishIndex].getFoodName().toLowerCase() + " for "  + allCustomers[customerIndex].getName() + ". " );
      try {
          Thread.sleep(1000);
      } catch (Exception e) {
          Thread.currentThread().interrupt();
       }
       System.out.print(". ");
      try {
          Thread.sleep(1000);
      } catch (Exception e) {
          Thread.currentThread().interrupt();
       }
      System.out.print(".");
      try {
          Thread.sleep(1000);
      } catch (Exception e) {
          Thread.currentThread().interrupt();
      }
       System.out.println("\n\nOrder up!!!");
      menu[dishIndex].setQuality(chefOnOrder);
      System.out.println(allCustomers[customerIndex].reaction(menu[dishIndex]));
      slowTypewriter(restaurant.getName() + " has recieved "  + allCustomers[customerIndex].getStarRating() + " stars from " + allCustomers[customerIndex].getName() + ".\n") ;
      try {
         Thread.sleep(3000);
      } catch (Exception e) {
          Thread.currentThread().interrupt();
       }
      restaurant.addEarnings(menu[dishIndex].getCost());
      allCustomers[customerIndex].setMoneySpent(menu[dishIndex].getCost());
      allCustomers[customerIndex].setDishOrdered(menu[dishIndex]);
      allCustomers[customerIndex].setCook(chefOnOrder);
			allCustomers[customerIndex].setPastRating(allCustomers[customerIndex].getStarRating());
      restaurant.setCurrentCustomer(allCustomers[customerIndex]);
      System.out.println("\n\n\n\n\n");
    }
   }
  
    public static void editMenu() {
      for (Dish x: menu) {
        System.out.println(x);
      }
      System.out.println("You can change one dish on your menu and the prices of any dish.");
      boolean dishChange = false;  
      boolean notDoneWithEdits = true;
      while (notDoneWithEdits) {
        Scanner input = new Scanner(System.in);
        System.out.println("Write the name of the dish you want to change.");
        String answer = input.nextLine();
        Dish menuItemEdit = menu[0];
        int itemEditIndex = 0;
        for (int i = 0; i < menu.length; i++) {
          if (menu[i].getFoodName().contains(answer) || menu[i].getFoodName().toLowerCase().contains(answer)) {
            menuItemEdit = menu[i];
            itemEditIndex = i;
          }
        }
        Scanner k = new Scanner(System.in);
        System.out.println("Would you like to (1) change this dish or (2) edit the price?");
        int edit = k.nextInt();
        if (edit == 1) {
          if (dishChange) {
            System.out.println("You have already changed an item on the menu today. Wait a few days to change the menu even more.");
          } else {
            dishChange = true;
            menu[itemEditIndex] = createDish();
          }
        }
        if (edit == 2) {
          Scanner priceAsk = new Scanner(System.in);
          System.out.println("What would you like to change the price of " + menuItemEdit.getFoodName() + " to?");
          int newPrice = priceAsk.nextInt();
          menuItemEdit.changePrice(newPrice);
          typewriter("The new price of " + menuItemEdit.getFoodName() + " is $" + menuItemEdit.getCost() + ".\n"); 
        }
        Scanner r = new Scanner(System.in);
        System.out.println("Would you like to change another menu item?");
        String rString = r.nextLine();
        if(rString.equals("no")) {
          notDoneWithEdits = false;
        }
      }
      for (Dish x: menu) {
        System.out.println(x);
      }
    }
    
    public static void restaurantReport(){
      boolean notDoneWithEdits2 = true;
      while(notDoneWithEdits2) {
      Scanner p = new Scanner(System.in);
      typewriter("\nThere are two options availible. Please pick one. ");
      typewriter("\n(1) View staff report (2) View financial report");
      int view = p.nextInt();
      if (view == 1) {
       System.out.println("These are the current employees");
       if(Chef.getNumberOfChefs() == 1){
          System.out.println(restaurant.getChef1().getName() + ", Skill: " + (int)restaurant.getChef1().getSkill());
       } else if(Chef.getNumberOfChefs() == 2 ){
         System.out.println(restaurant.getChef1().getName() +  ", Skill: " + (int)restaurant.getChef1().getSkill() + ", " + restaurant.getChef2().getName() + ", Skill: " + (int)restaurant.getChef2().getSkill());
       } else if(Chef.getNumberOfChefs() == 3) {
          System.out.println(restaurant.getChef1().getName() +  ", Skill: " + (int)restaurant.getChef1().getSkill() + ", " + restaurant.getChef2().getName() + ", Skill: " + (int)restaurant.getChef2().getSkill() + ", " + restaurant.getChef3().getName() + ", Skill: " + (int)restaurant.getChef3().getSkill());
        } else if(Chef.getNumberOfChefs() == 4){
          System.out.println(restaurant.getChef1().getName() +  ", Skill: " + (int)restaurant.getChef1().getSkill() + ", " + restaurant.getChef2().getName() + ", Skill: " + (int)restaurant.getChef3().getSkill() + ", " + restaurant.getChef3().getName() + ", Skill: " + (int)restaurant.getChef3().getSkill() + ", " + restaurant.getChef4().getName() + ", Skill: " + (int)restaurant.getChef4().getSkill());
        } else if(Chef.getNumberOfChefs() == 5 ){
          System.out.println(restaurant.getChef1().getName() +  ", Skill: " + restaurant.getChef1().getSkill() + ", " + restaurant.getChef2().getName() + ", Skill: " + (int)restaurant.getChef2().getSkill() + ", " + restaurant.getChef3().getName() + ", Skill: " + (int)restaurant.getChef3().getSkill() + ", " + restaurant.getChef4().getName() + ", Skill: " + (int)restaurant.getChef4().getSkill() + ", " + restaurant.getChef5().getName() + ", Skill: " + (int)restaurant.getChef5().getSkill());
       } else if(Chef.getNumberOfChefs() == 6 ){
          System.out.println(restaurant.getChef1().getName() +  ", Skill: " + restaurant.getChef1().getSkill() + ", " + restaurant.getChef2().getName() + ", Skill: " + (int)restaurant.getChef2().getSkill() + ", " + restaurant.getChef3().getName() + ", Skill: " + (int)restaurant.getChef3().getSkill() + ", " + restaurant.getChef4().getName() + ", Skill: " + (int)restaurant.getChef4().getSkill() + ", " + restaurant.getChef5().getName() + ", Skill: " + (int)restaurant.getChef5().getSkill() + ", " + restaurant.getChef6().getName() + ", Skill: " + (int)restaurant.getChef6().getSkill());
       }
       if (day != 1) {
         System.out.println(restaurant.getStaffReflection());
       }
			 restaurant.showSatisfactions();
       restaurant.askForTraining();
       restaurant.salaryChanges();
       Scanner u = new Scanner(System.in);
       System.out.println("Would you like to check another restaurant stat?");
       String uString = u.nextLine();
       if(uString.equals("no")) {
         notDoneWithEdits2 = false;
       }
      }
    if (view == 2){
      if(day == 1){
        System.out.println("Sorry, you can't view the financial report on the first day");
      } else {
        System.out.println("You made $" + sum(moneyFromEachCustomer) + " yesterday.");
        System.out.println("Your total earnings so far are $" + restaurant.getMoneyEarned() + ".");
        if(restaurant.getChef1().getWeeklyHours() > 0){
          System.out.println("Your chef is owed $" + restaurant.getChef1().getAmountOwed() + ".");
        } else if 
          (restaurant.getChef1().getWeeklyHours() > 0 && restaurant.getChef2().getWeeklyHours() > 0) {
            System.out.println("Your chefs need to be paid $" + (restaurant.getChef1().getAmountOwed() + restaurant.getChef2().getAmountOwed()));
          } else if 
            (restaurant.getChef1().getWeeklyHours() > 0 && restaurant.getChef2().getWeeklyHours() > 0 && restaurant.getChef3().getWeeklyHours() > 0) {
              System.out.println("Your chefs need to be paid $" + (restaurant.getChef1().getAmountOwed() + restaurant.getChef2().getAmountOwed() + restaurant.getChef3().getAmountOwed()) + ".");
            } else if 
              (restaurant.getChef1().getWeeklyHours() > 0 && restaurant.getChef2().getWeeklyHours() > 0 && restaurant.getChef3().getWeeklyHours() > 0 && restaurant.getChef4().getWeeklyHours() > 0) {
                System.out.println("Your chefs need to be paid $" + (restaurant.getChef1().getAmountOwed() + restaurant.getChef2().getAmountOwed() + restaurant.getChef3().getAmountOwed() + restaurant.getChef4().getAmountOwed()) + ".");
              } else if 
                (restaurant.getChef1().getWeeklyHours() > 0 && restaurant.getChef2().getWeeklyHours() > 0 && restaurant.getChef3().getWeeklyHours() > 0 && restaurant.getChef4().getWeeklyHours() > 0 && restaurant.getChef5().getWeeklyHours() > 0) {
                  System.out.println("Your chefs need to be $" + (restaurant.getChef1().getAmountOwed() + restaurant.getChef2().getAmountOwed() + restaurant.getChef3().getAmountOwed() + restaurant.getChef4().getAmountOwed() + restaurant.getChef5().getAmountOwed()));
                  
                } else if 
                (restaurant.getChef1().getWeeklyHours() > 0 && restaurant.getChef2().getWeeklyHours() > 0 && restaurant.getChef3().getWeeklyHours() > 0 && restaurant.getChef4().getWeeklyHours() > 0 && restaurant.getChef5().getWeeklyHours() > 0 && restaurant.getChef6().getWeeklyHours() > 0) {
                  System.out.println("Your chefs need to be $" + (restaurant.getChef1().getAmountOwed() + restaurant.getChef2().getAmountOwed() + restaurant.getChef3().getAmountOwed() + restaurant.getChef4().getAmountOwed() + restaurant.getChef5().getAmountOwed() + restaurant.getChef6().getAmountOwed()));
                }
      System.out.println("The minimum amount that you have made from a customer yesterday is $" + minNum(moneyFromEachCustomer));
      System.out.println("The maximum amount that you have made from a customer yesterday is $" + maxNum(moneyFromEachCustomer));
      System.out.println("The most frequent review that your restaurant recieved yesterday is " + modeArray(starsGivenToday) + " stars");
      if(ifContains(starsGivenToday, 5)){
        if(frequency(reverseOrder(shiftStuffLeft(starsGivenToday)), 5) >= 1){
          if (frequency(starsGivenToday, 5) == 1) {
            System.out.println("You recieved " + frequency(starsGivenToday, 5) + " 5 star review yesterday! Good Work!");
          } else {
            System.out.println("You recieved " + frequency(starsGivenToday, 5) + " 5 star reviews yesterday! Good Work!");
          }
        }
      } else {
        System.out.println("You did not recieve a 5-star rating yesterday.");
      }
      if(containsDuplicates(dishesOrderedToday)){
        System.out.println("There were multiples of the same dish ordered.");
      } else {
        System.out.println("Every meal ordered yesterday was different.");
      }
      Scanner w = new Scanner(System.in);
        System.out.println("Would you like to check another restaurant stat?");
        String wString = w.nextLine();
        if(wString.equals("no")) {
          notDoneWithEdits2 = false;
        }
      }
      
    }
    
    }
  }
           
  
    
    /** 
     * @param sentence
     */
    public static void typewriter(String sentence) { 
        for(int i = 0; i < sentence.length(); i++) {
            System.out.print(sentence.charAt(i));
            try {
                Thread.sleep(40);
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        }
   }
   
   
   /** 
    * @param sentence
    */
   public static void slowTypewriter(String sentence) { 
     for(int i = 0; i < sentence.length(); i++) {
       System.out.print(sentence.charAt(i));
       try {
         Thread.sleep(60);
       } catch (Exception e) {
         Thread.currentThread().interrupt();
       }
     }
   }


   
   /** 
    * @param array
    * @return double
    */
   public static double mean(int[] array){
    double sum = 0.0;
    for (int x: array) {
      sum += x;
    }
    return sum / array.length;
  }


  
  /** 
   * @param array
   * @return int
   */
  public static int sum(int[] array) {
    int sum = 0;
    for (int x: array) {
      sum += x;
    }
    return sum;
  }


     
     /** 
      * @param array
      * @return int
      */
     public static int maxNum(int[] array){
            int greater = 0;
            for(int number: array){
                if(number > greater) {
                    greater = number;
                }
            }
            return greater;
  }
  

/** 
 * @param array
 * @return int
 */
public static int minNum(int[] array) {
    int min = Integer.MAX_VALUE; 
    for (int x: array) {
      if (x < min) {
        min = x;
      }
    } 
    return min;
  }

  
  /** 
   * @param array
   * @return String[]
   */
  public static String[] reverseOrder(String[] array) {
        String[] newArray = new String[array.length];
        int d = 0;
        for(int i = array.length - 1; i >= 0; i--){
            newArray[d] = array[i];
            d++;
        }
        return newArray;
    }

  
  /** 
   * @param array
   * @return String
   */
  public static String print(String[] array) {
      String s = "";
      for(String a : array){
          s += a +", ";
      }
      return s;
  }

  
  /** 
   * @param array
   * @return String[]
   */
  public static String[] getCustomerInfo(Customer[] array) {
    int d = 0;
    String[] newArray = new String[array.length];
    for(int i = array.length - 1; i == 1; i++){
      newArray[d] = array[i].getName() + array[i].getCash();
      d++;
    }
    return newArray;
  }

  
  /** 
   * @param array
   * @param a
   * @return boolean
   */
  public static boolean ifContains(String[] array, String a) {
        boolean m;
        for(String chars : array){
            if(chars.equals(a)){
                return true;
            }       
        } 
        return false;
    }

    
    /** 
     * @param array
     * @param a
     * @return boolean
     */
    public static boolean ifContains(int[] array, int a) {
        boolean m;
        for(int num : array){
            if(num == a){
                return true;
            }       
        } 
        return false;
    }
  
  
  /** 
   * @param array
   * @return boolean
   */
  public static boolean containsDuplicates(String[] array) {
        for(int q = 0; q < array.length; q++){
            for(int i = q+1; i < array.length; i++){
                if(array[q].equals(array[i])){
                    return true;
                }
            }
        }
        return false;
    }

		  
  
  /** 
   * @param n
   * @return int
   */
  public static int sumOfDigits(int n) {
    int sum = 0;
    while (n > 0)
    {
      sum += n%10;
      n/=10;
    }
    return sum;
  }  
  
  
  /** 
   * @param n
   * @return double
   */
  public static double avgOfDigits(int n) {
    double sum = 0.0;
    int numOfDigits = 0;
    while (n > 0)
    {
      sum += n%10;
      numOfDigits++;
      n/=10;
    }
    return sum/numOfDigits;
  }
  
  
  /** 
   * @param n
   * @param i
   * @return int
   */
  public static int digitAt(int n, int i) {
    int l = n;
    int length = 0;
    while (l > 0)
    {
      length++;
      l/=10;
    }
    int character = 0;
    while (length >= i)
    {
      if (length == i + 1)
      {
        character = n%10;
      }
      n/=10;
      length--;
    }
    return character;
  }
  
  
  /** 
   * @param n
   * @return int
   */
  public static int mode(int n) {
    int digit = 0;
    int mode = n%10;//starts with the last digit as the mode in case there is only one digit
    while (digit <= 9)
    {
      if (frequencyInt(n, digit) > frequencyInt(n, mode))
      {
        mode = digit; 
      }
      digit++;
    }
    return mode; //if there are multiple it returns whichever mode has a digit closest to the ones place
  }

	
  /** 
   * @param n
   * @param d
   * @return int
   */
  public static int frequencyInt(int n, int d) {
   int frequency = 0;
   while (n > 0)
   {
     if (n % 10 == d)
     {
       frequency++;
     }
     n/=10;
   }
   return frequency;
  }

    
    /** 
     * @param array
     * @param i
     * @return int
     */
    public static int frequency(int[] array, int i) {
        int count = 0;
        for(int u : array){
            if(u == i){
                count++;
            }
        }
        return count;
    }
    
    
    /** 
     * @param array
     * @return int[]
     */
    public static int[] reverseOrder(int[] array){
        int[] newArray = new int[array.length];
        int d = 0;
        for(int i = array.length - 1; i >= 0; i--){
            newArray[d] = array[i];
            d++;
        }
        return newArray;
    }

  
  /** 
   * @param array
   * @return int[]
   */
  public static int[] shiftStuffLeft(int[] array){
        int[] newArray = new int[array.length];
        for(int i = 1; i < array.length; i++){
            newArray[i-1]=array[i];
        }
        newArray[newArray.length-1] = array[0];
        return newArray;
    }

  
  /** 
   * @param array
   * @return int
   */
  public static int modeArray(int [] array){
        int mode = array[0];
        int max = 0;
        for(int i = 0; i <array.length; i++){
            int current = 0;
            for(int j = i + 1; j<array.length; j++){
                if(array[j] ==array[i]){
                    current++;
                }
                if(current > max){
                    max = current;
                    mode = array[i];
                }
            }
        }
        return mode;
        }
  
  /** 
   * @param a
   * @param b
   * @return boolean
   */
  public static boolean divisible(int a, int b) {
        return a % b == 0 || b % a == 0;
  }

  
  /** 
   * @param a
   * @param b
   * @return int
   */
  public static int frequencyOf(int a, int b) {
        String strA = String.valueOf(a);
        int freq = 0;
        for (int i = 0; i < strA.length(); i++) {
            if (strA.substring(i, i + 1).equals(String.valueOf(b))) {
                freq++;
            }
        }
        return freq;
    
    }


		
    /** 
     * @param g
     * @param x
     * @return Chef[]
     */
    public static Chef[] remove(Chef[] g, int x) {
			Chef[] result = new Chef[g.length];
			for (int i = 0; i < x; i++) {
					result[i] = g[i];
			}
			for (int i = x; i < g.length - 1; i++) {
    		result[i] = g[i + 1];
			}
			return result;
		}







}
    