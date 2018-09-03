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
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        final double num1 = 7.5;
        final double num2 = 7.0;
        final double num3 = 8.0;
        Student s1 = new Student("Sangay", "IT201985001", num1, num2, num3);
        System.out.println(s1.calculateGPA());
    }
}
/**
 * Class for student.
 */
class Student {
    /**
     * { var_description }.
     */
    private String name;
    /**
     * { var_description }.
     */
    private String rollNumber;
    /**
     * { var_description }.
     */
    private double m1;
    /**
     * { var_description }.
     */
    private double m2;
    /**
     * { var_description }.
     */
    private double m3;
    /**
     *
     * Constructs the object.
     *
     * @param      n     { parameter_description }
     * @param      rno   The rno
     * @param      s1    The s 1
     * @param      s2    The s 2
     * @param      s3    The s 3
     */
    Student(final String n, final String rno, final double s1,
            final double s2, final double s3) {
        this.name = n;
        this.rollNumber = rno;
        this.m1 = s1;
        this.m2 = s2;
        this.m3 = s3;
    }
    /**
     * Calculates the gpa.
     *
     * @return     The gpa.
     */
    public double calculateGPA() {
        final int num = 3;
        return (m1 + m2 + m3) / num;
    }
}
