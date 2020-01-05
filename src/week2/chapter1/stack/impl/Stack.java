package week2.chapter1.stack.impl;

public interface Stack <Item> extends Iterable<Item>{

	void push(Item data);
	
	Item pop();
	
	int size();	
}