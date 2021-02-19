public class Location {
  private String city;
  private String state;
  private String country;
  public Location(String city, String country) {
    this.city = city;
    this.country = country;
    state = null;
  }
  public Location(String city, String state, String country) {
    this.city = city;
    this.country = country;
    this.state = state;
  }
  
  
  /** 
   * @return String
   */
  public String toString() {
    if (state != null) {
      return city + ", " + state + ", United States.";
    }
    return city + ", " + country + ".";
  }
}
  