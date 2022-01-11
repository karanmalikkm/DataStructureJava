/*
    Q) Write a basic code for push, pop, get and delete functions for a static array.
    Note:
    1. Array size can be increased based on push element calls.
    2. Do NOT use arraylist
 */
package Arrays.QuickReview;

import java.util.Arrays;

public class ArrayReview {
    private Object[] array;
    private int capacity;
    private int top;

    public ArrayReview(){
        capacity = 1;
        top = 0;
        array = new Object[1];
    }

    public Object get(int index){
        if(index>top || index<0){
            return null;
        }
        return array[index];
    }

    public Object pop(){
        if(top==-1){
            return null;
        }
        Object popped = array[top];
        array[top] = null;
        top--;
        return popped;
    }

    public void push(Object a){
        if(capacity==top+1){
            array = Arrays.copyOf(array,capacity*2);
            capacity *= 2;
        }
        array[top] = a;
        top++;
    }

    public Object delete(int index){
        if(index>top || index<0){
            return null;
        }
        Object item = array[index];
        System.arraycopy(array, index + 1, array, index, top - index);
        array[top] = null;
        top--;
        return item;
    }

    public static void main(String[] args) {
	 // write your code here
        ArrayReview obj = new ArrayReview();
        obj.push("Hello");
        obj.push("World");
        obj.push(1);
        obj.push(2);
        obj.delete(0);
        obj.pop();
        obj.pop();
        obj.delete(0);
        for(int i=0 ; i<obj.top ; i++){
            System.out.println(obj.get(i));
        }
    }
}
