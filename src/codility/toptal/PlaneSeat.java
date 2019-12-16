package codility.toptal;

public class PlaneSeat {

	public static void main(String[] args) {
		System.out.println(solution(1, ""));
	}
	
	public static int solution(int N, String S) {
		int arr[][] = new int[N][10];
		if (!S.equals("")) {
			String[] sArr = S.split(" ");			
			for (String a : sArr) {
				StringBuffer alpha = new StringBuffer();  
				StringBuffer num = new StringBuffer(); 
		        for (int i=0; i<a.length(); i++) {
		            if (Character.isDigit(a.charAt(i))) 
		                num.append(a.charAt(i));
		            else if(Character.isAlphabetic(a.charAt(i))) 
		                alpha.append(a.charAt(i));
		        }
		        arr[Integer.parseInt(num.toString())-1][getColumnNumber(alpha.charAt(0))] = 1;
			}
		}
		
		int total4Seater = 0;
		for (int i = 0; i < N; i++) {
			boolean leftSeat = false;
			boolean centerSeat = false;
			boolean rightSeat = false;
			if (arr[i][1] == 0 && arr[i][2] == 0 && arr[i][3] == 0 && arr[i][4] == 0) {
				leftSeat = true;
			} 
			if (arr[i][5] == 0 && arr[i][6] == 0 && arr[i][7] == 0 && arr[i][8] == 0) {
				rightSeat = true;
			}
			
			if (!(leftSeat && rightSeat)) {
				if (arr[i][3] == 0 && arr[i][4] == 0 && arr[i][5] == 0 && arr[i][6] == 0) {
					centerSeat = true;
				}
			}
			
			if (leftSeat && rightSeat) {
				total4Seater += 2;
			} else if (centerSeat || leftSeat || rightSeat) {
				total4Seater += 1;
			}
        }
		return total4Seater;
    }
	
	private static int getColumnNumber( char column ) {
		switch ( column ) {
	    	case 'A':
	          return 0;
	        case 'B':
	          return 1;
	        case 'C':
	          return 2;
	        case 'D':
	          return 3;
	        case 'E':
	          return 4;
	        case 'F':
	          return 5;
	        case 'G':
	          return 6;
	        case 'H':
	          return 7;
	        case 'J':
	          return 8;
	        case 'K':
	          return 9;
	    }
	        return -1;
	}

}
