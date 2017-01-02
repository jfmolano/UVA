package ThreeNPlusOne;
// @JUDGE_ID:  1000AA  100  Java  "Easy algorithm"

import java.io.*;
import java.util.*;

class Main
{
	static String ReadLn (int maxLg)  // utility function to read from stdin
    {
        byte lin[] = new byte [maxLg];
        int lg = 0, car = -1;
        String line = "";

        try
        {
            while (lg < maxLg)
            {
                car = System.in.read();
                if ((car < 0) || (car == '\n')) break;
                lin [lg++] += car;
            }
        }
        catch (IOException e)
        {
            return (null);
        }

        if ((car < 0) && (lg == 0)) return (null);  // eof
        return (new String (lin, 0, lg));
    }

    public static void main (String args[])  // entry polong from OS
    {
    	Main myWork = new Main();  // create a dinamic instance
        myWork.Begin();            // the true entry point
    }

    void Begin()
    {
        String input;
        StringTokenizer idata;
        int a, b, num_max, num_min, number, max, ciclo, n;

        while ((input = Main.ReadLn (255)) != null)
        {
            idata = new StringTokenizer (input);
            a = Integer.parseInt (idata.nextToken());
            b = Integer.parseInt (idata.nextToken());
            if(a > b) {num_max = a; num_min = b;} else {num_max = b; num_min = a;}
            max = -1;
            for(number = num_min; number<=num_max; number++){
            	for(ciclo = 1, n = number; n != 1;ciclo++){
            		n = (n % 2 == 0)?n/2:n*3+1;
            	}
            	if(ciclo>max)max=ciclo;
            }
            System.out.println (a + " " + b + " " + max);
        }
    }
}

