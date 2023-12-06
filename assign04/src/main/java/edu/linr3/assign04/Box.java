package edu.linr3.assign04;

public class Box
{
    private int sr;
    private int sc;
    private int er;
    private int ec;
    private boolean filled;
    private char drawChar;
    public Box(int sr, int sc, int er, int ec, boolean filled, char drawChar)
    {
        this.sr = sr;
        this.sc = sc;
        this.er = er;
        this.ec = ec;
        this.filled = filled;
        this.drawChar = drawChar;
    }
    public String toString()
    {
        if(filled)
        {
            return "Filled Box from ("+sr+","+sc+")"+" to ("+er+","+ec+") "+
                    "with char '"+drawChar+"'";
        }
        else
        {
            return "Box from ("+sr+","+sc+")"+" to ("+er+","+ec+") "+
                    "with char '"+drawChar+"'";
        }
    }
    public void draw(ScreenBuffer s) {
        for (int r = sr; r <= er; r++)
        {
            for (int c = sc; c <= ec; c++)
            {
                if (filled)
                {
                    s.setPos(r, c, drawChar);
                }
                else if (r == sr || r == er || c == sc || c == ec)
                {
                    s.setPos(r, c, drawChar);
                }
            }
        }
    }
}

