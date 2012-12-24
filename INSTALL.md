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
    <tr><td>eclipselink.jar     <td>EclipseLink JPA Implementation
    <tr><td>forms-1.3.0.jar     <td>FormLayout
</table>
