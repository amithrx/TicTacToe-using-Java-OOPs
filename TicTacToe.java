import java.util.*;
import java.util.Random;

public class TicTacToe {

    public static void main(String[] args) {
        board grid = new board();   //making a grid object of board class
        grid.initialise();      //initilising the grid

        System.out.println("Choose the version");
        System.out.println("Enter 1 for Player Vs Player, Enter 2 for Player Vs Computer");
        Scanner scn = new Scanner(System.in);
        int y = scn.nextInt();
        int x;

        grid.instructionBoard();

        if (y == 2) {
            System.out.println("Welcome to TicTacToe. Player is 'X' and Computer is 'O'");

            while (board.temp != 0) {
                if (board.xx == 1) {
                    System.out.println("Player, Enter your desired location[1-9]");
                    scn = new Scanner(System.in);
                    x = scn.nextInt();

                } else {
                    if (grid.computerMoves() != 0) {
                        x = grid.computerMoves();
                    } else {
                        Random rand = new Random();
                        x = rand.nextInt(9) + 1;
                    }

                    System.out.print("Computer entered ");
                    System.out.println(x);
                }
                grid.modifyBoard(x, y);
                grid.printBoard();

            }
        } else if (y == 1) {
            System.out.println("Welcome to TicTacToe. Player1 is 'X' and Player2 is 'O'");

            while (board.temp != 0) {
                if (board.xx == 1) {
                    System.out.println("Player1, Enter your desired location[1-9]");
                    scn = new Scanner(System.in);
                    x = scn.nextInt();

                } else {
                    System.out.println("Player2, Enter your desired location[1-9]");
                    scn = new Scanner(System.in);
                    x = scn.nextInt();
                }
                grid.modifyBoard(x, y);
                grid.printBoard();

            }
        } else {
            System.out.println("Wrong choosen option");
        }
    }
}

class board {
    private int[][] arr = new int[3][3];  //properties of class taken by object 
    static int temp = -1;   //variable of class board used in subsequent method
    static int xx = 1;      //variable of class board used in subsequent method
 
    public void initialise() {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                arr[i][j] = -1;
            }
        }
    }

    public void instructionBoard() {
        System.out.println("");
        System.out.println("This is a new game. Board numbers are as follows:");
        System.out.print("---------------");
        System.out.println("");
        
        for (int i = 0; i < 3; ++i) {

            for (int j = 0; j < 3; ++j) {
                System.out.print(" |");
                System.out.print(3 * i + j + 1);
                System.out.print("| ");
            }
            System.out.println("");
            System.out.print("---------------");
            System.out.println("");
        }
        System.out.println("");
    }

    public void printBoard() {
        System.out.print("---------------");
        System.out.println("");
        
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (arr[i][j] == 1) {
                    System.out.print(" |");
                    System.out.print("X");
                    System.out.print("| ");
                }
                if (arr[i][j] == 0) {
                    System.out.print(" |");
                    System.out.print("0");
                    System.out.print("| ");
                }
                if (arr[i][j] == -1) {
                    System.out.print(" |");
                    System.out.print(" ");
                    System.out.print("| ");
                }
            }
            System.out.println("");
            System.out.print("---------------");
            System.out.println("");
        }
    }

    public void modifyBoard(int x, int y) {
        int check = 0;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if ((3 * i + j + 1) == x) {
                    if (arr[i][j] == -1) {
                        check = 1;
                        break;
                    }
                }
            }
        }
        if (x >= 10 || x <= 0) {
            System.out.println("Invalid choosen location,Please choose b/w [1-9]");
        } else if (check == 1) {
            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < 3; ++j) {
                    if ((3 * i + j + 1) == x) {
                        this.arr[i][j] = xx;
                        break;
                    }
                }
            }

            if (x == 1) {
                if (this.arr[0][0] == xx && this.arr[0][1] == xx && this.arr[0][2] == xx) {
                    temp = 0;
                } else if (this.arr[0][0] == xx && this.arr[1][0] == xx && this.arr[2][0] == xx) {
                    temp = 0;
                } else if (this.arr[0][0] == xx && this.arr[1][1] == xx && this.arr[2][2] == xx) {
                    temp = 0;
                }
            } else if (x == 2) {
                if (this.arr[0][0] == xx && this.arr[0][1] == xx && this.arr[0][2] == xx) {
                    temp = 0;
                } else if (this.arr[0][1] == xx && this.arr[1][1] == xx && this.arr[2][1] == xx) {
                    temp = 0;
                }
            } else if (x == 3) {
                if (this.arr[0][0] == xx && this.arr[0][1] == xx && this.arr[0][2] == xx) {
                    temp = 0;
                } else if (this.arr[0][2] == xx && this.arr[1][2] == xx && this.arr[2][2] == xx) {
                    temp = 0;
                } else if (this.arr[0][2] == xx && this.arr[1][1] == xx && this.arr[2][0] == xx) {
                    temp = 0;
                }
            } else if (x == 4) {
                if (this.arr[0][0] == xx && this.arr[1][0] == xx && this.arr[2][0] == xx) {
                    temp = 0;
                } else if (this.arr[1][0] == xx && this.arr[1][1] == xx && this.arr[1][2] == xx) {
                    temp = 0;
                }
            } else if (x == 5) {
                if (this.arr[0][0] == xx && this.arr[1][1] == xx && this.arr[2][2] == xx) {
                    temp = 0;
                } else if (this.arr[0][2] == xx && this.arr[1][1] == xx && this.arr[2][0] == xx) {
                    temp = 0;
                } else if (this.arr[0][1] == xx && this.arr[1][1] == xx && this.arr[2][1] == xx) {
                    temp = 0;
                } else if (this.arr[1][0] == xx && this.arr[1][1] == xx && this.arr[1][2] == xx) {
                    temp = 0;
                }
            } else if (x == 6) {
                if (this.arr[0][2] == xx && this.arr[1][2] == xx && this.arr[2][2] == xx) {
                    temp = 0;
                } else if (this.arr[1][0] == xx && this.arr[1][1] == xx && this.arr[1][2] == xx) {
                    temp = 0;
                }
            } else if (x == 7) {
                if (this.arr[0][0] == xx && this.arr[1][0] == xx && this.arr[2][0] == xx) {
                    temp = 0;
                } else if (this.arr[2][0] == xx && this.arr[2][1] == xx && this.arr[2][2] == xx) {
                    temp = 0;
                } else if (this.arr[2][0] == xx && this.arr[1][1] == xx && this.arr[0][2] == xx) {
                    temp = 0;
                }
            } else if (x == 8) {
                if (this.arr[0][1] == xx && this.arr[1][1] == xx && this.arr[2][1] == xx) {
                    temp = 0;
                } else if (this.arr[2][0] == xx && this.arr[2][1] == xx && this.arr[2][2] == xx) {
                    temp = 0;
                }
            } else if (x == 9) {
                if (this.arr[0][0] == xx && this.arr[1][1] == xx && this.arr[2][2] == xx) {
                    temp = 0;
                } else if (this.arr[2][0] == xx && this.arr[2][1] == xx && this.arr[2][2] == xx) {
                    temp = 0;
                } else if (this.arr[2][2] == xx && this.arr[1][2] == xx && this.arr[0][2] == xx) {
                    temp = 0;
                }
            }
            //Checking if someone wins or not
            if (temp == 0) {

                if (y == 1) {
                    System.out.print("Player");
                    if (xx == 1) {
                        System.out.print(xx);
                    } else {
                        System.out.print(2);
                    }
                    System.out.println(" Win!!");
                }
                if (y == 2) {
                    if (xx == 1) {
                        System.out.println("You win!!");
                    } else {
                        System.out.println("Computer win!!");
                    }
                }
            }
            xx = 1 - xx;

        } else {
            System.out.println("Already filled location choosen");
        }
        //Checking for a Tie game
        if (isFull() == false) {
            System.out.println("The Game is a Tie!!");
            temp = 0;
        }
    }

    public boolean isFull() {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (arr[i][j] == -1) return true;
            }
        }
        return false;
    }
    //Checking if moves done by computer is optimal or not
    public boolean checkMoves() {
        if (arr[0][0] == arr[0][1] && arr[0][1] == arr[0][2]&&arr[0][0]!=-1) {
            return true;
        }
        if (arr[0][0] == arr[1][0] && arr[1][0] == arr[2][0]&&arr[0][0]!=-1) {
            return true;
        }
        if (arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2]&&arr[0][0]!=-1) {
            return true;
        }
        if (arr[0][1] == arr[1][1] && arr[1][1] == arr[2][1]&&arr[0][1]!=-1) {
            return true;
        }
        if (arr[0][2] == arr[1][2] && arr[1][2] == arr[2][2]&&arr[0][2]!=-1) {
            return true;
        }
        if (arr[0][2] == arr[1][1] && arr[1][1] == arr[2][0]&&arr[0][2]!=-1) {
            return true;
        }
        if (arr[1][0] == arr[1][1] && arr[1][1] == arr[1][2]&&arr[1][0]!=-1) {
            return true;
        }
        if (arr[2][0] == arr[2][1] && arr[2][1] == arr[2][2]&&arr[2][0]!=-1) {
            return true;
        }
        return false;
    }
    //Checking for if computer has a winning moves or if computer can block opponents winning position
    public int computerMoves() {
        if (arr[0][0] == -1) {
            arr[0][0] = 0;
            if (checkMoves() == true) {
                arr[0][0] = -1;
                return 1;
            } else {
                arr[0][0] = -1;
            }

        }
        if (arr[0][1] == -1) {
            arr[0][1] = 0;
            if (checkMoves() == true) {
                arr[0][1] = -1;
                return 2;
            } else {
                arr[0][1] = -1;
            }
        }
        if (arr[0][2] == -1) {
            arr[0][2] = 0;
            if (checkMoves() == true) {
                arr[0][2] = -1;
                return 3;
            } else {
                arr[0][2] = -1;
            }
        }
        if (arr[1][0] == -1) {
            arr[1][0] = 0;
            if (checkMoves() == true) {
                arr[1][0] = -1;
                return 4;
            } else {
                arr[1][0] = -1;
            }
        }
        if (arr[1][1] == -1) {
            arr[1][1] = 0;
            if (checkMoves() == true) {
                arr[1][1] = -1;
                return 5;
            } else {
                arr[1][1] = -1;
            }
        }
        if (arr[1][2] == -1) {
            arr[1][2] = 0;
            if (checkMoves() == true) {
                arr[1][2] = -1;
                return 6;
            } else {
                arr[1][2] = -1;
            }
        }
        if (arr[2][0] == -1) {
            arr[2][0] = 0;
            if (checkMoves() == true) {
                arr[2][0] = -1;
                return 7;
            } else {
                arr[2][0] = -1;
            }
        }
        if (arr[2][1] == -1) {
            arr[2][1] = 0;
            if (checkMoves() == true) {
                arr[2][1] = -1;
                return 8;
            } else {
                arr[2][1] = -1;
            }
        }
        if (arr[2][2] == -1) {
            arr[2][2] = 0;
            if (checkMoves() == true) {
                arr[2][2] = -1;
                return 9;
            } else {
                arr[2][2] = -1;
            }
        }

        if (arr[0][0] == -1) {
            arr[0][0] = 1;
            if (checkMoves() == true) {
                arr[0][0] = -1;
                return 1;
            } else {
                arr[0][0] = -1;
            }

        }
        if (arr[0][1] == -1) {
            arr[0][1] = 1;
            if (checkMoves() == true) {
                arr[0][1] = -1;
                return 2;
            } else {
                arr[0][1] = -1;
            }
        }
        if (arr[0][2] == -1) {
            arr[0][2] = 1;
            if (checkMoves() == true) {
                arr[0][2] = -1;
                return 3;
            } else {
                arr[0][2] = -1;
            }
        }
        if (arr[1][0] == -1) {
            arr[1][0] = 1;
            if (checkMoves() == true) {
                arr[1][0] = -1;
                return 4;
            } else {
                arr[1][0] = -1;
            }
        }
        if (arr[1][1] == -1) {
            arr[1][1] = 1;
            if (checkMoves() == true) {
                arr[1][1] = -1;
                return 5;
            } else {
                arr[1][1] = -1;
            }
        }
        if (arr[1][2] == -1) {
            arr[1][2] = 1;
            if (checkMoves() == true) {
                arr[1][2] = -1;
                return 6;
            } else {
                arr[1][2] = -1;
            }
        }
        if (arr[2][0] == -1) {
            arr[2][0] = 1;
            if (checkMoves() == true) {
                arr[2][0] = -1;
                return 7;
            } else {
                arr[2][0] = -1;
            }
        }
        if (arr[2][1] == -1) {
            arr[2][1] = 1;
            if (checkMoves() == true) {
                arr[2][1] = -1;
                return 8;
            } else {
                arr[2][1] = -1;
            }
        }
        if (arr[2][2] == -1) {
            arr[2][2] = 1;
            if (checkMoves() == true) {
                arr[2][2] = -1;
                return 9;
            } else {
                arr[2][2] = -1;
            }
        }
        return 0;
    }
}
