public class MyHeap{
  private static void pushDown(int[]data,int size,int index){

  }
  private static void pushUp(int[]data,int index){
    int maxindex = 0;
    int temp = 0;
    if (index * 2 + 1 >= data.length) {
      return;
    }
    else if (index * 2 + 2 >= data.length) {
      maxindex = index * 2 + 1;
    }
    else if (data[index * 2 + 1] > data[index * 2 + 2]) {
      maxindex = index * 2 + 1;
    }
    else {
      maxindex = index * 2 + 2;
    }
    temp = data[maxindex];
    data[maxindex] = data[index];
    data[index] = temp;
    pushUp(data,maxindex);
  }
  public static void heapify(int[]data) {
    int i = 1;
    while (i * 2 < data.length) {
      i *= 2;
    }
    System.out.println(i);
    for (;i > -1; i--) {
      pushUp(data,i);
    }
  }
  public static void heapsort(int[]data) {}
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
    int[] a = {3,1,5,4};
    heapify(a);
    printout(a);
  }
}
