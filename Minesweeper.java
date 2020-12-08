/******************************************************************************
MINESWEEPER (of sorts)
*******************************************************************************/
public class Main
{
    
	public static void main(String[] args) {
	    
	    char[][] inBoard={
	        {'*', '.', '.', '.', '.'},
	       {'.', '.', '.', '.', '.'},
	       {'.', '*', '.', '.', '.'},
	       {'.', '.', '.', '.', '.'}
	    
	    };
	   char[][] outBoard=inBoard; //* lazy copy
	   
	   	printBoard(inBoard);
		parseBoard(inBoard,outBoard);
		printBoard(outBoard);
	}
	
	
	//Parse the board
	private static void parseBoard(char[][]inBoard, char[][]outBoard){
	
	int maxX=inBoard.length;
	int maxY=inBoard[0].length;
	int mineCount=0;
	
	// Co-ordinate additions used to sweep round a cell looking for possible mines
	int sweep[][] = { 
        {-1,0}, 
        {0,-1}, 
        {-1,-1}, 
        {1,1},
        {-1,1}, 
        {1,-1},
        {1,0},
        {0,1} 
	    };
	
	int newX, newY;
	for(int i=0; i<maxX; i++){
        for(int j=0; j<maxY; j++){
            
        mineCount=0;
        if (inBoard[i][j]!='*'){    // ignore if is already a mine
            for(int y=0;y<8;y++){
            newY=j+sweep[y][0];		// sweep round looking for mines
            newX=i+sweep[y][1];
            
            // add a minecount if it's not out of bounds and is a mine
            if ((newX>=0) && (newX<maxX) && (newY>=0) && (newY<maxY))
                mineCount+=(inBoard[newX][newY]=='*')?1:0;    
            }
        outBoard[i][j]=Character.forDigit(mineCount, 10); // convert like: (char)mineCount;	    
        }
	    
	    }
	
    }   
	    
    }
	
// Print the board
private static void printBoard(char[][] a){		
    for(int i=0; i<a.length; i++){			
        for(int j=0; j<a[i].length; j++){
	    System.out.print(a[i][j] + " ");	
	}
	System.out.println();
    }   
}
}
