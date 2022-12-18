package Java_generics;

public class Main_04 {
    public static void main(String[] args) {
        /*Integer[] arrayInteger={2,3,4,6,8};
        Double[] arrayDouble={2.4,3.6,4.75,6.,8.};
        Character[] arrayCharacter={'a','b','c','d','e'};
        String[] arrayString={"Hello ","Mohamed ","Matrab ","Here !"};

        displayArray(arrayString);
        displayArray(arrayCharacter);
        displayArray(arrayInteger);
        displayArray(arrayDouble);*/

        newThing<Integer> thing_1=new newThing<>(2);
        newThing<Double> thing_2=new newThing<>(3.4);

        System.out.println(thing_1.getX());
        System.out.println(thing_2.getX());

    }
    /*public static  <Thing> void displayArray(Thing[] array){
        for (Thing x:array){
            System.out.print("\t"+x);
        }
        System.out.println();
    }*/
}
