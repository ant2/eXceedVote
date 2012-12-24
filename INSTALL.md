How to Install and Run eXceedVote
=================================

1. Copy all the JAR files in the `dist` directory into a directory on your computer.
2. Open command prompt or terminal, then launch the application by including that directory on the classpath. Our main class is `com.github.ant2.exceedvote.ExceedVoteMain`.

Example
-------

For example, you installed JAR files into the directory named `exceed`, to run eXceedVote, you can type:

    java -cp "exceed/*" com.github.ant2.exceedvote.ExceedVoteMain


Required Libraries
------------------
The required libraries are already included in `dist` folder. The main application is __`exceedvote.jar`__

<table>
    <tr><td>eclipselink.jar                 <td><a href="http://www.eclipse.org/eclipselink/">EclipseLink JPA Implementation</a>
    <tr><td>forms-1.3.0.jar                 <td><a href="http://www.jgoodies.com/freeware/libraries/forms/">JGoodies FormLayout</a>
    <tr><td>guava-13.0.1.jar                <td><a href="http://code.google.com/p/guava-libraries/">Guava: Google Core Libraries</a>
    <tr><td>javax.persistence_2.0.4.v201112161009.jar    <td>javax.persistence interfaces
    <tr><td>log4j-api-2.0-beta3.jar         <td><a href="http://logging.apache.org/log4j/2.x/">Apache Logging Services</a> API
    <tr><td>log4j-core-2.0-beta3.jar        <td>Standard Implementation of Apache Logging Services</a>
    <tr><td>mockito-all-1.9.0.jar           <td><a href="http://code.google.com/p/mockito/">Mockito: Mocking Framework</a>
    <tr><td>postgresql-9.2-1001.jdbc4.jar   <td><a href="http://jdbc.postgresql.org/">PostgreSQL JDBC Driver</a>
</table>
