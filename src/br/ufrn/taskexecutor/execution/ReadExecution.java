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
        // System.out.println("Estou executando");
        while(executor.getWriting()){
            // System.out.println("estou no loop?");
        }; 
        // System.out.println("sai do while");
        hold();
        // System.out.println("segurei");
        fill(read());
        // System.out.println("acabei de ler");
        return result;
    }
    
}