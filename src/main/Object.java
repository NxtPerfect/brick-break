package main;

public abstract class Object {
  int x = 0;
  int y = 0;
  int width = 0;

  boolean isColliding(Object other) {
    return true;
  };
  void draw() {};
}
