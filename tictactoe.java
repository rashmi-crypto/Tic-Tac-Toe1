import java.util.Scanner;
public class tictactoe {
    public static void main(String args[])
    {
        char[][] grid = new char[3][3];
         for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
                grid[i][j]=' ';
            }
        }
        char player='X'; //assuming the first player starts with X
        boolean gameOver=false;
         Scanner in = new Scanner(System.in); 
            while(gameOver!=true)
            {
                display(grid);
                System.out.println("Player "+player+" enter: ");
                int row=in.nextInt();
                int col=in.nextInt();
                if(grid[row][col]==' ')
                {
                    grid[row][col]=player;
                    boolean full=gridfull(grid);
                    if(full==true)
                    {
                        System.out.println("The board is full. The game is a tie");
                        break;
                    }
                    gameOver=haveWon(grid,player);
                    if(gameOver==true)
                    {
                        System.out.println("player: "+player+" has won");
                    }
                    else{
                        if(player=='X')
                            player='O';
                        else
                            player='X';
                    }
                }
                else
                    System.out.println("Invalid move");
            }
            display(grid);
        }
        public static boolean haveWon(char[][] grid,char player)
        {
            for(int i=0;i<grid.length;i++)
            {
                if(grid[i][0]== player && grid[i][1]== player && grid[i][2]== player)
                    return true;
            }
            for(int j=0;j<grid.length;j++)
            {
                if(grid[0][j]==player && grid[1][j]== player && grid[2][j]==player)
                return true;
            }
            if((grid[0][0]==player && grid[1][1]==player && grid[2][2]==player)||(grid[0][2]==player && grid[1][1]==player && grid[2][0]==player))
                return true;
            return false;
}
        public static void display(char[][] grid)
        {
             for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
                System.out.print(" | "+grid[i][j]+" | ");
            }
            System.out.println();
        }
        }
        public static boolean gridfull(char[][] grid)
        {
            int c=0;
            for(int i=0;i<grid.length;i++)
            {
                for(int j=0;j<grid.length;j++)
                {
                    if(grid[i][j]!=' ')
                        c++;
                }
            }
            if(c==9)
                return true;
            else
                 return false;
        }
    }