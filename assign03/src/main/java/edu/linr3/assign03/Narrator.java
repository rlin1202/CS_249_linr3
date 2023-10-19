package edu.linr3.assign03;

public class Narrator
{
    private char boundaryChar;
    private String[]lines;

    public Narrator(String[] lines,char boundaryChar)
    {
        setBoundaryChar(boundaryChar);
        setLines(lines);
    }
    public char getBoundaryChar()
    {
        return boundaryChar;
    }
    public String getLines()
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < lines.length;i++)
        {
            sb.append(lines[i]+"\n");
        }
        return sb.toString();
    }
    public void setBoundaryChar(char boundaryChar)
    {
        this.boundaryChar = boundaryChar;
    }
    public void setLines(String[] lines)
    {
        this.lines = new String[lines.length];
        for(int i = 0; i < lines.length; i++)
        {
            this.lines[i] = lines[i];
        }
    }
    public String generateBoundaryLine()
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < 50;i++)
        {
             sb.append(boundaryChar);
        }
        return sb.toString() +"\n";
    }
    public String generateCenteredLine(String text)
    {
        StringBuilder sb = new StringBuilder();
        int total = 48 - text.length();
        int half = total/2;
        int otherHalf = total - half;
        sb.append(boundaryChar);
        for(int i = 0;i < half;i++)
        {
            sb.append(" ");
        }
        sb.append(text);
        for(int i = 0;i < otherHalf;i++)
        {
            sb.append(" ");
        }
        sb.append(boundaryChar);
        sb.append("\n");
        return sb.toString();
    }
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        int lineCount = 0;
        int extraLines = 0;
        for (int i = 0;i < lines.length; i+=4)
        {
            sb.append(generateBoundaryLine());
            sb.append(generateCenteredLine(" "));
            lineCount = lines.length - i;
            if(lineCount < 4)
            {
                extraLines = 4 - lineCount;
            }
            else
            {
                lineCount = 4;
                extraLines = 0;
            }
            for (int n = 0; n < lineCount; n++)
            {
                sb.append(generateCenteredLine(lines[i + n]));
            }
            for (int e = 0;e < extraLines;e++)
            {
                sb.append(generateCenteredLine(" "));
            }
            sb.append(generateCenteredLine(" "));
            sb.append(generateBoundaryLine());
        }
        return sb.toString();
    }


}
