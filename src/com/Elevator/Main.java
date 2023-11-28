package com.Elevator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String file_name = "input.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file_name));
            String[] firstLine = reader.readLine().split(" ");
            BigInteger p = new BigInteger(firstLine[0]);
            String[] secondLine = reader.readLine().split(" ");
            BigInteger h = new BigInteger(secondLine[0]);

            Stack<BigInteger> array = new Stack<>();
            for (int i = 0; i < h.intValue(); i++) {
                BigInteger element = new BigInteger(reader.readLine());
                array.push(element);
            }

            BigInteger total = BigInteger.ZERO;
            BigInteger cur = BigInteger.ZERO;
            BigInteger prev = BigInteger.ZERO;

            while (!array.isEmpty()) {
                BigInteger el = array.pop();
                BigInteger cell = BigInteger.valueOf(array.size() + 1);

                if (el.equals(BigInteger.ZERO)) {
                    continue;
                }

                if (!prev.equals(BigInteger.ZERO)) {
                    total = total.add(prev.subtract(cell).multiply(BigInteger.valueOf(2)));
                }

                el = el.add(cur);
                BigInteger[] result = el.divideAndRemainder(p);
                total = total.add(result[0].multiply(cell.multiply(BigInteger.valueOf(2))));
                cur = result[1];

                if (!cur.equals(BigInteger.ZERO)) {
                    prev = cell;
                } else {
                    prev = BigInteger.ZERO;
                }
            }

            if (!cur.equals(BigInteger.ZERO)) {
                total = total.add(prev.multiply(BigInteger.valueOf(2)));
            }

            System.out.println(total);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

