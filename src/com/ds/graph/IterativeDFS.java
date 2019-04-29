package com.ds.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeDFS {

	private int V;
	private List<Integer>[] adjList;

	public IterativeDFS(int V) {
		this.V = V;
		this.adjList = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			this.adjList[i] = new ArrayList<>();
		}
	}

	public void addEdge(int src, int dest) {
		adjList[src].add(dest);
	}

	public void iterativeDFSTraversal(int src) {
		boolean[] visited = new boolean[V];
		for (int i = 0; i < V; i++) {
			visited[i] = false;
		}

		Stack<Integer> stack = new Stack<>();
		stack.push(src);

		while (!stack.isEmpty()) {
			src = stack.pop();
			System.out.print(src + " ");
			if (!visited[src] == true) {
				visited[src] = true;
			}

			for (int i : adjList[src]) {
				if (!visited[i] == true) {
					visited[i] = true;
					stack.push(i);
				}
			}
		}
	}

	public static void main(String[] args) {
		
		IterativeDFS g = new IterativeDFS(5);

		g.addEdge(1, 0);
		g.addEdge(0, 2);
		g.addEdge(2, 1);
		g.addEdge(0, 3);
		g.addEdge(1, 4);

		System.out.println("Following is the Depth First Traversal");
		g.iterativeDFSTraversal(0);

	}

}
