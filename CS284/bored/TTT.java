import java.util.*;

public class TTT
{
    private String board;
    private int moveCt;
    public TTT()
    {
        moveCt=0;
        board="         ";
    }

    /**
     *@param bd: String containing board
     *@param mc: moveCt
     */
    public TTT(String bd, int mc)
    {
        moveCt=mc;
        board=bd;
    }

    public void switch(){moveCt++;}

    public boolean move(int spot)
    {
        if(board.charAt(spot)==' ' && checkWin()==' ')
        {
            moveCt++;
            board=board.substring(0,spot)+((moveCt%2==0)?'X':'O')+board.substring(spot+1);
            return true;
        }
        return false;
    }

    char checkWin()
    {
        for(int x=0;x<3;x++)
            if(board.charAt(x)!=' '&&board.charAt(x)==board.charAt(x+3)&&board.charAt(x)==board.charAt(x+6))
                return board.charAt(x);
            else if(board.charAt(x*3)!=' '&&board.charAt(x*3)==board.charAt(x*3+1)&&board.charAt(x*3)==board.charAt(x*3+2))
                return board.charAt(x*3);
        if(board.charAt(0)!=' '&&board.charAt(0)==board.charAt(4)&&board.charAt(0)==board.charAt(8))
            return board.charAt(0);
        else if(board.charAt(2)!=' '&&board.charAt(2)==board.charAt(4)&&board.charAt(2)==board.charAt(6))
            return board.charAt(2);
        return ' ';
    }
}