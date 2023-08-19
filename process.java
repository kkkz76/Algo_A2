import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class process {
    private customer cus;
    private server s;
    private queue pQ;
    private queue sQ;
    private server[] pServers;
    private server[] sServers;
    final static String fileName = "A2data32.txt";
    boolean loop = true;

    
    private ArrayList <customer> customers = new ArrayList<customer>();


   


    public void getServer(){
        for(server x : sServers){
            System.out.println(x.getServer_number());
        }
    }


    public void  buildServer(int pCount, int sCount){
        pServers = new server[pCount];
        for(int i = 1; i <= pCount; i++){
            s = new server(Integer.toString(i), 0, "available", 0, null);
            pServers[i-1] = s;
            
        }
        sServers = new server[sCount];
        for(int i = 1; i <= sCount; i++){
            s = new server(Integer.toString(i), 0, "available", 0, null);
            sServers[i-1] = s;
        }
       
    }



    public void readFile(String fileName) {
        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);
            String header = reader.nextLine().trim();
            String[] serverCount = header.split("\\s+");
            int pCount = Integer.parseInt(serverCount[0].trim());
            int sCount = Integer.parseInt(serverCount[1].trim());
            buildServer(pCount, sCount);
            System.out.println("p"+pCount);
            System.out.println("s"+sCount);

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                // System.out.println(line);
                String[] data = line.split("\\s+");
                int pQueue_arriving_time = Integer.parseInt(data[0].trim());
                int pQueue_minute = Integer.parseInt(data[1].trim());
                int sQueue_minute = Integer.parseInt(data[2].trim());
                cus = new customer(pQueue_arriving_time, pQueue_minute, sQueue_minute);
                customers.add(cus);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void refreshServer(){
        for(server x: pServers){
            if(x.getStatus().equals("busy")){
              
                x.setRemaining_time(x.getRemaining_time()-1);
                System.out.println(x.getServer_number() +"server left " + x.getRemaining_time() +" min");
                if(x.getRemaining_time() == 0){
                    x.setCurrentCus(null);
                    x.setStatus("available");
                    System.out.println("Done Serving");
                    
                }
            }else{
                System.out.println(x.getServer_number() +"server left " + x.getRemaining_time() +" min");
                x.setIdle_time(x.getIdle_time()+1);
            }
        }
    }

    public void check(queue pQ, int i){
        System.out.println("loop checking");
        int y =0;
        for(server x:pServers){
            if(x.getStatus().equals("available")){
                y+=1;
        }
        if(y == pServers.length && pQ.isEmpty() && i == customers.size()-1){
            System.out.println("loop End");
            loop = false;
        }

    }
}

    



    public void run(){
        pQ = new queue(customers.size());
        sQ = new queue(customers.size());
        int min = 1;
        int i = 0;
        customer x;
        boolean sameMin = false;
        
        while (loop) {
             

            try {
                x = customers.get(i);
                System.out.println("min: " + min);
                System.out.println();

                if(sameMin == false) {
                    System.out.println();
                refreshServer();
                System.out.println();
                }

                
               
                if(x.getCustomer_arriving_time() == min){

                System.out.println("customer:"+ x.getCustomer_arriving_time()+" min");
                System.out.println("customer in pq min:"+ x.getpQueue_minute()+" min");
                System.out.println("same");
               
                pQ.enqueue(x);
                System.out.println("Goes to queue");

                


                for(server ps : pServers){

                    if(ps.getStatus().equals("available")&& !pQ.isEmpty()){

                        customer Customer = pQ.dequeue();
                        System.out.println("customer:"+ Customer.getpQueue_minute()+" min reach to "+ ps.getServer_number()+" server");
                        ps.setCurrentCus(Customer);
                        ps.setRemaining_time(Customer.getpQueue_minute());
                        ps.setStatus("busy");

                        
                        
                        break;
                        
                    }else{
                        System.out.println("customer "+ x.getpQueue_minute()+ "min cannot go into "+ps.getServer_number()+" server , it is busy");

                    }
                    
                }
                

                min+=1;
                sameMin = false;
                if(i == customers.size()-1){
                    System.out.println("No customers in array!");

                }else if(x.getCustomer_arriving_time() == customers.get(i+1).getCustomer_arriving_time()){
                    min-=1;
                    i+=1;
                    sameMin = true; 
                }else{
                    i+=1;
                    
                }

            }else if(x.getCustomer_arriving_time() != min){
                System.out.println("customer:"+ x.getCustomer_arriving_time()+" min");
                System.out.println("Differnet");
                min+=1;

                if(!pQ.isEmpty()){
                    for(server ps : pServers){

                    if(ps.getStatus().equals("available") && !pQ.isEmpty()){

                        customer Customer = pQ.dequeue();
                        System.out.println("customer:"+ Customer.getpQueue_minute()+" min reach to "+ ps.getServer_number()+" server");
                        ps.setCurrentCus(Customer);
                        ps.setRemaining_time(Customer.getpQueue_minute());
                        ps.setStatus("busy");
                        
                    }

                }
                }

                
               
        }



           
            check(pQ,i);
            System.out.println();
           


           
            } catch (Exception e) {
                // TODO: handle exception
               
               
              
            }
            
        }
    }







    public static void main(String[] args) {


        process p = new process();
        p.readFile(fileName);
        p.getServer();
        p.run();

         




    }
}
