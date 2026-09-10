package lecture_09_Design_a_Food_Delivery_App.foodXpress.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtils {

    public static String getCurrentTime(){
        LocalDateTime now = LocalDateTime.now();
        return now.format(DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss yyyy"));
    }
}
