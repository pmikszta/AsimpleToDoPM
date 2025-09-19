package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskTest {

    private Task task1;
    private Task task2;

    @BeforeEach
    public void setUp() {
        task1 = new Task("First Task");
        task2 = new Task("Second Task");
    }

    @Test
    public void testAutoIncrementId() {
        // IDs should increment automatically
        assertTrue(task2.getId() > task1.getId(), "Task IDs should increment ");
    }

    @Test
    public void testNameGetterSetter() {
        assertEquals("First Task", task1.getName());

        task1.setName("Updated Task Name");
        assertEquals("Updated Task Name", task1.getName());
    }

    @Test
    public void testStatusDefaultAndComplete() {
        // Default status should be INCOMPLETE
        assertEquals(Task.Status.INCOMPLETE, task1.getStatus());

        // Mark as completed
        task1.complete();
        assertEquals(Task.Status.COMPLETED, task1.getStatus());

        // Using setter
        task1.setStatus(Task.Status.INCOMPLETE);
        assertEquals(Task.Status.INCOMPLETE, task1.getStatus());
    }

    @Test
    public void testToStringContainsIdNameAndStatus() {
        String str = task1.toString();
        assertTrue(str.contains(String.valueOf(task1.getId())));
        assertTrue(str.contains(task1.getName()));
        assertTrue(str.contains(task1.getStatus().toString()));
    }
}
