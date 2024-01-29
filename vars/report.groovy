import java.io.*;
import groovy.io.*;
@NonCPS
def call (Map config=[:]){

    def dir = new File(pwd());
    def writer = new File(dir.path + "/releasenotes.txt").newWriter()
 
        writer -> dir.eachFileRecurse(FiletType.ANY) { file ->
            if(file.isDirectory()){
                writer.writeFile(file.name)
            }else{
                writer.writeFile("\t" + file.name + "\t" + file.length())
            }
        }
    

}
