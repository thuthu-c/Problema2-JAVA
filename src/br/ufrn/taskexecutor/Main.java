package br.ufrn.taskexecutor;

import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.ArrayList;
import java.util.Collections;

import java.util.Queue;
public class Main{
    
    public static void main(String[] args) {

        FileHandler.createFile();

        Scanner readInput = new Scanner(System.in);

        System.out.println("Digite a potência para número de tarefas: ");
        int N = readInput.nextInt();

        System.out.println("Digite o percentual de tarefas de escrita: ");
        int E = readInput.nextInt();

        

        ArrayList<Task> allTasks = new ArrayList<Task>();
        

        for(int i = 0; i < ((double)E/100.0)*Math.pow(10, N); ++i){
            double cost = Math.random()/100.0;
            short value = (short)(Math.random()*10);
            allTasks.add(new Task(i, cost, false, value));
        } 

        for(double i = ((double)E/100.0)*Math.pow(10, N); i < Math.pow(10, N) ; ++i){
            double cost = Math.random()/100.0;
            short value = (short)(Math.random()*10);
            allTasks.add(new Task((int)i, cost, true, value));
        }

        Collections.shuffle(allTasks);

        Queue<Task> tasksQueue = new ConcurrentLinkedQueue<Task>();

        for(Task task : allTasks){
            tasksQueue.add(task);
        }

        System.out.println("Digite o número de threads a serem criadas: ");
        int T = readInput.nextInt();
        readInput.close();
        CountDownLatch cdl = new CountDownLatch(T);
        // System.out.println("Começando em: "+ System.currentTimeMillis());
        long begin = System.currentTimeMillis();

        Executor executor = new Executor(T, tasksQueue, cdl);
        while (!executor.finished()) {
            executor.dispatch();
        }
        try {
            cdl.await();
        } catch (Exception e) {
            System.out.println("Ops! A thread foi interrompida");
        }
        
        System.out.println("Tempo gasto no processamento: ");
        System.out.println(System.currentTimeMillis() - begin);
        System.exit(0);
    }
}