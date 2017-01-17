import java.io.*;

class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String newLine = reader.readLine();
        String[] dimensions = newLine.split("\\s");
        int fieldCounter = 1;
        int row;
        int column;
        int field[][];
        
        do
        {
            if(fieldCounter != 1)
                System.out.println();
            row = Integer.parseInt(dimensions[0]);
            column = Integer.parseInt(dimensions[1]);
            
            newLine = reader.readLine();
            field = new int[row + 2][column + 2];
            
            for(int i= 0; i < row + 2; i++)
                for(int j = 0; j < column + 2; j++)
                    field[i][j] = 0;
            
            for(int i = 1; i <= row; i++)
            {
                for(int j = 1; j <= column; j++)
                {
                    if(newLine.charAt(j - 1) == '*')
                        field[i][j] = 9;
                }
                newLine = reader.readLine();
            }
            
            for(int i = 1; i <= row; i++)
                for(int j = 1; j<= column; j++)
                {
                    if(field[i][j] >= 9)
                    {
                        field[i-1][j-1] += 1;
                        field[i-1][j] += 1;
                        field[i-1][j+1] += 1;
                        field[i][j-1] += 1;
                        field[i][j+1] += 1;
                        field[i+1][j-1] += 1;
                        field[i+1][j] += 1;
                        field[i+1][j+1] += 1;
                    }
                }
            
            System.out.println("Field #" + fieldCounter + ":");
            fieldCounter += 1;
            
            for(int i = 1; i <= row; i++)
            {
                for(int j = 1; j<= column; j++)
                {
                    if(field[i][j] >= 9)
                        System.out.print('*');
                    else
                        System.out.print(field[i][j]);
                }
                System.out.println();
            }
            dimensions = newLine.split("\\s");
        }while(!dimensions[0].equals("0") && !dimensions[1].equals("0"));
        
         System.out.flush();
    }   
}
