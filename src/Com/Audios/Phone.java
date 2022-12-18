package Com.Audios;

public class Phone {
    private String name;
    private double price;
    private int year;
    Phone(String name,int year,double price){
        this.setName(name);
        this.setYear(year);
        this.setPrice(price);
    }
    Phone(Phone x){
        this.copyPhone(x);
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    public void copyPhone(Phone x){
        this.setName(x.getName());
        this.setPrice(x.getPrice());
        this.setYear(x.getYear());
    }
}