package org.example;

public class Task {
    // two options for status
    public enum Status {
        INCOMPLETE,
        COMPLETED
    }

    private static int nextId = 1; // Class variable to track the next ID

    private int id;          // Unique ID
    private String name;     // Task name
    private Status status;   // Task status (Completed or Incomplete)

    // Constructor
    public Task(String name) {
        this.id = nextId++;        // Assign current value, then increment gives an easy way to select a task
        this.name = name;
        this.status = Status.INCOMPLETE;  // Default status 
    }

    // --- Getters and Setters ---

    // ID (read-only)
    public int getId() {
        return id;
    }

    // Name
    public String getName() {
        return name;
    }
    // Setname
    public void setName(String name) {
        this.name = name;
    }

    // Status
    public Status getStatus() {
        return status;
    }
    // redunant Status i tested with
    public void setStatus(Status status) {
        this.status = status;
    }

    // Mark task as completed
    public void complete() {
        this.status = Status.COMPLETED;
    }

    // Mark task as completed
    public void incomplete() {
        this.status = Status.INCOMPLETE;
    }

    // Formating for task to make it more readable 
    @Override
    public String toString() {
        return "Task ID: " + id + " | " + name + " | Status: " + status;
    }
}
