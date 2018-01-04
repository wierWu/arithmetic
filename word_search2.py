def findWords(board,words):
	trie={}
	for w in words:
		t = trie
		for c in w:
			if c not in t:
				t[c]={}

			t = t[c]
		t['#']='#'

	print(trie)


def bfs(board,y,x,):
	return
	



if __name__ == "__main__":
	board = [['o','a','a','n'],['e','t','a','e'],['i','h','k','r'],['i','f','l','v']]
	words = ["oath","pea","eat","rain"]
	findWords(board,words)
