import java.io.*;
import groovy.io.*;

@NonCPS
def call (Map config=[:]){

    def dir = new File(pwd());
    def writer = new File(dir.path + "/releasenotes.txt").newWriter()
 
    dir.eachFileRecurse(FileType.ANY) { file ->
        if(file.isDirectory()){
            writer.writeLine(file.name)
        }else{
            writer.writeLine("\t" + file.name + "\t" + file.length())
        }
   }
}
