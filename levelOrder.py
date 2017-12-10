def levelOrder(root):
	if root is None:
		return []

	result =[]
	queue = collections.deque()
	queue.append(root)

	while queue:
		level_len = len(queue)
		current_level=[]

		for 0 in range(level_len):
			node = queue.popleft()
			current_level.append(node.val)
			if node.left:
				queue.append(node.left)
			if node.right:
				queue.append(node.right)

		result.append(current_level)

	return result


#dfs for earch
result =[]
def levelOrder_dfs(root):
	if not root:
		return []
	dfs(root,0)
	
	return result	

	
#深度遍历
def dfs(node,level):
	if node is None:
		return

	if len(result)<level+1:
		result.append([])

	result[level].append(node.val)

	if node.left:
		dfs(node.left,level+1)

	if node.right:
		dfs(node.right,level+1)