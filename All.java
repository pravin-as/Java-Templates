//This code is written by प्रविण शंखपाळ 

package wizard;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.List;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;

import wizard.Ginny_Weasley.JaggedArrayComparator;

//Only class for codechef.

class All {

	public static void main(String[] args) {

		try {
			FastReader fr = new FastReader();
			PrintWriter pt = new PrintWriter(System.out);
			BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

			output.write(0);
			output.write("\n");
			output.flush();

			int n = fr.nextInt();

			ArrayList<Pair> x = new ArrayList<>();

			ArrayList<ArrayList<Integer>> list_sort = new ArrayList<>();
			Collections.sort(list_sort, new JaggedArrayComparator());

			for (int i = 0; i < n; i++) {

				Pair y = new Pair(fr.nextInt(), fr.nextInt());
				x.add(y);

			}

			Collections.sort(x);

			List<Integer> A = new ArrayList<>();

			for (int i = 0; i < n; i++) {

				A.add(fr.nextInt());

			}

			HashMap<Integer, Integer> hm = new HashMap<>();

			for (int i : A) {

				Integer j = hm.get(i);

				hm.put(i, (j == null) ? 1 : j + 1);

			}

			int ans = 0;

			for (HashMap.Entry<Integer, Integer> entry : hm.entrySet()) {

				ans = Math.max(ans, entry.getValue());

			}

			String sm = "PRAVIN";
			System.out.println(sm);
			int data[] = new int[sm.length()];
			ArrayList<String> mn = new ArrayList<>();
			String pp = "";

			while (findNextPermutation(data)) {

				pp = "";

				for (int j = 0; j < sm.length(); j++) {

					pp += (char) data[j];
				}
				mn.add(pp);

			}

			for (String i : mn) {

				System.out.println(i);

			}

			pt.close();

		} catch (Exception e) {
			return;
		}
	}

	static class JaggedArrayComparator implements Comparator<ArrayList<Integer>> {

		@Override
		public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
			int i = 0;
			while (i < o1.size() && i < o2.size() && o1.get(i) == o2.get(i)) {
				i++;
			}
			if (i < o1.size() && i < o2.size()) {
				return o1.get(i) - o2.get(i);
			}
			return o1.size() - o2.size();
		}

	}

	public static int findMaxGCD(int arr[], int n) {

		int high = 0;
		for (int i = 0; i < n; i++)
			high = Math.max(high, arr[i]);

		int count[] = new int[high + 1];
		for (int i = 0; i < n; i++)
			count[arr[i]]++;

		int counter = 0;

		for (int i = high; i >= 1; i--) {
			int j = i;

			while (j <= high) {

				if (count[j] > 0)
					counter += count[j];

				j += i;

				if (counter == 2)
					return i;
			}
			counter = 0;
		}
		return 1;
	}

	static void merge(int arr[], int l, int m, int r) {

		int n1 = m - l + 1;
		int n2 = r - m;

		int L[] = new int[n1];
		int R[] = new int[n2];

		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		int i = 0, j = 0;

		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	static void sort(int arr[], int l, int r) {
		if (l < r) {

			int m = l + (r - l) / 2;

			sort(arr, l, m);
			sort(arr, m + 1, r);

			merge(arr, l, m, r);
		}
	}

	static boolean isPalindrome(String str) {

		int i = 0, j = str.length() - 1;

		while (i < j) {

			if (str.charAt(i) != str.charAt(j))
				return false;

			i++;
			j--;
		}

		return true;
	}

	public static int[] swap(int data[], int left, int right) {

		int temp = data[left];
		data[left] = data[right];
		data[right] = temp;

		return data;
	}

	public static int[] reverses(int data[], int left, int right) {

		while (left < right) {
			int temp = data[left];
			data[left++] = data[right];
			data[right--] = temp;
		}

		return data;
	}

	static boolean findNextPermutation(int data[]) {

		if (data.length <= 1)
			return false;

		int last = data.length - 2;

		while (last >= 0) {
			if (data[last] < data[last + 1]) {
				break;
			}
			last--;
		}

		if (last < 0)
			return false;

		int nextGreater = data.length - 1;

		for (int i = data.length - 1; i > last; i--) {
			if (data[i] > data[last]) {
				nextGreater = i;
				break;
			}
		}

		data = swap(data, nextGreater, last);

		data = reverses(data, last + 1, data.length - 1);

		return true;
	}

	static class Pair implements Comparable<Pair> {
		int a, b;

		Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}

		public int compareTo(Pair o) {

			if (this.a != o.a)
				return Integer.compare(this.a, o.a);
			else
				return Integer.compare(this.b, o.b);

		}

		public boolean equals(Object o) {
			if (o instanceof Pair) {
				Pair p = (Pair) o;
				return p.a == a && p.b == b;
			}
			return false;
		}
	}

	static int getProduct(int n) {
		int product = 1;

		while (n != 0) {
			product = product * (n % 10);
			n = n / 10;
		}

		return product;
	}

	static ArrayList<String> x = new ArrayList<>();

	static void findsubsequences(String str, String ans) {

		if (str.length() == 0) {
			x.add(ans);
			return;
		}

		findsubsequences(str.substring(1), ans + str.charAt(0));
		findsubsequences(str.substring(1), ans);

	}

	static int LCSubStr(char X[], char Y[], int m, int n) {

		int LCStuff[][] = new int[m + 1][n + 1];

		int result = 0;

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					LCStuff[i][j] = 0;
				else if (X[i - 1] == Y[j - 1]) {
					LCStuff[i][j] = LCStuff[i - 1][j - 1] + 1;
					result = Integer.max(result, LCStuff[i][j]);
				} else
					LCStuff[i][j] = 0;
			}
		}
		return result;
	}

	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static int numberOfprimeFactors(int n) {
		HashSet<Integer> hs = new HashSet<Integer>();
		while (n % 2 == 0) {
			hs.add(2);
			n /= 2;
		}

		for (int i = 3; i <= Math.sqrt(n); i += 2) {

			while (n % i == 0) {
				hs.add(i);
				n /= i;
			}
		}

		if (n > 2)
			hs.add(n);
		return hs.size();
	}

	static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	static void reverse(int arr[], int start, int end) {
		int temp;

		while (start < end) {
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	static void reverse(long arr[], int start, int end) {
		long temp;

		while (start < end) {
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	static boolean isPrime(long n) {

		if (n <= 1)
			return false;
		if (n <= 3)
			return true;

		if (n % 2 == 0 || n % 3 == 0)
			return false;

		for (int i = 5; i * i <= n; i = i + 6)
			if (n % i == 0 || n % (i + 2) == 0)
				return false;

		return true;
	}

	static int p2(int n) {
		int k = 0;
		while (n > 1) {
			if (n % 2 != 0)
				return k;
			n /= 2;
			k++;
		}
		return k;
	}

	static boolean isp2(int n) {
		while (n > 1) {
			if (n % 2 == 1)
				return false;
			n /= 2;
		}
		return true;
	}

	static int binarySearch(int arr[], int first, int last, int key) {
		int mid = (first + last) / 2;
		while (first <= last) {
			if (arr[mid] < key) {
				first = mid + 1;
			} else if (arr[mid] == key) {
				return mid;
			} else {
				last = mid - 1;
			}
			mid = (first + last) / 2;
		}
		return -1;
	}

	static int ans(int A[], int n) {
		int global_max = A[0];
		int max = A[0];

		for (int i = 1; i < n; i++) {
			max = Math.max(A[i], max + A[i]);
			global_max = Math.max(global_max, max);
		}
		return global_max;
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

}
