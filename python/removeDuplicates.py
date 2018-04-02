
#https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/discuss/
def removeDuplicates( nums):
	newLen=0

	for num in nums:
		if newLen<2 or num > nums[newLen-2]:
			nums[newLen]=num
			newLen+=1

	return newLen



if __name__ == "__main__":
	 nums = [1,1,1,2,2,3]
	 print("leg:"+str(removeDuplicates(nums))+",newNums:"+str(nums))
