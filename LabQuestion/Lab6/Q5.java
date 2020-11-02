package LabQuestion;

public class Q5 {
    public static void main(String[] args) {
        PriorityQueue<Packet> queue = new PriorityQueue<>();
        System.out.println("10 packets arrived");
        Packet [] packets = {new Packet("Video" , 1 , 1),new Packet("Voice" , 2 , 2),new Packet("Data" , 3 , 0),
        new Packet("Data" , 4 , 0),new Packet("Voice" , 5 , 2),new Packet("Video" , 6 , 1),
        new Packet("Voice" , 7 , 2),new Packet("Voice" , 8 , 2),new Packet("Data" , 9 , 0),new Packet("Video" , 10 , 1)};
        for(int i = 0 ; i< packets.length ; i++){
            System.out.println(packets[i]);
            queue.enqueue(packets[i]);
        }
        
        System.out.println("\nProcessing 10 network packets");
        while(!queue.isEmpty()){
            System.out.println(queue.dequeue());
        }
    }
}

class Packet implements Comparable<Packet>{
    private String type;
    private int priority;
    private int num ;

    public Packet(String type, int num,int priority) {
        this.type = type;
        this.priority = priority;
        this.num = num;
    }

    @Override
    public String toString() {
        return type + " " + num + " (Priority=" + priority + ")";
    }

    public String getType() {
        return type;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Packet o) {
        return this.getPriority() - o.getPriority();
    }
    
}