package br.ufrn.taskexecutor.execution;

import br.ufrn.taskexecutor.Result;
import br.ufrn.taskexecutor.Task;
import java.time.Duration;


public class ReadExecution extends Execution{

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