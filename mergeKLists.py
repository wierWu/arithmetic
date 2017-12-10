
#Merge k Sorted Lists
from Queue import PriorityQueue

def mergeKLists(lists):
	dummy = ListNode(None)
	tail = dammy
	
	queue = PriorityQueue()

	for inputNode in lists:
		queue.put((inputNode.val,inputNode))

	while not queue.empty():
		tail.next = queue.get()[1]
		tail=tail.next

		if tail.next :
			queue.put((tail.next.val,tail.next))

	return dummy.next
