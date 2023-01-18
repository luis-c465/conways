package luisc;

/**
 * Game of Life originally created by Joan Soler-Adillon.
 *
 * Press SPACE BAR to pause and change the cell's values
 * with the mouse. On pause, click to activate/deactivate
 * cells. Press 'R' to randomly reset the cells' grid.
 * Press 'C' to clear the cells' grid. The original Game
 * of Life was created by John Conway in 1970.
 *
 * @see https://processing.org/examples/gameoflife.html
 */
public class Conways extends Obj {

  public static final int padding = 100;

  public int cellSize = 5;
  public float probabilityOfAliveAtStart = 15;

  // Variables for timer
  public int interval = 100;
  public int lastRecordedTime = 0;

  // Colors for active/inactive cells
  public int alive = 0xff00c800;
  public int dead = 0xff000000;

  // Array of cells
  public int[][] cells;

  // Buffer to record the state of the cells and use this
  // while changing the others in the interactions
  public int[][] cellsBuffer;

  // Pause
  boolean pause = false;

  @Override
  protected void _setup() {
    cells = new int[App.w / cellSize][App.h / cellSize];
    cellsBuffer = new int[App.w / cellSize][App.h / cellSize];

    for (int x = 0; x < App.w / cellSize; x++) {
      for (int y = 0; y < App.h / cellSize; y++) {
        float state = p.random(100);
        if (state > probabilityOfAliveAtStart) {
          state = 0;
        } else {
          state = 1;
        }

        cells[x][y] = (int) state; // Save state of each cell
      }
    }
  }

  @Override
  protected void _update() {
    // TODO Auto-generated method stub

    //Draw grid
    for (int x = 0; x < App.w / cellSize; x++) {
      for (int y = 0; y < App.h / cellSize; y++) {
        if (cells[x][y] == 1) {
          p.fill(alive); // If alive
        } else {
          p.fill(dead); // If dead
        }
        // TODO: Add a padding to the top
        p.rect(x * cellSize, y * cellSize + padding, cellSize, cellSize);
      }
    }
    // Iterate if timer ticks
    if (p.millis() - lastRecordedTime > interval) {
      if (!pause) {
        iteration();
        lastRecordedTime = p.millis();
      }
    }

    // Create  new cells manually on pause
    if (pause && p.mousePressed) {
      // Map and avoid out of bound errors
      int xCellOver = (int) (p.map(p.mouseX, 0, App.w, 0, App.w / cellSize));
      xCellOver = p.constrain(xCellOver, 0, App.w / cellSize - 1);
      int yCellOver = (int) (p.map(p.mouseY, padding, App.h, 0, App.h / cellSize));
      yCellOver = p.constrain(yCellOver, 0, App.h / cellSize - 1);

      // Check against cells in buffer
      if (cellsBuffer[xCellOver][yCellOver] == 1) { // Cell is alive
        cells[xCellOver][yCellOver] = 0; // Kill
        p.fill(dead); // Fill with kill color
      } else { // Cell is dead
        cells[xCellOver][yCellOver] = 1; // Make alive
        p.fill(alive); // Fill alive color
      }
    } else if (pause && !p.mousePressed) { // And then save to buffer once mouse goes up
      // Save cells to buffer (so we operate with one array keeping the other intact)
      for (int x = 0; x < App.w / cellSize; x++) {
        for (int y = 0; y < App.h / cellSize; y++) {
          cellsBuffer[x][y] = cells[x][y];
        }
      }
    }
  }

  private void iteration() { // When the clock ticks
    // Save cells to buffer (so we operate with one array keeping the other intact)
    for (int x = 0; x < App.w / cellSize; x++) {
      for (int y = 0; y < App.h / cellSize; y++) {
        cellsBuffer[x][y] = cells[x][y];
      }
    }

    // Visit each cell:
    for (int x = 0; x < App.w / cellSize; x++) {
      for (int y = 0; y < App.h / cellSize; y++) {
        // And visit all the neighbors of each cell
        int neighbors = 0; // We'll count the neighbors
        for (int xx = x - 1; xx <= x + 1; xx++) {
          for (int yy = y - 1; yy <= y + 1; yy++) {
            if (((xx >= 0) && (xx < App.w / cellSize)) && ((yy >= 0) && (yy < App.h / cellSize))) { // Make sure you are not out of bounds
              if (!((xx == x) && (yy == y))) { // Make sure to to check against self
                if (cellsBuffer[xx][yy] == 1) {
                  neighbors++; // Check alive neighbors and count them
                }
              } // End of if
            } // End of if
          } // End of yy loop
        } //End of xx loop
        // We've checked the neighbors: apply rules!
        if (cellsBuffer[x][y] == 1) { // The cell is alive: kill it if necessary
          if (neighbors < 2 || neighbors > 3) {
            cells[x][y] = 0; // Die unless it has 2 or 3 neighbors
          }
        } else { // The cell is dead: make it live if necessary
          if (neighbors == 3) {
            cells[x][y] = 1; // Only if it has 3 neighbors
          }
        } // End of if
      } // End of y loop
    } // End of x loop
  } // End of function

  public void KeyPressed() {
    if (p.key == 'r' || p.key == 'R') {
      // Restart: re-initialization of cells
      for (int x = 0; x < App.w / cellSize; x++) {
        for (int y = 0; y < App.h / cellSize; y++) {
          float state = p.random(100);
          if (state > probabilityOfAliveAtStart) {
            state = 0;
          } else {
            state = 1;
          }
          cells[x][y] = (int) state; // Save state of each cell
        }
      }
    }
    if (p.key == ' ') { // On/off of pause
      pause = !pause;
    }
    if (p.key == 'c' || p.key == 'C') { // Clear all
      for (int x = 0; x < App.w / cellSize; x++) {
        for (int y = 0; y < App.h / cellSize; y++) {
          cells[x][y] = 0; // Save all to zero
        }
      }
    }

    // reset the pressed key to a random character
    p.key = 'ø';
  }

  public Conways(App a) {
    super(a);
  }

  /**
   * Calculates the cell size for the class
   */
  public void calc() {}
}
