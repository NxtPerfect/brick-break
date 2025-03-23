package main;

import java.util.List;

public class Board {
  int size = 0;
  String borders = "#";
  String background = " ";

  void draw(List<Object> objects) {
    for (int i = -1; i < size + 1; i++) {
      if (isTopBorder(i) || isBottomBorder(i)) {
        System.out.println(borders.repeat(size + 2));
        continue;
      }
      for (int j = -1; j < size + 1; j++) {
        if (isLeftBorder(j) || isRightBorder(j)) {
          System.out.print(borders);
          continue;
        }
        for (int k = 0; k < objects.size(); k++) {
          Object curObject = objects.get(k);
          if (curObject.y == j && curObject.x == i) {
            curObject.draw();
            j += curObject.width;
          }
        }
        System.out.print(background);
      }
      System.out.println();
    }
  }

  boolean isTopBorder(int y) {
    return y == -1;
  }

  boolean isBottomBorder(int y) {
    return y == size;
  }

  boolean isLeftBorder(int x) {
    return x == -1;
  }

  boolean isRightBorder(int x) {
    return x == size;
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
