import java.util.Scanner;
import java.util.Arrays;

/**
  * write your code below this comment
  */
class Task {
	private String taskTitle;
	private String performerName;
	private int completeTime;
	private boolean importance;
	private boolean urgency;
	private String status1;
	Task() {}
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
	public String getTitle() {
		return this.taskTitle;
	}
	public String getName() {
		return this.performerName;
	}
	public int getCompletionTime() {
		return this.completeTime;
	}
	public boolean getImportance() {
		return this.importance;
	}
	public boolean getUrgency() {
		return this.urgency;
	}
	public String getStatus() {
		return this.status1;
	}

	public String toString() {
		String str = "";
		str += getTitle() + "," + " " + getName() + ",";
		return str;
	}
}
class Todoist {
	Task[] tasks;
	private int size;
	Todoist() {
		this.tasks = new Task[10];
		this.size = 0;
	}
	public int getSize() {
		return size;
	}
	private void resize() {
		tasks = Arrays.copyOf(tasks, 2 * tasks.length);
	}
	public void addTask(Task task) {
		if (size == tasks.length) {
			resize();
		}
		tasks[size++] = task;
	}
	public Task[] getNextTask(final String s) {
		return tasks;
	}
	public Task[] getNextTask(final String s, final int k) {
		return tasks;
	}
	public int totalTime4Completion() {
		return 0;
	}
}
/**
 * Class for todoist main.
 */
public class TodoistMain {

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
        String assignedTo = tokens[2];
        int timeToComplete = Integer.parseInt(tokens[3]);
        boolean important = tokens[4].equals("y");
        boolean urgent = tokens[5].equals("y");
        String status = tokens[6];
        return new Task(
            title, assignedTo, timeToComplete, important, urgent, status);
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
