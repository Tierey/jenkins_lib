https://www.jenkins.io/doc/book/pipeline/shared-libraries/

1 inside the controller 
Global pipline variables ADD
    name = 
    version = 
    load implicit = yes/no  // If checked, scripts will automatically have access to this library without needing to request it via @Library.
    allow def vers override = yes
    include @library changes  in job recent changes = yes 
    cache = no 
    Retrivial method
    modern scm = true
    repo https url 


libs in folder not trusted