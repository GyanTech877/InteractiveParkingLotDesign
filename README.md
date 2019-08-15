Instructions to Run:

1> Go inside parking_lot directory and run bin/setup which will install jre 8, maven and other necessary softwares and build the code

2> run bin/parking_lot it will launch the application in interactive mode

3> run bin/parking_lot functional_spec/fixtures/input.txt it will run the application by reading command from input.txt

4> run ./bin/run_functional_tests which will run functional tests. But I found some of the tests are failing as formatting error but it seeems to me formats are same, so couldn't find any format difference.

Screeshots are attached inside parking_lot directory for reference.

Sample Input:

create_parking_lot 6

park KA-01-HH-1234 White

park KA-01-HH-9999 White

park KA-01-BB-0001 Black

park KA-01-HH-7777 Red

park KA-01-HH-2701 Blue

park KA-01-HH-3141 Black

leave 4

status

park KA-01-P-333 White

park DL-12-AA-9999 White

registration_numbers_for_cars_with_colour White

slot_numbers_for_cars_with_colour White

slot_number_for_registration_number KA-01-HH-3141

slot_number_for_registration_number MH-04-AY-1111

Sample Output:

Created a parking lot with 6 slots

Allocated Slot Number: 1

Allocated Slot Number: 2

Allocated Slot Number: 3

Allocated Slot Number: 4

Allocated Slot Number: 5

Allocated Slot Number: 6

Slot number 4 is free

Slot No	Registration No	Colour

1	KA-01-HH-1234	White

2	KA-01-HH-9999	White

3	KA-01-BB-0001	Black

5	KA-01-HH-2701	Blue

6	KA-01-HH-3141	Black

Allocated Slot Number: 4

Sorry, parking lot is full

KA-01-HH-1234, KA-01-HH-9999, KA-01-P-333

1, 2, 4

6

Not found

If you want the unit tests also to run while running the sh file just change mvn clean install -DskipTests to mvn clean install inside parking_lot sh file.


Environment Requirements:
1. JDK 8
2. Maven
3. Junit 5


