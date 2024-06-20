public class SpaceGame {
    public static String shipname;
    public static String health;
    public static String speed;


    public SpaceGame(String name, String health, String speed){
        this.shipname = name;
        this.health = health;
        this.speed = speed;
    }

    public static String getshipname() {return SpaceGame.shipname;}
    public static String getshiphealth() {return SpaceGame.health;}
    public static String getshipspeed() {return SpaceGame.speed;}
    public  void setshipname(String _shipname) {this.shipname=_shipname;}
    public  void setshiphealth(String _health) {this.health=_health;}
    public  void setshipspeed(String _speed) {this.speed=_speed;}
}
