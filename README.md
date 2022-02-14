# ioet-exercise
The company ACME offers their employees the flexibility to work the hours they want. But due to some external circumstances they need to know what employees have been at the office within the same time frame

The goal of this exercise is to output a table containing pairs of employees and how often they have coincided in the office.

Input: the name of an employee and the schedule they worked, indicating the time and hours. This should be a .txt file with at least five sets of data. You can include the data from our examples below:

Example 1:

INPUT
RENE=MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00- 21:00
ASTRID=MO10:00-12:00,TH12:00-14:00,SU20:00-21:00
ANDRES=MO10:00-12:00,TH12:00-14:00,SU20:00-21:00


OUTPUT:
ASTRID-RENE: 2
ASTRID-ANDRES: 3
RENE-ANDRES: 2

Example 2:

INPUT:
RENE=MO10:15-12:00,TU10:00-12:00,TH13:00-13:15,SA14:00-18:00,SU20:00-21:00
ASTRID=MO10:00-12:00,TH12:00-14:00,SU20:00-21:00

OUTPUT:
RENE-ASTRID: 3

## Overview of my solution
1. Read a txt input file line by line.
2. Save each line in order in a list.
3. Split each line into name and schedule.
4. Split schedule into day, start time and end time.
5. Compare all items to see when employees worked together.
6. Print output.

## Architecture
This program is structured in 3 Classes:
- Main
  - Functions
    - readLinesFromFile
    - getListOfEmployees
    - convertScheduleToMap
    - printListOfEmployeesWithSchedule
    - compareListOfEmployees
    - compareTimesAndDays
    - haveTheyWorkedInTheSameDay
- ScheduleEmployee
- TimeWorked

## How to run the program?
This is a Java program, built on IntelliJ IDEA IDE, to run this program, follow the instructions below:
1. Clone this repository. 
2. Open this project in your IDE.
3. You will find 3 Java Classes in src folder, run "Main" Class.
4. If you want to read another txt input file:
   - Go to the line 16 and change "input1.txt" to "input2.txt" or "input3.txt"
   - Run "Main" Class again.