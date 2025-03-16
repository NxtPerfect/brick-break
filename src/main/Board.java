package main;

public class Board {
  int size = 0;
  String borders = "#";
  String background = " ";

  void draw() {
    for (int i = 0; i < size; i++) {
      if (isTopBorder(i) || isBottomBorder(i)) {
        System.out.println(borders.repeat(size));
        continue;
      }
      for (int j = 0; j < size; j++) {
        if (isLeftBorder(j) || isRightBorder(j)) {
          System.out.print(borders);
          continue;
        }
        System.out.print(background);
      }
      System.out.println();
    }
  }

  boolean isTopBorder(int y) {
    return y == 0;
  }

  boolean isBottomBorder(int y) {
    return y == size - 1;
  }

  boolean isLeftBorder(int x) {
    return x == 0;
  }

  boolean isRightBorder(int x) {
    return x == size - 1;
  }

  public Board(String type) {
    switch (type) {
      case "test":
        this.size = 10;
        this.borders = "#";
        break;
      default:
        this.size = 50;
        this.borders = "/";
        break;
    }
  }
}
