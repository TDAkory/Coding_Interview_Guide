package _01_Stack.and.Queue;

import java.util.Stack;

/**
 * Created by Kory on 2017/9/12.
 */

/*
* attention:
* stackPush to stackPop , all data should move once;
* if stackPop.isEmpty() == False, can not move data from stackPush to stackPop;
* */

public class _02_ListByStack {
    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public _02_ListByStack(){
        stackPop = new Stack<Integer>();
        stackPush = new Stack<Integer>();
    }

    public add(int pushInt){
        stackPush.add(pushInt);
    }

    public int poll(){
        if(stackPop.isEmpty() && stackPush.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }else if(stackPop.isEmpty()){
            while(!stackPush.isEmpty()){
                stackPop.add(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public int peek(){
        if(stackPop.isEmpty() && stackPush.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }else if(stackPop.isEmpty()){
            while(!stackPush.isEmpty()){
                stackPop.add(stackPush.pop());
            }
        }
        return stackPop.peek();
    }
}
