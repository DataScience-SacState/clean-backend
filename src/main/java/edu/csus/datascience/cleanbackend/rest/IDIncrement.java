package edu.csus.datascience.cleanbackend.rest;

import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by merrillm on 4/9/16.
 */
public class IDIncrement {

    private static final File INCREMENTER_FILE = new File("incrementer_do_not_edit.txt");

    public static synchronized String nextEventId() {
        int count;
        try {
            Scanner scn = new Scanner(INCREMENTER_FILE);
            count = scn.nextInt() + 1;
        } catch (Exception e) {
            e.printStackTrace();
            count = 0;
        }

        FileWriter writer = null;
        try {
            writer = new FileWriter(INCREMENTER_FILE);
            writer.append(count + "");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "_" + count;
    }

}
