import collections
import sys

def maxSlidingWindow(nums, k):
	
	sliding_max_arr=[]
	
	if nums is None or len(nums)<k:
		return sliding_max_arr

	window_dq=collections.deque()

	for i in xrange(0,len(nums)):
		value = nums[i]
		if i<k:
			window_dq.append(value)
  		else:
  			window_dq.popleft()
  			window_dq.append(value)

  		if i<k-1:
  			continue

  		max_value=-sys.maxsize-1
  		for dp_value in window_dq:
  			if dp_value>max_value:
  				max_value=dp_value

  		sliding_max_arr.append(max_value)

  	return sliding_max_arr


if __name__ == "__main__":
	nums = [1,3,-1,-3,5,3,6,7]
	# nums=[]
	print(maxSlidingWindow(nums,3))