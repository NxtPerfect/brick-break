package main;

public class Vector {
  int x = 0;
  int y = 0;

  double getAngleInRadian() {
    return y / x;
  }

  public Vector(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
