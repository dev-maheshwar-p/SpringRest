package algorithms.heaps;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class HeapClass<T> {

    ArrayList<T> dataList = new ArrayList<>();

    public static void main(String[] args) {

        HeapClass<String> hc = new HeapClass<>();


        hc.insert("AAB");
        hc.insert("AAC");
        hc.insert("AAA");
        hc.insert("AAF");
        hc.insert("AAE");

        System.out.println(hc.delete());
        System.out.println(hc.delete());

    }


    private void siftDown(){
        int parentIndex = 0;
        int leftChildIndex = (parentIndex * 2) + 1;

        while(leftChildIndex < dataList.size()){

            int maxOfChildren = leftChildIndex, rightChildIndex = leftChildIndex + 1;

            if(rightChildIndex < dataList.size()){

                String rightChildData = dataList.get(rightChildIndex).toString();
                String leftChildData = dataList.get(leftChildIndex).toString();

                if(rightChildData.compareTo(leftChildData) > 0 ){
                    maxOfChildren++;
                }
            }


            T parent = dataList.get(parentIndex);
            T child = dataList.get(maxOfChildren);

            String parentData = parent.toString();
            String childData = child.toString();

            if( parentData.compareTo(childData) < 0){
                dataList.set(maxOfChildren, parent);
                dataList.set(parentIndex, child);

                parentIndex = maxOfChildren;
                leftChildIndex = (maxOfChildren * 2) +1;
            } else{
                break;
            }
        }
    }

    public void insert(T data){
        dataList.add(data);
        siftUp();
    }

    public T delete() throws NoSuchElementException {
        if (dataList.size()==0) {
            throw new NoSuchElementException();
        }
        if(dataList.size()==1){
            return dataList.remove(0);
        }

        T topOftheHeap = dataList.get(0);

        dataList.set(0, dataList.remove(dataList.size()-1));
        siftDown();

        return topOftheHeap;
    }


    private void siftUp(){
        int index = dataList.size()-1;

        while(index>0){
            int parentIndex = (index-1)/2;

            T child = dataList.get(index);
            T parent = dataList.get(parentIndex);

            if(child.toString().compareTo(parent.toString())>0){
                dataList.set(index, parent);
                dataList.set(parentIndex, child);
            }else{
                break;
            }
        }
    }
}
