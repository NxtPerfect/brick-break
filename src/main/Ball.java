package main;

public class Ball {
  Vector moveVector = new Vector(0, 0); // TODO: start in the middle

  void bounceBall() {
    this.moveVector.y = -this.moveVector.y;
  }
}
