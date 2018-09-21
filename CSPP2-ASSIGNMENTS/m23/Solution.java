import java.io.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.*;

class FileRead {
    String[] word;
    HashMap<String, Integer> map;
    FileRead (String fileName) {
        word = formatRead(fileName);
        map = new HashMap<String, Integer>();
    }
    public String[] formatRead(String fileName) {
        String[] str1 = null;
        String str2 = "";
        try {
            Scanner scan1 = new Scanner(new File(fileName));
            while (scan1.hasNext()) {
                str2 += (scan1.nextLine().replaceAll("[^a-zA-Z0-9_]+", " ").toLowerCase());
                str2 += " ";
            }
            str1 = str2.split(" ");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return str1;
    }
    public HashMap<String, Integer> freqWord() {
        for (int i = 0; i < word.length; i++) {
            if (map.containsKey(word[i])) {
                map.put(word[i], map.get(word[i]) + 1);
            } else {
                map.put(word[i], 1);
            }
        }
        return map;
    }
}
class Distance {
    private FileRead fr1;
    private FileRead fr2;
    HashMap<String, Integer> map1;
    Distance(FileRead file1, FileRead file2) {
        this.fr1 = file1;
        this.fr2 = file2;
        map1 = new HashMap<String, Integer>();
    }
    public double euclidProduct(FileRead fr) {
        map1 = fr.freqWord();
        long sum = 0;
        for (Map.Entry<String, Integer> m : map1.entrySet()) {
            int sum1 = m.getValue();
            sum += Math.pow(sum1, 2);
        }
        double product = Math.sqrt(sum);
        return product;
    }
    public double dotProduct() {
        HashMap<String, Integer> map2 = fr1.freqWord();
        HashMap<String, Integer> map3 = fr2.freqWord();
        String key;
        int sum = 0;
        for (Map.Entry<String, Integer> m : map2.entrySet()) {
            key = m.getKey();
            if (map3.containsKey(key)) {
                int value1 = map2.get(key);
                int value2 = map3.get(key);
                sum += (value1 * value2);
            }
        }
        return sum;
    }
    public double similarity() {
        double a = euclidProduct(fr1);
        double b = euclidProduct(fr2);
        double numerator = a * b;
        double denominator = dotProduct();
        double result = denominator / numerator;
        result = result * 100;
        return Math.round(result);
    }
}
public class Solution {
    public static void main(final String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        try {
            String folderName = scan.nextLine();
            File folder = new File(folderName);
            File[] allFiles = folder.listFiles();
            String s = "\t";
            for (File file : allFiles) {
                s += file.getName() + "\t";
            }
            s += "\n";
            for (File file1 : allFiles) {
                s += file1.getName() + "\t";
                for (File file2 : allFiles) {
                    FileRead d1 = new FileRead(file1 + "");
                    FileRead d2 = new FileRead(file2 + "");
                    Distance d = new Distance(d1, d2);
                    s += d.similarity() + "" + "\t";
                }
                s = s.trim();
                s += "\n";
            }
            System.out.println(s);
        } catch (Exception ex) {
            System.out.println("empty directory");
        }
    }
}