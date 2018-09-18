import java.util.Scanner;
// import java.text.SimpleDateFormat;

/**
 * Class for food log.
 */
class FoodLog {
    private String fooditemName;
    private int quantity;
    private String time;
    private String date;
    /**
     * Constructs the object.
     */
    FoodLog() {
        //Empty.
    }

    /**
     * Constructs the object.
     *
     * @param      name   The name
     * @param      q      The quarter
     * @param      date1  The date 1
     * @param      time1  The time 1
     */
    FoodLog(final String name, final int q, final String date1, final String time1) {
        this.fooditemName = name;
        this.quantity = q;
        this.date = date1;
        this.time = time1;
    }

    /**
     * Gets the food name.
     *
     * @return     The food name.
     */
    public String getFoodName() {
        return this.fooditemName;
    }

    /**
     * Gets the quantity.
     *
     * @return     The quantity.
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * Gets the time.
     *
     * @return     The time.
     */
    public String getTime() {
        return this.time;
    }

    /**
     * Gets the date.
     *
     * @return     The date.
     */
    public String getDate() {
        return this.date;
    }

    /**
     * Sets the food name.
     *
     * @param      name1  The name 1
     */
    public void setFoodName(final String name1) {
        this.fooditemName = name1;
    }

    /**
     * Sets the quantity.
     *
     * @param      q1    The quarter 1
     */
    public void setQuantity(final int q1) {
        this.quantity = q1;
    }

    /**
     * Sets the time.
     *
     * @param      time2  The time 2
     */
    public void setTime(final String time2) {
        this.time = time2;
    }

    /**
     * Sets the date.
     *
     * @param      date2  The date 2
     */
    public void setDate(final String date2) {
        this.date = date2;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String str = "Food" + "\n";
        str += "Date :" + getDate() + "\n";
        str += "Time :" + getTime() + "\n";
        str += "Name :" + getFoodName() + "\n";
        str += "Quantity :" + getQuantity();
        return str;
    }
}

/**
 * Class for water log.
 */
class WaterLog {
    private String quantity;
    private String timeDate;
    /**
     * Constructs the object.
     */
    WaterLog() {
        //Empty.
    }
    /**
     * Constructs the object.
     *
     * @param      q1     The quarter 1
     * @param      time1  The time 1
     */
    WaterLog(final String q1, final String time1) {
        this.quantity = q1;
        this.timeDate = time1;
    }

    /**
     * Gets the water quantity.
     *
     * @return     The water quantity.
     */
    public String getWaterQuantity() {
        return this.quantity;
    }

    /**
     * {Gets the date and time}
     *
     * @return     {date and time}
     */
    public String gettimeDate() {
        return this.timeDate;
    }

    /**
     * Sets the water quantity.
     *
     * @param      quan  The quan
     */
    public void setWaterQuantity(final String quan) {
        this.quantity = quan;
    }

    /**
     * Sets the time date.
     *
     * @param      time  The time
     */
    public void setTimeDate(final String time) {
        this.timeDate = time;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String str = "Water" + "\n";
        str += "Date :" + gettimeDate() + "\n";
        str += "Quantity :" + getWaterQuantity() + "ml";
        return str;
    }
}

/**
 * Class for activity log.
 */
class ActivityLog {
    private String activityName;
    private String date;
    private String startTime;
    private String endTime;
    private String notes;

    /**
     * Constructs the object.
     */
    ActivityLog() {

    }

    /**
     * Constructs the object.
     *
     * @param      aN     Activity name
     * @param      n      {notes}
     * @param      date1  The date1
     * @param      sT     The start time
     * @param      eT     The end time
     */
    ActivityLog(final String aN, final String n, final String date1,
        final String sT, final String eT) {
        this.activityName = aN;
        this.notes = n;
        this.date = date1;
        this.startTime = sT;
        this.endTime = eT;
    }

    /**
     * Gets the activity name.
     *
     * @return     The activity name.
     */
    public String getActivityName() {
        return this.activityName;
    }

    /**
     * Gets the date.
     *
     * @return     The date.
     */
    public String getDate() {
        return this.date;
    }

    /**
     * Gets the start time.
     *
     * @return     The start time.
     */
    public String getStartTime() {
        return this.startTime;
    }

    /**
     * Gets the end time.
     *
     * @return     The end time.
     */
    public String getEndTime() {
        return this.endTime;
    }

    /**
     * Gets the notes.
     *
     * @return     The notes.
     */
    public String getNotes() {
        return this.notes;
    }

    /**
     * Sets the activity name.
     *
     * @param      name  The name
     */
    public void setActivityName(final String name) {
        this.activityName = name;
    }

    /**
     * Sets the date.
     *
     * @param      date1  The date 1
     */
    public void setDate(final String date1) {
        this.date = date1;
    }

    /**
     * Sets the start time.
     *
     * @param      start  The start
     */
    public void setStartTime(final String start) {
        this.startTime = start;
    }

    /**
     * Sets the end time.
     *
     * @param      end   The end
     */
    public void setEndTime(final String end) {
        this.endTime = end;
    }

    /**
     * Sets the notes.
     *
     * @param      note  The note
     */
    public void setNotes(final String note) {
        this.notes = note;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String str = "PhysicalActivity" + "\n";
        str += "Name :" + getActivityName() + "\n";
        str += "Notes :" + getNotes() + "\n";
        str += "Date :" + getDate() + "\n";
        str += "Starttime :" + getStartTime() + "\n";
        str += "Endtime :" + getEndTime();
        return str;
    }
}

/**
 * Class for sleep log.
 */
class SleepLog {
    private String date;
    private String startTime;
    private String endTime;

    /**
     * Constructs the object.
     */
    SleepLog() {
        //Empty.
    }

    /**
     * Constructs the object.
     *
     * @param      date1  The date1
     * @param      sT     The start time
     * @param      eT     The end time
     */
    SleepLog(final String date1, final String sT, final String eT) {
        this.date = date1;
        this.startTime = sT;
        this.endTime = eT;
    }

    /**
     * Gets the start time.
     *
     * @return     The start time.
     */
    public String getStartTime() {
        return this.startTime;
    }

    /**
     * Gets the end time.
     *
     * @return     The end time.
     */
    public String getEndTime() {
        return this.endTime;
    }

    /**
     * Gets the date.
     *
     * @return     The date.
     */
    public String getDate() {
        return this.date;
    }

    /**
     * Sets the start time.
     *
     * @param      startT  The start t
     */
    public void setStartTime(final String startT) {
        this.startTime = startT;
    }

    /**
     * Sets the end time.
     *
     * @param      endT  The end t
     */
    public void setEndTime(final String endT) {
        this.endTime = endT;
    }

    /**
     * Sets the date.
     *
     * @param      date2  The date 2
     */
    public void setDate(final String date2) {
        this.date = date2;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String str = "Sleep" + "\n";
        str += "Date :" + getDate() + "\n";
        str += "Starttime :" + getStartTime() + "\n";
        str += "Endtime :" + getEndTime() + "\n";
        return str;
    }
}

/**
 * Class for weight log.
 */
class WeightLog {
    private String startDate;
    private String startTime;
    private String weight;
    private String fat;

    /**
     * Constructs the object.
     */
    WeightLog() {
        //Empty.
    }

    /**
     * Constructs the object.
     *
     * @param      startD  The start date
     * @param      startT  The start time
     * @param      w       {weight of the person}
     * @param      fat1    The fat1
     */
    WeightLog(final String startD, final String startT,
        final String w, final String fat1) {
        this.startDate = startD;
        this.startTime = startT;
        this.weight = w;
        this.fat = fat1;
    }

    /**
     * Gets the weight.
     *
     * @return     The weight.
     */
    public String getWeight() {
        return this.weight;
    }

    /**
     * Gets the fat.
     *
     * @return     The fat.
     */
    public String getFat() {
        return this.fat;
    }

    /**
     * {Gets the date}.
     *
     * @return     {Date}
     */
    public String getstartDate() {
        return this.startDate;
    }

    /**
     * {Gets the time}.
     *
     * @return     {Time}
     */
    public String getstartTime() {
        return this.startTime;
    }

    /**
     * Sets the weight.
     *
     * @param      w1    The w 1
     */
    public void setWeight(final String w1) {
        this.weight = w1;
    }

    /**
     * Sets the fat.
     *
     * @param      fat2  The fat 2
     */
    public void setFat(final String fat2) {
        this.fat = fat2;
    }

    /**
     * {Sets the date}.
     *
     * @param      startD1  The start d 1
     */
    public void setstartDate(final String startD1) {
        this.startDate = startD1;
    }

    /**
     * Sets the start time.
     *
     * @param      startT1  The start t 1
     */
    public void setStartTime(final String startT1) {
        this.startTime = startT1;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String str = "Weight" + "\n";
        str += "Date :" + getstartDate() + "\n";
        str += "Time :" + getstartTime() + "\n";
        str += "Weight :" + getWeight() + "KG" + "\n";
        str += "Fat :" + getFat();
        return str;
    }
}

/**
 * Class for fit byte.
 */
class FitByte {
    private List<ActivityLog> activitiesLog;
    private List<WaterLog> waterLogs;
    private List<FoodLog> foodLogs;
    private List<SleepLog> sleepLogs;
    private List<WeightLog> weightLogs;

    /**
     * Constructs the object.
     */
    FitByte() {
        activitiesLog = new List<ActivityLog>();
        waterLogs = new List<WaterLog>();
        foodLogs = new List<FoodLog>();
        sleepLogs = new List<SleepLog>();
        weightLogs = new List<WeightLog>();
    }

    /**
     * Gets the water log.
     *
     * @return     The water log.
     */
    public List<WaterLog> getWaterLog() {
        return waterLogs;
    }

    /**
     * Gets the food log.
     *
     * @return     The food log.
     */
    public List<FoodLog> getFoodLog() {
        return foodLogs;
    }

    /**
     * Gets the sleep log.
     *
     * @return     The sleep log.
     */
    public List<SleepLog> getSleepLog() {
        return sleepLogs;
    }

    /**
     * Gets the activity log.
     *
     * @return     The activity log.
     */
    public List<ActivityLog> getActivityLog() {
        return activitiesLog;
    }

    /**
     * Gets the weight log.
     *
     * @return     The weight log.
     */
    public List<WeightLog> getWeightLog() {
        return weightLogs;
    }

    /**
     * Adds a food item.
     *
     * @param      food  The food
     */
    public void addFood(FoodLog food) {
        foodLogs.add(food);
    }

    /**
     * Adds a water item.
     *
     * @param      water  The water
     */
    public void addWater(WaterLog water) {
        waterLogs.add(water);
    }

    /**
     * Adds an activity item.
     *
     * @param      activity  The activity
     */
    public void addActivity(ActivityLog activity) {
        activitiesLog.add(activity);
    }

    /**
     * Adds a sleep item.
     *
     * @param      sleep  The sleep
     */
    public void addSleep(SleepLog sleep) {
        sleepLogs.add(sleep);
    }

    /**
     * Adds a weight item.
     *
     * @param      weight  The weight
     */
    public void addWeight(WeightLog weight) {
        weightLogs.add(weight);
    }

    /**
     * Gets the summary.
     */
    public void getSummary() {
        System.out.println(getFoodLog());
        System.out.println(getWaterLog());
        System.out.println(getActivityLog());
        System.out.println(getWeightLog());
        System.out.println(getSleepLog());
    }

    /**
     * Gets the summary on a particular date.
     */
    public void getDSummary(final String date) {
        for (int i = 0; i < foodLogs.size(); i++) {
            if (foodLogs.get(i).getDate().equals(date)) {
                System.out.println(foodLogs.get(i));
            }
        }
        for (int i = 0; i < waterLogs.size(); i++) {
            if (waterLogs.get(i).gettimeDate().equals(date)) {
                System.out.println(waterLogs.get(i));
            }
        }
        for (int i = 0; i < sleepLogs.size(); i++) {
            if (sleepLogs.get(i).getDate().equals(date)) {
                System.out.println(sleepLogs.get(i));
            }
        }
        for (int i = 0; i < weightLogs.size(); i++) {
            if (weightLogs.get(i).getstartDate().equals(date)) {
                System.out.println(weightLogs.get(i));
            }
        }
        for (int i = 0; i < activitiesLog.size(); i++) {
            if (activitiesLog.get(i).getDate().equals(date)) {
                System.out.println(activitiesLog.get(i));
            }
        }
    }
}

/**
 * Class for solution.
 */
public class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Empty.
    }
    /**
     * {Main method}.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        FitByte fit = new FitByte();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(" ");
            switch (tokens[0]) {
                case "Food":
                    String[] logs = tokens[1].split(",");
                    FoodLog food = new FoodLog(
                        logs[0], Integer.parseInt(logs[1]), logs[2], logs[3]);
                    fit.addFood(food);
                break;
                case "Water":
                    logs = tokens[1].split(",");
                    WaterLog water = new WaterLog(logs[0], logs[1]);
                    fit.addWater(water);
                break;
                case "Sleep":
                    logs = tokens[1].split(",");
                    SleepLog sleep = new SleepLog(logs[0], logs[1], logs[2]);
                    fit.addSleep(sleep);
                break;
                case "PhysicalActivity":
                    logs = tokens[1].split(",");
                    ActivityLog activity = new ActivityLog(logs[0], logs[1],
                        logs[2], logs[3], logs[4]);
                    fit.addActivity(activity);
                break;
                case "Weight":
                    logs = tokens[1].split(",");
                    WeightLog weight = new WeightLog(logs[0], logs[1],
                        logs[2], logs[3]);
                    fit.addWeight(weight);
                break;
                case "Foodlog":
                    System.out.println(fit.getFoodLog());
                break;
                case "Waterlog":
                    System.out.println(fit.getWaterLog());
                break;
                case "Sleeplog":
                    System.out.println(fit.getSleepLog());
                break;
                case "Weightlog":
                    System.out.println(fit.getWeightLog());
                break;
                case "PhysicalActivitylog":
                    if (fit.getActivityLog().size() == 0) {
                        System.out.println("None");
                    } else {
                        System.out.println(fit.getActivityLog());
                    }
                break;
                case "Summary":
                    if (tokens.length == 1) {
                        fit.getSummary();
                    } else {
                        fit.getDSummary(tokens[1]);
                    }
                default:
                break;
            }
        }
    }
}
