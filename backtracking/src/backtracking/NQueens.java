package backtracking;

public class NQueens {
	int n=4;
	int[] Q=new int[n+1];
	void backtrack(int row) {//found solution, print it
		if (row==n+1) {
			for(int i=1;i<n+1;++i)
				System.out.print(Q[i]);
			System.out.println("");
		}
		else {
			for(int col=1;col<n+1;++col) {//try all possible columns
				//note that even if a solution is found
				//the algorithm will go on trying other 
				// configuration
				boolean possible=true;
				// j is the column under consideration
				// test all the rows before r
				// if any of them can attack queen at row r
				// then j is no good
				for(int i=1;i<row;++i) {//check previous rows
					if( (Q[i]==col) || (Q[i]==col+row-i) || (Q[i]==col-row+i))
						possible=false;
				}
				if (possible) {//possible choice
					Q[row]=col;
					//next row
					backtrack(row+1);
				}
				//otherwise try the next possible j
			}//end for
			
		}//end else
		
	}
	public static void main(String[] args) {
		NQueens nq=new NQueens();
		nq.backtrack(1);
	}
	
	

}
