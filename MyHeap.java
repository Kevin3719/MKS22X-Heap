import java.util.*;
public class MyHeap{
  private static void pushDown(int[]data,int size,int index){
    int maxindex = 0;
    int temp = 0;
    if (index * 2 + 1 >= size) {
      return;
    }
    else if (index * 2 + 2 >= size) {
      maxindex = index * 2 + 1;
    }
    else if (data[index * 2 + 1] > data[index * 2 + 2]) {
      maxindex = index * 2 + 1;
    }
    else {
      maxindex = index * 2 + 2;
    }
    temp = data[maxindex];
    if (data[maxindex] > data[index]) {
    data[maxindex] = data[index];
    data[index] = temp;
    pushDown(data,size,maxindex);
  }
  }
  private static void pushUp(int[]data,int size,int index){
    while (size > 0) {
      size -= 1;
      int temp = data[size];
      data[size] = data[0];
      data[0] = temp;
      pushDown(data,size,0);
    }
  }
  public static void heapify(int[]data) {
    int i = 1;
    while (i * 2 < data.length) {
      i *= 2;
    }
    for (;i > -1; i--) {
      pushDown(data,data.length,i);
    }
  }
  public static void heapsort(int[]data) {
    heapify(data);
    pushUp(data,data.length,0);
  }
  public static void printout(int[]data) {
    String output = "[";
    for (int i = 0; i < data.length; i++) {
      output += data[i];
      if(i != data.length - 1) {
        output += ",";
      }
    }
    output += "]";
    System.out.print(output);
  }
  public static void main(String[] args) {
    System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
  int[]MAX_LIST = {1000000000,500,10};
  for(int MAX : MAX_LIST){
    for(int size = 31250; size < 2000001; size*=2){
      long qtime=0;
      long btime=0;
      //average of 5 sorts.
      for(int trial = 0 ; trial <=5; trial++){
        int []data1 = new int[size];
        int []data2 = new int[size];
        for(int i = 0; i < data1.length; i++){
          data1[i] = (int)(Math.random()*MAX);
          data2[i] = data1[i];
        }
        long t1,t2;
        t1 = System.currentTimeMillis();
        heapsort(data2);
        t2 = System.currentTimeMillis();
        qtime += t2 - t1;
        t1 = System.currentTimeMillis();
        Arrays.sort(data1);
        t2 = System.currentTimeMillis();
        btime+= t2 - t1;
        if(!Arrays.equals(data1,data2)){
          System.out.println("FAIL TO SORT!");
          System.exit(0);
        }
      }
      System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    }
    System.out.println();
  }
  }
}
