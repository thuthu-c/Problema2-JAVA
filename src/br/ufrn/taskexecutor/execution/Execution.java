package br.ufrn.taskexecutor.execution;
import java.time.Duration;

import br.ufrn.taskexecutor.Result;
import br.ufrn.taskexecutor.Task; 
import br.ufrn.taskexecutor.FileHandler; 
import br.ufrn.taskexecutor.Executor; 

public abstract class Execution {

    Task task; 
    Result result;
    Executor executor;
    long begin;

    public Execution(Task t, Executor e){
        // System.out.println("Gonna execute task " + t.getId());
        this.begin = System.currentTimeMillis();
        this.task = t;
        this.executor = e; 
    }

    public void hold(){
        try {
            Thread.sleep((long) (task.getCost() * 1000));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }


    public Integer read (){
       return FileHandler.getFileValueWithWait();
    }


    public void fill (int value){
        result = new Result(task.getId(), value, Duration.ofMillis(System.currentTimeMillis() - begin));
    }

    
    public abstract Result executeTask(Task task); 
    
}
