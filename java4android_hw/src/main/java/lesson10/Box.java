package lesson10;

public class Box<E extends Fruit> {
    private E[] data;
    private int size;
    private int currentSize;

    public Box(int size) {
        this.size = size;
        this.data = (E[]) new Fruit[size];
        this.currentSize = 0;
    }

    public void add(E fruit){
        if(currentSize < size){
            this.data[currentSize] = fruit;
            this.currentSize++;
        }else{
            throw new BoxIsFullException();
        }
    }

    public void add(E... fruits){
        for(E fruit: fruits){
            this.add(fruit);
        }
    }

    public E get(int index){
        if(index < 0 || index > this.getCurrentSize()){
            throw new FruitNotFound(index);
        }
        return this.data[index];
    }

    public E pop(){
        if(this.isEmpty()){
            throw new BoxIsEmptyException();
        }
        E fruit = this.data[currentSize - 1];
        this.data[currentSize - 1] = null;
        this.currentSize--;
        return fruit;
    }

    public boolean isEmpty(){
        return currentSize == 0;
    }

    public float getWeight(){
        float weight = 0.0f;
        for(int i = 0; i < currentSize; i++){
            weight += this.get(i).getWeight();
        }
        return weight;
    }

    public boolean compare(Box<?> box){
        return this.getWeight() == box.getWeight();
    }

    public void getAllFruitsFromOtherBox(Box<E> box){
        if(box.getCurrentSize() > this.size - this.getCurrentSize()){
            throw new BoxIsFullException();
        }
        while(box.getCurrentSize() > 0){
            this.add(box.pop());
        }
    }

    public int getCurrentSize() {
        return currentSize;
    }

    @Override
    public String toString() {
        String str = "Box [";
        for(int i = 0; i < currentSize; i++){
            str += this.get(i).toString();
            if(i != currentSize - 1){
                str += ", ";
            }
        }
        str += "]";
        return str;
    }

    public void exchange(int index1, int index2){
        E fruit1 = this.get(index1);
        this.data[index1] = this.get(index2);
        this.data[index2] = fruit1;
    }

    protected E[] getData(){
        return this.data;
    }
}
