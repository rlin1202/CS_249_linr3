package edu.linr3.assign06;

import java.util.Scanner;

public abstract class Creature implements Loadable,Drawable
{
    private int row;
    private int col;
    protected Creature()
    {
        row = 0;
        col = 0;
    }
    protected Creature(int row,int col)
    {
        setRow(row);
        setCol(col);
    }
    public int getRow()
    {
        return row;
    }
    public int getCol()
    {
        return col;
    }
    public void setRow(int row)
    {
        this.row = row;
    }
    public void setCol(int col)
    {
        this.col = col;
    }
    public void load(Scanner input) throws GameFileException
    {
        try{
            row = input.nextInt();
            col = input.nextInt();
        }
        catch(Exception e)
        {
            setRow(0);
            setCol(0);
            throw new GameFileException("Error loading Creature", e);
        }
    }
}
