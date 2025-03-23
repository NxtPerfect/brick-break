package main;

import java.util.List;

public class Board {
  private static final String CURSOR_UP = "\u001B[%dA";
  private static final String CLEAR_LINE = "\u001B[2K";
  private static final String RESET_LINE = "\r";

  int size = 0;
  String borders = "#";
  String background = "x";

  public Board(String type) {
    switch (type) {
      case "test":
        this.size = 13;
        this.borders = "#";
        break;
      default:
        this.size = 50;
        this.borders = "/";
        break;
    }
  }

  void draw(List<Object> objects, int score) {
    for (int i = -1; i < size + 1; i++) {
      if (isHorizontalBorder(i)) {
        printHorizontalBorder();
        continue;
      }

      for (int j = -1; j < size + 1; j++) {
        for (int k = 0; k < objects.size(); k++) {
          Object curObject = objects.get(k);
          if (curObject.y != i || curObject.x != j) {
            continue;
          }

          curObject.draw();
          j += curObject.width;
        }

        if (isVerticalBorder(j)) {
          printVerticalBorder();
          continue;
        }
        printBackground();
      }
      System.out.println();
    }
    printScore(score);
  }

  void clearBoard() {
    System.out.printf(CURSOR_UP, (size + 3));
    for (int i = -1; i < size + 1; i++) {
      System.out.printf(CLEAR_LINE + RESET_LINE);
    }
    System.out.printf(CLEAR_LINE + RESET_LINE);
  }

  void printHorizontalBorder() {
    System.out.print(Game.ANSI_COLORS.get("cyan"));
    System.out.println(borders.repeat(size + 2));
    System.out.print(Game.ANSI_COLORS.get("reset"));
  }

  void printVerticalBorder() {
    System.out.print(Game.ANSI_COLORS.get("cyan"));
    System.out.print(borders);
    System.out.print(Game.ANSI_COLORS.get("reset"));
  }

  void printBackground() {
    System.out.print(Game.ANSI_COLORS.get("black"));
    System.out.print(background);
    System.out.print(Game.ANSI_COLORS.get("reset"));
  }

  void printScore(int score) {
    System.out.println(
        Game.ANSI_COLORS.get("yellow") +
            "Score: " +
            score +
            Game.ANSI_COLORS.get("reset"));
  }

  boolean isTopBorder(int y) {
    return y == -1;
  }

  boolean isBottomBorder(int y) {
    return y == size;
  }

  boolean isHorizontalBorder(int y) {
    return isTopBorder(y) || isBottomBorder(y);
  }

  boolean isLeftBorder(int x) {
    return x == -1;
  }

  boolean isRightBorder(int x) {
    return x == size;
  }

  boolean isVerticalBorder(int x) {
    return isLeftBorder(x) || isRightBorder(x);
  }
}
