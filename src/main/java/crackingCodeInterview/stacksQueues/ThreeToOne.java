package crackingCodeInterview.stacksQueues;

/**
 * Describe how you could use a single array to implement three stacks.
 * Divide the array in slots of size n/3
 */
public class ThreeToOne {

    static class Stack {
        int[] values;
        int[] sizes;
        int stackCapacity;
        Stack(int size) {
            stackCapacity = size;
            values = new int[3 * size];
            sizes= new int[3];
        }
        public int pop(int stackNum) {
            if (isEmpty(stackNum)) {
                throw new RuntimeException("Empty Stack");
            }
            int top = indexOfTop(stackNum);
            int value= values[top]; 
            values[top] = 0; 
            sizes[stackNum]--;
            return value;
        }
        public void push(int stackNum, int value) {
            if (isFull(stackNum)) {
                throw new RuntimeException("Full Stack");
            }
            sizes[stackNum]++;
            values[indexOfTop(stackNum)] = value;
        }
        public int peek(int stackNum) {
            if (isEmpty(stackNum)) {
                throw new RuntimeException("Empty Stack");
            }
            return values[indexOfTop(stackNum)];
        }

        public boolean isEmpty(int stackNum) {
            return sizes[stackNum] == 0;
        }
        public boolean isFull(int stackNum) {
            return sizes[stackNum] == stackCapacity;
        }
        private int indexOfTop(int stackNum) {
            int offset= stackNum * stackCapacity;
            int size= sizes[stackNum];
            return offset+ size - 1;
        }
    }
    public static void main(String[] args) {
        var s = new Stack(24);
        s.push1(0);
    }
}
