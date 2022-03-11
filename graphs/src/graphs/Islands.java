package graphs;

public class Islands {
	void visit(char[][] grid,int i, int j) {
	    int n = grid.length;
	    int m = grid[0].length;
	    grid[i][j] = '0';
	    if (i != 0 && (grid[i - 1][j] == '1'))visit(grid, i-1, j);
	    if (j != 0 && (grid[i][j-1] == '1'))visit(grid, i, j-1);
	    if (i != n-1 && (grid[i+1][j] == '1'))visit(grid, i+1, j);
	    if (j != m-1 && (grid[i][j+1] == '1'))visit(grid, i, j+1);

	}
	 int numIslands(char[][] grid) {
	     int count = 0;
	     int n = grid.length;
	     int m = grid[0].length;
	     for (int i = 0; i < n; ++i) {
	         for (int j = 0; j < m; ++j) {
	             if (grid[i][j] == '1') {
	                 count++;
	                 visit(grid, i, j);
	             }
	         }
	     }
	     return count;
	 }
	public static void main(String[] args) {
		char[][] grid={
				{ '1','1','0','0','0'},
				{ '1','1','0','0','0'},
				{ '0','0','1','0','0'},
				{ '0','0','0','1','1'},
				}; 
		Islands i=new Islands();
		System.out.println(i.numIslands(grid));
		
	}

}
