package main;

import java.util.HashMap;
import java.util.List;

public class Game {
  HashMap<Integer, List<Object>> objectsInLine = new HashMap<>();

  void main() {
    Board board = new Board("test");
    board.draw();
    // Player player = new Player(0);
    // player.draw();
  }
}
