import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
/**
 * Class for common string.
 */
class CommonString {
    private String file1;
    private String file2;
    private Double result;
    private Double res;
    /**
     * Constructs the object.
     *
     * @param      str1  The 1st String
     * @param      str2  The 2nd String
     */
    CommonString(final String str1, final String str2) {
        this.file1 = str1;
        this.file2 = str2;
    }
    /**
     * {Method to find the longest common substring}
     *
     * @param      arr1  The arr 1
     * @param      arr2  The arr 2
     * @param      m     {variable m}
     * @param      n     {variable n}
     */
    public void common(final char[] arr1, final char[] arr2,
        final int m, final int n) {
        Double[][] longest = new Double[m + 1][n + 1];
        result = 0.0;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    longest[i][j] = 0.0;
                } else if (arr1[i - 1] == arr2[j - 1]) {
                    longest[i][j] = longest[i - 1][j - 1] + 1;
                    result = Double.max(result, longest[i][j]);
                } else {
                    longest[i][j] = 0.0;
                }
            }
        }
        res = (double)Math.round((((result * 2) / (m + n)) * 100d));
    }
    public Double getResult() {
        return res;
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
     * {Main method}
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        File testcase = new File(scan.nextLine());
        File[] testfiles = testcase.listFiles();
        if (testfiles.length == 0) {
            System.out.println("Empty directory");
        } else {
            System.out.print("             ");
            for (File name : testfiles) {
                System.out.print(
                    name.toString().split("\\\\")[1] + "    ");
            }
            ArrayList<String> fileStrings = new ArrayList<>();
            ArrayList<CommonString> objects = new ArrayList<>();
            for (File filename : testfiles) {
                try {
                    String content = new String(
                        Files.readAllBytes(Paths.get(filename.getAbsolutePath())));
                    content = content.replaceAll("\n", " ").replaceAll(
                        "[^A-Za-z0-9 ]", "").replaceAll("\\s+", " ");
                    fileStrings.add(content);
                } catch (Exception e) {
                    System.out.println("file not found");
                }
            }
            int k = 0;
            int i = 1;
            for (String input1 : fileStrings) {
                System.out.println();
                System.out.print("File" + i + ".txt" + "        ");
                for (String input2 : fileStrings) {
                    objects.add(new CommonString(input1, input2));
                    objects.get(k).common(
                        input1.toCharArray(), input2.toCharArray(), input1.length(), input2.length());
                    System.out.print(objects.get(k).getResult() + "         ");
                    k++;
                }
                i++;
            }
        }
    }
}
