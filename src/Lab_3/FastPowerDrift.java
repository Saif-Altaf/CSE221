package Lab_3;

import java.io.*;
import java.math.BigInteger;

public class FastPowerDrift {
    public static void main(String[] args) throws IOException {
        BufferedReader read=new BufferedReader(new InputStreamReader(System.in));
        String [] line=read.readLine().split(" ");
        BigInteger a=new BigInteger(line[0]);
        BigInteger b=new BigInteger(line[1]);
        BigInteger mod=new BigInteger("107");
        BigInteger result=a.modPow(b,mod);
        System.out.println(result);
    }
}
