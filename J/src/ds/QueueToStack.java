package ds;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueToStack {

    Queue<Integer> q1 = new ArrayDeque();
    Queue<Integer> q2 = new ArrayDeque();
    public QueueToStack(){

    }
    public  void pop(int x){
        if(!q1.isEmpty() && q2.isEmpty()){
            q1.add(x);
        }
    }

}
