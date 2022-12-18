package ClockP;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

public class clockProject extends JFrame{

    SimpleDateFormat timeFormat,dayFormat,dateFormat;
    JLabel timeLabel,dayLabel,dateLabel;
    String time,day,date;
    clockProject(){

        timeFormat =new SimpleDateFormat("hh:mm:ss a");

        dayFormat=new SimpleDateFormat("EEEE");

        dateFormat=new SimpleDateFormat("yy | MM |dd ");

        time=timeFormat.format(Calendar.getInstance().getTime());

        timeLabel =new JLabel();
        timeLabel.setText(time);
        timeLabel.setFont(new Font("",Font.PLAIN,60));
        timeLabel.setForeground(Color.GREEN);
        timeLabel.setBackground(Color.BLACK);
        timeLabel.setOpaque(true);

        day=dayFormat.format(Calendar.getInstance().getTime());

        dayLabel =new JLabel();
        dayLabel.setText(day);
        dayLabel.setFont(new Font("Ink Free",Font.BOLD,60));

        date=dateFormat.format(Calendar.getInstance().getTime());

        dateLabel =new JLabel();
        dateLabel.setText(date);
        dateLabel.setFont(new Font("Ink Free",Font.PLAIN,50));


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("This is My Clock !");
        this.setSize(400,250);
        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);

        setTime();
    }
    public void setTime() {
        while (!Objects.equals(time, "00:00:00 AM")){
            time=timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);

            day=dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);

            date=dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}
