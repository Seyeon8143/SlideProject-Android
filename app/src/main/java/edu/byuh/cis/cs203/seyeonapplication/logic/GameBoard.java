package edu.byuh.cis.cs203.seyeonapplication.logic;

/**
 * This class implement a simple game
 * author Seyeon Kim
 */
public class GameBoard {


    private Player[][] grid;
    private final int DIM = 5;
    private Player whoseTurnIsIt;
    public int count =0;


    //private char[] rowLetters = {'A','B','C','D','E' };

    public GameBoard() {

        grid = new Player[DIM][DIM];
        for (int i=0; i<DIM; ++i) {
            for (int j=0; j<DIM; ++j) {
                grid[i][j] = Player.BLANK;
            }
        }
        whoseTurnIsIt = Player.X;
    }



    /**
     * This method to move vertially and horizentally  according to input
     * @param move
     * @param p
     */
    public void submitMove(char move, Player p) {
        if (move >= '1' && move <= '5') {
            //vertical move, move stuff down
            int col = Integer.parseInt(""+move)-1;
            Player newVal = p;
            for (int i=0; i<DIM; ++i) {
                if (grid[i][col] == Player.BLANK) {
                    grid[i][col] = newVal;
                    break;
                } else {
                    Player tmp = grid[i][col];
                    grid[i][col] = newVal;
                    newVal = tmp;
                }
            }

        } else { //A-E
            //horizontal move, move stuff right
            int row = (int)(move - 'A');
            Player newVal = p;
            for (int i=0; i<DIM; ++i) {
                if (grid[row][i] == Player.BLANK) {
                    grid[row][i] = newVal;
                    break;
                } else {
                 Player tmp = grid[row][i];
                    grid[row][i] = newVal;
                    newVal = tmp;
                }
            }
        }
        if (whoseTurnIsIt == Player.X) {
            whoseTurnIsIt = Player.O;
        } else {
            whoseTurnIsIt = Player.X;
        }
    }

    /**
     * This method to check whose the winner is. Firstly, they assume player winner is curtain index of value.
     * base on them, for loop start to check winner. if they find different value with winner they make winner as Blank
     * if not, they return winner
     * @return
     */
    public Player checkForWin() {
        Player winner = Player.BLANK;



        //check all rows
        for (int i=0; i<DIM; ++i) {
            if (grid[i][0] != Player.BLANK) {
                winner = grid[i][0];
                for (int j=0; j<DIM; ++j) {
                    if (grid[i][j] != winner) {
                        winner = Player.BLANK;
                        break;
                    }
                }
                if (winner != Player.BLANK) {
                    count++;
                    return winner;
                }
            }
        }

        //check all columns
        for (int i=0; i<DIM; ++i) {
            if (grid[0][i] != Player.BLANK) {
                winner = grid[0][i];
                for (int j=0; j<DIM; ++j) {
                    if (grid[j][i] != winner) {
                        winner = Player.BLANK;
                        break;
                    }
                }
                if (winner != Player.BLANK) {
                    count++;

                    return winner; //5 in a column!

                }
            }
        }

        //check top-left -> bottom-right diagonal
        if (grid[0][0] != Player.BLANK) {
            winner = grid[0][0];
            for (int i=0; i<DIM; ++i) {
                if (grid[i][i] != winner) {
                    winner = Player.BLANK;
                    break;
                }
            }
            if (winner != Player.BLANK) {
                count++;

                return winner; //5 in a diagonal!
            }
        }


        //check bottom-left -> top-right diagonal
        if (grid[DIM-1][0] != Player.BLANK) {
            winner = grid[DIM-1][0];
            for (int i=0; i<DIM; ++i) {
                if (grid[DIM-1-i][i] != winner) {
                    winner = Player.BLANK;
                    break;
                }
            }
            if (winner != Player.BLANK) {
                count++;
                return winner; //5 in a diagonal!
            }
        }

        return winner;
    }


    /**
     * this method is drawing for console
     */
    public void consoleDraw() {
        System.out.print("  ");
        for (int i=0; i<DIM; ++i) {
            System.out.print(i+1);
        }
        System.out.println();
        System.out.print(" /");
        for (int i=0; i<DIM; ++i) {
            System.out.print("-");
        }
        System.out.println("\\");
        for (int i=0; i<DIM; ++i) {
            System.out.print(((char)('A'+i)) + "|");
            for (int j=0; j<DIM; ++j) {
                if (grid[i][j] == Player.BLANK) {
                    System.out.print(" ");
                } else {
                    System.out.print(grid[i][j]);
                }
            }
            System.out.println("|");
        }
        System.out.print(" \\");
        for (int i=0; i<DIM; ++i) {
            System.out.print("-");
        }
        System.out.println("/");

    }

    /**
     * this method to return who is the current order is
     * @return
     */

    public Player getCurrentPlayer() {
        return whoseTurnIsIt;
    }
}
