public class Tester {
    public static void main(String []args){
        WordSearchGenerator newWordSearch = new WordSearchGenerator();
        newWordSearch.generate("Apple");
        System.out.println(newWordSearch);
        System.out.println("\n\n\n\n");
        newWordSearch.generate("Baller");
        newWordSearch.generate("Space");
        newWordSearch.generate("Tycho");
        newWordSearch.generate("eyes");
        newWordSearch.generate("opal");
        newWordSearch.generate("Snakes");
        newWordSearch.generate("baby");

        System.out.println(newWordSearch);

    }
}
