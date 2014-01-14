nicebean
========

<b>Summary:</b> Populates java beans with random dummy data and makes your jUnit tests more lean ...

<b>When:</b> If you need to fill a pojo object with dummy data and you really want to avoid tons of keystrokes like these
```
obj.setPropertyA(...);
obj.setPropertyB(...);
obj.setPropertyC(...);
obj.setPropertyD(...);
obj.setPropertyE(...);
...
obj.setPropertyZ(...);
```
<b>What to do:</b> Just mark an instance field(s) of your test with <b>@Nice</b> annotation and you're done.

Thanks,  

