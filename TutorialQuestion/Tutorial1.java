package TutorialQuestion;

import java.util.Arrays;

//Q1
class Tarikh{
    private int day, month, year;

    public Tarikh(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String toString() {
        return "Day: " + day + " Month: " + month + " Year: " + year +
                String.format("\nDate is : %02d/%02d/%04d" ,day,month,year);
    }
}

class testTarikh{
    public static void main(String[] args) {
        Tarikh t = new Tarikh(5,11,2016);
        System.out.println(t.toString());
    }
}

//Q2
class Sentence{
    private String sentence;
    //assume the sentence must contain at least one word
    private int length, words = 1 , vowels = 0;

    public Sentence(String sentence) {
        this.sentence = sentence;
        this.length = sentence.length();
        vowelsAndWords();
    }
    
    public void vowelsAndWords(){
        for(int i = 0 ; i <length; i++){
            if(sentence.charAt(i) == 'a' || sentence.charAt(i) == 'e' || 
                    sentence.charAt(i) == 'i' || sentence.charAt(i) == 'o' ||
                    sentence.charAt(i) == 'u' ){
                vowels += 1;
            }else if(sentence.charAt(i) == ' '){
                words += 1;
            }
        }
    }
    
    public String toString(){
        return "The sentence is : " + sentence + 
                "\nThe length of the sentence : " + length +
                "\nThe number of vowels : " + vowels + 
                "\nThe number of words : " + words;
    }
}

class testSentence{
    public static void main(String[] args) {
        Sentence s = new Sentence("How are you?");
        System.out.println(s.toString());
    }
}

//Q3
class ISP{
    protected String name;
    protected int Mpbs,GB;
    protected double price;

    public ISP(int Mpbs, int GB) {
        this.Mpbs = Mpbs;
        this.GB = GB;
    }
    
    public void display(){
        System.out.println("Plan : " + name + "with price RM: " + price);
    }

    public double getPrice() {
        return price;
    }
}

class DPlan extends ISP{

    public DPlan(int Mpbs, int GB) {
        super(Mpbs, GB);
        this.name = "DPlan";
        this.price = computePrice();
    }
    
    public double computePrice(){
        return Mpbs*10 + GB*0.2;
    }

}

class MPlan extends ISP{

    public MPlan(int Mpbs, int GB) {
        super(Mpbs, GB);
        this.name = "MPlan";
        this.price = computePrice();
    }
    
    public double computePrice(){
        return Mpbs*5 + GB*0.8;
    }

}

class testISP{
    public static void main(String[] args) {
        System.out.println("5Mpbs Subscription and 50GB");
        ISP plan1 = new DPlan(5,50);
        ISP plan2 = new MPlan(5,50);
        plan1.display();
        plan2.display();
        if(plan1.getPrice() < plan2.getPrice()){
            System.out.println("DPlan is cheaper as compared to MPlan");
        }else{
            System.out.println("MPlan is cheaper as compared to DPlan");
        }
    }
}

//Q4
class SmartPhone implements Comparable<SmartPhone>{
    private String name ;
    private int price;

    public SmartPhone(String name, int price) {
        this.name = name;
        this.price = price;
    }
    
    @Override
    public int compareTo(SmartPhone o) {
        return this.price - o.price;
    }
    
    public String toString(){
        return name + " (RM " + price + ")";
    }
    
}

class testSmartPhone{
    public static void main(String[] args) {
        SmartPhone []array = {new SmartPhone("iphone",2400) , new SmartPhone("Samsung",2200)
        ,new SmartPhone("Nokia" ,1400) , new SmartPhone("LG",1800)};
        System.out.println("List of Smart Phone:");
        for(SmartPhone s : array){
            System.out.print(s.toString() + " ");
        }
        Arrays.sort(array);
        System.out.println("\nList of Smart Phone in ascending order of the price");
        for(SmartPhone s : array){
            System.out.print(s.toString() + " ");
        }
    }
}

    