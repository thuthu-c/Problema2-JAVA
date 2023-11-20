package br.ufrn.taskexecutor;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;

import br.ufrn.taskexecutor.execution.Execution;
import br.ufrn.taskexecutor.Executor;
import br.ufrn.taskexecutor.execution.ReadExecution;
import br.ufrn.taskexecutor.execution.WriteExecution;

public class Worker extends Thread{
    private Queue<Task> tasks;
    private Queue<Result> results;
    private Executor executor;
    private CountDownLatch cdl;


    public Worker(Queue<Task> tasks, Executor executor, CountDownLatch cdl) {
        this.tasks = tasks;
        this.executor = executor;
        this.results = new ConcurrentLinkedQueue<Result>();
        this.cdl = cdl;
    }

    public void addTask(Task task){
        tasks.add(task);
    }

    @Override
    public void run() {
        
        while (true) {
            Task task = tasks.poll();
            if(task == null){
                // System.out.println("task == null");
                if (executor.finished()) {
                    // System.out.println("executor.finished()");
                    // System.out.println("Latch down by one!");
                    cdl.countDown();
                    break;
                }
                else continue;
            }
            Execution execution;
            if (task.getType()) {
                // Tarefa de leitura
                execution = new ReadExecution(task, executor);
            } else {
                // Tarefa de escrita
                execution = new WriteExecution(task, executor);
            }

            // Executa a tarefa e adiciona o resultado à fila de resultados
            Result result = execution.executeTask(task);
            results.add(result);
            // System.out.println("Tarefa feita!");
        }
    }
}
