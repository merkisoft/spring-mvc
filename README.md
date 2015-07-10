# spring mvc rest service + angularjs app

## requirements
- intellij plugins: spring mvc, github, rest client
- tomcat 8
- npm (cli, ...)

## from scratch

### new module
- spring mvc
- create default

update web.xml / dispatcher-servlet.xml


### create website using yo:
cd Test/spring-mvc/web
npm install
sudo npm install -g grunt-cli
sudo npm install -g bower
bower update
grunt serve


bower install restangular
bower install lodash


#### grunt has issues resolving:

gruntfile.js
require('jit-grunt')(grunt, {
    useminPrepare: 'grunt-usemin',
    ngtemplates: 'grunt-angular-templates',
    cdnify: 'grunt-google-cdn'
  });


