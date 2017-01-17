import java.io.*;

class Main {
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String newLine = reader.readLine();
		String[] dimensions;
		int t = Integer.parseInt(newLine);
		String plateLetters;
		int plateNumbers;
		int[] letterNumbers = new int[3];
		int calcValue;
		
		for(int i = 0; i < t; i++)
			{
				newLine = reader.readLine();
				dimensions = newLine.split("-");
				plateLetters = dimensions[0];
				plateNumbers = Integer.parseInt(dimensions[1]);
				
				for(int j = 0; j < 26; j++)
					{
						if(plateLetters.charAt(0) == alphabet.charAt(j))
							letterNumbers[0] = j;
						if(plateLetters.charAt(1) == alphabet.charAt(j))
							letterNumbers[1] = j;
						if(plateLetters.charAt(2) == alphabet.charAt(j))
							letterNumbers[2] = j;
					}
				calcValue = (letterNumbers[0] * 26 * 26 + letterNumbers[1] * 26 + letterNumbers[2]);
				if(Math.abs(calcValue - plateNumbers) <= 100)
					System.out.println("nice");
				else
					System.out.println("not nice");
			}
		System.out.flush();
	}
}
				
