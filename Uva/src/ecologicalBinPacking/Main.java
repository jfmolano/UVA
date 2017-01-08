package ecologicalBinPacking;

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

    public static void main (String args[])  // entry point from OS
    {
        Main myWork = new Main();  // create a dinamic instance
        myWork.Begin();            // the true entry point
    }

    void Begin()
    {
        String input;
        StringTokenizer idata;
        int [][] numbers;
        String [] tags = new String[6];
        tags[0] = "BCG";
        tags[1] = "BGC";
        tags[2] = "CBG";
        tags[3] = "CGB";
        tags[4] = "GBC";
        tags[5] = "GCB";

        while ((input = Main.ReadLn (255)) != null)
        {
          idata = new StringTokenizer (input);
          numbers = new int[3][3];
          for(int i=0;i<9;i++){
        	  numbers[i/3][i%3] = Integer.parseInt(idata.nextToken());
          }
          int [] sumas = new int[6];
          int b_1 = numbers[1][0] + numbers[2][0];
          int b_2 = numbers[0][0] + numbers[2][0];
          int b_3 = numbers[0][0] + numbers[1][0];
          int g_1 = numbers[1][1] + numbers[2][1];
          int g_2 = numbers[0][1] + numbers[2][1];
          int g_3 = numbers[0][1] + numbers[1][1];
          int c_1 = numbers[1][2] + numbers[2][2];
          int c_2 = numbers[0][2] + numbers[2][2];
          int c_3 = numbers[0][2] + numbers[1][2];
          sumas[0] = b_1 + c_2 + g_3;
          sumas[1] = b_1 + g_2 + c_3;
          sumas[2] = c_1 + b_2 + g_3;
          sumas[3] = c_1 + g_2 + b_3;
          sumas[4] = g_1 + b_2 + c_3;
          sumas[5] = g_1 + c_2 + b_3;
          
          int min = Integer.MAX_VALUE;
          int tag_index = 0;
          
          for(int i=0;i<6;i++){
        	  if(min > sumas[i]){
        		  min = sumas[i];
        		  tag_index = i;
        	  }
          }
          System.out.println(tags[tag_index] +" "+ min);
        }
    }
}

