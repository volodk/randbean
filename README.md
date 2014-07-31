nicebean
========

<h3>Summary</h3> Populates java beans with random dummy data and makes your jUnit tests more lean

<h3>Use case</h3> If you need to fill a pojo object with dummy data and you really want to avoid tons of keystrokes like these
```
bean.setPropertyA(...);
bean.setPropertyB(...);
bean.setPropertyC(...);
bean.setPropertyD(...);
bean.setPropertyE(...);
...
bean.setPropertyZ(...);
```
<h3>What to do</h3> Mark an instance field(s) of your test with <b>@Randomize</b> annotation and that's it. Basic idea is the following:

```
@Randomize private Pojo bean;

@Test public void thisIsAtest(){
  bean.getPropertyA() // null-safe access to generated data
}
```
<h3>Installation</h3>
It is not pushed to any public Nexus, so you have to do some work to get it in your app
```
git clone git@github.com:volodk/randbean.git
cd randbean
mvn install
```
After installing the jar locally you can include it in your pom.xml
```
<dependency>
  <groupId>org.randbean</groupId>
  <artifactId>randbean</artifactId>
  <version>0.0.1</version>
  <scope>test</scope>
</dependency>
```
<h2>License</h2>
```
This software is licensed under the Apache 2 license, quoted below.

Copyright 2013-2014 Volodymyr Krasnikov

Licensed under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License. You may obtain a copy of
the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
License for the specific language governing permissions and limitations under
the License.
```

