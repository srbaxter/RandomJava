import java.util.*;

public class Hello { // class header
	public static void main(String[] args) { //method header
		System.out.println("Hello"); //statement

		// add 1 star to each line
		addStars();

		//fibonacci problem getting the number of times from args
        int n = Integer.parseInt(args[0]);
        for (int i = 1; i <= n; i++) {
            System.out.println(fibonacci(i));	
        }
        System.out.println();


        for (int i = 1; i <= n; i++) {
            System.out.println(fibonacci2(i));		
        }      
        System.out.println();


        System.out.println(reverse("hello"));
        System.out.println();

        System.out.println(reverse2("hello again"));        

        System.out.println();
		rolldice();    

        System.out.println();
		System.out.println(firstWord("  this is a test   "));    

		System.out.println();
		int[] list = {3, 1, 10, 5, 9, 0, 0, 2};
		reverseArray(list);
		System.out.println(Arrays.toString(list));

		rotateLeft(list);
		System.out.println(Arrays.toString(list));

		System.out.println();
		double[][] grid = new double[3][5];
		printMultiArray(grid);
	}

	public static void addStars() {
		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

    public static long fibonacci(int n) {
        if (n <= 1) {
        	return n;
        } else {
        	return fibonacci(n-1) + fibonacci(n-2);
        }
    }

	public static long fibonacci2(int n){
	    long prev = 0, next = 1, result = 0;
	    for (int i = 1; i < n; i++) {
	        result = prev + next;
	        prev = next;
	        next = result;
	    }
	    return result;
	}    

	public static String reverse(String phrase) {
		String result = "";
		for (int i = 0; i < phrase.length(); i++) {
			result = phrase.charAt(i) + result;
		}
		return result;
	}

	public static String reverse2(String phrase) {
		String reverse = new StringBuilder(phrase).reverse().toString(); //StringBuilder is preferred over StringBuffer due to thread safety
		return reverse;
	}

	public static void rolldice() {
		Random r = new Random();
		int sum;
		do {
			int rol1 = r.nextInt(6) + 1;
			int rol2 = r.nextInt(6) + 1;
			sum = rol1 + rol2;
			System.out.println(rol1 + " + " + rol2 + " = " + sum);
		} while (sum != 7);
	}

	public static String firstWord(String s) {
		int start = 0;
		while (start < s.length() && s.charAt(start) == ' ') {
			start++;
		}
		int stop = start;
		while (stop < s.length() && s.charAt(stop) != ' ') {
			stop++;
		}
		return s.substring(start, stop);
	}

	public static void reverseArray(int[] list) {
		for (int i = 0; i < list.length / 2; i++) {
			int j = list.length - 1 - i;
			swap(list, i, j);
		}
	}
	public static void swap(int[] list, int i, int j) {
		int temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	}

	public static void rotateLeft(int[] list) {
		int first = list[0];
		for (int i = 0; i < list.length - 1; i++) {
			list[i] = list[i+1];
		}
		list[list.length - 1] = first;
	}

	public static void printMultiArray(double[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void replace(ArrayList<String> list, String target, String replacement) {
		int index = list.indexOf(target);
		if (index >= 0) {
			list.set(index, replacement);
		}
	}

	public static int binarySearch(int[] nums, int target) {
		int min = 0;
		int max = nums.length - 1;
		while (min <= max) {
			int mid = (min + max) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				min = mid + 1;
			} else if (nums[mid] > target) {
				max = mid - 1;
			}
		}
		return -1;
	}

	public static void selectionSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int smallest = 1;
			for (int j = i+1; j < a.length; j++) {
				if (a[j] < a[smallest]) {
					smallest = j;
				}
			}
			int temp = a[i];
			a[i] = a[smallest];
			a[smallest] = temp;
		}
	}
}