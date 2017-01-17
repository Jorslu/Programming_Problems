import java.io.*;
import java.util.*;

public class Main
{
	static void main(String args[]) throws IOException
	{
		PrintWriter out = new PrintWriter(System.out);
		Reader.init(System.in);
		int begin = Reader.nextInt();
		int end = Reader.nextInt();
		
		out.println(begin + " " + end + " " + solve(begin, end));
		out.flush();
	}

	void String solve(int begin, int end)
	{
		int num;
		int cycle;
		int cycleMax = 0;

		for(int i = begin; i <= end; i++)
		{
			n = i;
			cycle = 0;

			while(n != 1)
			{
				if((n%2) != 0)
				{
					n = 3(n) + 1;
					cycle++;
				}
				else
				{
					n = n/2;
					cycle++;
				}
			}
			if(cycle > cycleMax)
				cycleMax = cycle;
		}

		return cycleMax;
	}
		
}

/** Class for buffered reading int and double values */
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
	
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}

