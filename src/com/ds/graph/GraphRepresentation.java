package com.ds.graph;

import java.util.LinkedList;

public class GraphRepresentation {
	
	public static final String DIRECTED_GRAPH_TYPE="D";
	public static final String UNDIRECTED_GRAPH_TYPE="U";

	public static void main(String[] args) {

		AdjMatrixGraph amGraph = new AdjMatrixGraph(GraphRepresentation.UNDIRECTED_GRAPH_TYPE,5);
		amGraph.init();
		amGraph.printGraph();

		AdjListGraph alGraph = new AdjListGraph(GraphRepresentation.UNDIRECTED_GRAPH_TYPE,5);
		alGraph.init();
		alGraph.printGraph();

	}

}

class AdjMatrixGraph {

	private String graphType;
	private int vertices;
	private Integer[][] edges;

	public AdjMatrixGraph(String graphType,int vertices) {
		this.graphType = graphType;
		this.vertices = vertices;
		this.edges = new Integer[vertices][vertices];

		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				edges[i][j] = 0;
			}
		}
	}

	public void addEdge(int src, int dest) {
		edges[src][dest] = 1;
		if(this.graphType.equals(GraphRepresentation.UNDIRECTED_GRAPH_TYPE)){
			edges[dest][src] = 1;
		}
	}

	public void removeEdge(int src, int dest) {
		edges[src][dest] = 0;
		if(this.graphType.equals(GraphRepresentation.UNDIRECTED_GRAPH_TYPE)){
			edges[dest][src] = 0;
		}
	}

	public void printGraph() {
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				System.out.print(edges[i][j] + " ");
			}
			System.out.print("\n");
		}

		System.out.print("-----------------------------------------------------------");
	}

	public void init() {
		this.addEdge(0, 1);
		this.addEdge(0, 2);
		this.addEdge(1, 2);
		this.addEdge(2, 0);
		this.addEdge(2, 3);
		this.addEdge(3, 3);
	}

	public int getVertices() {
		return vertices;
	}

	public void setVertices(int vertices) {
		this.vertices = vertices;
	}

	public Integer[][] getEdges() {
		return edges;
	}

	public void setEdges(Integer[][] edges) {
		this.edges = edges;
	}

	public String getGraphType() {
		return graphType;
	}

	public void setGraphType(String graphType) {
		this.graphType = graphType;
	}
	

}

class AdjListGraph {

	private String graphType;
	private int vertices;
	private LinkedList<Integer>[] edges;

	public AdjListGraph(String graphType,int vertices) {
		this.graphType = graphType;
		this.vertices = vertices;
		this.edges = new LinkedList[vertices];

		for (int i = 0; i < vertices; i++) {
			edges[i] = new LinkedList<>();
		}
	}

	public void addEdge(int src, int dest) {
		if (!edges[src].contains(dest)) {
			edges[src].add(dest);
		}
		if(this.graphType.equals(GraphRepresentation.UNDIRECTED_GRAPH_TYPE)){
			if (!edges[dest].contains(src)) {
				edges[dest].add(src);
			}
		}
	}

	public void removeEdge(int src, int dest) {
		if (edges[src].contains(dest)) {
			edges[src].remove(dest);
		}
		if(this.graphType.equals(GraphRepresentation.UNDIRECTED_GRAPH_TYPE)){
			if (edges[dest].contains(src)) {
				edges[dest].remove(src);
			}
		}
	}

	public void printGraph() {
		for (int i = 0; i < vertices; i++) {
			System.out.println("\nAdjacency List of Vertex :" + i);
			for (Integer j : edges[i]) {
				System.out.print("->" + j);
			}
			System.out.print("\n");
		}
		System.out.print("-----------------------------------------------------------");
	}

	public void init() {
		this.addEdge(0, 1);
		this.addEdge(0, 2);
		this.addEdge(1, 2);
		this.addEdge(2, 0);
		this.addEdge(2, 3);
		this.addEdge(3, 3);
	}

	public int getVertices() {
		return vertices;
	}

	public void setVertices(int vertices) {
		this.vertices = vertices;
	}

	public LinkedList<Integer>[] getEdges() {
		return edges;
	}

	public void setEdges(LinkedList<Integer>[] edges) {
		this.edges = edges;
	}

}