public class Customer {
  private final String name;
  private int cash;
  private boolean badMood;
  private int visits;
  private int visitsToday;
  private int rating;
  private String pronoun;
  private String possessivePronoun;
  private int chanceOfGoing;
  private int moneySpent;
  private Dish dishOrdered;
  private Chef cook;
  private int numberOrdered;
	private int pastRating;
  public Customer(String name, int cash, boolean badMood, String pronoun, String pPronoun) {
    this.name = name;
    this.cash = cash;
    this.badMood = badMood;
    visits = 0;
    visitsToday = 0;
    rating = 0;
    this.pronoun = pronoun;
    possessivePronoun = pPronoun;
    chanceOfGoing = 100;
  }

  public Customer(String name, int cash, boolean badMood, String pronoun, String pPronoun, int r, int moneySpent, Dish o, Chef c) {
    this.name = name;
    this.cash = cash;
    this.badMood = badMood;
    visits = 0;
    visitsToday = 0;
    rating = r;
    this.pronoun = pronoun;
    possessivePronoun = pPronoun;
    chanceOfGoing = 100;
    this.moneySpent = moneySpent;
    dishOrdered = o;
    cook = c;
    numberOrdered = 1;
  }  
  
  
  /** 
   * @return String
   */
  public String getPosessivePronoun(){
    return possessivePronoun;
  }

  
  /** 
   * @return boolean
   */
  public boolean getBadMood(){
    return badMood;
  }
  
  
  /** 
   * @return String
   */
  public String getName()
  {
    return name;
  }
  
  
  /** 
   * @return int
   */
  public int getCash()
  {
    return cash;
  }
  
  public void visit()
  {
    visits++;
    visitsToday++;
  }
  
  
  /** 
   * @return int
   */
  public int getVisits() 
  {
    return visits;
  }
  
  
  /** 
   * @return int
   */
  public int getVisitsToday() {
    return visitsToday;
  }
  
  
  /** 
   * @return String
   */
  public String getPronoun() {
    return pronoun;
  }
  
  
  /** 
   * @param d
   * @return String
   */
  public String reaction(Dish d) {
    rating = 0;
    boolean likedDish = false;
    boolean worthPrice = false;
    int managementRating = 0;
    int reactionRating = (int) (Math.random() * 5) + 1;
    if (d.getQuality() > 7) {
      reactionRating += 3;
    } else if (d.getQuality() > 5) {
      reactionRating+= 2;
    } else if(d.getQuality() > 3) {
      reactionRating++;
    }
    if (Quiz.getDecency() > 1) {
       if (reactionRating > 3) {
         likedDish = true;
       }
    } else if (Quiz.getDecency() < 0) {
      if (reactionRating > 5) {
         likedDish = true;
       }
    } else {
      if (reactionRating > 4) {
         likedDish = true;
       }
    }
    if (d.getCost()/d.getQuality() < 5) {
        worthPrice = true;
    } else if (d.getCost()/d.getQuality() < 8) {
      if (likedDish) {
        worthPrice = true;
      }   
    } else {
      if (Quiz.getConfidence() > 3 && d.getCost()/d.getQuality() < 11) {
        worthPrice = true;
      }
      if (Quiz.getConfidence() > 2 && d.getCost()/d.getQuality() < 10) {
        worthPrice = true;
      }
      if (Quiz.getConfidence() > 1 && d.getCost()/d.getQuality() < 9) {
        worthPrice = true;
      }
    }
    if (Quiz.getConfidence() > 2 && Quiz.getDecency() > 2) {
      managementRating += 4;
    } else if (Quiz.getConfidence() > 1 && Quiz.getDecency() > 1) {
      managementRating += 3;
    } else if (Quiz.getConfidence() > 1 || Quiz.getDecency() > 1) {
      managementRating += 2;
    }           
    rating = 1;
    if (badMood) {
      rating--;
    }
    int randomManagementeffect = (int) (Math.random() * 4);
    managementRating -= randomManagementeffect;
    String managementString = "" ;
    if (likedDish && worthPrice) {
      chanceOfGoing = (int) (chanceOfGoing * 1.3);
			rating = 5;
      if (managementRating >= 3) {
        managementString = " and " + pronoun.toLowerCase() + " loved the managment. " + pronoun + " wants to come back very soon!";
        chanceOfGoing = 100;
      } else if (managementRating >= 2) {
        managementString = " and " + pronoun.toLowerCase() + " liked the managment. "  + pronoun + " will definitely come back to this fine establishment.";
        chanceOfGoing = 100;
      } else if (managementRating == 0) {
        managementString = ". However, " + pronoun.toLowerCase() + " did not like the staff at the restaurant.";
        chanceOfGoing = (int) (chanceOfGoing * .8);
        rating = 4;
      } else {
				managementString = " too.";
      }
      return this.getName() + " liked the " + d.getFoodName().toLowerCase() + "! " + pronoun + " thought the dish was a great price" + managementString;
    }
    if (likedDish && !worthPrice) {
      chanceOfGoing = (int) (chanceOfGoing*.7);
      rating += 3;
      if (managementRating >= 3) {
        managementString = pronoun + " loved the managment and wants to come back for sure!";
        chanceOfGoing = (int) (chanceOfGoing * 1.2);
      } else if (managementRating >= 2) {
        chanceOfGoing = (int) (chanceOfGoing * 1.1);
      }
      if (managementRating == 0) {
        managementString = pronoun + " did not like the staff at the restaurant.";
        chanceOfGoing = (int) (chanceOfGoing * .8);
      }
      return this.getName() + " liked the " + d.getFoodName().toLowerCase() + "! However, " + pronoun.toLowerCase() + " thought the dish was a bit pricey for what " + pronoun.toLowerCase() 
        + " got." +  pronoun + " will most likely return to this restraunt but maybe try to lower some prices." + managementString;
     }
     if (!likedDish && worthPrice) {
       chanceOfGoing = (int) (chanceOfGoing*.5);
       rating += 2;
       if (managementRating >= 3) {
        managementString =  " and loved the managment which makes " + pronoun.toLowerCase() + " want to give the restaurant another chance.";
        chanceOfGoing = (int) (chanceOfGoing * 1.2);
      } else if (managementRating >= 2) {
        managementString =  " and liked the treatment " + pronoun.toLowerCase() + " receieved.";
        chanceOfGoing = (int) (chanceOfGoing * 1.1);
      } else if (managementRating == 0) {
        managementString = " and " + pronoun + " did not like the staff at the restaurant.";
        chanceOfGoing = (int) (chanceOfGoing * .7);
      } else {
				managementString = ".";
			}
       return this.getName() + " did not like the " + d.getFoodName().toLowerCase() + ". However, " + pronoun.toLowerCase() 
         + " thought the prices were good" + managementString;
    }
     chanceOfGoing = (int) (chanceOfGoing*.2); 
     rating += 1;
     if (managementRating >= 3) {
       managementString = "Fortunately, " + pronoun + " loved the staff! " + pronoun + " may return for this reason, but still t";
       chanceOfGoing = (int) (chanceOfGoing * 1.2);
     } else if (managementRating >= 2) {
       managementString = "Fortunately, " + pronoun + " liked the managment! Yet there is still a low chance that " + pronoun.toLowerCase() + " will return to this establishment. T";
       chanceOfGoing = (int) (chanceOfGoing * 1.1);
     } else if (managementRating == 0) {
       managementString = pronoun + " also did not like the staff at the restaurant. There is a very low chance that " + pronoun.toLowerCase() + " will return to this establishment. T";
       chanceOfGoing = (int) (chanceOfGoing * .7);
     } else {
			 managementString = "T";
		 }
     if (badMood) {
       chanceOfGoing = (int) (chanceOfGoing * .8);
     }
     return "Uh Oh... \n" + this.getName() + " didn't like the " + d.getFoodName().toLowerCase() + " and also thought that it was too expensive. " + managementString + "ry changing some of the prices or giving your chefs some training.";
    
  }
  
  
  /** 
   * @return int
   */
  public int getChanceOfGoing() {
    return chanceOfGoing;
  }
  
  
  /** 
   * @return int
   */
  public int getStarRating() {
    return rating;
  }

  
  /** 
   * @param d
   */
  public void setStarRating(int d) {
    rating = d;
  }
    

  public void tooExpensiveReview() {
    rating = 3;
    if(badMood) {
      rating--;
    }
  }

  
  /** 
   * @return int
   */
  public int getMoneySpent() {
    return moneySpent;
  }

  
  /** 
   * @param j
   */
  public void setMoneySpent(int j) {
    moneySpent = j;
  }

  
  /** 
   * @param k
   */
  public void setDishOrdered(Dish k) {
    dishOrdered = k;
  }
  
  /** 
   * @return Dish
   */
  public Dish getDishOrdered() {
    return dishOrdered;
  }  

  
  /** 
   * @param v
   */
  public void setCash(int v) {
    cash = v;
  }

  public void resetVisitsToday() {
    visitsToday = 0;
  }

  
  /** 
   * @return Chef
   */
  public Chef getCook() {
    return cook;
  }

  
  /** 
   * @param g
   */
  public void setCook(Chef g) {
    cook = g;
  }
	
 public void setNumberOrdered() {
	 numberOrdered = 0;
	 if (chanceOfGoing > 100) {
		 numberOrdered++;
	 } if (Quiz.getDetermination() > 2 && pastRating > 3) {
      numberOrdered++;
   } else if (Quiz.getDetermination() > 1 && pastRating > 4) {
		 numberOrdered++;
	 }
 }

 
 /** 
  * @return int
  */
 public int getNumberOrdered() {
   return numberOrdered;
 }
 
 
 /** 
  * @param d1
  * @param d2
  * @return String
  */
 public String twoDishReaction(Dish d1, Dish d2) {
    rating = 0;
    boolean likedDish1 = false;
    boolean worthPrice1 = false;
    int managementRating = 0;
    int reactionRating1 = (int) (Math.random() * 5) + 1;
    if (d1.getQuality() > 7) {
      reactionRating1 += 3;
    } else if (d1.getQuality() > 5) {
      reactionRating1 += 2;
    } else if(d1.getQuality() > 3) {
      reactionRating1++;
    }
    if (Quiz.getDecency() > 1) {
       if (reactionRating1 > 3) {
         likedDish1 = true;
       }
    } else if (Quiz.getDecency() < 0) {
      if (reactionRating1 > 5) {
         likedDish1 = true;
       }
    } else {
      if (reactionRating1 > 4) {
         likedDish1 = true;
       }
    }
    if (d1.getCost()/d1.getQuality() < 5) {
        worthPrice1 = true;
    } else if (d1.getCost()/d1.getQuality() < 8) {
      if (likedDish1) {
        worthPrice1 = true;
      }   
    } else {
      if (Quiz.getConfidence() > 3 && d1.getCost()/d1.getQuality() < 11) {
        worthPrice1 = true;
      }
      if (Quiz.getConfidence() > 2 && d1.getCost()/d1.getQuality() < 10) {
        worthPrice1 = true;
      }
      if (Quiz.getConfidence() > 1 && d1.getCost()/d1.getQuality() < 9) {
        worthPrice1 = true;
      }
    }
    boolean likedDish2 = false;
    boolean worthPrice2 = false;
    int reactionRating2 = (int) (Math.random() * 5) + 1;
    if (d2.getQuality() > 7) {
      reactionRating2 += 3;
    } else if (d2.getQuality() > 5) {
      reactionRating2 += 2;
    } else if(d2.getQuality() > 3) {
      reactionRating2++;
    }
    if (Quiz.getDecency() > 1) {
       if (reactionRating2 > 3) {
         likedDish2 = true;
       }
    } else if (Quiz.getDecency() < 0) {
      if (reactionRating2 > 5) {
         likedDish2 = true;
       }
    } else {
      if (reactionRating2 > 4) {
         likedDish2 = true;
       }
    }
    if (d2.getCost()/d2.getQuality() < 5) {
        worthPrice1 = true;
    } else if (d2.getCost()/d2.getQuality() < 8) {
      if (likedDish2) {
        worthPrice2 = true;
      }   
    } else {
      if (Quiz.getConfidence() > 3 && d2.getCost()/d2.getQuality() < 11) {
        worthPrice2 = true;
      }
      if (Quiz.getConfidence() > 2 && d2.getCost()/d2.getQuality() < 10) {
        worthPrice2 = true;
      }
      if (Quiz.getConfidence() > 1 && d2.getCost()/d2.getQuality() < 9) {
        worthPrice2 = true;
      }
    }
    if (Quiz.getConfidence() > 2 && Quiz.getDecency() > 2) {
      managementRating += 4;
    } else if (Quiz.getConfidence() > 1 && Quiz.getDecency() > 1) {
      managementRating += 3;
    } else if (Quiz.getConfidence() > 1 || Quiz.getDecency() > 1) {
      managementRating += 2;
    }         
    rating = 1;
    if (badMood) {
      rating--;
    }
    int randomManagementeffect = (int) (Math.random() * 4);
    managementRating -= randomManagementeffect;
    String managementString = "" ; 
    if (likedDish1 && likedDish2 && worthPrice1 && worthPrice2) {
      chanceOfGoing = 100;
      rating = 5;
      if (managementRating >= 3) {
        managementString = pronoun + " also loves the staff and wants to come back very soon!";
        chanceOfGoing = 110;
      } else if (managementRating >= 2) {
        managementString = pronoun + " liked the managment too! "  + pronoun + " will make this " + possessivePronoun + " go-to place in the area.";
      }
      if (managementRating == 0) {
        managementString = pronoun + " did not like the treatment " + pronoun + " receieved. You should probably change this since " + this.getName() + " is most likely to become a loyal customer.";
      }
      return this.getName() + " liked both dishes and thought they were a great price! " + managementString;
    }
    if (likedDish1 && likedDish2 && (worthPrice1 || worthPrice2)) {
      chanceOfGoing = (int) (chanceOfGoing * 1.1);
      if (chanceOfGoing > 100) {
        chanceOfGoing = 100;
      }
      rating += 4;
      if (managementRating >= 3) {
        managementString = pronoun + " loved the managment and will return.";
        chanceOfGoing = (int) (chanceOfGoing * 1.2);
      } else if (managementRating >= 2) {
        chanceOfGoing = (int) (chanceOfGoing * 1.1);
        managementString = pronoun + " loved the managment and will most likely come back to this restaurant.";
      }
      if (managementRating == 0) {
        managementString = "  However, " + pronoun + " did not like the staff here.";
        chanceOfGoing = (int) (chanceOfGoing * .8);
      }
      return this.getName() + " liked both dishes!" + managementString;
     }
     if (likedDish1 && !likedDish2) {
       String priceString = "";
			 rating += 3;
       if (worthPrice1 && worthPrice2) {
         priceString = pronoun + " thought the prices were good.";
       } else if (worthPrice1 || worthPrice2) {
          priceString = pronoun + " thought the prices were decent.";
       } else  {
         priceString =  pronoun + " thought the prices could improve.";
         chanceOfGoing = (int) (chanceOfGoing * .9);
         rating--;
       }
       if (managementRating >= 3) {
        managementString =  pronoun + " loved the managment, so coming back is a vey likely possibility.";
        chanceOfGoing = (int) (chanceOfGoing * 1.2);
        rating++;
      } else if (managementRating >= 2) {
        managementString = pronoun +  " liked the treatment " + pronoun.toLowerCase() + " receieved, and will most likely come back.";
        chanceOfGoing = (int) (chanceOfGoing * 1.1);
				if (chanceOfGoing > 100) {
					chanceOfGoing = 100;
				}
      }
       if (managementRating == 0) {
        managementString = pronoun + " did not like the staff at the restaurant ";
        if (worthPrice1 && worthPrice2) {
          managementString = managementString + ", but " + pronoun.toLowerCase() + " will most likely return for the good prices and get " + d1.getFoodName().toLowerCase() + ".";
        } else {
          managementString = pronoun + ", but " + pronoun.toLowerCase() + " will probably return again in " + possessivePronoun + " lifetime.";

        }
        chanceOfGoing = (int) (chanceOfGoing * .8);
      }
       return this.getName() + " did not like the " + d2.getFoodName().toLowerCase() + ", but liked the " + d1.getFoodName().toLowerCase() + "." + priceString + managementString;
    }
    
    if (!likedDish1 && likedDish2) {
       String priceString = "";
       if (worthPrice1 && worthPrice2) {
         priceString = pronoun + " thought the prices were good.";
       } else if (worthPrice1 || worthPrice2) {
          priceString = pronoun + " thought the prices were decent.";
          rating += 3;
       } else  {
         priceString =  pronoun + " thought the prices could improve.";
         chanceOfGoing = (int) (chanceOfGoing * .9);
         rating += 2;
       }
       if (managementRating >= 3) {
        managementString =  pronoun + " loved the managment, so coming back is a vey likely possibility.";
        chanceOfGoing = (int) (chanceOfGoing * 1.2);
        rating++;
      } else if (managementRating >= 2) {
        managementString = pronoun +  " liked the treatment " + pronoun.toLowerCase() + " receieved, and will most likely come back.";
        chanceOfGoing = (int) (chanceOfGoing * 1.1);
				if (chanceOfGoing > 100) {
					chanceOfGoing = 100;
				}
      }
       if (managementRating == 0) {
        managementString = pronoun + " did not like the staff at the restaurant ";
        if (worthPrice1 && worthPrice2) {
          managementString = managementString + ", but " + pronoun.toLowerCase() + " will most likely return for the good prices and get " + d2.getFoodName().toLowerCase() + ".";
        } else {
          managementString = pronoun + ", but " + pronoun.toLowerCase() + " will probably return for the " + d2.getFoodName().toLowerCase()+ ".";
        }
        chanceOfGoing = (int) (chanceOfGoing * .8);
      }
       return this.getName() + " did not like the " + d1.getFoodName().toLowerCase() + ", but liked the " + d2.getFoodName().toLowerCase() + "." + priceString + managementString;
    }
    if (!likedDish1 && !likedDish2 && (worthPrice1 || worthPrice2)) {
      if (managementRating >= 3) {
        managementString = "Fortunately, " + pronoun + " loved the staff! " + pronoun + " may return for this reason, but still t";
        chanceOfGoing = (int) (chanceOfGoing * 1.2);
      } else if (managementRating >= 2) {
        managementString = "Fortunately, " + pronoun + " liked the managment. Yet there is still a low chance that " + pronoun.toLowerCase() + " will return to this establishment. T";
        chanceOfGoing = (int) (chanceOfGoing * 1.1);
     }
     if (managementRating == 0) {
        managementString = pronoun + " also did not like the staff at the restaurant. There is a very low chance that " + pronoun.toLowerCase() + " will return to this establishment. T";
        chanceOfGoing = (int) (chanceOfGoing * .7);
     }
      return "Oops... \n" + this.getName() + " didn't like either the " + d1.getFoodName().toLowerCase() + " or the " + d2.getFoodName().toLowerCase() + "." + managementString + "ry changing some of the prices or giving your chefs some training.";
    }
     if (managementRating >= 3) {
        managementString = "Fortunately, " + pronoun + " loved the staff! " + pronoun + " may return for this reason, but still try changing some of the prices or giving your chefs some training.";
        chanceOfGoing = (int) (chanceOfGoing * 1.1);
      } else if (managementRating >= 2) {
        managementString = "Fortunately, " + pronoun + " liked the managment. Yet " + pronoun + " will probably not return. Try changing some of the prices or giving your chefs some training.";
     }
		 if (managementRating >= 3) {
			 managementString = pronoun + " did like treatment he recieved at the restaraunt through.";
			 chanceOfGoing += 5;
		 }
     if (managementRating == 0) {
        managementString = pronoun + " also did not like the staff at the restaurant. " + pronoun + " will not return to this establishment.";
        chanceOfGoing = 0;
     }
    	return "Uh Oh... \n" + this.getName() + " didn't like either dish and thinks the restaurant is too expensive." + managementString;
  }


  
  /** 
   * @param d1
   * @param d2
   * @param d3
   * @return String
   */
  public String threeDishReaction(Dish d1, Dish d2, Dish d3) {
    rating = 0;
    boolean likedDish1 = false;
    boolean worthPrice1 = false;
    int managementRating = 0;
    int reactionRating1 = (int) (Math.random() * 5) + 1;
    if (d1.getQuality() > 7) {
      reactionRating1 += 3;
    } else if (d1.getQuality() > 5) {
      reactionRating1 += 2;
    } else if(d1.getQuality() > 3) {
      reactionRating1++;
    }
    if (Quiz.getDecency() > 1) {
       if (reactionRating1 > 3) {
         likedDish1 = true;
       }
    } else if (Quiz.getDecency() < 0) {
      if (reactionRating1 > 5) {
         likedDish1 = true;
       }
    } else {
      if (reactionRating1 > 4) {
         likedDish1 = true;
       }
    }
    if (d1.getCost()/d1.getQuality() < 5) {
        worthPrice1 = true;
    } else if (d1.getCost()/d1.getQuality() < 8) {
      if (likedDish1) {
        worthPrice1 = true;
      }   
    } else {
      if (Quiz.getConfidence() > 3 && d1.getCost()/d1.getQuality() < 11) {
        worthPrice1 = true;
      }
      if (Quiz.getConfidence() > 2 && d1.getCost()/d1.getQuality() < 10) {
        worthPrice1 = true;
      }
      if (Quiz.getConfidence() > 1 && d1.getCost()/d1.getQuality() < 9) {
        worthPrice1 = true;
      }
    }
    boolean likedDish2 = false;
    boolean worthPrice2 = false;
    int reactionRating2 = (int) (Math.random() * 5) + 1;
    if (d2.getQuality() > 7) {
      reactionRating2 += 3;
    } else if (d2.getQuality() > 5) {
      reactionRating2 += 2;
    } else if(d2.getQuality() > 3) {
      reactionRating2++;
    }
    if (Quiz.getDecency() > 1) {
       if (reactionRating2 > 3) {
         likedDish2 = true;
       }
    } else if (Quiz.getDecency() < 0) {
      if (reactionRating2 > 5) {
         likedDish2 = true;
       }
    } else {
      if (reactionRating2 > 4) {
         likedDish2 = true;
       }
    }
    if (d2.getCost()/d2.getQuality() < 5) {
        worthPrice1 = true;
    } else if (d2.getCost()/d2.getQuality() < 8) {
      if (likedDish2) {
        worthPrice2 = true;
      }  
    } 
    boolean likedDish3 = false;
    boolean worthPrice3 = false;
    int reactionRating3 = (int) (Math.random() * 5) + 1;
    if (d3.getQuality() > 7) {
      reactionRating3 += 3;
    } else if (d3.getQuality() > 5) {
      reactionRating3 += 2;
    } else if(d3.getQuality() > 3) {
      reactionRating3++;
    }
    if (Quiz.getDecency() > 1) {
       if (reactionRating3 > 3) {
         likedDish3 = true;
       }
    } else if (Quiz.getDecency() < 0) {
      if (reactionRating2 > 5) {
         likedDish3 = true;
       }
    } else {
      if (reactionRating3 > 4) {
         likedDish3 = true;
       }
    }
    if (d3.getCost()/d3.getQuality() < 5) {
        worthPrice3 = true;
    } else if (d3.getCost()/d3.getQuality() < 8) {
      if (likedDish3) {
        worthPrice3 = true;
      } 
    } else {
      if (Quiz.getConfidence() > 3 && d2.getCost()/d2.getQuality() < 11) {
        worthPrice2 = true;
      }
      if (Quiz.getConfidence() > 2 && d2.getCost()/d2.getQuality() < 10) {
        worthPrice2 = true;
      }
      if (Quiz.getConfidence() > 1 && d2.getCost()/d2.getQuality() < 9) {
        worthPrice2 = true;
      }
    }
    if (Quiz.getConfidence() > 2 && Quiz.getDecency() > 2) {
      managementRating += 4;
    } else if (Quiz.getConfidence() > 1 && Quiz.getDecency() > 1) {
      managementRating += 3;
    } else if (Quiz.getConfidence() > 1 || Quiz.getDecency() > 1) {
      managementRating += 2;
    }         
    rating = 1;
    if (badMood) {
      rating--;
    }
    int randomManagementeffect = (int) (Math.random() * 4);
    managementRating -= randomManagementeffect;
    String managementString = "" ; 
    if (likedDish1 && likedDish2 && likedDish3) {
      chanceOfGoing = 100;
      rating = 5;
      String priceString = "";
      if (worthPrice1  && worthPrice2 && worthPrice3) {
        priceString = " and thought the prices were great!";
      } else if ((worthPrice1 && worthPrice2) || (worthPrice1 && worthPrice2) || (worthPrice2 && worthPrice3)) {
        priceString = " and thought the prices are alright!";
      } else if (worthPrice1 || worthPrice2 || worthPrice2) {
        priceString = "! But " + pronoun.toLowerCase() + " thinks there is room for improvement with the prices.";
      } else {
        priceString = "! However, " + pronoun.toLowerCase() + " thinks the restaurant is overpriced.";
      }
      if (managementRating >= 3) {
        managementString = pronoun + "also loves the staff and wants to come back very soon!";
        chanceOfGoing = 120;
      } else if (managementRating >= 2) {
        if ((worthPrice1 && worthPrice2) || (worthPrice1 && worthPrice2) || (worthPrice2 && worthPrice3)) {
          managementString = pronoun + " thought the staff was great the managment too! "  + pronoun + " will make this " + possessivePronoun + " go-to place in the area.";
        } else {
          managementString = pronoun + " liked the staff in the restaurant and hope to come back!";
        }
        chanceOfGoing = 110;
      }
      if (managementRating == 0) {
        managementString = pronoun + " did not like the treatment " + pronoun + " receieved.";
        rating--;
        if (badMood) {
          rating--;
        }
        if ((worthPrice1 && worthPrice2) || (worthPrice1 && worthPrice2) || (worthPrice2 && worthPrice3)) {
          managementString = managementString + "You should change this because " + this.getName() + " will soon be a loyal customer.";
       }
      }
      return this.getName() + " liked all 3 dishes" + priceString + managementString;
    }
    if ((likedDish1 && likedDish2) || (likedDish2 && likedDish3) || (likedDish1 && likedDish3)) {
      String beginningString = "";
      String priceString = "";
      rating += 3;
      if (likedDish1 && likedDish2) {
         beginningString = this.getName() + " liked the " + d1.getFoodName().toLowerCase() + " and the " + d2.getFoodName().toLowerCase() + ", but was not happy with the " + d3.getFoodName().toLowerCase() + ".";
      } else if (likedDish2 && likedDish3) {
         beginningString = this.getName() + " enjoyed the " + d2.getFoodName().toLowerCase() + " and the " + d3.getFoodName().toLowerCase() + ", but did not like the " + d1.getFoodName().toLowerCase() + ".";
      } else {
         beginningString = this.getName() + " disliked the " + d2.getFoodName().toLowerCase() + " but was very happy with the " + d1.getFoodName().toLowerCase() + " and the " + d3.getFoodName().toLowerCase() + ".";
      }
       if (worthPrice1 && worthPrice2) {
         priceString = pronoun + " thought the prices were good.";
         rating += 1;
       } else if (worthPrice1 || worthPrice2) {
          priceString = pronoun + " thought the prices were decent.";
       } else  {
         priceString =  pronoun + " thought the prices could improve.";
         chanceOfGoing = (int) (chanceOfGoing * .9);
       }
       if (managementRating >= 3) {
        managementString =  pronoun + " loved the managment, so coming back is a vey likely possibility.";
        chanceOfGoing = (int) (chanceOfGoing * 1.1);
        rating++;
      } else if (managementRating >= 2) {
        managementString = pronoun +  " liked the treatment " + pronoun.toLowerCase() + " receieved, and will most likely come back.";
      }
       if (managementRating == 0) {
          managementString = pronoun + ", but " + pronoun.toLowerCase() + " will still return.";
          rating--;
        }
        return beginningString + priceString + managementString;
    }
    if (likedDish1 || likedDish2 || likedDish3) {
      String beginningString = "";
      rating += 2;
      if (likedDish1) {
         beginningString = this.getName() + " liked the " + d1.getFoodName() + ", but not the " + d2.getFoodName().toLowerCase() + " and the " + d3.getFoodName().toLowerCase() + ".";
      } else if (likedDish2) {
         beginningString = this.getName() + " was happy with the " + d2.getFoodName().toLowerCase() + ", but not happy with the " + d3.getFoodName().toLowerCase() + " and the " + d1.getFoodName().toLowerCase() + ".";
      } else {
         beginningString = this.getName() + " was not happy with the " + d2.getFoodName().toLowerCase() + " and the " + d1.getFoodName().toLowerCase() +  ", but " + pronoun + " did like the " + d3.getFoodName().toLowerCase() + ".";
      }
       String priceString = "";
       if (worthPrice1 && worthPrice2) {
         priceString = pronoun + " thought the prices were good.";
       } else if (worthPrice1 || worthPrice2) {
          priceString = pronoun + " thought the prices were decent.";
       } else  {
         priceString =  pronoun + " thought the prices could improve.";
         chanceOfGoing = (int) (chanceOfGoing * .9);
       }
       if (managementRating >= 3) {
        managementString =  pronoun + " loved the managment, so coming back is a vey likely possibility.";
        chanceOfGoing = (int) (chanceOfGoing * 1.1);
        rating++;
      } else if (managementRating >= 2) {
        managementString = pronoun +  " liked the treatment " + pronoun.toLowerCase() + " receieved, and will most likely come back.";
      }
       if (managementRating == 0) {
          managementString = pronoun + ", but " + pronoun.toLowerCase() + " will still return.";
          rating--;
        }
        return beginningString + priceString + managementString;
      }
      if (worthPrice1 && worthPrice2 && worthPrice3) {
        chanceOfGoing = (int) (chanceOfGoing * .6);
        rating++;
       if (managementRating >= 3) {
        managementString =  " and thought the staff was really nice, so " + pronoun.toLowerCase() + " wants to come back.";
        chanceOfGoing = (int) (chanceOfGoing * 1.1);
        rating++;
      } else if (managementRating >= 2) {
        managementString = pronoun +  " liked the treatment " + pronoun.toLowerCase() + " receieved, and there is a possibility that " + pronoun.toLowerCase() + " will come back.";
      }
       if (managementRating == 0) {
          managementString = pronoun + ", but " + pronoun.toLowerCase() + " will still return.";
          rating = 0;
        }
        return this.getName() + " did not like any of the dishes, but thought the prices were great"  + managementString;
      }
       if (managementRating >= 3) {
        managementString =  "but was very happy with the company " + pronoun.toLowerCase() + " got, so there is a possibility " + this.getName() + " will come back.";
        chanceOfGoing = (int) (chanceOfGoing * 1.1);
        rating++;
      }
			 rating = 0;
       if (managementRating == 0) {
          managementString = ", and " + pronoun.toLowerCase() + " did not like the treatment " + pronoun.toLowerCase() + " got. It is likely that " + this.getName() + " will not return";
        } else {
					managementString = ".";
				}
        return this.getName() + " did not like " + possessivePronoun + " food" + managementString;
  }
       
	public void setMoreMoney() {
		cash = (int) (cash*1.2);
	}

	
  /** 
   * @param r
   */
  public void setPastRating(int r) {
		pastRating = r;
	}
  
	
  /** 
   * @return int
   */
  public int getPastRating() {
		return pastRating;
	}


}

