import java.util.*;
public class Restaurant {
  private String name;
  private Location location;
  private int rating;
  private double ratingDouble;
  private int allStarsOfTheDay;
  private boolean starIncrease;
  private boolean starDecrease;
  private int totalCustomersVisited;
  private int dailyCustomersVisited;
  private Customer currentCustomer;
  private int earned;
  private int money;
  private int debt;
  private int chefsOwed;
  private String staffReflection;
  private int hoursOpen;
  private Chef chef1;
  private Chef chef2;
  private Chef chef3;
  private Chef chef4; 
  private Chef chef5;
  private Chef chef6;
	private boolean chefQuit;
  private int category; //3 categories: cheap food resturant, normal restraunt, fancy resturanut
  public Restaurant(String n, Location l) {
    name = n;
    location = l;
    rating = 0;
    category = 1;
    ratingDouble = 0;
    chef1 = new Chef("Rordan Gamsey", "Executive Chef", 17, 4, 1);
  }
 
  
  /** 
   * @return String
   */
  public String getName() {
    return name;
  }
 
  
  /** 
   * @return int
   */
  public int getRating() {
    if (rating > 5) {
      rating = 5;
    }
    if (rating < 0) {
      rating = 0;
    }
    return rating;
  } 
  
  /** 
   * @return int
   */
  public int getCategory() {
    return category;
  } 
  
  
  /** 
   * @return String
   */
  public String getStringCategory() {
    if (category == 1) {
      return "cheap food restaurant";
    } else if (category == 2) {
      return "normal restaurant";
    } else {
      return "fancy restaurant";
    }
  }

  public void categoryIncrease() {
      category++;
  }

  public void categoryDecrease() {
    category++;
  }
  
  
  /** 
   * @return Location
   */
  public Location getLocation() {
    return location;
  }
  
  
  /** 
   * @param x
   */
  public void customer(Customer x) {
    dailyCustomersVisited++;
    totalCustomersVisited++;
    currentCustomer = new Customer(x.getName(), x.getCash(), x.getBadMood(), x.getPronoun(), x.getPosessivePronoun());
  }
   
  public void resetDailyVariables() {
    dailyCustomersVisited = 0;
    starDecrease = false;
    starIncrease = false;
  }
	

  
  /** 
   * @return int
   */
  public int getDailyCustomersVisited() {
    return dailyCustomersVisited;
  }

  
  /** 
   * @return int
   */
  public int getTotalCustomersVisited() {
    return totalCustomersVisited;
  }

  
  /** 
   * @return double
   */
  public double getRatingDouble() {
    if (ratingDouble > 5.0) {
      ratingDouble = 5.0;
    }
    if (ratingDouble > 5.0) {
      ratingDouble = 5.0;
    }
    return ratingDouble;
  }
   
   /** 
    * @param a
    */
   public void increaseRatingDouble(double a) {
    ratingDouble += a;
    if (ratingDouble > 5.0) {
      ratingDouble = 5.0;
    }
  } 
  
  /** 
   * @param a
   */
  public void decreaseRatingDouble(double a) {
    ratingDouble -= a;
   if (ratingDouble > 5.0) {
      ratingDouble = 5.0;
    }
  }
  public void increaseRating() {
    rating++;
    starIncrease = true;
    if (rating > 5) {
      rating = 5;
    }
    System.out.println("Your restaurant rating increased!!\n" + name + " is now a " + rating + " star restaurant.\n");
  }
  public void decreaseRating() {
    rating--;
    starDecrease = true;
    if (rating < 0) {
      rating = 0;
    }
    System.out.println("Oops..your restaurant rating has dropped :(\n" + name + " is now a " + rating + " star restaurant.\n");
  }
  
  /** 
   * @return boolean
   */
  public boolean getStarIncrease() {
    return starIncrease;
  }

  
  /** 
   * @return boolean
   */
  public boolean getStarDecrease() {
    return starDecrease;
  }

  
  /** 
   * @param x
   */
  public void setCurrentCustomer(Customer x) {
    currentCustomer = new Customer(x.getName(), x.getCash(), x.getBadMood(), x.getPronoun(), x.getPosessivePronoun(), x.getStarRating(), x.getMoneySpent(), x.getDishOrdered(), x.getCook());
  } 

  
  /** 
   * @return Customer
   */
  public Customer getCurrentCustomer() {
    return currentCustomer;
  }

  
  /** 
   * @param o
   */
  public void addDebt(int o) {
    debt += o;
  }

  
  /** 
   * @return int
   */
  public int getDebt() {
    return debt;
  }

  
  /** 
   * @param e
   */
  public void addEarnings(int e) {
    earned += e;
    money += e;
  }
  
  
  /** 
   * @return int
   */
  public int getMoney() {
   return money;
  }
  
  
  public void payDebt() {
    if (debt > money) {
      int miscCosts = debt - chefsOwed;
      if (miscCosts > money) {
        int canPay = miscCosts - money;
        debt -= canPay;
        money = 0;
        System.out.println("You are only able to pay $" + canPay + " in utilities. You have a debt of $" + debt + ".");
      } else {
        money = money - miscCosts;
      }
      if (chefsOwed > money && money > 0) {
        debt += chefsOwed - money;
        System.out.println("You do not have enough money to pay every chef. Here's where the hard part comes in. \n" 
                           + "How would you like to distribute your money?  You can pay some of your chefs in full or give each chef some of what they are owed.\n"
                           + "For each chef please say how much you want to pay them:");
        int pay1 = -1;
        while (pay1 > money || pay1 == -1) {
          Scanner pay1Input = new Scanner(System.in);
          System.out.print("Chef 1 ");
          pay1 = pay1Input.nextInt();
          if (pay1 > money) {
            System.out.println("You do not have that much money to give."); 
          }
        }
        if (Chef.getNumberOfChefs() >= 2) {
          int pay2 = -1;
          while (pay2 > money || pay2 == -1) {
            Scanner pay2Input = new Scanner(System.in);
            System.out.print("Chef 2 ");
            pay2 = pay2Input.nextInt();
            if (pay2 > money) {
              System.out.println("You do not have that much money to give."); 
            }
          }
        }
        if (Chef.getNumberOfChefs() >= 3) {
          int pay3 = -1;
          while (pay3 > money || pay3 == -1) {
            Scanner pay3Input = new Scanner(System.in);
            System.out.print("Chef 3 ");
            pay3 = pay3Input.nextInt();
            if (pay3 > money) {
              System.out.println("You do not have that much money to give."); 
            }
          }
        }
        if (Chef.getNumberOfChefs() >= 4) {
          int pay4 = -1;
          while (pay4 > money || pay4 == -1) {
            Scanner pay4Input = new Scanner(System.in);
            System.out.print("Chef 4 ");
            pay4 = pay4Input.nextInt();
            if (pay4 > money) {
              System.out.println("You do not have that much money to give."); 
            }
          }
        }
        if (Chef.getNumberOfChefs() >= 5) {
          int pay5 = -1;
          while (pay5 > money || pay5 == -1) {
            Scanner pay5Input = new Scanner(System.in);
            System.out.print("Chef 5 ");
            pay5 = pay5Input.nextInt();
            if (pay5 > money) {
              System.out.println("You do not have that much money to give."); 
            }
          }
        }
        if (Chef.getNumberOfChefs() >= 6) {
          int pay6 = -1;
          while (pay6 > money || pay6 == -1) {
            Scanner pay6Input = new Scanner(System.in);
            System.out.print("Chef 6 ");
            pay6 = pay6Input.nextInt();
            if (pay6 > money) {
              System.out.println("You do not have that much money to give."); 
            }
          }
        }
      } else if (chefsOwed < money) {
        money = money - chefsOwed;
        System.out.println("All of your chefs were paid.");
        chef1.paid();
        if (Chef.getNumberOfChefs() >= 2) {
          chef2.paid();
        }
        if (Chef.getNumberOfChefs() >= 3) {
          chef3.paid();
        }
        if (Chef.getNumberOfChefs() >= 4) {
          chef4.paid();
        }
        if (Chef.getNumberOfChefs() >= 5) {
          chef5.paid();
        }
        if (Chef.getNumberOfChefs() >= 6) {
          chef6.paid();
        }
      } else {
        System.out.println("You could not pay any of your chefs.");
        chef1.notPaid();
        if (Chef.getNumberOfChefs() >= 2) {
          chef2.notPaid();
        }
        if (Chef.getNumberOfChefs() >= 3) {
          chef3.notPaid();
        }
        if (Chef.getNumberOfChefs() >= 4) {
          chef4.notPaid();
        }
        if (Chef.getNumberOfChefs() >= 5) {
          chef5.notPaid();
        }
        if (Chef.getNumberOfChefs() >= 6) {
          chef6.notPaid();
        }
      }
    } else if (debt < money) {
          money = money - debt;
          System.out.println("You have made a profit of $" + money + "!");
    } else {
      money = money - debt;
      System.out.println("You are debt free but you have made no profit.");
  }
 }
 
  

  
  /** 
   * @return int
   */
  public int getMoneyEarned() {
    return earned;
  }

  
  /** 
   * @return int
   */
  public int getChefsOwed() {
    return chefsOwed;
  }

  
  /** 
   * @param c
   */
  public void setChefsOwed(int c) {
    chefsOwed += c;
  }

  
  /** 
   * @param x
   */
  public void setStaffReflection(String x) {
    staffReflection = x;
  }

  
  /** 
   * @return String
   */
  public String getStaffReflection() {
    return staffReflection;
  }
  
  public void setHoursOpen() {
    Scanner hourInput = new Scanner(System.in);
    System.out.println("How many hours do you want to open your restaurant today? (6 is recomended)");
    hoursOpen = hourInput.nextInt();
		System.out.println("\n\n\n");
  }
  
  
  /** 
   * @return int
   */
  public int getHoursOpen() {
    return hoursOpen;
  }
  
   
   /** 
    * @return Chef
    */
   public Chef getChef1() {
    return chef1;
  }
  
  
  /** 
   * @return Chef
   */
  public Chef getChef2() {
    return chef2;
  }
  
  
  /** 
   * @return Chef
   */
  public Chef getChef3() {
    return chef3;
  }
  
  
  /** 
   * @return Chef
   */
  public Chef getChef4() {
    return chef4;
  }
  
  
  /** 
   * @return Chef
   */
  public Chef getChef5() {
    return chef5;
  }
  
  
  /** 
   * @return Chef
   */
  public Chef getChef6() {
    return chef6;
  }
  
  
  /** 
   * @param i
   */
  public void setChef2(Chef i) {
    chef2 = new Chef(i.getName(), i.getJobTitle(), i.getWage(), i.getSkill(), i.getEmployeeNumber());
  }
  
  
  /** 
   * @param i
   */
  public void setChef3(Chef i) {
    chef3 = new Chef(i.getName(), i.getJobTitle(), i.getWage(), i.getSkill(), i.getEmployeeNumber());
  }
  
  
  /** 
   * @param i
   */
  public void setChef4(Chef i) {
    chef4 = new Chef(i.getName(), i.getJobTitle(), i.getWage(), i.getSkill(), i.getEmployeeNumber());
  }
  
  
  /** 
   * @param i
   */
  public void setChef5(Chef i) {
    chef5 = new Chef(i.getName(), i.getJobTitle(), i.getWage(), i.getSkill(), i.getEmployeeNumber());
  }
  
  
  /** 
   * @param i
   */
  public void setChef6(Chef i) {
    chef6 = new Chef(i.getName(), i.getJobTitle(), i.getWage(), i.getSkill(), i.getEmployeeNumber());
  }
  
  public void training() {
    if(Chef.getNumberOfChefs() == 1){
      if (chef1.getPaidTraining()) {
        chef1.trained();
      }
    } else if(Chef.getNumberOfChefs() == 2 ){
      if (chef1.getPaidTraining()) {
        chef1.trained();
      }
      if (chef2.getPaidTraining()) {
        chef2.trained();
      }
    } else if(Chef.getNumberOfChefs() == 3 ){
      if (chef1.getPaidTraining()) {
        chef1.trained();
      }
      if (chef2.getPaidTraining()) {
        chef2.trained();
      }
      if (chef3.getPaidTraining()) {
        chef3.trained();
      }  
    } else if(Chef.getNumberOfChefs() == 4){
      if (chef1.getPaidTraining()) {
        chef1.trained();
      }
      if (chef2.getPaidTraining()) {
        chef2.trained();
      }
      if (chef3.getPaidTraining()) {
        chef3.trained();
      }  
      if (chef4.getPaidTraining()) {
        chef4.trained();
      }    
    } else if(Chef.getNumberOfChefs() == 5 ){
      if (chef1.getPaidTraining()) {
        chef1.trained();
      }
      if (chef2.getPaidTraining()) {
        chef2.trained();
      }
      if (chef3.getPaidTraining()) {
        chef3.trained();
      }  
      if (chef4.getPaidTraining()) {
        chef4.trained();
      }  
      if (chef5.getPaidTraining()) {
        chef5.trained();
      }     
    } else if(Chef.getNumberOfChefs() == 6 ){
      if (chef1.getPaidTraining()) {
        chef1.trained();
      }
      if (chef2.getPaidTraining()) {
        chef2.trained();
      }
      if (chef3.getPaidTraining()) {
        chef3.trained();
      }  
      if (chef4.getPaidTraining()) {
        chef4.trained();
      }  
      if (chef5.getPaidTraining()) {
        chef5.trained();
      }
      if (chef6.getPaidTraining()) {
        chef6.trained();
      }
    }
  }
  
  
  /** 
   * @param x
   */
  public void chefCooking(Chef x) {
    if(x.getName() == chef1.getName()) {
       chef1.makeDish();
     }
     if(chef2 != null && x.getName() == chef2.getName()) {
       chef2.makeDish();
     }
     if(chef3 != null && x.getName() == chef3.getName()) {
       chef3.makeDish();
     }
     if(chef4!= null && x.getName() == chef4.getName()) {
       chef4.makeDish();
     } 
    if(chef5 != null && x.getName() == chef5.getName()) {
       chef5.makeDish();
     }
     if(chef6 != null && x.getName() == chef6.getName()) {
       chef6.makeDish();
     }
  }
  
  
  public void askForTraining() {
    Scanner t = new Scanner(System.in);
    System.out.println("Would you like to provide any chefs with training for $50? If yes, which chef?");
    String chefForTraining = t.nextLine();
    if(Chef.getNumberOfChefs() == 1){
      if (chef1.getName().equals(chefForTraining)) {
        chef1.payForTraining();
        addDebt(50);
      }
    } else if(Chef.getNumberOfChefs() == 2 ){
      if (chef1.getName().equals(chefForTraining)) {
        chef1.payForTraining();
        addDebt(50);
      }
      if (chef2.getName().equals(chefForTraining)) {
        chef2.payForTraining();
        addDebt(50);
      }
    } else if(Chef.getNumberOfChefs() == 3 ){
      if (chef1.getName().equals(chefForTraining)) {
        chef1.payForTraining();
        addDebt(50);
      }
      if (chef2.getName().equals(chefForTraining)) {
        chef2.payForTraining();
        addDebt(50);
      }
      if (chef3.getName().equals(chefForTraining)) {
        chef3.payForTraining();
        addDebt(50);
      }  
    } else if(Chef.getNumberOfChefs() == 4){
      if (chef1.getName().equals(chefForTraining)) {
        chef1.payForTraining();
        addDebt(50);
      }
      if (chef2.getName().equals(chefForTraining)) {
        chef2.payForTraining();
        addDebt(50);
      }
      if (chef3.getName().equals(chefForTraining)) {
        chef3.payForTraining();
        addDebt(50);
      }
      if (chef4.getName().equals(chefForTraining)) {
        chef4.payForTraining();
        addDebt(50);
      }    
    } else if(Chef.getNumberOfChefs() == 5 ){
      if (chef1.getName().equals(chefForTraining)) {
        chef1.payForTraining();
        addDebt(50);
      }
      if (chef2.getName().equals(chefForTraining)) {
        chef2.payForTraining();
        addDebt(50);
      }
      if (chef3.getName().equals(chefForTraining)) {
        chef3.payForTraining();
        addDebt(50);
      }  
      if (chef4.getName().equals(chefForTraining)) {
        chef4.payForTraining();
        addDebt(50);
      }  
      if (chef5.getName().equals(chefForTraining)) {
        chef5.payForTraining();
        addDebt(50);
      }     
    } else if(Chef.getNumberOfChefs() == 6 ){
      if (chef1.getName().equals(chefForTraining)) {
        chef1.payForTraining();
        addDebt(50);
      }
      if (chef2.getName().equals(chefForTraining)) {
        chef2.payForTraining();
        addDebt(50);
      }
      if (chef3.getName().equals(chefForTraining)) {
        chef3.payForTraining();
        addDebt(50);
      }  
      if (chef4.getName().equals(chefForTraining)) {
        chef4.payForTraining();
        addDebt(50);
      }  
      if (chef5.getName().equals(chefForTraining)) {
        chef5.payForTraining();
        addDebt(50);
      }
      if (chef6.getName().equals(chefForTraining)) {
        chef6.payForTraining();
        addDebt(50);
      }
    }
  }

  public void chefHourSatisfaction() {
    if(Chef.getNumberOfChefs() == 1) {
      if (chef1.getWeeklyHours() > 30) {
        chef1.lowerSatisfaction();
      }
    } else if(Chef.getNumberOfChefs() == 2) {
      if (chef1.getWeeklyHours() > 30) {
        chef1.lowerSatisfaction();
      }
      if (chef2.getWeeklyHours() > 30) {
        chef2.lowerSatisfaction();
      }
    } else if(Chef.getNumberOfChefs() == 3) {
      if (chef1.getWeeklyHours() > 30) {
        chef1.lowerSatisfaction();
      }
      if (chef2.getWeeklyHours() > 30) {
        chef2.lowerSatisfaction();
      }
      if (chef3.getWeeklyHours() > 30) {
        chef3.lowerSatisfaction();
      }
    } else if(Chef.getNumberOfChefs() == 4) {
     if (chef1.getWeeklyHours() > 30) {
        chef1.lowerSatisfaction();
      }
      if (chef2.getWeeklyHours() > 30) {
        chef2.lowerSatisfaction();
      }
      if (chef3.getWeeklyHours() > 30) {
        chef3.lowerSatisfaction();
      }
      if (chef4.getWeeklyHours() > 30) {
        chef4.lowerSatisfaction();
      }
    } else if(Chef.getNumberOfChefs() == 5) {
      if (chef1.getWeeklyHours() > 30) {
        chef1.lowerSatisfaction();
      }
      if (chef2.getWeeklyHours() > 30) {
        chef2.lowerSatisfaction();
      }
      if (chef3.getWeeklyHours() > 30) {
        chef3.lowerSatisfaction();
      }
      if (chef4.getWeeklyHours() > 30) {
        chef4.lowerSatisfaction();
      }
      if (chef5.getWeeklyHours() > 30) {
        chef5.lowerSatisfaction();
      }
      
    } else {
      if (chef1.getWeeklyHours() > 30) {
        chef1.lowerSatisfaction();
      }
      if (chef2.getWeeklyHours() > 30) {
        chef2.lowerSatisfaction();
      }
      if (chef3.getWeeklyHours() > 30) {
        chef3.lowerSatisfaction();
      }
      if (chef4.getWeeklyHours() > 30) {
        chef4.lowerSatisfaction();
      }
      if (chef5.getWeeklyHours() > 30) {
        chef5.lowerSatisfaction();
      }
      if (chef6.getWeeklyHours() > 30) {
        chef6.lowerSatisfaction();
      }   
    }
  }
  
  
  public void resetWeekVariables() {
     if(Chef.getNumberOfChefs() == 1) {
       chef1.resetHoursWorked();
     } else if(Chef.getNumberOfChefs() == 2) {
       chef1.resetHoursWorked();
       chef2.resetHoursWorked();
     } else if(Chef.getNumberOfChefs() == 3) {
       chef1.resetHoursWorked();
       chef2.resetHoursWorked();
       chef3.resetHoursWorked();
     } else if(Chef.getNumberOfChefs() == 4) {
       chef1.resetHoursWorked();
       chef2.resetHoursWorked();
       chef3.resetHoursWorked();
       chef4.resetHoursWorked();
     } else if(Chef.getNumberOfChefs() == 5) {
       chef1.resetHoursWorked();
       chef2.resetHoursWorked();
       chef3.resetHoursWorked();
       chef4.resetHoursWorked();
       chef5.resetHoursWorked();
    } else {
       chef1.resetHoursWorked();
       chef2.resetHoursWorked();
       chef3.resetHoursWorked();
       chef4.resetHoursWorked();
       chef5.resetHoursWorked();
       chef6.resetHoursWorked();  
    }
  }
      


  public void salaryChanges() {
	  Scanner chefSalInput = new Scanner(System.in);     System.out.println("Would you like to change the salary of any chef? If yes, write that chef's name.");
    String lowerChef = chefSalInput.nextLine();
  	if (Chef.getNumberOfChefs() >= 6) {
					if (chef1.getName().equals(lowerChef)) {
						Scanner salInput = new Scanner(System.in);
        		 System.out.println("What would you like to pay" + lowerChef + " per hour? (previous salary was $" + chef1.getWage() + ")");
				 		 int newSalary = salInput.nextInt();
						 chef1.newSalary(newSalary);
					}
					if (chef2.getName().equals(lowerChef)) {
					 	 Scanner salInput = new Scanner(System.in);
        		 System.out.println("What would you like to pay" + lowerChef + " per hour? (previous salary was $" + chef2.getWage() + ")");
				 		 int newSalary = salInput.nextInt();
						 chef2.newSalary(newSalary);
					}
					if (chef3.getName().equals(lowerChef)) {
						Scanner salInput = new Scanner(System.in);
        		 System.out.println("What would you like to pay" + lowerChef + " per hour? (previous salary was $" + chef3.getWage() + ")");
				 		 int newSalary = salInput.nextInt();
						 chef3.newSalary(newSalary);
					}
					if (chef4.getName().equals(lowerChef)) {
						Scanner salInput = new Scanner(System.in);
        		 System.out.println("What would you like to pay" + lowerChef + " per hour? (previous salary was $" + chef4.getWage() + ")");
				 		 int newSalary = salInput.nextInt();
						 chef4.newSalary(newSalary);
					}
					if (chef5.getName().equals(lowerChef)) {
						Scanner salInput = new Scanner(System.in);
        		 System.out.println("What would you like to pay" + lowerChef + " per hour? (previous salary was $" + chef5.getWage() + ")");
				 		 int newSalary = salInput.nextInt();
						 chef5.newSalary(newSalary);
					}
					if (chef6.getName().equals(lowerChef)) {
						Scanner salInput = new Scanner(System.in);
        		 System.out.println("What would you like to pay" + lowerChef + " per hour? (previous salary was $" + chef6.getWage() + ")");
				 		 int newSalary = salInput.nextInt();
						 chef6.newSalary(newSalary);
					}
				} else if (Chef.getNumberOfChefs() >= 5) {
					if (chef1.getName().equals(lowerChef)) {
						Scanner salInput = new Scanner(System.in);
        		 System.out.println("What would you like to pay" + lowerChef + " per hour? (previous salary was $" + chef1.getWage() + ")");
				 		 int newSalary = salInput.nextInt();
						 chef1.newSalary(newSalary);
					}
					if (chef2.getName().equals(lowerChef)) {
					 	 Scanner salInput = new Scanner(System.in);
        		 System.out.println("What would you like to pay" + lowerChef + " per hour? (previous salary was $" + chef2.getWage() + ")");
				 		 int newSalary = salInput.nextInt();
						 chef2.newSalary(newSalary);
					}
					if (chef3.getName().equals(lowerChef)) {
						Scanner salInput = new Scanner(System.in);
        		 System.out.println("What would you like to pay" + lowerChef + " per hour? (previous salary was $" + chef3.getWage() + ")");
				 		 int newSalary = salInput.nextInt();
						 chef3.newSalary(newSalary);
					}
					if (chef4.getName().equals(lowerChef)) {
						Scanner salInput = new Scanner(System.in);
        		 System.out.println("What would you like to pay" + lowerChef + " per hour? (previous salary was $" + chef4.getWage() + ")");
				 		 int newSalary = salInput.nextInt();
						 chef4.newSalary(newSalary);
					}
					if (chef5.getName().equals(lowerChef)) {
						Scanner salInput = new Scanner(System.in);
        		 System.out.println("What would you like to pay" + lowerChef + " per hour? (previous salary was $" + chef5.getWage() + ")");
				 		 int newSalary = salInput.nextInt();
						 chef5.newSalary(newSalary);
					}
				} else if (Chef.getNumberOfChefs() >= 4) {
					if (chef1.getName().equals(lowerChef)) {
						Scanner salInput = new Scanner(System.in);
        		 System.out.println("What would you like to pay" + lowerChef + " per hour? (previous salary was $" + chef1.getWage() + ")");
				 		 int newSalary = salInput.nextInt();
						 chef1.newSalary(newSalary);
					}
					if (chef2.getName().equals(lowerChef)) {
					 	 Scanner salInput = new Scanner(System.in);
        		 System.out.println("What would you like to pay" + lowerChef + " per hour? (previous salary was $" + chef2.getWage() + ")");
				 		 int newSalary = salInput.nextInt();
						 chef2.newSalary(newSalary);
					}
					if (chef3.getName().equals(lowerChef)) {
						Scanner salInput = new Scanner(System.in);
        		 System.out.println("What would you like to pay" + lowerChef + " per hour? (previous salary was $" + chef3.getWage() + ")");
				 		 int newSalary = salInput.nextInt();
						 chef3.newSalary(newSalary);
					}
					if (chef4.getName().equals(lowerChef)) {
						Scanner salInput = new Scanner(System.in);
        		 System.out.println("What would you like to pay" + lowerChef + " per hour? (previous salary was $" + chef4.getWage() + ")");
				 		 int newSalary = salInput.nextInt();
						 chef4.newSalary(newSalary);
					}
				} else if (Chef.getNumberOfChefs() >=3) {
					if (chef1.getName().equals(lowerChef)) {
						Scanner salInput = new Scanner(System.in);
        		 System.out.println("What would you like to pay" + lowerChef + " per hour? (previous salary was $" + chef1.getWage() + ")");
				 		 int newSalary = salInput.nextInt();
						 chef1.newSalary(newSalary);
					}
					if (chef2.getName().equals(lowerChef)) {
					 	 Scanner salInput = new Scanner(System.in);
        		 System.out.println("What would you like to pay" + lowerChef + " per hour? (previous salary was $" + chef2.getWage() + ")");
				 		 int newSalary = salInput.nextInt();
						 chef2.newSalary(newSalary);
					}
					if (chef3.getName().equals(lowerChef)) {
						Scanner salInput = new Scanner(System.in);
        		 System.out.println("What would you like to pay" + lowerChef + " per hour? (previous salary was $" + chef3.getWage() + ")");
				 		 int newSalary = salInput.nextInt();
						 chef3.newSalary(newSalary);
					}
				} else if (Chef.getNumberOfChefs() >= 2) {
					if (chef1.getName().equals(lowerChef)) {
						Scanner salInput = new Scanner(System.in);
        		 System.out.println("What would you like to pay" + lowerChef + " per hour? (previous salary was $" + chef1.getWage() + ")");
				 		 int newSalary = salInput.nextInt();
						 chef1.newSalary(newSalary);
					}
					if (chef2.getName().equals(lowerChef)) {
					 	 Scanner salInput = new Scanner(System.in);
        		 System.out.println("What would you like to pay" + lowerChef + " per hour? (previous salary was $" + chef2.getWage() + ")");
				 		 int newSalary = salInput.nextInt();
						 chef2.newSalary(newSalary);
					}
				} else {
					if (chef1.getName().equals(lowerChef)) {
						Scanner salInput = new Scanner(System.in);
        		 System.out.println("What would you like to pay" + lowerChef + " per hour? (previous salary was $" + chef1.getWage() + ")");
				 		 int newSalary = salInput.nextInt();
						 chef1.newSalary(newSalary);
					} else if (lowerChef.toLowerCase().equals("no")) {
						return;
					} else {
						System.out.println("That is invalid.");
            salaryChanges();
				}
			}	
	}

	public void anyChefsQuit() {
		System.out.println("Number of chefs: " + Chef.getNumberOfChefs());
		if (Chef.getNumberOfChefs() >= 6) {
			if (chef1.getSatisfaction() <= 1) {
				System.out.println("Yikes...\n\n" + chef1.getName() + " has quit!!!!");
				chefQuit = true;
        chef1 = null;
			}
			if (chef2.getSatisfaction() <= 1) {
				System.out.println("Yikes...\n\n" + chef2.getName() + " has quit!!!!");
				chefQuit = true;
        chef2 = null;
			}
			if (chef3.getSatisfaction() <= 1) {
				System.out.println("Yikes...\n\n" + chef3.getName() + " has quit!!!!");
				chefQuit = true;
        chef3 = null;
			}
			if (chef4.getSatisfaction() <= 1) {
					System.out.println("Yikes...\n\n" + chef4.getName() + " has quit!!!!");
					chefQuit = true;
        	chef4 = null;
			}
			if (chef5.getSatisfaction() <= 1) {
					System.out.println("Yikes...\n\n" + chef5.getName() + " has quit!!!!");
				chefQuit = true;
        chef5 = null;
			}
			if (chef6.getSatisfaction() <= 1) {
					System.out.println("Yikes...\n\n" + chef6.getName() + " has quit!!!!");
					chefQuit = true;
					chef6 = null;
			}
		} else if (Chef.getNumberOfChefs() >= 5) {
			if (chef1.getSatisfaction() <= 1) {
					System.out.println("Yikes...\n\n" + chef1.getName() + " has quit!!!!");
					chefQuit = true;
					chef1 = null;
			}
			if (chef2.getSatisfaction() <= 1) {
				System.out.println("Yikes...\n\n" + chef2.getName() + " has quit!!!!");
				chefQuit = true;
				chef2 = null;
			}
			if (chef3.getSatisfaction() <= 1) {
				System.out.println("Yikes...\n\n" + chef3.getName() + " has quit!!!!");
				chefQuit = true;
				chef3 = null;
			}
			if (chef4.getSatisfaction() <= 1) {
				System.out.println("Yikes...\n\n" + chef4.getName() + " has quit!!!!");
				chefQuit = true;
				chef4 = null;
			}
			System.out.println(chef5.getSatisfaction());
			if (chef5.getSatisfaction() <= 1) {
				System.out.println("Yikes...\n\n" + chef5.getName() + " has quit!!!!");
				chefQuit = true;
				chef5 = null;
			}
		} else if (Chef.getNumberOfChefs() >= 4) {
			if (chef1.getSatisfaction() <= 1) {
				System.out.println("Yikes...\n\n" + chef1.getName() + " has quit!!!!");
				chefQuit = true;
				chef1 = null;
			}
			if (chef2.getSatisfaction() <= 1) {
				System.out.println("Yikes...\n\n" + chef2.getName() + " has quit!!!!");
				chefQuit = true;
				chef2 = null;
			}
			if (chef3.getSatisfaction() <= 1) {
				System.out.println("Yikes...\n\n" + chef3.getName() + " has quit!!!!");
				chefQuit = true;
				chef3 = null;
			}
			if (chef4.getSatisfaction() <= 1) {
				System.out.println("Yikes...\n\n" + chef4.getName() + " has quit!!!!");
				chefQuit = true;
				chef4 = null;
			}
		} else if (Chef.getNumberOfChefs() >= 3) {
			if (chef1.getSatisfaction() <= 1) {
				System.out.println("Yikes...\n\n" + chef1.getName() + " has quit!!!!");
				chefQuit = true;
				chef1 = null;
			}
			if (chef2.getSatisfaction() <= 1) {
				System.out.println("Yikes...\n\n" + chef2.getName() + " has quit!!!!");
				chefQuit = true;
				chef2 = null;
			}
			if (chef3.getSatisfaction() <= 1) {
				System.out.println("Yikes...\n\n" + chef3.getName() + " has quit!!!!");
				chefQuit = true;
				chef3 = null;
			}
		} else if (Chef.getNumberOfChefs() >= 2) {
			if (chef1.getSatisfaction() <= 1) {
				System.out.println("Yikes...\n\n" + chef1.getName() + " has quit!!!!");
				chefQuit = true;
				chef1 = null;
			}
			if (chef2.getSatisfaction() <= 1) {
				System.out.println("Yikes...\n\n" + chef2.getName() + " has quit!!!!");
				chefQuit = true;
				chef2 = null;
			}
		} else {
			if (chef1.getSatisfaction() <= 1) {
				System.out.println("Yikes...\n\n" + chef1.getName() + " has quit!!!!");
				chefQuit = true;
				chef1 = null;
			}
		}
	}

	public void doneWithQuits() {
		chefQuit = false;
	}

	
  /** 
   * @return boolean
   */
  public boolean getChefQuit() {
		return chefQuit;
	}

	
  /** 
   * @param x
   */
  public void replaceChef(Chef x) {
		if (Chef.getNumberOfChefs() >= 6) {
			if (chef1 == null) {
				chef1 = x;
				chef1.setEmployeeNumber(1);
				return;
			}
			if (chef2 == null) {
				chef2 = x;
				chef2.setEmployeeNumber(2);
				return;
			}
			if (chef3 == null) {
				chef3 = x;
				chef3.setEmployeeNumber(3);
				return;
			}
			if (chef4 == null) {
				chef4 = x;
				chef4.setEmployeeNumber(4);
				return;
			}
			if (chef5 == null) {
				chef5 = x;
				chef5.setEmployeeNumber(5);
				return;
			}
			if (chef6 == null) {
				chef6 = x;
				chef6.setEmployeeNumber(6);
				return;
			}
		} else if (Chef.getNumberOfChefs() >= 5) {
			if (chef1 == null) {
				chef1 = x;
				chef1.setEmployeeNumber(1);
				return;
			}
			if (chef2 == null) {
				chef2 = x;
				chef2.setEmployeeNumber(2);
				return;
			}
			if (chef3 == null) {
				chef3 = x;
				chef3.setEmployeeNumber(3);
				return;
			}
			if (chef4 == null) {
				chef4 = x;
				chef4.setEmployeeNumber(4);
				return;
			}
			if (chef5 == null) {
				chef5 = x;
				chef5.setEmployeeNumber(5);
				return;
			}
		} else if (Chef.getNumberOfChefs() >= 4) {
			if (chef1 == null) {
				chef1 = x;
				chef1.setEmployeeNumber(1);
				return;
			}
			if (chef2 == null) {
				chef2 = x;
				chef2.setEmployeeNumber(2);
				return;
			}
			if (chef3 == null) {
				chef3 = x;
				chef3.setEmployeeNumber(3);
				return;
			}
			if (chef4 == null) {
				chef4 = x;
				chef4.setEmployeeNumber(4);
				return;
			}
		} else if (Chef.getNumberOfChefs() >= 3) {
			if (chef1 == null) {
				chef1 = x;
				chef1.setEmployeeNumber(1);
				return;
			}
			if (chef2 == null) {
				chef2 = x;
				chef2.setEmployeeNumber(2);
				return;
			}
			if (chef3 == null) {
				chef3 = x;
				chef3.setEmployeeNumber(3);
				return;
			}
		} else if (Chef.getNumberOfChefs() >= 2) {
			if (chef1 == null) {
				chef1 = x;
				chef1.setEmployeeNumber(1);
				return;
			}
			if (chef2 == null) {
				chef2 = x;
				chef2.setEmployeeNumber(2);
				return;
			}
		} else {
			if (chef1 == null) {
				chef1 = x;
				chef1.setEmployeeNumber(1);
				return;
			}
		}
	}

	public void showSatisfactions() {
		System.out.println(chef1.getName() + " satisfaction: " + chef1.getSatisfaction());
		if (Chef.getNumberOfChefs() >= 2) {
				System.out.println(chef2.getName() + " satisfaction: " + chef2.getSatisfaction());
		} 
		if (Chef.getNumberOfChefs() >= 3) {
				System.out.println(chef3.getName() + " satisfaction: " + chef3.getSatisfaction());
		} 
		if (Chef.getNumberOfChefs() >= 4) {
				System.out.println(chef4.getName() + " satisfaction: " + chef4.getSatisfaction());
		} 
		if (Chef.getNumberOfChefs() >= 5) {
				System.out.println(chef5.getName() + " satisfaction: " + chef5.getSatisfaction());
		} 
		if (Chef.getNumberOfChefs() >= 6) {
				System.out.println(chef6.getName() + " satisfaction: " + chef6.getSatisfaction());
		} 
	}

	public void halfwayThruWeek() {
		chef1.lowerSatisfaction();
		if (Chef.getNumberOfChefs() >= 2) {
			if (chef2.getWeeklyHours() > 6) {
				chef2.lowerSatisfaction();
			}	
		} 
		if (Chef.getNumberOfChefs() >= 3) {
				if(chef3.getWeeklyHours() > 6) {
          chef3.lowerSatisfaction();
        }
		} 
		if (Chef.getNumberOfChefs() >= 4) {
				if(chef4.getWeeklyHours() > 6) {
          chef4.lowerSatisfaction();
        }
		} 
		if (Chef.getNumberOfChefs() >= 5) {
				if(chef5.getWeeklyHours() > 6) {
          chef5.lowerSatisfaction();
        }
		} 
		if (Chef.getNumberOfChefs() >= 6) {
				if(chef6.getWeeklyHours() > 6) {
          chef5.lowerSatisfaction();
        }
		} 

	}


	
  /** 
   * @param k
   */
  public void lowerSatisfaction(Chef k) {
		if (chef1.getName().equals(k.getName())) {
			chef1.lowerSatisfaction();
		} else if (chef2.getName().equals(k.getName())) {
			chef2.lowerSatisfaction();
		} else if (chef3.getName().equals(k.getName())) {
			chef3.lowerSatisfaction();
		}	else if (chef4.getName().equals(k.getName())) {
			chef4.lowerSatisfaction();
		}	else if (chef5.getName().equals(k.getName())) {
			chef5.lowerSatisfaction();
		}	else if (chef6.getName().equals(k.getName())) {
			chef6.lowerSatisfaction();
		}	else {
			return;
		}
	}

}


  
 