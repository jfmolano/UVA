// @JUDGE_ID:  1000AA  100  Java  "Easy algorithm"

import java.io.*;
import java.util.*;

class Three_n_plus_one
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
    
    static int cycle (int number)  // utility function to read from stdin
    {
        int n = number;
        int i = 1;
        while(n != 1){
        	if(n % 2 == 1){
        		n = 3*n + 1;
        	} else {
        		n = n/2;
        	}
        	i++;
        }
        return i;
    }

    public static void main (String args[])  // entry point from OS
    {
    	Three_n_plus_one myWork = new Three_n_plus_one();  // create a dinamic instance
        myWork.Begin();            // the true entry point
    }

    void Begin()
    {
        String input;
        StringTokenizer idata;
        int a, b;

        while ((input = Three_n_plus_one.ReadLn (255)) != null)
        {
          idata = new StringTokenizer (input);
          a = Integer.parseInt (idata.nextToken());
          b = Integer.parseInt (idata.nextToken());
          int max = 0;
          for(int i=a;i<=b;i++){
        	  max = Math.max(max,cycle(i));
          }
          System.out.println(a+" "+b+" "+max);
        }
    }
}

