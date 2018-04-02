
#https://leetcode.com/problems/sort-colors/description/
def sortColors( nums):
	red,white,blue=0,0,0
	for num in nums:
		if num==0:
			red+=1
		elif num==1:
			white+=1
		elif num==2:
			blue+=1
	for i in xrange(0,red):
		nums[i]=0
	for i in xrange(red,red+white):
		nums[i]=1
	for i in xrange(red+white,red+white+blue):
		nums[i]=2

	return nums

def sortColors2(nums):
	i=j=0
	
	for index in xrange(len(nums)):
		value=nums[index]
		nums[index]=2
		if value<2:
			nums[i]=1
			i+=1
		if value<1:
			nums[j]=0
			j+=1
	return nums

if __name__ == "__main__":
	nums=[2,1,0,1,2,0]
	nums = sortColors(nums)
	print("sortColors:" + str(nums))
	nums=[2,1,0,1,2,0]
	nums = sortColors2(nums)
	print("sortColors2:" + str(nums))