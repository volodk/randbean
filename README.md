nicebean
========

Populates java beans with random data, useful in unit tests

If you need to fill a pojo object with dummy data and you do not want to type a lot of lines like these

obj.setPropertyA(...)
obj.setPropertyB(...)
obj.setPropertyC(...)
obj.setPropertyD(...)
obj.setPropertyE(...)
...
obj.setPropertyZ(...)


you can use Nicebean (project name is kind of working version) tool. Usage is very simple:

@Nice YouPojoBean instance;

And that's it - you can use it. Anyway, please take a look on unit tests for more information

Thanks,  
