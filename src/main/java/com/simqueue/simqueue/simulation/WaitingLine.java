package com.simqueue.simqueue.simulation;


import java.util.*;



public class WaitingLine {

    //Variables
    Queue<Customer>line;


//Constructors
    public WaitingLine() {
        this.line=new ArrayDeque<>();
    }




//Methods
public boolean isEmpty(){
    return (line.isEmpty());
}

    
    
}
