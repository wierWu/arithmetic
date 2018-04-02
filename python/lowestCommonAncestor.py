def lowestCommonAncestor(root, p, q):
	if root is None or root == p or root ==q:
		return root

	left = lowestCommonAncestor(root.left,p,q)
	right = lowestCommonAncestor(root.right,p,q)

	if left is None:
		return right
	elif right is None:
		return left
	else:
		return root
 	

def lowestCommonAncestor2(root,p,q):
	if root is None or root == p or root ==q:
		return root

	#查找root的左子树，发现是否有p或者p,有的话返回
	left = lowestCommonAncestor2(root.left,p,q)
	# 查找右子树，发现是否有p或者q，有则返回
	right = lowestCommonAncestor2(root.right,p,q)

	#左树和右树都找到了，说明当前节点是公共父节点
	if left and right:
		return root 

# 右边没有p或者q ，肯定在左边
	if left and right is None:
		return left

# 左边没有q或者p，肯定都在右边
	if right and left is None:
		return right

