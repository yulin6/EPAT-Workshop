package sg.edu.nus.iss.epat.tdd.workshop;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ToDoListTest {
   private final String DESC1 = "desc 1";
   private final String DESC2 = "desc 2";
   private final String DESC3 = "desc 3";
   
   private Task task1;
   private Task task2;
   private Task task3;
   private ToDoList todoList;

   @Before
   public void setUp() throws Exception {
      task1 = new Task(DESC1);
      task2 = new Task(DESC2);
      task3 = new Task(DESC3);

      todoList = new ToDoList();
   }

   @After
   public void tearDown() throws Exception {
      // Put any clean up here
      // This project is simple and there are not much to clean
   }

   @Test
   public void testAddTask() {
      todoList.addTask(task1);
      assertEquals(1, todoList.getAllTasks().size());
      assertEquals(task1, todoList.getTask(DESC1));
   }

   @Test
   public void testGetStatus() {
      todoList.addTask(task1);
      assertEquals(false, todoList.getStatus(DESC1));
      todoList.completeTask(DESC1);
      assertEquals(true, todoList.getStatus(DESC1));
   }

   @Test
   public void testRemoveTask() {
      todoList.addTask(task1);
      todoList.addTask(task2);

      todoList.removeTask(DESC1);
      assertNull(todoList.getTask(DESC1));
      assertEquals(task2, todoList.getTask(DESC2));
   }

   @Test
   public void testGetCompletedTasks() {
      todoList.addTask(task1);
      todoList.addTask(task2);
      todoList.addTask(task3);
      
      todoList.completeTask(DESC1);
      todoList.completeTask(DESC3);

      Collection<Task> tasks = todoList.getCompletedTasks();
      assertEquals(2, tasks.size());
      assertTrue(tasks.contains(task1));
      assertFalse(tasks.contains(task2));
      assertTrue(tasks.contains(task3));
   }
}
