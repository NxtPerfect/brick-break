package main;

public class Player extends Object {
  int points = 0;

  // Listen to key pressed in cli input
  // then act upon it
  void move(int direction) {
    switch (direction) {
      case 1:
        moveLeft();
        break;
      case -1:
        moveRight();
        break;
      default:
        break;
    }
  }

  private void moveLeft() {
    x--;
  }

  private void moveRight() {
    x++;
  }

  public boolean isColliding(Object other) {
    return (x + width) >= (other.x + other.width) &&
        y >= other.y;
  }

  public void draw() {
    System.out.print("=".repeat(width));
  }

  public Player(int x, int y, int w) {
    this.x = x;
    this.y = y;
    this.width = w;
  }
}
