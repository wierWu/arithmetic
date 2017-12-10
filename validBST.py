
import sys
min_value=-sys.maxsize-1

#in-order valid
def isValidBST(root):

	if root is None:
		return True

	if not isValidBST(root.left):
		return False

	if root.val <= min_value:
		return False
	min_value = root.val

	if not isValidBST(root.right):
		return False

	return True


#in-order 2
def isValidBST(root,minVal,maxVal):
	if root is None:
		return True

	if root.val>=maxVal or root.val <=minVal:
		return False

	return isValidBST(root.left,minVal,root.val) and isValidBST(root.right,root.val,maxVal)

