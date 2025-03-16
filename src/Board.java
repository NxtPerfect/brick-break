package src;

public class Board {
  int width = 0;
  int height = 0;
  String borders = "#";
  String background = " ";

  void draw() {
    for (int i = 0; i < height; i++) {
      if (isTopBorder(i) || isBottomBorder(i)) {
        System.out.println(borders.repeat(width));
        continue;
      }
      for (int j = 0; j < width; j++) {
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
    return y == height - 1;
  }

  boolean isLeftBorder(int x) {
    return x == 0;
  }

  boolean isRightBorder(int x) {
    return x == width - 1;
  }

  public Board(String type) {
    if (type == "test") {
      this.width = 10;
      this.height = 10;
      this.borders = "#";
    }
  }
}
