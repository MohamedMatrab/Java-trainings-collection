package Java_generics;

public class newThing <Thing extends Number> {
    Thing x;
    newThing(Thing x){
        this.x=x;
    }
    public Thing getX() {
        return x;
    }
}