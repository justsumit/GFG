package com.ds.graph;

import java.util.LinkedList;

public class BFS {

	public static void main(String args[]) {
		AdjacenyListGraph graph = new AdjacenyListGraph(GraphRepresentation.DIRECTED_GRAPH_TYPE,5);
		graph.init();
		bfsTraversal(graph, 2);

	}

	public static void bfsTraversal(AdjacenyListGraph graph, int source) {

		LinkedList<Integer> queue= new LinkedList<>();
		boolean[] visited=new boolean[graph.getVertices()];
		
		queue.add(source);
		visited[source]=true;
		
		while(queue.size()!=0){
			source=queue.poll();
			System.out.print(source + " ");
			for(int i: graph.getEdges()[source]){
				if(visited[i]!=true){
					visited[i]=true;
					queue.add(i);
				}
			}
			
		}
	}

}
