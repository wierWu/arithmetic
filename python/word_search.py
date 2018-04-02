def wordSearch( board, word):
	if not board or not word:
		return False
	if len(board)<len(word):
		return False

	yleg = len(board)

	for y in range(yleg):
		for x in range(len(board[y])):
			if exits(board,y,x,word,0):
				return True

	return False



def exits(board,y,x,word,index):
	if index== len(word):
		return True

	if y>=len(board) or y<0 or x>=len(board[y]) or x<0:
		return False

	if board[y][x] != word[index]:
		return False

	oldValue =board[y][x]
	board[y][x]='#'

	isExits = exits(board,y+1,x,word,index+1) or exits(board,y-1,x,word,index+1) or exits(board,y,x+1,word,index+1) or exits(board,y,x-1,word,index+1)

	board[y][x]=oldValue

	return isExits


if __name__ == "__main__":
	board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']]
	word =['A','B','C','C','E','D']
	result = wordSearch(board,word)
	print(result)
