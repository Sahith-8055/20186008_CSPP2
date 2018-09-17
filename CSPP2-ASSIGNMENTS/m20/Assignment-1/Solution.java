import java.util.Scanner;
/**
 * Class for question.
 */
class Question {
    /**
     * {Declaring a String variable questiontext}.
     */
    private String questiontext;
    /**
     * {Declaring a String array of choices}.
     */
    private String[] choices;
    /**
     * {Declaring a int variable of correctanswer}.
     */
    private int correctAnswer;
    /**
     * {Declaring a variable of maximum marks}.
     */
    private int maxMarks;
    /**
     * {Declaring a variable penalty}.
     */
    private int penalty;
    /**
     * {Declaring a variable response}.
     */
    private String response;
    /**
     * Constructs the object.
     */
    Question() {
        //Empty.
    }
    /**
     * Constructs the object.
     *
     * @param      question1       The question 1
     * @param      choices1        The choices 1
     * @param      correctAnswer1  The correct answer 1
     * @param      maxMarks1       The maximum marks 1
     * @param      penalty1        The penalty 1
     */
    Question(final String question1, final String[] choices1,
        final int correctAnswer1, final int maxMarks1, final int penalty1) {
        this.questiontext = question1;
        this.choices = choices1;
        this.correctAnswer = correctAnswer1;
        this.maxMarks = maxMarks1;
        this.penalty = penalty1;
    }
    /**
     * {Method to evaluate response}.
     *
     * @param      choice  The choice
     *
     * @return     {Boolean value}
     */
    public boolean evaluateResponse(final String choice) {
        return choice.equals(getResponse());
    }
    /**
     * Gets the correct answer.
     *
     * @return     The correct answer.
     */
    public String getCorrectAnswer() {
        return getChoice()[this.correctAnswer - 1];
    }
    /**
     * Gets the question text.
     *
     * @return     The question text.
     */
    public String getQuestionText() {
        return this.questiontext;
    }
    /**
     * Gets the choice.
     *
     * @return     The choice.
     */
    public String[] getChoice() {
        return this.choices;
    }
    /**
     * Gets the maximum marks.
     *
     * @return     The maximum marks.
     */
    public int getMaxMarks() {
        return this.maxMarks;
    }
    /**
     * Gets the penalty.
     *
     * @return     The penalty.
     */
    public int getPenalty() {
        return this.penalty;
    }
    /**
     * Sets the response.
     *
     * @param      answer  The answer
     */
    public void setResponse(final String answer) {
        this.response = answer;
    }
    /**
     * Gets the response.
     *
     * @return     The response.
     */
    public String getResponse() {
        return this.response;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "";
        return s;
    }
}
/**
 * Class for quiz.
 */
class Quiz {
    /**
     * {Variable for hundred}.
     */
    private final int onehundred = 100;
    /**
     * {Declaring a array of questions}.
     */
    private Question[] questions;
    /**
     * {Declaring a variable size}.
     */
    private int size;
    /**
     * Constructs the object.
     */
    Quiz() {
        questions = new Question[onehundred];
        size = 0;
    }
    /**
     * Adds a question.
     *
     * @param      q     The question
     */
    public void addQuestion(final Question q) {
        questions[size++] = q;
    }
    /**
     * Gets the question.
     *
     * @param      index  The index
     *
     * @return     The question.
     */
    public Question getQuestion(final int index) {
        return questions[index];
    }
    /**
     * Shows the report.
     *
     * @return     {String representation}
     */
    public String showReport() {
        String s = "";

        return s;
    }

}
/**
 * Solution class for code-eval.
 */
public final class Solution {
     /**
     * Constructs the object.
     */
    private Solution() {
        // leave this blank
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
         // instantiate this Quiz
        Quiz q = new Quiz();
         // code to read the test cases input file
        Scanner s = new Scanner(System.in);
        // check if there is one more line to process
        while (s.hasNext()) {
            // read the line
            String line = s.nextLine();
             // split the line using space
            String[] tokens = line.split(" ");
              // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "LOAD_QUESTIONS":
                System.out.println("|----------------|");
                System.out.println("| Load Questions |");
                System.out.println("|----------------|");
                loadQuestions(s, q, Integer.parseInt(tokens[1]));
                break;
                case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                startQuiz(s, q, Integer.parseInt(tokens[1]));
                break;
                case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                displayScore(q);
                break;
                default:
                break;
            }
        }
    }
    /**
     * Loads questions.
     *
     * @param      scan       The scan
     * @param      quiz       The quiz
     * @param      q          The question count
     *
     */
    public static void loadQuestions(final Scanner scan,
        final Quiz quiz, final int q) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        System.out.println(q + " " + "are added to the quiz");
        if (q > 0) {
            for (int i = 0; i < q; i++) {
                String[] tokens = scan.nextLine().split(":");
                String[] options = tokens[1].split(",");
                Question question = new Question(tokens[0], options, Integer.parseInt(tokens[2]),
                    Integer.parseInt(tokens[2 + 1]), Integer.parseInt(tokens[2 + 2]));
                if (tokens.length != 5) {
                    System.out.println("Error! Malformed question");
                } else if (options.length < 2) {
                    System.out.println(tokens[0] + "does not have enough answer choices");
                } else if (Integer.parseInt(tokens[2]) < 1 && Integer.parseInt(tokens[2]) > options.length) {
                    System.out.println("Error! Correct answer choice number is out of range for " + tokens[0]);
                } else if (Integer.parseInt(tokens[2 + 1]) < 0) {
                    System.out.println("Invalid max marks for " + tokens[0]);
                } else if (Integer.parseInt(tokens[2 + 2]) >= 0) {
                    System.out.println("Invalid penalty for " + tokens[0]);
                } else {
                    quiz.addQuestion(question);
                }
            }
        }
    }
    /**
     * Starts a quiz.
     *
     * @param      scan  The scan
     * @param      quiz  The quiz
     * @param      q     The answer count
     */
    public static void startQuiz(final Scanner scan,
        final Quiz quiz, final int q) {
        // write your code here to display the quiz questions on the console.
        // read the user responses from the console using scanner object.
        // store the user respone in the question object


    }
    /**
     * Displays the score report.
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report using quiz object.
        quiz.showReport();
    }
}
