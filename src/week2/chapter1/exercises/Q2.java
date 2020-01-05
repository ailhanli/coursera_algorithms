package week2.chapter1.exercises;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * Stack with max. Create a data structure that efficiently supports the stack operations (push and pop) 
 * and also a return-the-maximum operation. 
 * Assume the elements are real numbers so that you can compare them.
 * @author Abdullah
 *
 */
public class Q2 {

	private Stack<Integer> s = new Stack<>();
	
	private Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	
	public void push(Integer n){
		s.push(n);
		pq.add(n);
	}
	
	public Integer pop(){
		if(s.isEmpty()){
			throw new IllegalAccessError();
		}
		
		Integer r = s.pop();
		if(r==pq.peek()){
			pq.poll();
		}
		return r;
	}
	
	public Integer max(){
		return pq.peek();
	}
	
	public static void main(String[] args) {
		Q2 q = new Q2();
		q.push(100);
		q.push(45);
		q.push(500);
		q.pop();
		q.push(1000);
		
		System.out.println(q.max());
		
		q.pop();
		System.out.println(q.max());
	}
}