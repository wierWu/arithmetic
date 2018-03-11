 
def canFinish_BFS(numCourses, prerequisites):
	if prerequisites is None or numCourses>= len(prerequisites):
		return False

	graph_adjacency_list =[None]*numCourses
	degree =[None]*numCourses
	count=0

	#链表转换为邻接表
	for i in range(0,len(prerequisites)):
		if degree[prerequisites[i][1]] is None:
			degree[prerequisites[i][1]]=0

		degree[prerequisites[i][1]]+=1 #入度+1
		if graph_adjacency_list[prerequisites[i][0]] is None:
			graph_adjacency_list[prerequisites[i][0]]=[] 

		graph_adjacency_list[prerequisites[i][0]].append(prerequisites[i][1])

	print(graph_adjacency_list)
	from queue import Queue

	queue=Queue()
	#找到顶点
	for d in range(0,numCourses):
		if degree[d]==0:
			queue.put(d)
			count+=1


	#前续的课程入度-1，若全部修完，标识它没有人依赖，可以通过它来找下一个路径
	while not queue.empty():
		course = queue.get()
		for c in graph_adjacency_list[course]:
			degree[c]-=1
			if degree[c]==0:
				queue.put(c)
				count+=1
	print(count)
	return count==numCourses	


def canFinish_DFS(numCourses, prerequisites):

	if prerequisites is None or numCourses>= len(prerequisites):
		return False

	graph_adjacency_list =[None]*numCourses
	visited =[None]*numCourses
	count=0

	#链表转换为邻接表
	for i in range(0,len(prerequisites)):

		if graph_adjacency_list[prerequisites[i][1]] is None:
			graph_adjacency_list[prerequisites[i][1]]=[] 

		graph_adjacency_list[prerequisites[i][1]].append(prerequisites[i][0])


	#深度查找每个顶点，看是否有闭环	
	for vertex in range(0,numCourses):

		if(not dfs(graph_adjacency_list,visited,vertex)):
			return False

	return True		


def dfs(graph_adjacency_list,visited,course):
	if visited[course]:
		return False

	visited[course]=True	

	if not graph_adjacency_list[course]:
		return True

	for vertex in graph_adjacency_list[course]:
		if(vertex and not dfs(graph_adjacency_list,visited,vertex)):
			return False

	#当前顶点查找过后，恢复，方便后续顶点查找
	visited[course]=False

	return True


if __name__ == "__main__":
	courses=[[0,1], [0,6], [0,8], [1,4], [1,6], [1,9], [2,4], [2,6], [3,4], [3,5],[3,8], [4,5], [4,9], [7,8], [7,9] ] 
	print(canFinish_BFS(10,courses))
	print(canFinish_DFS(10,courses))

