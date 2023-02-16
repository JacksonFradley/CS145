public class Tester {
    public static void main(String []args){
        WordSearchGenerator newWordSearch = new WordSearchGenerator();
        newWordSearch.generate("Apple");
        System.out.println(newWordSearch);
        System.out.println("\n\n\n\n");
        newWordSearch.increaseSize(5);
        System.out.println(newWordSearch);

    }
}
