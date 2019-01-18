package BigTask;

import java.util.ArrayList;
import java.util.Iterator;

public class Box <T extends Fruit>{
    private ArrayList <T> fruitList;

    public float getWeight(){
        if(fruitList.isEmpty()) return 0;
        return fruitList.get(0).getWeight()*fruitList.size();
    }
    public boolean compare (Box box){
        return Math.abs(getWeight() - box.getWeight()) < 0.0001;
    }
    public void addFruit (T fruit){
        fruitList.add(fruit);
    }
    public void pourEnotherBox(Box<? super T> secondBox) {
        if (fruitList.isEmpty()) return;

        Iterator<T> iter = fruitList.iterator();
        while (iter.hasNext()) {
            secondBox.addFruit(iter.next());
            iter.remove();
        }
    }

    public static void fillBoxApples(Box box){
        int max = (int)(6*Math.random());
        for (int i = 0; i < max; i++) {
            box.addFruit(new Apple());
        }
    }
    public static void fillBoxOranges(Box box){
        int max = (int)(6*Math.random());
        for (int i = 0; i < max; i++) {
            box.addFruit(new Orange());
        }
    }

    public Box() {
        fruitList = new ArrayList<>();
    }
}
