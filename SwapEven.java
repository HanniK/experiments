package swap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SwapEven {

	public static List<Character> swapArray(List<Character> input) {
		List<Character> swapped = new ArrayList<Character>();
		if (input.size() > 2) {
			Character temp = input.get(0);
			input.set(0, input.get(1));
			input.set(1, temp);
			swapped = copyFirstTwo(swapped, input);
			input = removeFirstTwo(input);
			swapped.addAll(swapArray(input));
			return swapped;
		} else {
			return input;
		}
	}

	public static List<Character> copyFirstTwo(List<Character> swapped,
			List<Character> input) {
		if (input.size() <= 2) {
			return swapped;
		}
		for (int i = 0; i < 2; i++) {
			swapped.add(input.get(i));
		}
		return swapped;
	}

	public static List<Character> removeFirstTwo(List<Character> input) {
		if (input.size() <= 2) {
			return input;
		}
		List<Character> remove = new ArrayList<Character>();
		for (int i = 0; i < input.size() - 2; i++) {
			remove.add(i, input.get(i + 2));
		}
		return remove;
	}

	public static void swapAjacent(List<char[]> lines) {
		int lineCount = lines.size();
		for (int i = 0; i < lineCount; i++) {
			char[] ary = lines.get(i);
			List<char[]> asList = Arrays.asList(ary);
			List<Character> listC = new ArrayList<Character>();
			for (char c : ary) {
				listC.add(c);
			}
			System.out.println(swapArray(listC));
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
			swapAjacent(stringLines);
		}
	}
}