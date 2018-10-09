package multiThreading;

public class ArrayConstruction {
    int[] array = new int[100];

    public ArrayConstruction() {
        for (int i = this.array.length - 1; i >= 0; i--) {
            this.array[i] = i;

        }
    }

    public void create() {
        int i;
        for (i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        System.out.println("Creation finished");
    }

    public void print() {
        int i;
        for (i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
