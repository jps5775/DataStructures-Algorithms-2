import DataStructures.MyDeque;

public class Main {
    public static void main(String[] args) {
        MyDeque d = new MyDeque();
        d.append(1);
        d.append(2);
        d.append(3);
        d.append(4);
        d.printDeque();

        d.deleteFront();
        d.deleteFront();
        d.deleteFront();
        d.deleteFront();
        d.printDeque();

    }
}