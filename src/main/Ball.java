package main;

import java.util.Random;

public class Ball extends Object {
  Vector moveVector;

  void bounceBall() {
    this.moveVector.y = -this.moveVector.y;
  }

  void draw() {
    System.out.print("*".repeat(this.width));
  }

  public Ball(int x, int y) {
    this.x = x;
    this.y = y;
    this.width = 1;
    Random rand = new Random();
    int randomX = rand.nextInt(3) - 1; // [-1, 1]
    int randomY = rand.nextInt(3) - 1; // [-1, 1]
    this.moveVector = new Vector(randomX, randomY);
  }
}
