
public class Main {

	public static void createStarTree(int size) {
		int height = size;
		if (height == 1)
			System.out.println("Hight must be bigger than 1");
		if(height<0)
			System.out.println("Hight can't be smaller than 0");
			
		else {
			for (int i = 1; i <= size; i++) {

				for (int j = 1; j <= size - i; j++) {
					System.out.print(" ");
				}
				for (int k = 1; k <= (i*2-1); k++) {
					System.out.print("*");
				}

				System.out.println();
			}

		}
	}

	public static void main(String[] args) {
		createStarTree(10);

	}

}
