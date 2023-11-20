package br.ufrn.taskexecutor;

import java.time.*;

public class Result{
    int id;
    int result;
    Duration time;

    public Result(int id, int result, Duration time){
        this.id = id; 
        this.result = result;  
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public int getResult() {
        return result;
    }

    public Duration getTime() {
        return time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setResult(int result) {
        this.result = result;
    }
    public void setTime(Duration time) {
        this.time = time;
    }
}