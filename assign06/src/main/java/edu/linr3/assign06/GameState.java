package edu.linr3.assign06;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import edu.linr3.assign04.ScreenBuffer;
public class GameState implements Loadable
{
    private ArrayList<Loadable> l = new ArrayList<>();
    private ScreenBuffer baseMap = new ScreenBuffer(12,30,'.');
    public Loadable createLoadable(String typeName)throws GameFileException
    {
        return switch (typeName)
        {
            case "Skeleton"-> new Skeleton();
            case "Rat"-> new Rat();
            case "Item"-> new Item();
            case "Tome"-> new Tome();
            default->throw new GameFileException("Unknown type: "+typeName);
        };
    }
    public void load(Scanner input) throws GameFileException
    {
        baseMap.clear();
        l.clear();
        int numLines = input.nextInt();
        String type = "";
        for(int i = 0;i < numLines;i++)
        {
            type = input.next();
            Loadable m = createLoadable(type);
            m.load(input);
            l.add(m);
            if(m instanceof Drawable d)
            {
                d.draw(baseMap);
            }
        }
    }
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MAP:\n" + baseMap.getDisplayString()+"\n");
        sb.append("CREATURES:\n");
        for(Loadable i: l)
        {
            if(i instanceof Creature)
            {
                sb.append("* " + i + "\n");
            }
        }
        sb.append("INVENTORY:\n");
        for(Loadable x:l)
        {
            if(x instanceof Item)
            {
                sb.append("* " + x + "\n");
            }
        }
        return sb.toString();
    }
    public void save(String filename) throws GameFileException
    {
        try(PrintWriter writer = new PrintWriter(filename)){
            writer.print(this.toString());
        }
        catch(Exception e)
        {
            throw new GameFileException("Failed to save file!",e);
        }
    }
}
