package swap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SwapEven {
	public static char[] swapArray(char[] input) {
		if (input.length > 1) {
			char temp = input[0];
			input[0] = input[1];
			input[1] = temp;
			swapArray(removeFirstTwo(input));
			System.out.println(input);
		}
		return input;
	}

	public static char[] removeFirstTwo(char[] input) {
		char[] copy = new char[input.length - 2];
		for (int i = 0; i < input.length - 2; i++) {
			copy[i] = input[i + 2];
		}
		return copy;
	}

	public static void swapArray(List<char[]> arrays) {
		int lineCount = arrays.size();
		for (int i = 0; i < lineCount; i++) {
			System.out.println(swapArray(arrays.get(i)));
		}
	}

	public static void main(String[] args) throws IOException {
		int lineCount = 0;
		List<char[]> stringLines = new ArrayList<char[]>();
		BufferedReader br = new BufferedReader(new FileReader(
				"src/swap/input05.txt"));
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			lineCount = Integer.parseInt(line);
			for (int i = 0; i < lineCount; i++) {
				line = br.readLine();
				stringLines.add(line.toCharArray());
			}
		} finally {
			br.close();
		}

		if (lineCount > 0) {
			swapArray(stringLines);
		}
	}
}
