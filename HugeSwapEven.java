package swap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class HugeSwapEven {

	public static LinkedList<Character> swapArray(LinkedList<Character> swapped, LinkedList<Character> input) {
		if (input.size() > 2) {
			swapAndCopyFirstTwo(swapped, input);
			swapArray(swapped, input);
			return swapped;
		} else {
			if (input.size() == 2) {
				Collections.swap(input, 0, 1);
			}
			swapped.addAll(input);
			return swapped;
		}
	}

	public static void swapAndCopyFirstTwo(LinkedList<Character> swapped, LinkedList<Character> input) {
		if (input.size() <= 2) {
			return;
		}
		Collections.swap(input, 0, 1);
		swapped.add(input.removeFirst());
		swapped.add(input.removeFirst());
	}

	public static void swapAjacent(List<char[]> lines) {
		int lineCount = lines.size();
		for (int i = 0; i < lineCount; i++) {
			char[] ary = lines.get(i);
			List<Character> listC = new ArrayList<Character>();
			for (char c : ary) {
				listC.add(c);
			}
			if (listC.size() > 10000) {// divide the huge list in smaller
										// partitions for performance
				int partitionSize = 100;
				List<List<Character>> partitions = new LinkedList<List<Character>>();
				for (int kk = 0; kk < listC.size(); kk += partitionSize) {
					partitions.add(listC.subList(kk, Math.min(kk + partitionSize, listC.size())));
				}
				LinkedList<Character> result = new LinkedList<Character>();
				for (Iterator iterator = partitions.iterator(); iterator.hasNext();) {
					List<Character> part = (List<Character>) iterator.next();
					LinkedList<Character> swapped = new LinkedList<Character>();
					LinkedList<Character> convert = new LinkedList<Character>();
					convert.addAll(part);
					result.addAll(swapArray(swapped, convert));
				}
				System.out.println(result);
			} else {
				LinkedList<Character> swapped = new LinkedList<Character>();
				LinkedList<Character> convert = new LinkedList<Character>();
				convert.addAll(listC);
				System.out.println(swapArray(swapped, convert));
			}

		}
	}

	public static void main(String[] args) throws IOException {
		int lineCount = 0;
		List<char[]> stringLines = new LinkedList<char[]>();
		BufferedReader br = new BufferedReader(new FileReader("src/swap/input05.txt"));
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			try {
				lineCount = Integer.parseInt(line);
			} catch (Exception e) {
				System.err.println("Input format wrong (or) input not found");
			}
			for (int i = 0; i < lineCount; i++) {
				line = br.readLine();
				stringLines.add(line.toCharArray());
			}
		} finally {
			br.close();
		}
		swapAjacent(stringLines);
	}
}