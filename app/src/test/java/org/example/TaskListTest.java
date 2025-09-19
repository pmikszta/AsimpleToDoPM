package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskListTest {

    private TaskList taskList;

    @BeforeEach
    public void setUp() {
        taskList = new TaskList("Test List", 10);
    }

    @Test
    public void testAddTask() {
        Task task1 = new Task("Task 1");
        Task task2 = new Task("Task 2");

        taskList.addTask(task1);
        taskList.addTask(task2);

        assertEquals(2, taskList.getSize());
        assertEquals(task1, taskList.getTask(0));
        assertEquals(task2, taskList.getTask(1));
    }

    @Test
    public void testClear() {
        taskList.addTask(new Task("Task 1"));
        taskList.addTask(new Task("Task 2"));

        taskList.clear();

        assertEquals(0, taskList.getSize());
    }

    @Test
    public void testGetCompletedAndIncompleteTasks() {
        Task task1 = new Task("Task 1");
        Task task2 = new Task("Task 2");
        Task task3 = new Task("Task 3");

        task2.complete();

        taskList.addTask(task1);
        taskList.addTask(task2);
        taskList.addTask(task3);

        Task[] completed = taskList.getCompletedTasks();
        Task[] incomplete = taskList.getIncompleteTasks();

        assertEquals(1, completed.length);
        assertEquals(task2, completed[0]);

        assertEquals(2, incomplete.length);
        assertTrue(incomplete[0] == task1 || incomplete[0] == task3);
        assertTrue(incomplete[1] == task1 || incomplete[1] == task3);
    }

    @Test
    public void testTaskListStats() {
        Task task1 = new Task("Task 1");
        Task task2 = new Task("Task 2");

        task2.complete();

        taskList.addTask(task1);
        taskList.addTask(task2);

        // We can't directly assert printed output, but we can check counts
        assertEquals(2, taskList.getSize());

        Task[] completed = taskList.getCompletedTasks();
        Task[] incomplete = taskList.getIncompleteTasks();

        assertEquals(1, completed.length);
        assertEquals(1, incomplete.length);
    }

    @Test
    public void testGetTaskIndexOutOfBounds() {
        Task task = new Task("Task 1");
        taskList.addTask(task);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            taskList.getTask(5);
        });
    }
}
