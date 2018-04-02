def largestValues(root):
	if root is None:
		return []
	return dfs(root,0,[])


def dfs(root,level,maxArr):
	if not root:
		return maxArr

	if len(maxArr) == level:
		maxArr.append(root.val)
	else:
		maxArr.insert(level,max(maxArr[level],root.val))

	dfs(root.left,level+1,maxArr)
	dfs(root.right,level+1,maxArr)

	return maxArr
		


if __name__ == "__main__":
	
