import java.io.*;
import groovy.io.*;

@NonCPS
def call (Map config=[:]){

    def dir = new File(pwd());
    new File(dir.path + "/report.txt").withWriter { writer ->
    
        dir.eachFileRecurse(FileType.ANY) { file ->
            if(file.isDirectory()){
                writer.writeLine(file.name)
            }else{
                writer.writeLine(file.name)
            }
       }
    }
}
