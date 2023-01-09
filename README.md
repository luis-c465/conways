# Convert App

Binary and Hexadecimal Converter for AP Computer Science AB 2022-2023 in Ivan Rico's class

## Dependencies for running

- [Java 1.8](https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html) or [higher](https://adoptium.net/)

## Running

- First download the **[Latest release](https://github.com/luis-c465/Convert/releases/latest)**
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

- Then the **Executable Jar** `convert.jar` will be in the root folder 🎉

## Project Requirements

Due: **Sat, Jan 15 2022** @midnight

- Explains how Binary is converted into an integer (see this link)
- Note: Each binary digit is a power of 2.
- Shows what each Binary digit represents as an integer
- Converts a Binary number to an integer
- Converts an integer into a binary number
- Explains how Hexadecimal is converted into an decimal (see this link)
- Note: Each hexadecimal digit is a power of 16 multiplied by the digit’s value
- Shows what each Hexadecimal digit represents as an decimal
- Converts a Hexadecimal digit to a decimal digit
- Converts a decimal digit to a hexadecimal
- Note: See this example for help with code
