/*
* Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.

 Constraints:
Methods pop, top and getMin operations will always be called on non-empty stacks.
* */

public class MinStack{

    private class StNode{
        StNode next;
        int val;
        public StNode(int val){
            this.val = val;
            this.next = null;
        }
        public StNode(){
        }
    }

   private StNode head;
    private int n;
    private int minVal = Integer.MAX_VALUE;

    public MinStack(){
        n = 0;
    }
    public void push(int x) {
        StNode oldHead = head;
        head = new StNode(x);
        if(n != 0){
            head.next = oldHead;
        }
        minVal = Math.min(minVal, x);
        n++;
    }

    public void pop() {
        int val = head.val;
        head = head.next;
        n--;
        if(minVal == val){
            minVal = Integer.MAX_VALUE;
            StNode cur = head;
            while(cur != null){
                minVal = Math.min(minVal, cur.val);
                cur = cur.next;
            }
        }
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return minVal;
    }
}