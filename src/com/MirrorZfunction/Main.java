package com.MirrorZfunction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(System.out);

        int N = Integer.parseInt(reader.readLine());
        String S = reader.readLine();

        StringBuilder sb = new StringBuilder();
        sb.append(S.charAt(0));
        boolean check = false;

        StringBuilder result = new StringBuilder();
        result.append(1);

        for (int i = 1; i < S.length(); i++) {
            sb.append(S.charAt(i));
            StringBuilder helper = new StringBuilder();
            for (int j = 0; j < sb.length() / 2; j++) {
                if (sb.charAt(j) == sb.charAt(sb.length() - 1 - j)) {
                    helper.append(sb.charAt(j));
                    helper.append(sb.charAt(sb.length() - 1 - j));
                } else {
                    if (helper.length() - 1 == -1) {
                        result.append(" 0");
                    } else result.append(" ").append(helper.length() / 2);

                    check = true;
                    break;
                }
            }
            if (!check) {
                result.append(" ").append(sb.length());
            }
            check = false;
        }

        System.out.println(result);

        reader.close();
        writer.close();
    }
}
