# Student Record Management with File Persistence

## What this project does
- Loads `students.txt` at startup (CSV records)
- Allows adding, viewing, searching, deleting, sorting students
- Saves updated records to `students.txt` on exit
- Demonstrates: BufferedReader/Writer, RandomAccessFile, Comparator, Iterator

## How to compile & run
From project root (where `src/` and `students.txt` are located):

### macOS / Linux:
```
mkdir -p out
find src -name "*.java" > sources.txt
javac -d out @sources.txt
java -cp out main.App
```

### Windows (PowerShell):
```
New-Item -ItemType Directory -Path out -Force
Get-ChildItem -Path .\src -Filter *.java -Recurse | ForEach-Object { $_.FullName } > sources.txt
javac -d out @sources.txt
java -cp out main.App
```

## File format (students.txt)
Each line: roll,name,email,course,marks

Example:
101,Ankit,ankit@mail.com,B.Tech,85.5
102,Riya,riya@mail.com,M.Tech,91.0
