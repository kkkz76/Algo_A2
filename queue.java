import java.util.*;

public class queue {
    private customer[] customerList;
    private int qCustomerCount;
    private int qMaxLength;
    private int qTotalTime;
    private int qTotalCustomer;
    private int front;
    private int rear;

    public queue(int size) {
        customerList = new customer[size]; // a list of customer for stimulation
        qCustomerCount = 0;
        qTotalTime = 0;
        qTotalCustomer = 0;
        front = 0;
        rear = 0;
    }

    public int getqCustomerCount() {
        return qCustomerCount;
    }

    public int getqMaxLength() {
        return qMaxLength;
    }

    public void setqMaxLength(int len) {
        this.qMaxLength = len;
    }

    public boolean isEmpty() {
        return qCustomerCount == 0;
    }

    public void enqueue(customer c) {
        customerList[front] = c;
        front++;
        if (front == customerList.length) {
            front = 0;
        }
        qCustomerCount++;
        qTotalCustomer++;
    }

    public customer dequeue() {
        customer c = customerList[rear];
        customerList[rear] = null;
        rear++;
        if (rear == customerList.length) {
            rear = 0;
        }
        qCustomerCount--;
        return c;
    }

    public customer front() { // return the item recently added to the queue but do not remove
        return customerList[rear];
    }

    public static void main(String[] args) {
        queue x = new queue(2);
        customer y = new customer(0, 0, 0);
        x.enqueue(y);
        x.dequeue();
        if (x.isEmpty()) {
            System.out.println("empty");
        }else{
            System.out.println("not empty");
        }

    }
}

