import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public class Main {


    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.add(7);
        tree.add(3);
        tree.add(9);
        tree.add(2);
        tree.add(8);
        tree.add(1);
        tree.add(5);
        tree.add(4);
        tree.add(6);
        tree.add(11);
 //       List<Integer> dfsOrderItems = new ArrayList<>();
//        tree.dfs(dfsOrderItems::add);
//        tree.dfs(integer -> dfsOrderItems.add(integer));.
//        System.out.println(dfsOrderItems);
//        List<Integer> bfsOrderItems = new ArrayList<>();

//        tree.bfs(bfsOrderItems::add);
//        System.out.println(bfsOrderItems);
//        System.out.println(tree.size());
        System.out.println("Минимальное значение значение");
        System.out.println(tree.findFirst());
        System.out.println("Максимальное значение");
        System.out.println(tree.findLast());
//        System.out.println("Total Leaf Nodes = " +  tree.getChildrenCount());

//        List<Tree.Node> getChildrenCountOrderItems = new ArrayList<>();
        tree.getChildrenCount();
//
//        System.out.println(tree.contains(5));//true
//        System.out.println(tree.contains(2));//true
//        System.out.println(tree.contains(10));//true
//        System.out.println(tree.contains(-1));//false
//        System.out.println(tree.contains(4));//false
//        System.out.println(tree.findFirst()); //2
//        tree.remove(2);
//        System.out.println(tree.findFirst());//5
//        tree.remove(5);
//        System.out.println(tree.findFirst());//10
//        tree.remove(10);
//        System.out.println(tree.findFirst());
        //поиск в глубину dfs

        int leafNodes = tree.getChildrenCount(tree.root);
        System.out.println("Количество листьев = " + leafNodes);

    }

}