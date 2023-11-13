package br.ufrn.taskexecutor;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.List;

public  class Executor {
    private Queue<Task> tasks;
    private List<Worker> workers; 
    private static Lock lock;
    private boolean isWriting;
    
    public void lock(){
        lock.lock();
    }
    public void unlock(){
        lock.unlock();
    }

    public void set_writing(boolean isWriting){
        this.isWriting = isWriting;
    }

    public Task recover(){
        return tasks.remove();
    }

    public Executor(List<Worker> workers, Queue<Task> tasks){
        this.workers = workers;
        this.tasks = tasks;
    }

    public void dispatch(){
        while (!tasks.isEmpty()) {
            for(Worker w : workers){
                w.addTask(recover());
            }
        }
    }
    public boolean getWriting() {
        return false;
    }
    
}
