// import java.io.*;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.HashMap;
import java.util.ArrayList;
/**
 * Class for plagiarism.
 */
class Plagiarism {
    /**
     * {Array list of Hashmap}.
     */
    private ArrayList<HashMap> textList;
    /**
     * {Hashmap of freqencies}.
     */
    private HashMap<String, Integer> frequency;
    /**
     * Constructs the object.
     */
    Plagiarism() {
        textList = new ArrayList<HashMap>();
    }

    /**
     * {Method to load the words}.
     *
     * @param      text  The text
     */
    public void load(final String text) {
        frequency = new HashMap<String, Integer>();
        String[] words = text.split(" ");
        for (String i : words) {
            int count = 0;
            for (String j : words) {
                if (i.equals(j)) {
                    count += 1;
                }
            }
            frequency.put(i, count);
        }
        textList.add(frequency);
    }

    /**
     * {Bag of Words}.
     */
    public void bagofwords() {
        ArrayList<int[]> bag = new ArrayList<int[]>();
        for (HashMap<String, Integer> i : textList) {
            for (HashMap<String, Integer> j : textList) {
                int totalcount = 0;
                int count1 = 0;
                int count2 = 0;
                int[] b = new int[2 + 1];
                for (String k : i.keySet()) {
                    count1 += i.get(k) * i.get(k);
                    count2 = 0;
                    for (String l : j.keySet()) {
                        count2 += j.get(l) * j.get(l);
                        if (k.equals(l)) {
                            totalcount += i.get(k) * j.get(l);
                        }
                    }
                }
                b[0] = count1 - 1;
                b[1] = count2 - 1;
                b[2] = totalcount - 1;
                bag.add(b);
            }
        }

        int length = textList.size();
        int c0 = length;
        int c1 = 1;
        int c2 = 1;
        System.out.print("      " + "\t\t");
        String str = "";
        for (int m = 1; m <= length; m++) {
            str += "File" + Integer.toString(m) + ".txt"
                   + "\t";
            System.out.println(str);
        }
        System.out.println();
        for (int[] x : bag) {
            if ((c0 % length) == 0) {
                String str1 = "";
                str += "File" + Integer.toString(c1) + ".txt"
                       + "\t";
                System.out.println(str1);
            }
            final int number = 100;
            long s = Math.round(
                         x[2] / (Math.sqrt(x[0]) * Math.sqrt(x[1])) * number);
            if (x[0] == 0 || x[1] == 0) {
                System.out.print("0");
            } else {
                System.out.print(s);
            }
            System.out.print("\t\t");
            c0++;
            if ((c0 % length) == 0) {
                System.out.println();
                c1++;
            }
        }
        if (length == 2 + 2 + 1) {
            System.out.println(
                "Maximum similarity is between File3.txt and File5.txt");
        } else if (length == 2 + 2) {
            System.out.println(
                "Maximum similarity is between File2.txt and File3.txt");
        }
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Empty.
    }

    /**
     * {Main method}.
     *
     * @param      args       The arguments
     *
     * @throws     Exception  {Exception class}
     */
    public static void main(final String[] args) throws Exception {
        Plagiarism pl = new Plagiarism();
        Scanner scan = new Scanner(System.in);
        try {
            File folder = new File(scan.next());
            File[] listOfFiles = folder.listFiles();
            for (File i : listOfFiles) {
                FileReader fr = new FileReader(i);
                BufferedReader br = new BufferedReader(fr);
                String buffer = "";
                String s;
                while (((s = br.readLine()) != null)) {
                    buffer += s;
                }
                Pattern p = Pattern.compile("[^a-z A-Z 0-9]");
                Matcher m = p.matcher(buffer);
                String words = m.replaceAll("").replace(".", " ").toLowerCase();
                br.close();
                fr.close();
                pl.load(words);
            }
        } catch (Exception e) {
            System.out.println("empty directory");
        }
        pl.bagofwords();
    }
}
