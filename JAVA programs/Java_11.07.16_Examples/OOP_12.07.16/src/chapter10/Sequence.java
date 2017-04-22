package chapter10;

class Sequence {
	private static int currentValue = -1;
	// Intentionally deny instantiation of this class
	private Sequence() {
	}
	// Static method
	public static int nextValue() {
	currentValue++;
	return currentValue;
	}
	
}
