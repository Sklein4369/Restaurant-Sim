public class Dish {
  private String foodName;
  private int cost;
  private int quality; //1 to 10
  private String dishType;
  private int difficulty;
  public Dish(String n, String t, int c, int d) {
    foodName = n;
    cost = c;
    dishType = t;
    difficulty = d;
  }
 
  
  /** 
   * @return String
   */
  public String getFoodName() {
    return foodName;
  }
 
  
  /** 
   * @return int
   */
  public int getCost(){
    return cost;
  }
 
  
  /** 
   * @return int
   */
  public int getQuality() {
    return quality;
  }
  
  
  /** 
   * @return String
   */
  public String getType()
  {
     return dishType;
  }
  
  
  /** 
   * @return String
   */
  public String toString()
  {
    return foodName + ": " +  dishType + " -- Cost: $" + cost;
  }
  
  
  /** 
   * @param i
   */
  public void changePrice(int i) {
    cost = i;
  }
    
  
  /** 
   * @param c
   */
  public void setQuality(Chef c) {
    quality = (int)c.getSkill();
    if (difficulty > 4 && c.getSkill() < 7) {
      quality--;
    }
    if (difficulty > 7) {
      quality--;
    }
    if (quality == 10) {
      quality--;
    }
    if (c.getSkill() == 10) {
      quality = 10;
    }
    if (quality <= 0) {
      quality = 1;
    }
    if (Quiz.getCheer() > 2) {
      quality++;
    } else if (Quiz.getCheer() < 0 && quality > 1) {
      quality--;
    }
  }
  
  
  /** 
   * @return int
   */
  public int getDifficulty() {
    return difficulty;
  }
    
}