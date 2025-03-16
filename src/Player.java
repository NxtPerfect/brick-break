package src;

public class Player implements Object {
  int x = 0;
  final int y = 15;
  int points = 0;
  final int width = 10;
  final int height = 5;
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
    (y + height) >= (other.y + other.height);
  }

  void draw() {
    System.out.println("=".repeat(width));
  }

  public Player(int x) {
    this.x = x;
  }
}
