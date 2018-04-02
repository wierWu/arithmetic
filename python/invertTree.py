def invertTree(root):
	
	if root is None:
		return

	left = root.left
	right =root.right
	if left:
		root.right =left
		invertTree(left)
 	if right:
 		root.left=right
 		invertTree(right)

 	return root

if __name__ == "__main__":
