
def sortedArrayToBST( nums):
	if nums is None:
		return

	return medianSplit(nums,0,len(nums)-1)


def medianSplit(nums,left,right):
	if left>right:
		return []
	int mid = (left+right)//2
	node = Tree()
	node.val=mid
	node.left=medianSplit(nums,left,mid-1)
	node.right=medianSplit(nums,mid+1,right)

	return node
