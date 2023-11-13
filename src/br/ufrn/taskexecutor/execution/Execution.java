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

    public Execution(Task t, Executor e){
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
       return FileHandler.getFileValue();
    }


    public void fill (){
        result = new Result(task.getId(), 0, Duration.ofMillis(System.currentTimeMillis()));
    }

    
    public abstract Result executeTask(Task task); 
    
}
