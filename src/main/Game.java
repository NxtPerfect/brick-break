package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {
  List<Object> objects = new ArrayList<Object>();
  Ball ball;
  Player player;
  Brick[] bricks;

  public Game() {
    // TODO: game setup
    return;
  }

  void main() {
    Board board = new Board("test");

    int yBottomPointBoard = board.size - 1;
    int xMiddlePointBoard = board.size / 2;
    player = new Player(yBottomPointBoard, xMiddlePointBoard-(5/2), 5);
    objects.add(player);
    int yMiddlePointBoard = board.size / 2;
    ball = new Ball(yMiddlePointBoard, xMiddlePointBoard);
    objects.add(ball);

    board.draw(objects);
    // Player player = new Player(0);
    // player.draw();
  }
}
