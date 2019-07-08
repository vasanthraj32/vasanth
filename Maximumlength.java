package max;

import java.util.*;

public class Maximumlength
{
	static final int MAX_CHARS = 256;

	public static void main(String args[])
	{
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter the input string:");
		String str_name = obj.next();
		int len = str_name.length();
		int len_count = 0;
		boolean[] r = new boolean[MAX_CHARS];
		Arrays.fill(r, false);
		for (int i = 0; i < len; i++) {
			if (r[str_name.charAt(i)] == false)
			{
				r[str_name.charAt(i)] = true;
				len_count++;
			}
		}
		int st = 0, str_index = -1;
		int min_len = Integer.MAX_VALUE;
		int count = 0;
		int[] end_count = new int[MAX_CHARS];
		for (int i = 0; i < len; i++)
		{
			end_count[str_name.charAt(i)]++;

			if (end_count[str_name.charAt(i)] == 1)
				count++;
			if (count == len_count) 
			{
				while (end_count[str_name.charAt(st)] > 1)
				{
					if (end_count[str_name.charAt(st)] > 1)
						end_count[str_name.charAt(st)]--;
					st++;
				}
				int len_window = i - st + 1;
				if (min_len > len_window)
				{
					min_len = len_window;
					str_index = st;
				}
			}
		}
		System.out.println("the maximum count is:");
		System.out.print(str_name.substring(str_index, str_index + min_len).length());
	}

}
