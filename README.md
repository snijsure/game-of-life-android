Instructions: 

Life is a simple cellular automata program. It has these rules:

* Cells are either alive or dead,
* All the cells are laid out on a rectangular grid (WHICH WRAPS AROUND THE EDGES),
* Each cell has 8 neighbors. For example : cell (2,2) has the neighbors : (1,1) (1,2) (1,3) (2,1) (2,3) (3,1) (3,2) (3,3)
* If you board is wrapping correctly cell (0,4) has the neighbors : (0,3) (1,3) (1,4) (1,5) (0,5) (xsize - 1,3) (xsize -1,4) (xsize-1,5)
* If a dead cell has exactly 3 living neighbors it becomes alive in the next generation
* If a living cell has exactly 2 or 3 living neighbors it stays alive in the next generation, otherwise it dies

Someone has tried to write a version of the Life program for Android but hasn't had time to make it work right yet. Make it work! All three of the provided board setups ("flower", "blinker", and "glider") should work according to the rules listed above.
