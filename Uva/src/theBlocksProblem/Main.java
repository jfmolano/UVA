package theBlocksProblem;
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
        
        String n = Main.ReadLn (255);
        int n_tam = Integer.parseInt(n);
        String line = "";
        int matrix[][] = new int[n_tam][2];
        for(int i=0;i<n_tam;i++){
        	matrix[i][0] = 1;
        	matrix[i][1] = -1;
        }
        
        while ((input = Main.ReadLn (255)) != null && !line.equals("quit"))
        {
        	line = input;
        	String[] command = line.split(" ");
        	if(command[0].equals("move") && command[2].equals("onto")){
        		int block_1 = Integer.parseInt(command[1]);
	    		boolean tope = false;
	    		
	    		int block_2_state = matrix[Integer.parseInt(command[3])][0];
	    		
				while (!tope){
					int upper_block = matrix[block_1][1];
	    			if(upper_block == -1){tope = true;matrix[block_1][0]=1;}
	    			else{
	    				matrix[block_1][0] = 1;
	    				matrix[block_1][1] = -1;
	    				block_1 = upper_block;
	    			}
	    			
	    		}
				
        		block_1 = Integer.parseInt(command[3]);
	    		tope = false;
				while (!tope){
					int upper_block = matrix[block_1][1];
	    			if(upper_block == -1){tope = true;matrix[block_1][0]=1;}
	    			else{
	    				matrix[block_1][0] = 1;
	    				matrix[block_1][1] = -1;
	    				block_1 = upper_block;
	    			}
	    			
	    		}
        		
        		matrix[Integer.parseInt(command[3])][1] = Integer.parseInt(command[1]);
        		matrix[Integer.parseInt(command[1])][0] = 0;
        		matrix[Integer.parseInt(command[3])][0] = block_2_state;
        	}
        	
        	if(command[0].equals("move") && command[2].equals("over")){
        		int block_2_state = matrix[Integer.parseInt(command[3])][0];
        		int block_1 = Integer.parseInt(command[1]);
	    		boolean tope = false;
				while (!tope){
					int upper_block = matrix[block_1][1];
	    			if(upper_block == -1){tope = true;matrix[block_1][0]=1;}
	    			else{
	    				matrix[block_1][0] = 1;
	    				matrix[block_1][1] = -1;
	    				block_1 = upper_block;
	    			}
	    			
	    		}
				
        		block_1 = Integer.parseInt(command[3]);
	    		tope = false;
				while (!tope){
					int upper_block = matrix[block_1][1];
	    			if(upper_block == -1){tope = true;matrix[block_1][1]=Integer.parseInt(command[1]);}
	    			else{
	    				block_1 = upper_block;
	    			}
	    			
	    		}
        		
        		matrix[Integer.parseInt(command[1])][0] = 0;
        		matrix[Integer.parseInt(command[3])][0] = block_2_state;
        	}
        	
        	if(command[0].equals("pile") && command[2].equals("onto")){
        		int block_2_state = matrix[Integer.parseInt(command[3])][0];
        		int block_1 = Integer.parseInt(command[3]);
	    		boolean tope = false;
				while (!tope){
					int upper_block = matrix[block_1][1];
	    			if(upper_block == -1){tope = true;matrix[block_1][0]=1;}
	    			else{
	    				matrix[block_1][0] = 1;
	    				matrix[block_1][1] = -1;
	    				block_1 = upper_block;
	    			}
	    			
	    		}
						
        		matrix[Integer.parseInt(command[1])][0] = 0;
        		matrix[Integer.parseInt(command[3])][0] = block_2_state;
        		
        		for(int i=0;i<n_tam;i++){
        			if(matrix[i][1]==Integer.parseInt(command[1])){matrix[i][1]=-1;}
        		}
        		
        		matrix[Integer.parseInt(command[3])][1] = Integer.parseInt(command[1]);
        	}
        	
        	if(command[0].equals("pile") && command[2].equals("over")){
        		for(int i=0;i<n_tam;i++){
        			if(matrix[i][1]==Integer.parseInt(command[1])){matrix[i][1]=-1;}
        		}        		
        		int block_1 = Integer.parseInt(command[1]);
        		block_1 = Integer.parseInt(command[3]);
	    		boolean tope = false;
				while (!tope){
					int upper_block = matrix[block_1][1];
	    			if(upper_block == -1){tope = true;matrix[block_1][1]=Integer.parseInt(command[1]);}
	    			else{
	    				block_1 = upper_block;
	    			}
	    			
	    		}
        		
        		matrix[Integer.parseInt(command[1])][0] = 0;
        	}
        }
        for(int i=0;i<n_tam;i++){
        	System.out.println(i + "->" + matrix[i][0] + " " + matrix[i][1]);
        }
    }
}

