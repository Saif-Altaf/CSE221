//package Lab_1;
//
//
//
//import java.util.*;
//
//public class Trains {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        sc.nextLine();
//        String[] schedule = new String[n];
//        for (int i = 0; i < n; i++) {
//            schedule[i] = sc.nextLine();
//        }
//
//        String[] names = new String[n];
//        int[] times = new int[n];
//        for (int i = 0; i < schedule.length; i++) {
//            String[] name = schedule[i].split(" ");
//            names[i] = name[0];
//            String hr = schedule[i].substring(schedule[i].length() - 5, schedule[i].length() - 3);
//            String min = schedule[i].substring(schedule[i].length() - 2);
//            var timeHr = Integer.parseInt(hr);
//            var timeMin = Integer.parseInt(min);
//            times[i] = timeHr * 60 + timeMin;
//        }
//        for (int i = 0; i < n - 1; i++) {
//            int minIndex = i;
//            for (int j = i+1; j < n; j++) {
//                if (names[minIndex].compareTo(names[j]) < 0) {
//                    minIndex = j;
//                }
////                else if (names[minIndex].compareTo(names[j]) == 0) {
////                    if (times[minIndex] > times[j]) {
////                        minIndex = j;
////                    }
////                }
//            }
//            var temp = schedule[i];
//            schedule[i] = schedule[minIndex];
//            schedule[minIndex] = temp;
//        }
//        for (int i = 0; i < n; i++) {
//            System.out.println(schedule[i]);
//        }
//
////        System.out.println(Arrays.toString(times));
//    }
//}
//
