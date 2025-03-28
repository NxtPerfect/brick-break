package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {
  public static final HashMap<String, String> ANSI_COLORS = new HashMap<>() {
    {
      put("reset", "\u001B[0m");
      put("black", "\u001B[30m");
      put("red", "\u001B[31m");
      put("green", "\u001B[32m");
      put("yellow", "\u001B[33m");
      put("blue", "\u001B[34m");
      put("purple", "\u001B[35m");
      put("cyan", "\u001B[36m");
      put("white", "\u001B[37m");
    }
  };
  List<Object> objects = new ArrayList<Object>();
  Board board;
  Ball ball;
  Player player;
  List<Brick> bricks = new ArrayList<Brick>();
  int score = 0;

  public Game() {
    board = new Board("test");

    int yBottomPointBoard = board.size - 1;
    int xMiddlePointBoard = board.size / 2;
    player = new Player(xMiddlePointBoard - (5 / 2), yBottomPointBoard, 5);
    objects.add(player);

    int yMiddlePointBoard = board.size / 2;
    ball = new Ball(xMiddlePointBoard, yMiddlePointBoard);
    objects.add(ball);

    int xRightPointBoard = board.size;
    Brick redBrick = new Brick(xRightPointBoard - 5 - 1, 1, 5, "red");
    bricks.add(redBrick);
    Brick blueBrick = new Brick(0 + 1, 1, 5, "blue");
    bricks.add(blueBrick);
    objects.addAll(bricks);
  }

  void main() {
    while (true) {
      ball.move();
      board.draw(objects, score);
      try {
        Thread.sleep(1000);
      } catch (Exception e) {
        System.out.println("Failed to sleep.");
        return;
      }
      board.clearBoard();
    }
  }
}
