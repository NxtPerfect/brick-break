package main;

public interface Object {
  int x = 0;
  int y = 0;
  int width = 0;
  int height = 0;

  boolean isColliding(Object other);
}
