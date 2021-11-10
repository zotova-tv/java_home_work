package lesson7;

public class Plate {

    private int foodCount;

    public Plate(int foodCount) {
        this.foodCount = foodCount;
    }

    public void printInfo() {
        System.out.println("Количество еды в миске: " + foodCount);
    }

    public int decreaseFood(int catEatFoodCount) {
        // метод уменьшает количетво еды в тарелке и возвращает сколько еды съедено
        if (catEatFoodCount > this.foodCount) {
            int eatenCount = this.foodCount;
            this.foodCount = 0;
            return eatenCount;
        } else {
            this.foodCount -= catEatFoodCount;
            return catEatFoodCount;
        }
    }

    public int getFoodCount() {
        return foodCount;
    }

    public void addFood(int foodCount) {
        if(foodCount < 0){
            System.out.println("Забирать еду из миски нельзя!");
        }
        this.foodCount += foodCount;
    }
}
