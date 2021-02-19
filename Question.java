public class Question
{
  private String question;
  private String options;
  private int type;
  public Question (String q) {
    question = q;
    type = 1;
  }
  public Question (String q, String o) {
    question = q;
    options = o;
    type = 2;
  }
  
  
  /** 
   * @return int
   */
  public int getType() {
    return type;
  }
  
  
  /** 
   * @return String
   */
  public String toString() {
    if (type == 1) {
      return question + "(1) yes\n(2) no";
    }
    return question + options;
  }

}
