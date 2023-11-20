package br.ufrn.taskexecutor;

public class Task {
    int id;
    double cost;
    boolean type;
    short value;
    

    Task (int id, double cost, boolean type, short value){

        this.id = id; 
        this.cost = cost;
        this.type = type;
        this.value = value;

    }

    public double getCost() {
        return this.cost;
    }

    public int getId() {
        return this.id;
    }

    public short getValue() {
        return this.value;
    }

    public boolean getType(){
        return this.type; 
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public void setValue(short value){
        this.value = value;
    }
}
