import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(); int k = in.nextInt();
		StringBuilder sb = new StringBuilder();
		Deque<Integer> queue = new ArrayDeque<>();
		ArrayList<Integer> result = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			queue.offer(i);
		}

		while (!queue.isEmpty()) {
			for (int i = 0; i < k - 1; i++) {
				queue.offer(queue.poll());
			}
			result.add(queue.poll());
		}

		sb.append("<");
		for (int i = 0; i < result.size(); i++) {
			sb.append(result.get(i));
			if (i != result.size() - 1) {
				sb.append(", ");
			}
		}
		sb.append(">");

		System.out.println(sb.toString());
	}
}


