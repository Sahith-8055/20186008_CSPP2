import java.util.Scanner;
import java.util.Arrays;

/**
  * @author Sahith.
  */

/**
 * Class for task.
 */
class Task {
    /**
     * {Title of the task}.
     */
    private String taskTitle;
    /**
     * {Name of the task performer}.
     */
    private String performerName;
    /**
     * {Time needed to complete the task}.
     */
    private int completeTime;
    /**
     * {Importance of the task}.
     */
    private boolean importance;
    /**
     * {Urgency of the task}.
     */
    private boolean urgency;
    /**
     * {Status of the task}.
     */
    private String status1;
    /**
     * Constructs the object.
     *
     * @param      title           The title
     * @param      assignedTo      The assigned to
     * @param      timeToComplete  The time to complete
     * @param      important       The important
     * @param      urgent          The urgent
     * @param      status          The status
     */
    Task(final String title, final String assignedTo,
         final int timeToComplete, final boolean important,
         final boolean urgent, final String status) {
        this.taskTitle = title;
        this.performerName = assignedTo;
        this.completeTime = timeToComplete;
        this.importance = important;
        this.urgency = urgent;
        this.status1 = status;
    }
    /**
     * Gets the title.
     *
     * @return     The title.
     */
    public String getTitle() {
        return this.taskTitle;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return this.performerName;
    }
    /**
     * Gets the completion time.
     *
     * @return     The completion time.
     */
    public int getCompletionTime() {
        return this.completeTime;
    }
    /**
     * Gets the importance.
     *
     * @return     The importance.
     */
    public String getImportance() {
        String str = "";
        if (this.importance) {
            str = "Important";
        } else {
            str = "Not Important";
        }
        return str;
    }
    /**
     * Gets the urgency.
     *
     * @return     The urgency.
     */
    public String getUrgency() {
        String str = "";
        if (this.urgency) {
            str = "Urgent";
        } else {
            str = "Not Urgent";
        }
        return str;
    }
    /**
     * Gets the status.
     *
     * @return     The status.
     */
    public String getStatus() {
        return this.status1;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String str = "";
        str += getTitle() + "," + " " + getName() + ",";
        str += " " + getCompletionTime() + "," + " " + getImportance() + ",";
        str += " " + getUrgency() + "," + " " + getStatus();
        return str;
    }
}
/**
 * Class for todoist.
 */
class Todoist {
    /**
     * {List of tasks}.
     */
    private Task[] tasks;
    /**
     * {Size of the tasks list}.
     */
    private int size;

    /**
     * Constructs the object.
     */
    Todoist() {
        final int x =10;
        this.tasks = new Task[x];
        this.size = 0;
    }

    /**
     * Gets the size.
     *
     * @return     The size.
     */
    public int getSize() {
        return size;
    }

    /**
     * {Resizes the List}.
     */
    private void resize() {
        tasks = Arrays.copyOf(tasks, 2 * tasks.length);
    }

    /**
     * Adds a task.
     *
     * @param      task  The task
     */
    public void addTask(final Task task) {
        if (size == tasks.length) {
            resize();
        }
        tasks[size++] = task;
    }

    /**
     * Gets the next task.
     *
     * @param      name  The name
     *
     * @return     The next task.
     */
    public Task getNextTask(final String name) {
        return null;
    }

    /**
     * Gets the next task.
     *
     * @param      s     { parameter_description }
     * @param      k     { parameter_description }
     *
     * @return     The next task.
     */
    public Task[] getNextTask(final String s, final int k) {
        return tasks;
    }

    /**
     * {Method to calcuate time for completion}.
     *
     * @return     {Total time for completion}
     */
    public int totalTime4Completion() {
        int total = 0;
        for (int i = 0; i < size; i++) {
            if (tasks[i].getStatus() == "todo") {
                total += tasks[i].getCompletionTime();
            }
        }
        return total;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String str = "";
        for (int i = 0; i < size; i++) {
            str += tasks[i].toString() + "\n";
        }
        return str;
    }
}
/**
 * Class for todoist main.
 */
public class TodoistMain {
    /**
     * Constructs the object.
     */
    private TodoistMain() {
        //Empty.
    }
    /**
     * Starts a test.
     */
    public static void startTest() {
        Todoist todo = new Todoist();
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(",");
            switch (tokens[0]) {
            case "task":
                testTask(tokens);
                break;
            case "add-task":
                testAddTask(todo, tokens);
                break;
            case "print-todoist":
                System.out.println(todo);
                break;
            case "get-next":
                System.out.println(todo.getNextTask(tokens[1]));
                break;
            case "get-next-n":
                int n = Integer.parseInt(tokens[2]);
                Task[] tasks = todo.getNextTask(tokens[1], n);
                System.out.println(Arrays.deepToString(tasks));
                break;
            case "total-time":
                System.out.println(todo.totalTime4Completion());
                break;
            default:
                break;
            }
        }
    }

    /**
     * method to test add task.
     *
     * @param      todo    The todo
     * @param      tokens  The tokens
     */
    public static void testAddTask(final Todoist todo, final String[] tokens) {
        try {
            todo.addTask(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * method to test the creation of task object.
     *
     * @param      tokens  The tokens
     */
    public static void testTask(final String[] tokens) {
        try {
            System.out.println(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates a task object.
     *
     * @param      tokens     The tokens
     *
     * @return     Task object
     *
     * @throws     Exception  if task inputs are invalid
     */
    public static Task createTask(final String[] tokens) throws Exception {
        String title = tokens[1];
        if (title.length() == 0) {
            throw new Exception ("Title not provided");
        }
        String assignedTo = tokens[2];
        int timeToComplete = Integer.parseInt(tokens[2 + 1]);
        if (timeToComplete < 0) {
            throw new Exception ("Invalid timeToComplete" + " " + timeToComplete);
        }
        boolean important = tokens[2 + 2].equals("y");
        boolean urgent = tokens[2 + 2 + 1].equals("y");
        String status = tokens[2 + 2 + 2];
        if (!(status.equals("todo") || status.equals("done"))) {
            throw new Exception ("Invalid status dud");
        }
        return new Task(
                   title, assignedTo, timeToComplete,
                   important, urgent, status);
    }

    /**
     * main method.
     *
     * @param      args  The command line arguments
     */
    public static void main(final String[] args) {
        startTest();
    }
}
