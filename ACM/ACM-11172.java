import java.io.*;

class Main{
	public static void main(String [] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String newLine = reader.readLine();
		String[] dimensions;
		int t = Integer.parseInt(newLine);
		int a, b;

		for(int i = 0; i < t; i++)
			{
				newLine = reader.readLine();
				dimensions = newLine.split("\\s");
				a = Integer.parseInt(dimensions[0]);
				b = Integer.parseInt(dimensions[1]);

				if(a  == b)
					System.out.println("=");
				if(a < b)
					System.out.println("<");
				if(a > b)
					System.out.println(">");
			}

		System.out.flush();
	}
}
				
