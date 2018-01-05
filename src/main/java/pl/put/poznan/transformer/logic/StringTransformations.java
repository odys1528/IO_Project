package pl.put.poznan.transformer.logic;

public class StringTransformations {

    private static int a = 'a', A = 'A', z = 'z', Z = 'Z', diff = a - A;

    private static char toUp(char c)
    {
        if (c >= a && c <= z) c -= diff;
        return c;
    }
    private static char toLow(char c)
    {
        if (c >= A && c <= Z) c += diff;
        return c;
    }

    public static String inverseCase (String line)
    {
        String tmp = "",ans = "";
        for (char c: line.toCharArray()) tmp = c + tmp;
        for (int i = 0; i < line.length(); i++)
        {
            if (line.charAt(i) >= A && line.charAt(i) <= Z) ans += toUp(tmp.charAt(i));
            else if (line.charAt(i) >= a && line.charAt(i) <= z) ans += toLow(tmp.charAt(i));
            else ans += tmp.charAt(i);
        }
        return ans;
    }

    public static String changeCase(String line, String type)
    {
        Boolean flag = true;
        String ans = "";
        switch(type)
        {
            case "upper": { for (char c: line.toCharArray()) ans += toUp(c); break; }
            case "lower": { for (char c: line.toCharArray()) ans += toLow(c); break; }
            case "capitalize":
            {
                for (char c: line.toCharArray())
                {
                    if (flag) c = toUp(c);
                    flag = false;
                    if (c == ' ') flag = true;
                    ans += c;
                } break;
            }
            default: return "Bad type";
        }
        return ans;
    }

    private static void main(String args[]) {

//        String dupa = "supa koteu duUUpaa";
//
//        System.out.println(changeCase(dupa,"capitalize"));
    }
}
