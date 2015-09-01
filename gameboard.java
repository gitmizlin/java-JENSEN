/** Rita ut ett tre-i-rad-spelbräde (förbättra gärna!) Förtydligande: gör ett program som ritar ut ett spelbräde för tre-i-rad

  |  |
--------
  |  |
--------
  |  |

*/

public class gameboard {
  public static void main(String[] args) {

    int sizeOfBoardSide = 3;
    int sizeOfSpace = 2;
    int numOfLettersInLine = sizeOfBoardSide * 2 + sizeOfBoardSide - 1;
    String space = "  ";
    String separator = "|";

    for (int i = 1; i <= sizeOfBoardSide + 2; i++) {
      if (i % 2 == 0) {
        for (int n = 0; n < numOfLettersInLine; n++) {
          System.out.print("-");
        }
      } else {
          for (int n = 0; n < sizeOfBoardSide - 1; n += sizeOfSpace) {
            for (int k = 0; k <= sizeOfSpace; k++) {
              System.out.print(space);
              if (k != sizeOfSpace) {
                System.out.print(separator);
              }
            }
          }
      }
      System.out.print("\n");
    }
  }
}