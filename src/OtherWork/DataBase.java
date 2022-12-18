package OtherWork;

public class DataBase {
    String name;
    public static DataBase instance;
    public static synchronized DataBase getInstance(String name){
        if(instance==null){
            instance=new DataBase(name);
        }
        return instance;
    }

    private DataBase(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        String name=this.name;
        return name;
    }
}
