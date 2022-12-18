package enum_course;

enum Planet{
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);
    int number;
    Planet(int number){
        this.number=number;
    }
    public static void isMonday(Planet myPlanet){
        switch (myPlanet){
            case MONDAY:
                System.out.println("This is Monday !");
                break;
            case SUNDAY:
                System.out.println("Tomorrow is Monday !");
                break;
            default:
                System.out.println("This is not Monday !");
        }
    }
}

public class chaining {
    public static void main(String[] args) {

        Planet MyPlanet=Planet.SUNDAY;
        Planet.isMonday(MyPlanet);

    }


}
