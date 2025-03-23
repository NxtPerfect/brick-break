package main;

public class Brick extends Object {
  String color;

  public Brick(int x, int y, int w, String color) {
    this.x = x;
    this.y = y;
    this.width = w;
    this.color = Game.ANSI_COLORS.get(color);
  }

  void draw() {
    System.out.print(color);
    System.out.print("|".repeat(width));
    System.out.print(Game.ANSI_COLORS.get("reset"));
  }
}
