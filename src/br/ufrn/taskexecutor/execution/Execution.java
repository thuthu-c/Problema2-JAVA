package br.ufrn.taskexecutor.execution;

import java.time.Duration;

import br.ufrn.taskexecutor.Result;
import br.ufrn.taskexecutor.Task; 

public class Execution {

    Task task; 
    Result result;

    public void hold(){
        int contime = 0; 
        while (task.getCost() > contime) {
         //wait();
            contime++; 
        }
    }


    public void read (){

    }


    public void fill (){
        
    }

    
    public Result executeTask(Task task) {
        Result result = null;
        try {
            
            Thread.sleep((long) (task.getCost() * 1000)); // Convertendo segundos para milissegundos

            result = new Result(task.getId(), 0, Duration.ofMillis(System.currentTimeMillis()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }
    
}
