package br.ufrn.taskexecutor;

import java.util.Queue;

import br.ufrn.taskexecutor.execution.Execution;
import br.ufrn.taskexecutor.execution.ReadExecution;
import br.ufrn.taskexecutor.execution.WriteExecution;

public class Worker extends Thread{
    private Queue<Task> tasks;
    private Queue<Result> results;

    public Worker(Queue<Task> tasks, Queue<Result> results) {
        this.tasks = tasks;
        this.results = results;
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
                execution = new ReadExecution();
            } else {
                // Tarefa de escrita
                execution = new WriteExecution();
            }

            // Executa a tarefa e adiciona o resultado à fila de resultados
            Result result = execution.executeTask(task);
            results.add(result);
        }
    }
}
