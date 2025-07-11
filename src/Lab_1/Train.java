package Lab_1;

import java.util.Scanner;

public class Train {
    public String name;
    public int time;
    public int order;
    private String line;

    public Train(String line, int order) {
        this.line = line;
        this.order = order;
        var name = line.split(" ");
        this.name = name[0];
        String hr = line.substring(line.length() - 5, line.length() - 3);
        String min = line.substring(line.length() - 2);
        var timeHr = Integer.parseInt(hr);
        var timeMin = Integer.parseInt(min);
        this.time = timeHr * 60 + timeMin;
    }
    public void print(){
        System.out.println(line);
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var n=sc.nextInt();
        sc.nextLine();
        Train[] trains = new Train[n];
        for (int i = 0; i <n ; i++) {
//            var string=sc.nextLine();
            trains[i]=new Train(sc.nextLine(),i);
        }
        trains[0].print();
    }
}

