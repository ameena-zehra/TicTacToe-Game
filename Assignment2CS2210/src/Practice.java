
public class Practice {
	public static void main(String[] args) {
		int[][] gameBoard;
		gameBoard = new int[5][5];
		int[][] newgameBoard;
		newgameBoard = new int[5][5];
		int innercount=0;
		for (int i=0; i<4; i++) {
			int count =0;
			for (int j=0;j<5;j++ ) {
				count++;
				
				if (i==0) {
					System.out.print("  ");
					innercount=0;
				}
				else {
					innercount++;
					System.out.print("  ");
				}
				gameBoard[i][j]= i;
				newgameBoard[i][j]= j;
//				System.out.print(gameBoard[i][j]+""+newgameBoard[i][j]+" ");
				System.out.print("I-"+i);
				System.out.print("J-"+j);
//				if (i==3) {
//					System.out.print(innercount);
//				}
			}
			System.out.println();
		}
		System.out.println(gameBoard);
		
		
		
		
		
		
//		int[][] gameBoard;
//		gameBoard = new int[5][5];
//		int[][] newgameBoard;
//		newgameBoard = new int[5][5];
		int countfori=0;
		for (int j=0; j<5; j++) {
			countfori++;
			
			for (int i=0;i<5;i++ ) {
				
				
				if (i==0) {
					System.out.print("  ");
					
				}
				else {
					
					System.out.print("  ");
				}
				
//				System.out.print(gameBoard[i][j]+" ");
				System.out.print("I-"+i);
				System.out.print("J-"+j);
//				if (i==3) {
//					System.out.print(innercount);
//				}
//				if (i==3) {
//					
//					System.out.print(" ");
////					countfori = 0;
//				}
//			}
//			if (i==3) {
//				countfori=0;
			}
			System.out.println();
		}
		System.out.println(gameBoard);
	}

}
