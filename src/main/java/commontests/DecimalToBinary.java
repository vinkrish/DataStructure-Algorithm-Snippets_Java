package commontests;

public class DecimalToBinary {

	public static void main(String[] args) {
		convertBinary(1000);
	}
	
	static void convertBinary(int num) {
		StringBuilder sb = new StringBuilder();
		int binary[] = new int[40];
		int index = 0;
		while (num > 0) {
			binary[index++] = num % 2;
			num = num / 2;
		}
		for (int i = index - 1; i >= 0; i--) {
			sb.append(binary[i]);
		}
		System.out.println(sb);
	}

}
