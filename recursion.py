def recursion(level,param1,param2,...):
	
	# recursion terminator
	if level>MAX_LEVEL:
		return

	# process logic in current level
	process_data(level,data...)

    # drill down 
	self.recursion(level+1,param1,param2...)

	# reverse the current level status if needed
	reverse_state(level)