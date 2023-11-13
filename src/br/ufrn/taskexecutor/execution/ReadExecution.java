package br.ufrn.taskexecutor.execution;

import br.ufrn.taskexecutor.Result;
import br.ufrn.taskexecutor.Task;
import br.ufrn.taskexecutor.Executor;

public class ReadExecution extends Execution{
    
    public ReadExecution(Task t, Executor e){
        super(t, e);
    }

    @Override
    public Result executeTask(Task task) {
        Result result = null;
        while(executor.getWriting()); 
        hold();
        read();
        fill();
        return result;
    }
    
}