def medianSlidingWindow( nums, k):

	if nums is None or len(nums) <k or k<2:
		return []

	slid_median_arr=[]
	is_even = k%2==0
	median_k=k//2

	import collections 
	import copy
	windows_num_dp = collections.deque()

	sum=0
	for i in range(0,len(nums)):
		value = nums[i]
		sum +=value
		if i<k:
			windows_num_dp.append(value)
		else:
			left = windows_num_dp.popleft();
			sum-=left
			windows_num_dp.append(value);

		if i<k-1:
			continue

		#find  median of windows
		#偶数取得平均值，奇数获取中间位置
		if is_even:
			slid_median_arr.append(sum/k)
		else:
			sort_arr =windows_num_dp.copy()
			sort_arr = quick_sort(sort_arr,0,k-1)
			slid_median_arr.append(sort_arr[median_k])

	return slid_median_arr


def quick_sort(lists, left, right):
    if left >= right:
        return lists
    key = lists[left]
    low = left
    high = right
    while left < right:
        while left < right and lists[right] >= key:
            right -= 1
        lists[left] = lists[right]
        while left < right and lists[left] <= key:
            left += 1
        lists[right] = lists[left]
    lists[right] = key
    quick_sort(lists, low, left - 1)
    quick_sort(lists, left + 1, high)
    return lists
	


if __name__ == "__main__":
	nums = [1,3,-1,-3,5,3,6,7]
	print(medianSlidingWindow(nums,2))
