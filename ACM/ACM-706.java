import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String newLine = reader.readLine();
        String[] dimensions = newLine.split("\\s");
        int size;
        int number;
		ArrayList<Integer> num = new ArrayList<>();
		String lineOut = "";
        
        do
        {
            size = Integer.parseInt(dimensions[0]);
            number = Integer.parseInt(dimensions[1]);

			if(number == 0)
				num.add(0);
				
			while(number > 0)
			{
				num.add(number % 10);
				number = number / 10;
			}
			
			if(num.size() != dimensions[1].length())
				for(int i = 0; i < dimensions[1].length() - num.size(); i++)
					num.add(0);
			
			//top
			for(int i = 0; i < num.size(); i++)
			{
				if(num.get(i) != 1 && num.get(i) != 4)
				{
					lineOut = " " + lineOut;
					for(int j = 0; j < size; j++)
						lineOut = "-" + lineOut;
					lineOut = " " + lineOut;
				}
				else
					for(int j = 0; j < size + 2; j++)
						lineOut = " " + lineOut;

				if(i != num.size() - 1)
					lineOut = " " + lineOut;
			}
			System.out.println(lineOut);
			lineOut = "";

			//upper
			for(int i = 0; i < num.size(); i++)
				{
					if(num.get(i) == 1 || num.get(i) == 2 || num.get(i) == 3 || num.get(i) == 7)
						{
							lineOut = "|" + lineOut;
							for(int j = 0; j < size; j++)
								lineOut = " " + lineOut;
							lineOut = " " + lineOut;
						}
					else if(num.get(i) == 5 || num.get(i) == 6)
						{
							lineOut = " " + lineOut;
							for(int j = 0; j < size; j++)
								lineOut = " " + lineOut;
							lineOut = "|" + lineOut;
						}
					else
						{
							lineOut = "|" + lineOut;
							for(int j = 0; j < size; j++)
								lineOut = " " + lineOut;
							lineOut = "|" + lineOut;
						}

					if(i != num.size() - 1)
						lineOut = " " + lineOut;
				}
			for(int i = 0; i < size; i++)
				System.out.println(lineOut);
			lineOut = "";

			//mid
			for(int i = 0; i < num.size(); i++)
				{
					if(num.get(i) == 1 || num.get(i) == 7 || num.get(i) == 0)
							for(int j = 0; j < size + 2; j++)
								lineOut = " " + lineOut;
					else
						{
							lineOut = " " + lineOut;
							for(int j = 0; j < size; j++)
								lineOut = "-" + lineOut;
							lineOut = " " + lineOut;
						}
					
					if(i != num.size() - 1)
						lineOut = " " + lineOut;
				}
			System.out.println(lineOut);
			lineOut = "";

			//lower
			for(int i = 0; i < num.size(); i++)
				{
					if(num.get(i) == 2)
						{
							lineOut = " " + lineOut;
							for(int j = 0; j < size; j++)
								lineOut = " " + lineOut;
							lineOut = "|" + lineOut;
						}
					else if(num.get(i) == 6 || num.get(i) == 8 || num.get(i) == 0)
						{
							lineOut = "|" + lineOut;
							for(int j = 0; j < size; j++)
								lineOut = " " + lineOut;
							lineOut = "|" + lineOut;
						}
					else
						{
							lineOut = "|" + lineOut;
							for(int j = 0; j < size; j++)
								lineOut = " " + lineOut;
							lineOut = " " + lineOut;
						}

					if(i != num.size() - 1)
						lineOut = " " + lineOut;
				}
			for(int i = 0; i < size; i++)
				System.out.println(lineOut);
			lineOut = "";

			//bottom
			for(int i = 0; i < num.size(); i++)
			{
				if(num.get(i) != 1 && num.get(i) != 4 && num.get(i) != 7)
				{
					lineOut = " " + lineOut;
					for(int j = 0; j < size; j++)
						lineOut = "-" + lineOut;
					lineOut = " " + lineOut;
				}
				else
					for(int j = 0; j < size + 2; j++)
						lineOut = " " + lineOut;

				if(i != num.size() - 1)
					lineOut = " " + lineOut;
			}
			System.out.println(lineOut);
			lineOut = "";
            
			System.out.println();
			num.clear();
			newLine = reader.readLine();
			dimensions = newLine.split("\\s");
        }while(!dimensions[0].equals("0") && !dimensions[1].equals("0"));
        System.out.println();
        System.out.flush();
    }   
}  
