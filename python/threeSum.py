# -*- coding:utf-8 -*- 

#https://leetcode.com/problems/3sum/description/
class Solution(object):
	
	# for
	def threeSum(self,nums):
		result =[]
		if len(nums) == 0:
			return result

		#sor	
		nums.sort()
		leg=len(nums)
		for i in range(0,leg):
			# 相同的key，同一key不要再循环了，防止重复
			if i>0 and nums[i]==nums[i-1]:
				continue
			for j in range(i+1,leg):
				if j>i+1 and nums[j]==nums[j-1]:
					continue
				for k in range(j+1,leg):
					if k>j+1 and nums[k]==nums[k-1]:
						continue
					if (nums[i]+nums[j]+nums[k])==0:
						group=[nums[i],nums[j],nums[k]]
						result.append(group)	
		return result

	#a+b=-c		
	def threeSum2(self,nums):
		result =[]
		leg =len(nums)
		nums.sort()
		for i in range(0,leg-2):
			if i==0 or (i>0 and nums[i]!=nums[i-1]):
				left=i+1
				right=leg-1
				summ =0-nums[i]
				# print(summ)
				while left<right:
					if (nums[left]+nums[right])==summ:
						group=[nums[left],nums[i],nums[right]]
						result.append(group)
						while (left<right and nums[left]==nums[left+1]):
							left=left+1
						while (left<right and nums[right] ==nums[right-1]):
							right=right-1
						left=left+1
						right=right-1
					elif (nums[left]+nums[right])<summ:
						left=left+1
					else:
						right=right-1
		return result

if __name__ == "__main__":
	print("hell world")
	# S = [-1, 0, 1, 1,1,1,2, -1,-1,-1, -4]
	S = [-1, 0, 1, 2, -1, -4]
	solution = Solution();
	result=solution.threeSum2(S);
	print(result)