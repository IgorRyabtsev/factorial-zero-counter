### Factorial end-Zero counter

The program counts zeros at the end of the factorial value of a number.
We take into account that given number no more then Long.MAX_VALUE = 9223372036854775807, just for
convenience.

#### Usage

To compile it's necessary execute:   

 `mvn clean install -Dlog4j.configuration=PATH_TO_LOG4J_PROPERTIES`

Where PATH_TO_LOG4J_PROPERTIES is a path to log4j.properties file. Now it's located in src/main/resources/log4j.properties.  
In log4j.properties you can change file for logging.

To execute it's necessary to execute JAR located in target.

`java -jar factorial-zero-ends-counter.jar`

You can use -h key to look how to use app.

`java -jar factorial-zero-ends-counter.jar -h`

Output:
 >usage: factorial-zero-ends-counter [options] [number]  
   -h,--help              Display usage.  
   -n,--number <number>   Given number for calculations. No more than Long.MAX_VALUE. Default value is 1000.  
  

Default number is  `100`

#### Example usage

The example how to start app and save metadata to res.csv file using 5 threads and with input order:  
* It's necessary to compile project:  
    `mvn clean install -DskipTests -Dlog4j.configuration=${PATH_TO_PROJECT}/src/main/resources/log4j.properties`  
* Execute jar file:  
    `java -jar factorial-zero-ends-counter.jar -n 1000`