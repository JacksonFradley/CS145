public class Towers {
    int height;
    int[] t1 = new int[height];
    int[] t2 = new int[height];
    int[] t3 = new int[height];

    public Towers(int h){
        height = h;

        for(int i = 0, x = height; x > 0; i++, x--){
            t1[x-1] = i;
        }
    }

    public String toString(){
        String temp = "";
        for(int x = height; x > 0; x--){
            temp += t1[x] + "    " + t2[x] + "    " + t3[x] + "\n";
        }
        return temp;
    }
}
