package com.ds.graph;

public class DFS {

	public static void main(String args[]) {
		AdjacenyListGraph graph = new AdjacenyListGraph(GraphRepresentation.DIRECTED_GRAPH_TYPE,5);
		graph.init();
		graph.printGraph();
		dfsTraversal(graph, 2);

	}

	public static void dfsTraversal(AdjacenyListGraph graph, int source) {
		
		boolean[] visited=new boolean[graph.getVertices()];
		dfsUtil(graph,source,visited);
	}
	
	private static void dfsUtil(AdjacenyListGraph graph, int source,boolean[] visited){
		System.out.print(source + " ");
		visited[source]=true;
		for(int i:graph.getEdges()[source]){
			if(visited[i]!=true){
				dfsUtil(graph, i, visited);
			}
		}
		
	}
	
	
	
}
