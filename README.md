# Snap App

Snap Card game for AP Computer Science AB 2022-2023 in Ivan Rico's class

## Dependencies for running

- [Java 1.8](https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html) or [higher](https://adoptium.net/)

## Running

- First download the **[Latest release](https://github.com/luis-c465/Snap/releases/latest)**
- Then run in the command line _(Or just double click on the file)_
  ```bash
  java -jar Main.jar
  ```

## Building

### Dependencies

- **[Processing v3.5.1](https://processing.org/download)**
- **[Ant v1.10.12](https://ant.apache.org/bindownload.cgi#:~:text=1.10.12%20release%20%2D%20requires%20minimum%20of%20Java%208%20at%20runtime)**

### How to build

- In the Processing app go to in the top bar: `Tools` -> `Install processing-java`
  - NOTE: **The Processing-java command only has to be installed once**
- Then in the command line run
  ```bash
    ant
  ```
- Then the **Executable Jar** `Main.jar` will be in the`build/` folder 🎉

## Project Requirements

Due: **Sun, Jan 8 2023**

- 2 Players per game
- 7 cards in a deck, start with 5 (12 total card, 4 per location)
- Cards have values of at least 1-9
- 3 Locations
- 4 cards can be placed at each location
- Highest sum of cards wins location
- 1 card played on the first turn, 2 cards on the second turn, etc..
- 1 card randomly drawn each turn
- Ends after at least 3 rounds (suggested 5 rounds)
- Can exit whenever
