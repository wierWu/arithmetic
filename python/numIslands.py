
grid = {}
vister=set()

offset=[[-1,0],[1,0],[0,-1],[0,1]]

x_leg =0
y_leg =0

def numIslands(grid):
	if grid is None or len(grid)==0:
		return 0

	grid = grid
	x_leg = len(grid)
	y_leg=len(grid[0])

	count =0
	for x in range(x_leg):
		for y in range(y_leg):
			count += fillLand_DFS(x,y)

def fillLand_DFS(x,y)
	if x>=x_leg or y>=y_leg or x<0 or y <0:
		return 0 

	if grid[x][y]=='0' or ((x,y) in vister):
		return 0 

	vister.add((x,y))

	for k in range(4):
		fillLand_DFS(x+offset[k][0],y+offset[k][1])

	return 1
	