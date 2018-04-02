
pre =null 

def flatten(root):
	if root is None:
		return

	flatten(root.right)
	flatten(root.left)
	root.right=pre
	root.left=null
	pre =root
	
