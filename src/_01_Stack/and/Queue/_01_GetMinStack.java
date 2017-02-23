package _01_Stack.and.Queue;

import java.util.Stack;

/* Design a Stack with the function getMin();
 * basic idea is using 2 stacks, stackData store data,
 * stackMin store min number;
 * There are two ways to approach, showing below:
*/

public class _01_GetMinStack {

}

/* 如果newNum比当前最小值大，则stackMin中不压入
*/
class Mystack1{
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;
	
	public Mystack1(){
		this.stackData= new Stack<>();
		this.stackMin = new Stack<>();
	}
	
	public void push(int newNum){
		if(this.stackMin.isEmpty()){
			this.stackMin.push(newNum);
		}else if(newNum<=this.getMin()){
			this.stackMin.push(newNum);
		}
		this.stackData.push(newNum);
	}
	
	public int pop(){
		if(this.stackData.isEmpty()){
			throw new RuntimeException("Stack is Empty");
		}
		int value = this.stackData.pop();
		if(value==this.getMin()){
			this.stackMin.pop();
		}
		return value;
		
	}
	
	public int getMin(){
		if(this.stackMin.isEmpty()){
			throw new RuntimeException("Stack is Empty");
		}
		return this.stackMin.peek();
	}
}


/* 如果newNum比但钱最小值大，则stackMin同步压入最小元素，即重复压入
*/
class MyStack2{
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;
	
	public MyStack2(){
		this.stackData= new Stack<>();
		this.stackMin = new Stack<>();
	}
	
	public void push(int newNum){
		if(this.stackMin.isEmpty()){
			this.stackMin.push(newNum);
		}else if(newNum<this.getMin()){
			this.stackMin.push(newNum);
		}else{
			int newMin=this.stackMin.peek();
			this.stackMin.push(newMin);
		}
		this.stackData.push(newNum);
		
	}
	
	public int pop(){
		if(this.stackData.isEmpty()){
			throw new RuntimeException("Stack is Empty");
		}
		this.stackMin.pop();
		return this.stackData.pop();
	}
	
	public int getMin(){
		if(this.stackMin.isEmpty()){
			throw new RuntimeException("Stack is Empty");
		}
		return this.stackMin.peek();
	}
}