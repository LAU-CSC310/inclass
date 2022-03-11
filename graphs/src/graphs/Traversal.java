package graphs;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
/*Simple implementation of BFS traversal
 * 
 */
public class Traversal {
	
	public static void main(String[] args) {
		BfsGraph g=new BfsGraph();
		BfsVertex[] nodes=new BfsVertex[6];
		for(int i=0;i<6;++i)
			nodes[i]=new BfsVertex(Integer.toString(i));
		/* The graph has 6 vertices with connections
		 * 0-1, 0-5,1-0,1-2,1-3,2-1,2-4,3-1,3-4,3-5
		 * 4-2,4-3,5-0,5-3
		 * Usually the connection are added from some
		 * description file but this will do.
		 */
		nodes[0].addAdj(nodes[1]);nodes[0].addAdj(nodes[5]);
		nodes[1].addAdj(nodes[0]);nodes[1].addAdj(nodes[2]);
		     nodes[1].addAdj(nodes[3]);
		nodes[2].addAdj(nodes[1]);nodes[2].addAdj(nodes[4]);
		nodes[3].addAdj(nodes[1]);nodes[3].addAdj(nodes[4]);
		     nodes[3].addAdj(nodes[5]);
		nodes[4].addAdj(nodes[2]);nodes[4].addAdj(nodes[3]);
		nodes[5].addAdj(nodes[0]);nodes[5].addAdj(nodes[3]);
		    
		// add nodes to graph
		for(int i=0;i<6;++i)
			g.addVertex(nodes[i]);
		
		bfs(g);
		
		
	}
	static void bfs(BfsGraph g) {
		Iterator<BfsVertex> itr=g.getVertices().iterator();
		while(itr.hasNext()) {
			BfsVertex v=itr.next();
			if(!v.visited)
				bfsVisit(v);
		}
	}
	static void bfsVisit(BfsVertex source) {
		
		Queue<BfsVertex> q=new LinkedList<BfsVertex>();
		source.visited=true;
		q.add(source);
		while(!q.isEmpty()) {
			BfsVertex u=q.remove();
			System.out.print("node="+u.label+",d="+u.d
				     +",pred="+(u.p==null?"null":u.p.label)
							);
					System.out.println("");
			Iterator<BfsVertex> itr=u.getAdj().iterator();
			
			while(itr.hasNext()) {
				BfsVertex v=itr.next();
				if(!v.visited) {
					v.p=u;
					v.d=u.d+1;
					v.visited=true;
					q.add(v);
				}
			}
		}
		
	}
	
	

}
class BfsVertex{
	boolean visited;
	//predecessor
	BfsVertex p;
	int d=0;
	String label;
	LinkedList<BfsVertex> adj;
	
	public BfsVertex(String label) {
		this.label=label;
		adj=new LinkedList<BfsVertex>();
	}
	void addAdj(BfsVertex v) {
		adj.add(v);
	}
	LinkedList<BfsVertex> getAdj(){
		return adj;
	}
}
class BfsGraph{
	int n;
	LinkedList<BfsVertex> vertices;

	public BfsGraph() {
		n=0;
		vertices=new LinkedList<BfsVertex>();
	}
	void addVertex(BfsVertex v) {
		n++;
		vertices.add(v);
	}
	LinkedList<BfsVertex> getVertices(){
	    
		return vertices;
	}
	
}
