package br.ufrn.taskexecutor;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Executor {
    private Queue<Task> tasks;
    private List<Worker> workers; 
    private Lock lock;
    private boolean isWriting;
    
    public void lock(){
        lock.lock();
    }

    public void unlock(){
        lock.unlock();
    }

    public boolean finished(){
        return tasks.isEmpty();
    }

    public void set_writing(boolean isWriting){
        this.isWriting = isWriting;
    }

    public Task recover(){
        return tasks.remove();
    }

    public Executor(int numberOfWorkers, Queue<Task> tasks, CountDownLatch cdl){
        lock = new ReentrantLock();
        this.tasks = tasks;
        workers = new ArrayList<Worker>();
        
        for(int i = 0; i < numberOfWorkers; ++i){
            Worker w = new Worker(new ConcurrentLinkedQueue<Task>(), this, cdl);
            w.start();
            workers.add(w);
        }
        
    }

    public void dispatch(){
        while (!finished()){
            for(Worker w : workers){
                Task task = recover();
                w.addTask(task);
                if(finished()) break;
            }
        }
    }
    public boolean getWriting() {
        return isWriting;
    }
}
