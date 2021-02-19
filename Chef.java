public class Chef {
  private String name;
  private String jobTitle; 
  private int wage;
  private int satisfaction; 
  private double chefSkill;
  private int weeklyHours;
  private static int numberOfChefs = 0;
  private boolean onTheJob;
  private int employeeNumber;
  private int dishesMade;
  private int owedMoney;
  private int totalMoneyGiven;
  private boolean paidTraining;
  private int dailyDishesMade;
  private double sumDailyStars;
  private int amountOwed;
  public Chef(String n, String jobTitle, int wage, double skill, int employee) { //chef
    name = n;
    this.jobTitle = jobTitle;
    this.wage = wage;
    chefSkill = skill;
    if (wage > 30){
      satisfaction = 9;
    } else if (wage > 25) {
      satisfaction = 8;
    } else if (wage > 18) {
      satisfaction = 7;
    } else if (wage > 14){
      satisfaction = 6;
    } else {
      satisfaction = 5;
    }
    numberOfChefs++;
    weeklyHours = 0;
    onTheJob = false;
    employeeNumber = employee;
    dishesMade = 0;
    owedMoney = 0;
    totalMoneyGiven = 0;
    paidTraining = false;
  }
    public Chef(String n, String jobTitle, int wage, double skill, int employee, boolean option) { //chef
    name = n;
    this.jobTitle = jobTitle;
    this.wage = wage;
    chefSkill = skill;
    weeklyHours = 0;
    onTheJob = false;
		if (wage > 30){
      satisfaction = 9;
    } else if (wage > 25) {
      satisfaction = 8;
    } else if (wage > 18) {
      satisfaction = 7;
    } else if (wage > 14){
      satisfaction = 6;
    } else {
      satisfaction = 5;
    }
    employeeNumber = employee;
    dishesMade = 0;
    owedMoney = 0;
    totalMoneyGiven = 0;
  }
  
  
  /** 
   * @return String
   */
  public String getName() {
    return name;
  }

  
  /** 
   * @return String
   */
  public String getJobTitle() {
    return jobTitle;
  }

  
  /** 
   * @param toString(
   */
  public void increaseWage() {//in the main class, "would you like to increase their salary?"
    satisfaction+=3;
    wage*=1.05;
  }
  
  
  /** 
   * @return String
   */
  public String toString()  {
    return name + ", " + jobTitle + ". Wage: " + wage + ", Skill " + chefSkill;
  }
 
  
  /** 
   * @return int
   */
  public int getEmployeeNumber() {
    return employeeNumber;
  }
  
  
  /** 
   * @return int
   */
  public static int getNumberOfChefs() {
    return numberOfChefs;
  }
  
  public void working() {
    onTheJob = true;
  }
  
  public void notWorking() {
    onTheJob = false;
  }
  
  
  /** 
   * @return boolean
   */
  public boolean getOnTheJob() {
    return onTheJob;
  }
  
  public void makeDish() {
    dishesMade++;
    chefSkill += 0.3;
  }
 
  
  /** 
   * @return int
   */
  public int getDishesMade() {
    return dishesMade++;
  }
  
  
  /** 
   * @return double
   */
  public double getSkill() {
    return chefSkill;
  }

  
  /** 
   * @return int
   */
  public int getWage() {
    return wage;
  }
  public void resetHoursWorked() {
    weeklyHours = 0;
  }
  
  public void payForTraining() {
    paidTraining = true;
  }

  
  /** 
   * @return boolean
   */
  public boolean getPaidTraining() {
    return paidTraining;
  }

  public void trained() {
    paidTraining = false;
    chefSkill += 2;
		weeklyHours += 2;
  }

  
  /** 
   * @return double
   */
  public double getSumDailyStars() {
    return sumDailyStars;
  }

  
  /** 
   * @param i
   */
  public void setSumDailyStars(int i) {
    sumDailyStars += i;
  }

  public void setDailyDishesMade(){
    dailyDishesMade++;
  }

   
   /** 
    * @return int
    */
   public int getDailyDishesMade() {
    return dailyDishesMade;
   }

  public void resetDailyServes() {
		if (dailyDishesMade > 4) {
			satisfaction--;
		}
    dailyDishesMade = 0;
    sumDailyStars = 0;
  }
  
  
  /** 
   * @param l
   */
  public void setAmountOwed(int l) {
    amountOwed += l;
  }
  
  
  /** 
   * @return int
   */
  public int getAmountOwed() {
    return amountOwed;
  }
  
  public void notPaid() {
    satisfaction -= 6;
		if (Quiz.getSelfishness() < -2) {
			satisfaction++;
		}
  }
  
  public void paid() {
    satisfaction += 3;
  }
  
  
  /** 
   * @return int
   */
  public int getSatisfaction() {
    if (satisfaction > 10) {
      satisfaction = 10;
    }
    return satisfaction;
  }
  
	
  /** 
   * @param k
   */
  public void setSatisfaction(int k) {
		satisfaction += k;
	}
  
  /** 
   * @param h
   */
  public void setWeeklyHours(int h) {
    weeklyHours += h;
  }
  
  
  /** 
   * @return int
   */
  public int getWeeklyHours() {
    return weeklyHours;
  }
  
  public void lowerSatisfaction() {
    satisfaction--;
  }

	
  /** 
   * @param n
   */
  public void newSalary(int n) {
		if (n < wage) {
			satisfaction -= 7;
			if (Quiz.getDecency() > 3) {
				satisfaction++;
			}
			if (Quiz.getCheer() > 3) {
				satisfaction++;
			}
		} else if (n > wage) {
			if (n - wage > 3) {
				satisfaction = 10;
			} else if (n - wage >= 2) {
				satisfaction += 6;
				if (satisfaction > 10) {
					satisfaction = 10;
				}
			} else {
				satisfaction += 4;
				if (satisfaction > 10) {
					satisfaction = 10;
				}
			}
		}
		wage = n;
	}

	
  /** 
   * @param n
   */
  public void setEmployeeNumber(int n) {
	 employeeNumber = n;
 }

}