
public class PercolationUF implements IPercolate {
	
	
	protected boolean[][] myGrid;
	protected int myOpenCount;
	protected IUnionFind myFinder;
	private final int VTOP;
	private final int VBOTTOM;
	
	public PercolationUF(int size, IUnionFind finder) {
	
		myGrid= new boolean[size][size];
		myOpenCount=0;
		VTOP= size*size;
		VBOTTOM= VTOP +1;
		finder.initialize(VTOP +2);
	    myFinder = finder;
		
	}
	protected boolean inBounds(int row, int col) {
		if (row < 0 || row >= myGrid.length) return false;
		if (col < 0 || col >= myGrid[0].length) return false;
		return true;
	}
	
	public Integer conversion(int row, int gridLength, int col) {
		return row*gridLength + col;
		}

	
	
	
	
	@Override
	public void open(int row, int col) {
		 
		if (! inBounds(row,col)) throw 
		new IndexOutOfBoundsException("out of bounds");
		if (myGrid[row][col]==true)return;
		
		myGrid[row][col]=true;
		myOpenCount+=1;
		
		// if they connect to top or bottom 
		if (row==0) myFinder.union(conversion(row, myGrid.length, col), VTOP);
		if (row==myGrid.length-1) myFinder.union(conversion(row, myGrid.length, col), VBOTTOM);

		
		
		// if neighbor in bounds && open ->
		if (inBounds(row+1, col) &&
				myGrid[row+1][col]==true)myFinder.union(conversion(row, myGrid.length, col), conversion(row+1, myGrid.length, col));
		if (inBounds(row-1, col) &&
				myGrid[row-1][col]==true)myFinder.union(conversion(row, myGrid.length, col), conversion(row-1, myGrid.length, col));
		if (inBounds(row, col+1) &&
				myGrid[row][col+1]==true)myFinder.union(conversion(row, myGrid.length, col), conversion(row, myGrid.length, col+1));
		if (inBounds(row, col-1) &&
				myGrid[row][col-1]==true)myFinder.union(conversion(row, myGrid.length, col), conversion(row, myGrid.length, col-1));
		
	}
	

	@Override
	public boolean isOpen(int row, int col) {
		 
		if (! inBounds(row,col)) throw 
		new IndexOutOfBoundsException("out of bounds");
		//sets open cells to true
		return myGrid[row][col];
	}

	@Override
	public boolean isFull(int row, int col) {
		 
		if (! inBounds(row,col)) throw 
		new IndexOutOfBoundsException("out of bounds");
		//return whether or not value connected to VTOP
		return myFinder.connected(conversion(row, myGrid.length, col), VTOP);
	}

	@Override
	public boolean percolates() {
		if (myFinder.connected(VTOP, VBOTTOM)) return true;
		return false;
	}

	@Override
	public int numberOfOpenSites() {
		 
		return myOpenCount;
	}

}
