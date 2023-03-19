import java.util.Scanner;

public class Main{

    public static class StaticArrayList {
        int capacity;
        int[] list;
        int size;
        //constructors------------------------------------
        public StaticArrayList(int cap){
            this.capacity = cap;
            this.size = 0;
            this.list = new int[this.capacity];
        }
        public StaticArrayList(){
            this(5);
            this.size = 0;
        }
        //-------------------------------------------------
        public boolean isFull(){
            return size==capacity;
        }
        public boolean isEmpty(){
            return size==0;
        }
        public void pushBack(int value){
            if(!isFull()){
                this.list[size++] = value;
            }
            else{
                System.out.println("List is full");
            }
        }
        public int popBack(){
            int aux =0;
            if(!isEmpty()){
                aux =list[size-1];
                size--;
            }
            else{
                //System.out.println("Can't pop. List is empty");
            }
            return aux;
        }
        public void pushFront(int value){
            if(isFull()){
                System.out.println("List is full");
            }
            else{
                size++;
                for(int i=size-1;i>0;i--){
                    list[i] = list[i-1];
                }
                list[0] = value;
            }
        }
        public int popFront(){
            //System.out.println(size);
            int aux = list[0];
            for(int i=0;i<size-1;i++){
                list[i] = list[i+1];
            }
            size--;
            return aux;
        }

        public void printString(){
            if(this.size<=this.capacity){
                for(int i=0;i<size;i++){
                    System.out.print(this.list[i]);
                    if(!(i==size-1)){
                        System.out.print(" ");
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        String[] firstInput = read.nextLine().split(" ");
        String[] secondInput = read.nextLine().split(" ");
        StaticArrayList firstList = new StaticArrayList(firstInput.length);
        StaticArrayList secondList = new StaticArrayList(firstInput.length);
        for(String a:firstInput){
            int number = Integer.parseInt(a);
            firstList.pushBack(number);
        }
        for(String a:secondInput){
            int number = Integer.parseInt(a);
            secondList.pushBack(number);
        }
        StaticArrayList returnedFirst = new StaticArrayList(firstInput.length);
        StaticArrayList returnedSecond = new StaticArrayList(firstInput.length);
        for(int i=0;i<firstInput.length;i++){
            int popedFirst = firstList.popFront();
            int popedSecond = secondList.popBack();
            if(popedFirst!=popedSecond){
                returnedFirst.pushBack(popedFirst);
                returnedSecond.pushFront(popedSecond);
            }
        }
        returnedFirst.printString();
        System.out.print("\n");
        returnedSecond.printString();


    }
}