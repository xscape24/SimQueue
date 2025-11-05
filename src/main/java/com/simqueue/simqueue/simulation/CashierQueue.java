package com.simqueue.simqueue.simulation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.*;


public class CashierQueue{
Queue<Customer>queue=new LinkedList<Customer>();
int queueID;
static int queueIDCounter=1;


//Constructors
CashierQueue(){
    this.queueID=queueIDCounter++;
}

    public CashierQueue(int queueID) {
        this.queueID = queueID;
    }




//Methods







}