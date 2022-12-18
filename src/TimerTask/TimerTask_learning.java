package TimerTask;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTask_learning {
    public static void main(String[] args) {
        Timer timer=new Timer();
        TimerTask task=new TimerTask() {
            int counter=10;
            @Override
            public void run() {
                if(counter>0) {
                    System.out.println(counter+" seconds!");
                    counter--;
                }
                else {
                    System.out.println("HAPPY NEW YEAR !");
                    timer.cancel();
                }
            }
        };

        Calendar date=Calendar.getInstance();
        date.set(Calendar.YEAR,2022);
        date.set(Calendar.MONTH,Calendar.OCTOBER);
        date.set(Calendar.DAY_OF_MONTH,11);
        date.set(Calendar.HOUR_OF_DAY,13);
        date.set(Calendar.MINUTE,36);
        date.set(Calendar.SECOND,0);

//        timer.schedule(task,date.getTime());
        timer.scheduleAtFixedRate(task,date.getTime(),1000);

    }
}
