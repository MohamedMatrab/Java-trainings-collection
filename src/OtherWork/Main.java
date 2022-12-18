package OtherWork;

public class Main {

    public static void main(String[] args) {
        int[] a={8, 13, 0, 6, 11, 2};
        for(int i=1;i<a.length-1;i++){
            a[i]=a[i-1]+a[i+1];
            if(a[i]%2==0)
                a[i]/=2;
        }
        System.out.print("{");
        for (int i=0;i<a.length;i++)
            System.out.print(a[i]+",");
        System.out.print("}");
    }
}