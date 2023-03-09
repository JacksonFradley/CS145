import java.util.Arrays;

public class LetterInventory {
    int size = 0;
    int[] lInv = new int[26];

    public LetterInventory(String data){
        data = data.toLowerCase();
        for(int i = 0; i < data.length(); i++){
            lInv[Character.valueOf(data.charAt(i)) - 97] = lInv[Character.valueOf(data.charAt(i)) -97] +1;
            size++;
        }
    }

    public int get(char letter){
        if(!Character.isLetter(letter)){
            System.out.println(letter);
            throw new IllegalArgumentException();
        }
        else {
            return lInv[Character.valueOf(letter)-97];
        }
    }

    public void set(char letter, int value){
        if(!Character.isLetter(letter) || value < 0){
            System.out.println(letter);
            throw new IllegalArgumentException();
        }
        else {
            letter = Character.toLowerCase(letter);
            size = size + value - lInv[Character.valueOf(letter)-97];
            lInv[Character.valueOf(letter)-97] = value;
        }
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return (size<=0);
    }

    public String toString(){
        String temp = "[";
        for(int i = 0 ; i < lInv.length; i++){
            for(int x=lInv[i]; x > 0; x--){
                temp += (char)(i+97);
            }
        }
        temp += "]";
        return temp;
    }

    public LetterInventory add(LetterInventory other){
        LetterInventory temp = new LetterInventory("");
        for(int i = 0 ; i < lInv.length; i++){
            temp.set((char)(i+97), lInv[i] + other.get((char)(i +97)));
        }
        return temp;
    }

    public LetterInventory subtract(LetterInventory other){
        LetterInventory temp = new LetterInventory("");
        for(int i = 0 ; i < lInv.length; i++){
            temp.set((char)(i+97), lInv[i] - other.get((char)(i +97)));
        }
        return temp;
    }
}
