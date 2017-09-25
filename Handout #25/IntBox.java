import java.util.HashSet;
import java.util.Set;

class IntBox {
	int i;
	int j;
	IntBox(int i, int j) { 
		this.i = i; 
		this.j = j;
	}

	// equals other IntBoxes that store the same int value.
	@Override
	public boolean equals(Object o) {
		IntBox other = (IntBox) o;
		return (this.i == other.i);
	}


	@Override
	public int hashCode() {
		int result = 0;
		result = j / 2;
		return result;

	}

	public static void main(String[] args) {
		Set<IntBox> intBoxes = new HashSet<>();
		IntBox intBox1 = new IntBox(2, 40);
		IntBox intBox2 = new IntBox(1, 100);

		intBoxes.add(intBox1);
		intBoxes.add(intBox2);
		// make sure when you override equal methods, you should always override hashCode methods
		// Because when the hashCode doesn't match, the equal will never be called even if the return value
		// of your equals methods is true.
		boolean found = intBoxes.contains(new IntBox(2,50));

		//		intBoxes.add(new IntBox(0));
		//		boolean found = intBoxes.contains(new IntBox(0));
		System.out.println(found);  // found == false ?? why
	}
}

