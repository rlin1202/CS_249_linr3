package edu.linr3.assign05;

import java.util.ArrayList;

public class Woods
{
    private ArrayList<Giant> g = new ArrayList<>();
    public Giant createGiant(String name, String typeName)
    {
        if(name.isEmpty())
        {
            return null;
        }
        return switch (typeName)
        {
            case "GIANT"-> new Giant(name);
            case "TROLL"-> new Troll(name);
            case "TREE"-> new Tree(name);
            case "ENT"-> new Ent(name);
            case "HUORN"-> new Huorn(name);
            default->null;
        };
    }
    public boolean addGiant(String name, String typeName)
    {
        Giant temp = createGiant(name,typeName);
        if(temp != null)
        {
            g.add(temp);
            return true;
        }
        else
        {
            return false;
        }

    }
    public Giant getGiant(int index)
    {
        if(index >= 0 && index < g.size())
        {
            return g.get(index);
        }
        else
        {
            return null;
        }
    }
    public void printAllGiants()
    {
        System.out.println("ALL GIANTS:");
        for (Giant i: g )
        {
            System.out.println("- "+i.toString());
        }
    }
    public void printAllTrees()
    {
        System.out.println("ALL TREES:");
        for(Giant i: g)
        {
            if(i instanceof Tree)
            {
                Tree t = (Tree)i;
                System.out.println("- "+t.toString()+": "+t.speak());
            }
        }
    }
    public void printAllTrolls()
    {
        System.out.println("ALL TROLLS:");
        for(Giant i: g)
        {
            if(i instanceof Troll)
            {
                Troll t = (Troll)i;
                System.out.println("- "+t.toString()+": "+t.cook());
            }
        }
    }




}
