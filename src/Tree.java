import java.util.*;
import java.util.function.Consumer;

//import static sun.net.www.http.KeepAliveCache.result;

public class Tree {
    public void getChildrenCount() {
        return ;
    }

    public class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    Node root;// первое значение 7

    public void add(int value) {
        // затем вставляем value = 3
        root = appendNode(root, value);

    }

    private Node appendNode(Node current, int value) {
        if (current == null) {
            return new Node(value);// вставится здесь 3
        }
        if (current.value > value) {
            current.left = appendNode(current.left, value);
        } else if (current.value < value) {
            current.right = appendNode(current.right, value);
        }
        return current;
    }

    public boolean contains(int value) {
        return findNode(root, value) != null;
    }

    private Node findNode(Node current, int value) {
        if (current == null) {
            return null;
        }
        if (current.value > value) {
            return findNode(current.left, value);
        } else if (current.value < value) {
            return findNode(current.right, value);

        }
        return current;
    }

    public void remove(int value) {
        root = removeNode(root, value);

    }

    private Node removeNode(Node current, int value) {
        if (current == null) {
            return null;
        }
        if (current.value > value) {
            current.left = removeNode(current.left, value);
            return current;
        } else if (current.value < value) {
            current.right = removeNode(current.right, value);
            return current;
        }
        //если совпало с текущим узлом надо удалить текущий узел
        //3 случая
        // 1 Нет дочерних узлов
        if (current.left == null && current.right == null) {
            return null;
        }
        // 2 Есть только 1 дочерний узел
        if (current.left == null) {//&& current.right!=null
            return current.right;
        }
        if (current.left != null) {//&& current.right==null
            return current.left;
        }
        //3 естьоба дочерних узла
        //Нужно найти минимальный элемент в правом поддереве
        Node smallestNodeOnTheRight = findFirst((current.right));
        int smallestValueOnTheRight = smallestNodeOnTheRight.value;
        //Вставить его значение в текущий узел
        current.value = smallestValueOnTheRight;
        // И удалить этот найденный минимальный узел
        current.right = removeNode(current.right, smallestValueOnTheRight);
        return current;
    }

    public int findFirst() {
        if (root == null) {
            throw new NoSuchElementException();
        }
        return findFirst(root).value;
    }

    private Node findFirst(Node current) {
        if (current.left != null) {
            return findFirst(current.left);
        }
        return current;
    }
    public static int getChildrenCount(Node node) {
        if(node == null) {
            return 0;
        }
        // if left and right of the node is null
        // it is leaf node
        if (node.left == null && node.right == null) {
            return 1;
        }
        else {
            return getChildrenCount(node.left) + getChildrenCount(node.right);
        }
    }


    //Показывает root корень
//    public int findLast() {
//        if (root == null) {
//            throw new NoSuchElementException();
//        }
//        return findLast(root).value;
//    }
//
//    private Node findLast(Node current) {
//        if (current.left == null) {
//            return findLast(current.left);
//        }
//        return current;
//    }
    public int findLast() {
        if (root == null) {
            throw new NoSuchElementException();
        }
        return findLast(root).value;
    }
    private Node findLast(Node current) {
        if (current.right != null) {
            return findLast(current.right);
        }
        return current;
    }
    //

//    public Node getChildrenCount(Node current, Consumer<Integer> valueConsumer) {
//        getChildrenCountInternal(root, valueConsumer);
//        return current;
//    }
//    public int getChildrenCountInternal(Node current, Consumer<Integer> valueConsumer) {
//        if (root == null) {
//            throw new NoSuchElementException();
//        }
//        return 0;
//
//        if (current.left == null && current.right == null) {
//            return 1;
//        } else {
//            return getChildrenCountInternal(current.left, valueConsumer) + getChildrenCountInternal(current.right, valueConsumer);
//        }
//    }
    //
//    private int getChildrenCount (Node current){
//            if (current == null) {
//                return 0;
//            }
//            if (current.left == null && current.right == null) {
//                return 1;
//            }
//            else {                
//                return getChildrenCount(current.left) + getChildrenCount(current.right);
//            }
//        
//
//    }
    //

    //    public List<Integer> dfs() {
//        List<Integer> result = new ArrayList<>();
//        dfs(root, result);
//        return result;
//    }


//        public void dfs (Consumer < Integer > valueConsumer) {
//            dfsInternal(root, valueConsumer);
//        }
//
//        private void dfsInternal (Node current, Consumer < Integer > valueCosumer){
//            if (current != null) {
//                dfsInternal(current.left, valueCosumer);
//                valueCosumer.accept(current.value);
//                dfsInternal(current.right, valueCosumer);
//            }
//
//        }

//    public List<Integer> bfs() {
//        List<Integer> result = new ArrayList<>();
//        bfs(result);
//        return result;
//    }
//        public void bfs (Consumer < Integer > valueConsumer) {
//            bfsInternal(valueConsumer);
//        }
//
//        private void bfsInternal (Consumer < Integer > valueConsumer) {
//            if (root == null) {
//            }
//
//            Queue<Node> queue = new ArrayDeque<>();
//            queue.add(root);
//            //7 3 9 2 5 8 1 4 6
//            while (!queue.isEmpty()) {
//                Node node = queue.poll();
//                valueConsumer.accept(node.value);
//                if (node.left != null) {
//                    queue.add(node.left);
//                }
//                if (node.right != null) {
//                    queue.add(node.right);
//                }
//
//            }
//        }
//        public int size () {
//            final int[] counter = new int[1];
//            bfs(n -> counter[0]++);
//            return counter[0];
//        }

}