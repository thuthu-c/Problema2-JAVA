package br.ufrn.taskexecutor;

import java.util.Queue;

import br.ufrn.taskexecutor.execution.Execution;
import br.ufrn.taskexecutor.Executor;
import br.ufrn.taskexecutor.execution.ReadExecution;
import br.ufrn.taskexecutor.execution.WriteExecution;

public class Worker extends Thread{
    private Queue<Task> tasks;
    private Queue<Result> results;
    private Executor executor;


    public Worker(Queue<Task> tasks, Queue<Result> results) {
        this.tasks = tasks;
        this.results = results;
    }

    public void addTask(Task task){
        tasks.add(task);
    }

    @Override
    public void run() {
        while (true) {
            Task task = tasks.poll();
            if (task == null) {
                // Não há mais tarefas para executar
                break;
            }

            Execution execution;
            if (task.getType()) {
                // Tarefa de leitura
                execution = new ReadExecution(task, executor);
            } else {
                
                execution = new WriteExecution(task, executor);
            }

            // Executa a tarefa e adiciona o resultado à fila de resultados
            Result result = execution.executeTask(task);
            results.add(result);
        }
    }
}
