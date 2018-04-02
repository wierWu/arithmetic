
#图算法https://www.khanacademy.org/computing/computer-science/algorithms/graph-representation/a/representing-graphs
#图链表
graph_edge_list=[[0,1], [0,6], [0,8], [1,4], [1,6], [1,9], [2,4], [2,6], [3,4], [3,5],[3,8], [4,5], [4,9], [7,8], [7,9] ] 

#图矩阵
graph_matrices=[  [0, 1, 0, 0, 0, 0, 1, 0, 1, 0],
  				  [1, 0, 0, 0, 1, 0, 1, 0, 0, 1],
				  [0, 0, 0, 0, 1, 0, 1, 0, 0, 0],
				  [0, 0, 0, 0, 1, 1, 0, 0, 1, 0],
				  [0, 1, 1, 1, 0, 1, 0, 0, 0, 1],
				  [0, 0, 0, 1, 1, 0, 0, 0, 0, 0],
				  [1, 1, 1, 0, 0, 0, 0, 0, 0, 0],
				  [0, 0, 0, 0, 0, 0, 0, 0, 1, 1],
				  [1, 0, 0, 1, 0, 0, 0, 1, 0, 0],
				  [0, 1, 0, 0, 1, 0, 0, 1, 0, 0] 
				]
#图邻接表				
graph_adjacency_list=[ [1, 6, 8],
  [0, 4, 6, 9],
  [4, 6],
  [4, 5, 8],
  [1, 2, 3, 5, 9],
  [3, 4],
  [0, 1, 2],
  [8, 9],
  [0, 3, 7],
  [1, 4, 7] ]

from queue import Queue
#宽度搜索算法(没有避免环的问题)
def bfs(adjacency_list[x];,start,target):
	if graph_adjacency_list is None:
		return False

	if start>=len(graph_adjacency_list) or target>=len(graph_adjacency_list):
		return False

	queue=Queue()
	queue.put(start)
	visted=[None]*len(graph_adjacency_list)
	visted[start]=1

	while not queue.empty():
		point = queue.get()
		if point == target:
			return True
			
		for i in graph_adjacency_list[point]:
			if not visted[i]:
				queue.put(i)

	return False

#深度搜索算法
def dfs(graph_adjacency_list,visted,start,target):
	if graph_adjacency_list is None:
		return False

	graph_leg =len(graph_adjacency_list)
	if start>=graph_leg or target>=graph_leg:
		return False

	if start==target:
		return True


	visted[start]=1
	for i in graph_adjacency_list[start]:
		if not visted[i]:
			if dfs(graph_adjacency_list,visted,i,target):
				return True
					
	return False

if __name__ == "__main__":
	print(bfs(graph_adjacency_list,0,9))
	visted =[None]*10
	print('dfs')
	print(dfs(graph_adjacency_list,visted,0,9))