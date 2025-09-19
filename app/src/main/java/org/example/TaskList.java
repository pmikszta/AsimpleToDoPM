package org.example;

public class TaskList {
    private String name;    // Name of the task list
    private Task[] tasks;
    private int size;

    // Constructor with name and capacity
    public TaskList(String name, int capacity) {
        this.name = name;
        tasks = new Task[capacity];
        size = 0;
    }

    // Add task to the list
    public void addTask(Task task) {
        if (size < tasks.length) {
            tasks[size++] = task;
        } else {
            System.out.println("Task list is full. Cannot add more tasks.");
        }
    }

    // Get task by index
    public Task getTask(int index) {
        if (index >= 0 && index < size) {
            return tasks[index];
        } else {
            throw new IndexOutOfBoundsException("Invalid task index");
        }
    }

    // Clear all tasks
    public void clear() {
        for (int i = 0; i < size; i++) {
            tasks[i] = null;
        }
        size = 0;
        System.out.println("All tasks cleared.");
    }

    // Display all tasks
    public void displayTasks() {
        if (size == 0) {
            System.out.println("No tasks in the list.");
            return;
        }
        System.out.println("Tasks in \"" + name + "\":");
        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + ". " + tasks[i]);
        }
    }

    // Show TaskList stats
    public void taskListStats() {
        int completed = 0;
        int incomplete = 0;
    //Simple check since there are only two options
        for (int i = 0; i < size; i++) {
            if (tasks[i].getStatus() == Task.Status.COMPLETED) {
                completed++;
            } else {
                incomplete++;
            }
        }

        System.out.println("\n\n--- TaskList Stats ---");
        System.out.println("Name: " + name);
        System.out.println("Total tasks: " + size);
        System.out.println("Completed tasks: " + completed);
        System.out.println("Incomplete tasks: " + incomplete);
        System.out.println("----------------------\n\n");
    }

    // Get completed tasks
    public Task[] getCompletedTasks() {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (tasks[i].getStatus() == Task.Status.COMPLETED) {
                count++;
            }
        }

        Task[] completedTasks = new Task[count];
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (tasks[i].getStatus() == Task.Status.COMPLETED) {
                completedTasks[index++] = tasks[i];
            }
        }
        return completedTasks;
    }

    // Get incomplete tasks
    public Task[] getIncompleteTasks() {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (tasks[i].getStatus() == Task.Status.INCOMPLETE) {
                count++;
            }
        }

        Task[] incompleteTasks = new Task[count];
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (tasks[i].getStatus() == Task.Status.INCOMPLETE) {
                incompleteTasks[index++] = tasks[i];
            }
        }
        return incompleteTasks;
    }

    // Get number of tasks
    public int getSize() {
        return size;
    }
}
