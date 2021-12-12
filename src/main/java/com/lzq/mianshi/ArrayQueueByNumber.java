package com.lzq.mianshi;

public class ArrayQueueByNumber {
    private int Maxsize;
    private int arr[];
    private int front;//默认是0
    private int rear;//默认是0

    //构建函数
    public ArrayQueueByNumber(int arrMaxsize){
        Maxsize=arrMaxsize;
        arr=new int[Maxsize];
    }
    //判断数组是否时空
    public boolean isEmpty(){
        return rear==front;
    }

    //判断数组是否是满的
    public  boolean isFull(){
        return (rear+1)%Maxsize==front;
    }

    //为数组添加数据
    public void add(int n){
        if (isFull()){
            System.out.println("数组已经满了");
            return;
        }
        arr[rear]=n;
        rear=(rear+1)%Maxsize;
    }
    //删除数组数据
    public  int remove(){
        if (isEmpty()){
            new RuntimeException("数组是空的");
        }
        //先把数据值给一个局部变量
        int a=arr[front];
        front=(front+1)%Maxsize;
        return a;
    }

    //获取头数据
    public int  getHeadDate(){
        if (isEmpty()){
            new RuntimeException("数组是空的");
        }

        return arr[front];
    }
    //显示所有数据
    public  void allDate(){
        if (isEmpty()){
            new RuntimeException("数组是空的");
        }

        for (int i=front;i<front+size();i++){
            System.out.printf("arr[%d]=%d\n",i%Maxsize,arr[i%Maxsize]);
        }

    }

    //有效数据长度,(Maxsize-front+rear)%Maxsize  当rear<front时，长度是(maxsize-front)+(rear-0)
    public int size(){
        if (isEmpty()){
            return 0;
        }
        return (Maxsize-front+rear)%Maxsize;
    }
}
