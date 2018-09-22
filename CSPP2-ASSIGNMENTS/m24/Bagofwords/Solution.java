import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.*;
class Plagiarism {
    private ArrayList<HashMap> textlist;
    private ArrayList<String> lss;
    private HashMap<String, Integer> frequence;
    Plagiarism() {
        textlist = new ArrayList<HashMap> ();
        lss = new ArrayList<String> ();
    }
    public void loadlss(String text) {
        lss.add(text);
    }
    public void load(String text) {
        frequence = new HashMap<String, Integer> ();
        String[] words = text.split(" ");
        for (String i : words) {
            int count = 0;
            for (String j : words) {
                if (i.equals(j)) {
                    count += 1;
                }
            }
            frequence.put(i, count);
        }
        textlist.add(frequence);
    }
    public void longestsubstring() {
        List<Long> listsub = new ArrayList<Long>();
        for (String i : lss) {
            for (String j : lss) {
                String sub = "";
                for (int k = 0; k < j.length();) {
                    for (int l = k ; l < j.length(); l++) {
                        if (i.contains(j.substring(k, l + 1)) && sub.length() < j.substring(k, l).length()) {
                            sub = j.substring(k, l + 1);
                        }
                    }
                    k += sub.length();
                }
                double a = sub.length();
                double b = i.length();
                double c = j.length();
                listsub.add(Math.round((a * 2 / (b + c)) * 100));
            }
        }
        //System.out.println(listsub);
        int length = lss.size();
        int c0 = length;
        int c1 = 1;
        System.out.print("           ");
        for (int m = 1; m <= length; m++) {
            System.out.print("File");
            System.out.print(m);
            System.out.print(".txt");
            System.out.print("    ");
        }
        System.out.println();
        for (long x : listsub) {
            if ((c0 % length) == 0) {
                System.out.print("File");
                System.out.print(c1);
                System.out.print(".txt    ");
            }
            System.out.print(x);
            System.out.print("    ");
            c0++;
            if ((c0 % length) == 0) {
                System.out.println();
                c1++;
            }
        }
    }
    public void bagofwords() {
        ArrayList<int[]> bag = new ArrayList<int[]> ();
        for (HashMap<String, Integer> i : textlist) {
            for (HashMap<String, Integer> j : textlist) {
                int totalcount = 0;
                int count1 = 0;
                int count2 = 0;
                int[] b = new int[3];
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
                b[0] = count1;
                b[1] = count2;
                b[2] = totalcount;
                bag.add(b);
            }
        }
        int length = textlist.size();
        int c0 = length;
        int c1 = 1;
        System.out.print("           ");
        for (int m = 1; m <= length; m++) {
            System.out.print("File");
            System.out.print(m);
            System.out.print(".txt");
            System.out.print("    ");
        }
        System.out.println();
        for (int[] x : bag) {
            if ((c0 % length) == 0) {
                System.out.print("File");
                System.out.print(c1);
                System.out.print(".txt    ");
            }
            System.out.print(Math.round((x[2] / (Math.sqrt(x[0]) * Math.sqrt(x[1]))) * 100));
            System.out.print("    ");
            c0++;
            if ((c0 % length) == 0) {
                System.out.println();
                c1++;
            }
        }
    }
}

public class Solution {
    public static void main(String[] args) throws Exception {
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
                pl.loadlss(words);
            }
        } catch (Exception e) {
            System.out.println("empty directory");
        }
        pl.bagofwords();
        pl.longestsubstring();
    }
}