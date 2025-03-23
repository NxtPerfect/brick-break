package main;

import java.util.List;

public class Board {
  int size = 0;
  String borders = "#";
  String background = "x";

  void draw(List<Object> objects, int score) {
    for (int i = -1; i < size + 1; i++) {
      if (isHorizontalBorder(i)) {
        System.out.print(Game.ANSI_COLORS.get("cyan"));
        System.out.println(borders.repeat(size + 2));
        System.out.print(Game.ANSI_COLORS.get("reset"));
        continue;
      }

      for (int j = -1; j < size + 1; j++) {
        for (int k = 0; k < objects.size(); k++) {
          Object curObject = objects.get(k);
          if (curObject.y == i && curObject.x == j) {
            curObject.draw();
            j += curObject.width;
          }
        }

        if (isVerticalBorder(j)) {
          System.out.print(Game.ANSI_COLORS.get("cyan"));
          System.out.print(borders);
          System.out.print(Game.ANSI_COLORS.get("reset"));
          continue;
        }
        System.out.print(Game.ANSI_COLORS.get("black"));
        System.out.print(background);
        System.out.print(Game.ANSI_COLORS.get("reset"));
      }
      System.out.println();
    }
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
}
