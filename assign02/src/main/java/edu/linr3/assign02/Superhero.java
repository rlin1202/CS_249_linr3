package edu.linr3.assign02;

public class Superhero
{
    private String heroName ="";
    private String realName = "";
    private int height = 0;
    private double weight = 0.0;

    public String getHeroName()
    {
        return heroName;
    }

    public String getRealName()
    {
        return realName;
    }

    public int getHeight()
    {
        return height;
    }

    public double getWeight()
    {
        return weight;
    }

    public void setHeroName(String name)
    {
        heroName = name;
    }

    public void setRealName(String name)
    {
        realName = name;
    }

    public void setHeight(int totalInches)
    {
        height = totalInches;
    }

    public void setWeight(double pounds)
    {
        weight = pounds;
    }

    public int calculateBMI()
    {
        return (int)((703 * weight)/(height * height));
    }

    public String getNameString()
    {
        return heroName + " (" + realName + ")";
    }

    public String getHeightString()
    {
        return height/12 + "'" + "-"+ height%12 + "\"";
    }

    public String getWeightString()
    {
        return weight + " lbs.";
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("NAME: "+getNameString()+"\n");
        sb.append("WEIGHT: "+getWeightString()+"\n");
        sb.append("HEIGHT: "+getHeightString()+"\n");
        sb.append("BMI: "+calculateBMI()+"\n");
        return sb.toString();
    }
}

