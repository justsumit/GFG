package com.ds.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TransitiveClosure {

	private int V;
	private List<Integer>[] adjList;
	private int[][] tc;

	public TransitiveClosure(int V) {
		this.V = V;
		this.adjList = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}
		this.tc = new int[V][V];

	}

	public void addEdge(int src, int dest) {
		adjList[src].add(dest);

	}

	public void findTransitiveClosure() {

		for (int i = 0; i < V; i++) {
			dfsUtil(i, i);
		}

		for (int i = 0; i < V; i++) {
			System.out.println(Arrays.toString(tc[i]));
		}
	}

	public void dfsUtil(int src, int dest) {
		tc[src][dest] = 1;
		for (int i : adjList[dest]) {
			if (tc[src][i] == 0) {
				dfsUtil(src, i);
			}
		}
	}

	public static void main(String[] args) {

		TransitiveClosure g = new TransitiveClosure(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		System.out.println("Transitive closure " + "matrix is");

		g.findTransitiveClosure();

	}

}
