import java.util.Collection;

import org.junit.*;
import org.junit.Test;
import junit.framework.*;


public class ToDoListTest extends TestCase{
	// Define Test Fixtures
	private ToDoList todo;
	
	public ToDoListTest() {
		super();
	}
	@Before
	 public void setUp() throws Exception{
		//Initialise Test Fixtures
		 todo = new ToDoList();
	}
	@After
	 public void tearDown() throws Exception{
		// Uninitialise test Fixtures
	}

	@Test
	public void testAddTask() {
		//ToDoList todo = new ToDoList();
		todo.addTask(new Task("Test task1"));
		
		Collection<Task> col = todo.getAllTasks();
		assertTrue("Expected collectioon to contain 1 task object", col.size() == 1);		
		
		Task[] tasks = new Task[] {};
		Task t = col.toArray(tasks)[0];
		
		assertEquals("Test task1", t.getDescription());		
	}
	
	@Test
	public void testgetStatus() {
		String description = "Test task1";
		todo.addTask(new Task(description, false));
		assertFalse("getStatus should return false", todo.getStatus(description));
		
		description = "Test task2";
		todo.addTask(new Task(description, true));
		assertTrue("getStatus should return true", todo.getStatus(description));
	}
	@Test
	public void testRemoveTask() {
		Task t = todo.removeTask("Test task1");
		assertNull("removeTask should return null", t);
		
		Task expected = new Task("Test task1", true);
		todo.addTask(expected);
		t = todo.removeTask("Test task1");
		assertSame("removeTask should return what was removed", expected, t);
	}
	@Test
	public void testGetCompletedTasks() {
		assertEquals("getCompletedTasks should return 0 completed task", todo.getCompletedTasks().size(), 0);
		
		todo.addTask(new Task("Test task1", true));
		todo.addTask(new Task("Test task2", false));
		todo.addTask(new Task("Test task3", true));
		assertEquals("getCompletedTasks should return 2 completed tasks", todo.getCompletedTasks().size(), 2);
	}
}
