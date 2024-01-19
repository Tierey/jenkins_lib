libs in folder mode etc not trusted
https://www.jenkins.io/doc/book/pipeline/shared-libraries/

https://github.com/darinpope/github-api-global-lib/blob/main/vars/addSidebarLink.groovy

1 inside the controller 
Global pipline variables ADD
    name = 
    version = commit hash a tag a brunch
    load implicit = yes/no  // If checked, scripts will automatically have access to this library without needing to request it via @Library.
    allow def vers override = yes
    include @library changes  in job recent changes = yes 
    cache = no 
    Retrivial method
    modern scm = true
    repo https url 

/vars/helloWorld.groovy
def call () { 
    echo "some"
}
in pipline :
@Library('lib') _
helloWorld()


2 retrivier directly
library identifier :'x@master',
        retriever  : modernSCM([
            $class :'GitSCMSource',
            remote :'https://github.com/Tierey/jenkins_lib.git'
        ])

3 retriver local

// in pipline or global can use library in web UI - load implicitly = значит доступно в каждом степе
/*
structure of shred librarry
/
    /src        // groove source files
    /resources  // static data and config files
    /vars       // global groove scripts

if use filename log.groovy
def info ( String message ){}
def warn ( String message ){}
то в степах будет доступно как log.info 'Info!'

or if filename infoLog.groovy
def call( String message ){
    node {
        echo "${message}"
    }
}
и в степах logInfo 'info!'
*/

// shared-librarry/vars/auditTools.groovy
def call( Map config) {
    node {
        echo "${config.message}"
        sh '''
            git version
            docker version
        '''
    }
}




// resource folder - can get anywhere 
def js = libraryRedource '/org/foo/bar.json'