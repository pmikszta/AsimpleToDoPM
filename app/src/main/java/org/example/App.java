package org.example;

import java.util.Scanner;


public class App {
    public static void main(String[] args) {

      // Create Scanner 
        Scanner scanner = new Scanner(System.in);
        TaskList taskList = new TaskList("My Task List", 50); // auto-create TaskList

        int choice = 0;
        do {
          // Print Main Menu
            System.out.println("\n===== Task List Menu =====");
            System.out.println("1. Add Task");
            System.out.println("2. Modify Task");
            System.out.println("3. Clear Task List");
            System.out.println("4. Show All Tasks");
            System.out.println("5. Show Completed Tasks");
            System.out.println("6. Show Incomplete Tasks");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            // Validate input to ensure it is an integer
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); 
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 7.");
                scanner.nextLine(); 
                continue;
            }

            switch (choice) {
              //Create Task
                case 1:
                    System.out.print("Enter task name: ");
                    String taskName = scanner.nextLine();
                    taskList.addTask(new Task(taskName));
                    System.out.println("Task added.");
                    break;

                case 2:
                //Simple submenu that first asks for the task then modifies it based on three options
                    if (taskList.getSize() == 0) {
                        System.out.println("No tasks to modify.");
                        break;
                    }
                    taskList.displayTasks();
                    System.out.print("Enter task number to modify: ");
                    if (scanner.hasNextInt()) {
                        int index = scanner.nextInt() - 1;
                        scanner.nextLine(); 
                        try {
                            Task task = taskList.getTask(index);
                            System.out.println("Selected: " + task);
                            System.out.println("1. Change name");
                            System.out.println("2. Mark as completed");
                            System.out.println("3. Mark as incompleted");
                            System.out.print("Choose an option: ");
                            if (scanner.hasNextInt()) {
                                int modChoice = scanner.nextInt();
                                scanner.nextLine(); 

                                if (modChoice == 1) {
                                    System.out.print("Enter new name: ");
                                    String newName = scanner.nextLine();
                                    task.setName(newName);
                                    System.out.println("Task updated.");
                                } else if (modChoice == 2) {
                                    task.complete();
                                    System.out.println("Task marked as completed.");
                                } else if (modChoice == 3) {
                                    task.incomplete();
                                    System.out.println("Task marked as incomplete.");
                                } else {
                                    System.out.println("Invalid option.");
                                }
                            } else {
                                System.out.println("Invalid input. Returning to main menu.");
                                scanner.nextLine(); 
                            }
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Invalid task number.");
                        }
                    } else {
                        System.out.println("Invalid input. Returning to main menu.");
                        scanner.nextLine(); 
                    }
                    break;


                case 3:
                  //Wipes Tasklist
                    taskList.clear();
                    break;

                case 4:
                  //Displays all tasks
                    taskList.displayTasks();
                    break;

                case 5:
                    //Displays Completed Tasks
                    Task[] completed = taskList.getCompletedTasks();
                    if (completed.length == 0) {
                        System.out.println("No completed tasks.");
                    } else {
                        System.out.println("Completed tasks:");
                        for (Task t : completed) {
                            System.out.println(t);
                        }
                    }
                    break;

                case 6:
                    //Displays incomplete Tasks
                    Task[] incomplete = taskList.getIncompleteTasks();
                    if (incomplete.length == 0) {
                        System.out.println("No incomplete tasks.");
                    } else {
                        System.out.println("Incomplete tasks:");
                        for (Task t : incomplete) {
                            System.out.println(t);
                        }
                    }
                    break;

                case 7:
                //exit
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 7);

        scanner.close();
    }
}
