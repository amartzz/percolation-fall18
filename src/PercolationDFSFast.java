
public class PercolationDFSFast extends PercolationDFS{

	public PercolationDFSFast(int size) {
		super(size);
		
	}
/**
 * account for 2 cases:
 * if cell in top row, mark as full
 * if adjacent cell is full, mark cell looked at as full
 */
	
	
	@Override
	protected void updateOnOpen(int row, int col) {
	//if (row==0) dfs(row,col); //top row check
	
	//now check if neighbors are already full, and if row,col in bounds to avoid null pointer
//	if (inBounds(row+1, col) && isFull(row+1, col)) dfs(row, col);
//	if (inBounds(row-1, col) && isFull(row-1, col)) dfs(row, col);
//	if (inBounds(row, col+1) && isFull(row, col+1)) dfs(row, col);
//	if (inBounds(row, col-1) && isFull(row, col-1)) dfs(row, col);
	if ((row==0) ||
			(inBounds(row+1, col) && isFull(row+1, col))||
			(inBounds(row-1, col) && isFull(row-1, col)) ||
			(inBounds(row, col+1) && isFull(row, col+1))||
			(inBounds(row, col-1) && isFull(row, col-1))) dfs(row,col);
		
	}

}
