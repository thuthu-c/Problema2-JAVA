package br.ufrn.taskexecutor.execution;

import br.ufrn.taskexecutor.Executor;
import br.ufrn.taskexecutor.FileHandler;
import br.ufrn.taskexecutor.Result;
import br.ufrn.taskexecutor.Task;

public class WriteExecution extends Execution{
    
    public WriteExecution(Task t, Executor e) {
        super(t, e);
    }

    public Integer sum(){
    
        return task.getValue() + read(); 
    }

    public void write(int value){
        FileHandler.writeToFile(value);
    }

    

    @Override
    public Result executeTask(Task task) {
        // System.out.println("Executing a writing test!");
        executor.setWriting(true);
        executor.lock();
        // System.out.println("Writing test locked");
        hold();
        int value = sum();
        write(value);
        fill(value);
        // System.out.println("Writing test will unlock");
        executor.unlock();
        executor.setWriting(false);
        // System.out.println("Executed a writing test!");
        return result;
    }
}
