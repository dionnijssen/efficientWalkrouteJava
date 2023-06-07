package Logic.Helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

public class Helpers {

    public static String readLine() throws IOException {
        while (true) {
            System.out.print(">");
            String line = (new BufferedReader(new InputStreamReader(System.in))).readLine();
            if (line.equals("")) {
                System.out.println("Input can't be empty");
                continue;
            }
            return line;
        }
    }

    public static int readInt() throws IOException {
        while (true) {
            String sOption = Helpers.readLine();
            if (!isInt(sOption)) {
                System.out.println("Invalid option");
                System.out.print(">");
                continue;
            }
            return Integer.parseInt(sOption);
        }
    }

    public static String readOption(ArrayList<String> array) throws IOException {
        while (true) {
            String option = Helpers.readLine();
            for (String opt : array) {
                if (opt.equals(option)) {
                    return option;
                }
            }
            System.out.println("Invalid option");
        }
    }


    public static boolean isInt(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int i = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}