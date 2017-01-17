import java.io.*;
import java.util.*;
import java.math.BigInteger;

	class Main {
		public static void main(String[] args) throws IOException
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String newLine;
			BigInteger number;
			BigInteger p;
			BigInteger counter;
			BigInteger multiply;

			while((newLine=reader.readLine()) != null)
				{
					number = BigInteger(newLine);
					p = 1;
					counter = 1;
					multiply = 2;
					while(p < number)
					{
						if(p == 1)
							p++;
						else 
						{
							p = p * multiply;
							if(multiply < 9)
								multiply++;
							else
								multiply = 2;
							counter++;
						}	
					}
					if(counter % 2 == 0)
						System.out.println("Ollie wins.");
					else
						System.out.println("Stan wins.");
				}
			System.out.flush();
		}
	}
