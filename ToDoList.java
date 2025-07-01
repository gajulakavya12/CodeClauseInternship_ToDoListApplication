import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {

    static ArrayList<String> tasks = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String []args){
        
        while(true){
            System.out.println("***************************************************************");
            System.out.println("To Do List Application");
            System.out.println("***************************************************************");
            System.out.println("1). Add Task");
            System.out.println("2). Edit Task");
            System.out.println("3). Remove Task");
            System.out.println("4). View all Tasks");
            System.out.println("5). Quit");
            System.out.println("===============================================================");
            System.out.print("Enter Your Choice: ");
            int option;
            try {
                option = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch(option){
                case 1:
                    addTask();
                    break;
                case 2:
                    editTask();
                    break;
                case 3:
                    removeTask();
                    break;
                case 4:
                    displayTasks();
                    break;
                case 5:
                    System.out.println("Existing the To-Do List program.");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    public static void addTask(){
        System.out.println("***************************************************************");
        System.out.println("Enter Your Task: ");
        System.out.println("***************************************************************"); 
        String task = sc.nextLine();
        tasks.add(task);
        System.out.println("Task added Successfully");
    }

     public static void editTask() {
        displayTasks();
        if (tasks.isEmpty()) {
            return;
        }
        System.out.println("***************************************************************");
        System.out.println("Enter the task number you want to edit: ");
        System.out.println("***************************************************************");
        
        int taskNum;
        try {
            taskNum = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid task number.");
            return;
        }

        if (taskNum > 0 && taskNum <= tasks.size()) {
            System.out.print("Enter the new description for task " + taskNum + ": ");
            String newTask = sc.nextLine();
            tasks.set(taskNum - 1, newTask);
            System.out.println("Task updated successfully.");
        } else {
            System.out.println("Invalid Task Number");
        }
    }

    public static void removeTask(){
        System.out.println("***************************************************************");
        System.out.println("Enter task number to be deleted: ");
        System.out.println("***************************************************************");
        int taskNum;
        try {
            taskNum = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid task number.");
            return;
        }

        if (taskNum > 0 && taskNum <= tasks.size()) {
            tasks.remove(taskNum - 1);
            System.out.println("Task deleted Successfully");
        } else {
            System.out.println("Invalid Task Number");
        }

    }

    public static void displayTasks(){
        if(tasks.isEmpty()){
            System.out.println("No tasks to diplay");
        }
        else{
            for(int i = 0; i < tasks.size();  i++){
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

}