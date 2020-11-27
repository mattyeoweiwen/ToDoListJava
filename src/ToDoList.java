import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;

public class ToDoList {
private HashMap<String, Task> tasks = new HashMap<String, Task>();

	public void addTask (Task task) {
		//Add code here
		tasks.put(task.getDescription(), task);
	}
	public void completeTask(String description) {
		// Add code here
		Task t = getTask(description);
		if ( t != null ) {
			t.setComplete(true);
		}
	}
	public boolean getStatus(String description) {
		//Add code here
		return getTask(description).isComplete();
	}
	public Task getTask(String description) {
		// Add code here
		return tasks.get(description);
	}
	public Task removeTask(String description) {
		// Add code here
		return tasks.remove(description);
	}
	public Collection<Task> getAllTasks() {
		return tasks.values();

	}
	public Collection<Task> getCompletedTasks() {
		// Add code here
		ArrayList<Task> taskList = new ArrayList<Task>();
		
		for (Entry<String, Task> es: tasks.entrySet()) {
			if(es.getValue().isComplete())
				taskList.add(es.getValue());
		}
		return taskList;
	}
}
