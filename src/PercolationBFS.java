import java.util.LinkedList;
import java.util.Queue;

public class PercolationBFS extends PercolationDFSFast {

	public PercolationBFS(int size) {
		super(size);
	}
	@Override
	protected void dfs(int row, int col) {
		if (! inBounds(row,col)) return;
		if (isFull(row, col) || !isOpen(row, col)) return;


		Queue <Integer> qi= new LinkedList<>();
		myGrid[row][col] = FULL;
		qi.add(conversion(row, myGrid.length, col));
		
		while(qi.size() != 0) {
			int value = qi.remove();
			int size = myGrid.length;
			
			int nrow= value/size;
			int ncol= value%size;
						
			
			if(inBounds(nrow+1, ncol) &&
				isOpen(nrow+1, ncol) &&
				!isFull(nrow+1, ncol)) {
				myGrid[nrow+1][ncol]=FULL;
				qi.add(conversion(nrow+1,size, ncol));
				
			}
			
			if(inBounds(nrow-1, ncol) &&
					isOpen(nrow-1, ncol) &&
					!isFull(nrow-1, ncol)) {
					myGrid[nrow-1][ncol]=FULL;
					qi.add(conversion(nrow-1,size, ncol));
					
				}
			
			if(inBounds(nrow, ncol+1) &&
					isOpen(nrow, ncol+1) &&
					!isFull(nrow, ncol+1)) {
					myGrid[nrow][ncol+1]=FULL;
					qi.add(conversion(nrow,size, ncol+1));
					
				}
			
			if(inBounds(nrow, ncol-1) &&
					isOpen(nrow, ncol-1) &&
					!isFull(nrow, ncol-1)) {
					myGrid[nrow][ncol-1]=FULL;
					qi.add(conversion(nrow,size, ncol-1));
					
				}
							
		}
		
		
		}
	public Integer conversion(int row, int gridLength, int col) {
		return row*gridLength + col;
		}

}
