
#
def solveNQueens(n):

	res =[]
	return res


def dfs(board,col,res):
	if col ==len(board):
		res.append(construct(board))
		return

	for row in range(0,len(board)):
		if validate(board,row,col):
			board[row][col]="Q"
			dfs(board,col+1,res)
			#第一轮已经解决完成，需要重置
			board[row][col]="."


def validate(board,x,y):
	for i in range(0,len(board)):
		for j in range(0,y):
			#往右走，所以只看左边，它的45°和135°以及垂直和水平线上不能有皇后
			if (board[i][j]=='Q' and (x+j==y+i or x+y=i+j or x==i )):
				return False

	return True

			


def construct(board):
	res = []
	#每一行的数据放入
	for i in range(0,len(board)):
		res.append(board[i])

	return res