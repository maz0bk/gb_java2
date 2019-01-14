package BigTask;

public class TestBox {
    public static void main(String[] args) {
        Box <Apple> boxAp = new Box<>();
        Box <Apple> boxAp2 = new Box<>();
        Box <Orange> boxOr1 = new Box<>();
        Box <Orange> boxOr2 = new Box<>();
        Box.fillBoxApples(boxAp);
        Box.fillBoxApples(boxAp2);
        Box.fillBoxOranges(boxOr1);
        Box.fillBoxOranges(boxOr2);

        System.out.println(boxAp.getWeight());
        System.out.println(boxAp2.getWeight());
        System.out.println(boxOr1.getWeight());
        System.out.println(boxOr2.getWeight());

        System.out.println(boxAp.compare(boxAp2));
        System.out.println(boxAp.compare(boxOr1));
        System.out.println(boxAp.compare(boxOr2));
        System.out.println(boxAp2.compare(boxOr1));
        System.out.println(boxAp2.compare(boxOr2));
        System.out.println(boxOr1.compare(boxOr2));

        boxAp.pourEnotherBox(boxAp2);
        boxOr1.pourEnotherBox(boxOr2);

        System.out.println(boxAp.getWeight());
        System.out.println(boxAp2.getWeight());
        System.out.println(boxOr1.getWeight());
        System.out.println(boxOr2.getWeight());

        System.out.println(boxAp2.compare(boxOr2));
    }

}
