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
        executor.set_writing(true);
        executor.lock();
        
        Result result = null;

        hold();
        write(sum());
        fill();
        executor.unlock();
        executor.set_writing(false);
        return result;
    }
}
