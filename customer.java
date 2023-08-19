import java.io.File;
import java.util.*;

public class customer{
    private int customer_arriving_time;
    private int pQueue_arriving_time;
    private int sQueue_arriving_time;
    private int pQueue_minute;
    private int sQueue_minute;
  

    public customer(int customer_arriving_time, int pQueue_minute, int sQueue_minute) {
        this.customer_arriving_time = customer_arriving_time;
        this.pQueue_minute = pQueue_minute;
        this.sQueue_minute = sQueue_minute;
    }

   



    public int getCustomer_arriving_time() {
        return customer_arriving_time;
    }


    public void setCustomer_arriving_time(int customer_arriving_time) {
        this.customer_arriving_time = customer_arriving_time;
    }


    public int getpQueue_minute() {
        return pQueue_minute;
    }


    public void setpQueue_minute(int pQueue_minute) {
        this.pQueue_minute = pQueue_minute;
    }


    public int getsQueue_minute() {
        return sQueue_minute;
    }


    public void setsQueue_minute(int sQueue_minute) {
        this.sQueue_minute = sQueue_minute;
    }
}


    