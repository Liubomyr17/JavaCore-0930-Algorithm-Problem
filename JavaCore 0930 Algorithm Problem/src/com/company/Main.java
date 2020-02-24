package com.company;

/*

0930 Algorithm Problem
Task: The user enters a list of words (and numbers) from the keyboard.
Output the words in ascending order, numbers in decreasing order.
Input Example:
Cherry
1
Bean
3
Apple
22
0
Watermelon
Output Example:
Watermelon
22
Bean
3
Cherry
1
0
Apple
Requirements:
1. The program should read data from the keyboard.
2. The program should display data on the screen.
3. Derived words should be sorted in ascending order.
4. The displayed numbers should be sorted in descending order.
5. The main method should use the sort method.
6. The sort method should use the isGreaterThan method.
7. The sort method should use the isNumber method.

 */

import java.io.*;
import java.lang.reflect.Array;
import java.net.URISyntaxException;
import java.nio.file.FileSystemException;
import java.nio.file.attribute.AclFileAttributeView;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        String buf;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j <array.length ; j++) {
                if (isNumber(array[i]) == isNumber(array[j]))
                {
                    if ((isNumber(array[j])  &&  (Integer.parseInt(array[j]) > Integer.parseInt(array[i])))
                            || (!isNumber(array[j])  &&  isGreaterThan(array[i],array[j])))
                    {
                        buf = array[i];
                        array[i] = array[j];
                        array[j] = buf;
                    }
                }
            }
        }
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }

    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-')) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}












