package multiThreading;

public class NewJavaClass {
    public static void main(String[] args) {
        ArrayConstruction arrConstr = new ArrayConstruction();
        PrintingThread printingThr = new PrintingThread(arrConstr);

        SortingThread sortingThr = new SortingThread(arrConstr);

        arrConstr.create();
        arrConstr.print();

        System.out.println();
        System.out.println("After construction");
        sortingThr.start();
        try {
            printingThr.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

