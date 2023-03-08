public class Tester {
    public static void main(String []args){
        SearchTree tree = new SearchTree();
        tree.addNode(new Node(3));
        tree.addNode(new Node(5));
        tree.addNode(new Node(1));
        tree.addNode(new Node(6));
        tree.addNode(new Node(2));
        tree.printPre(tree.root);
        System.out.println("\n\n\n\n");
        tree.printIn(tree.root);
        System.out.println("\n\n\n\n");
        tree.printPost(tree.root);
        tree.deleteNode(5);
        System.out.println("\n\n\n\n");
        tree.printIn(tree.root);
    }

}
