public class server {
    private String server_number;
    private int idle_time;
    private String status;
    private int remaining_time;
    private customer CurrentCus;
    
 

    public server(String server_number, int idle_time, String status, int remaining_time, customer currentCus) {
        this.server_number = server_number;
        this.idle_time = idle_time;
        this.status = status;
        this.remaining_time = remaining_time;
        this.CurrentCus = currentCus;
    }

    



    public String getServer_number() {
        return server_number;
    }





    public void setServer_number(String server_number) {
        this.server_number = server_number;
    }





    public int getIdle_time() {
        return idle_time;
    }





    public void setIdle_time(int idle_time) {
        this.idle_time = idle_time;
    }





    public String getStatus() {
        return status;
    }





    public void setStatus(String status) {
        this.status = status;
    }





    public int getRemaining_time() {
        return remaining_time;
    }





    public void setRemaining_time(int remaining_time) {
        this.remaining_time = remaining_time;
    }





    public customer getCurrentCus() {
        return CurrentCus;
    }





    public void setCurrentCus(customer currentCus) {
        CurrentCus = currentCus;
    }





    public static void main(String[] args) {
       
        
         
    }

    
}
