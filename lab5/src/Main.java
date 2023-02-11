
public class Main {
    public static void main(String[] args) {
        LetterInventory george = new LetterInventory("george");
        System.out.println(george);
        System.out.println(george.size());
        System.out.println(george.get((char)101));
        george.set((char)101, 30);
        System.out.println(george);
        LetterInventory fradley = new LetterInventory("fradley");
        LetterInventory addition = george.add(fradley);
        System.out.println(addition);
        LetterInventory subtraction = addition.subtract(fradley);

    }
}