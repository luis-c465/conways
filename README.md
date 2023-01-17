# Conway's Game Of Life App

Binary and Hexadecimal Converter for AP Computer Science AB 2022-2023 in Ivan Rico's class

## Dependencies for running

- [Java 1.8](https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html) or [higher](https://adoptium.net/)

## Running

- First download the **[Latest release](https://github.com/luis-c465/conways/releases/latest)**
- Then run in the command line _(Or just double click on the file)_
  ```bash
  java -jar Main.jar
  ```

## Building

### Dependencies

- **[Maven v3.8.4](https://maven.apache.org/download.cgi)**

### How to build

Run the following in the [command line](https://www.freecodecamp.org/news/how-to-use-the-cli-beginner-guide/#how-to-locate-your-cli)

```bash
mvn clean compile assembly:single
```

- Then the **Executable Jar** `conways.jar` will be in the root folder 🎉

## Project Requirements

Due: **Sun, Jan 22 2023** @midnight

- http://pi.math.cornell.edu/~lipa/mec/lesson6.html
- If the cell is alive, then it stays alive if it has either 2 or 3 live neighbors
- If the cell is dead, then it springs to life only in the case that it has 3 live neighbors
-
- Cell’s stay alive according to Conway’s rules
- Cell’s die according to Conway’s rules
- Cell’s come to life according to Conway’s rules
- Can set the size of the board (number of possible cells)
- Counts the number of cycles (i.e. how long the program has been running)
- Counts the number of cells that have died
- Exit anytime
