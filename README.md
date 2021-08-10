# Android develop learning
> learn form Tiange
## launchMode
### standard
> 标准模式，默认
Activity是由任务栈管理的,每启动一个Activity ,就会被放入栈中,按返回键,就会从栈顶移除一个Activity。

### singleTop
> Task栈顶复用模式
当要启动的目标Activity已经位于栈顶时,不会创建新的实例,会复用栈顶的Activity ,并且其onNewIntent()方法会被调用;如果目标Activity不在栈顶,则跟standard一样创建新的实例。

### singleTask
> Task栈内复用模式
<b>Remember the taskAffinity should start with "."</b>
在同一个任务栈中,如果要启动的目标Activity已经在栈中,则会复用该Activity ,并调用其onNewIntent()方法,并且该Activity.上面的Activity会被清除;如果栈中没有,则创建新的实例。
可通过`android:taskAffinity=".exampleAffinity"`实现任务栈的指定，任务栈默认是包名

### singleInstance
> 全局单例模式
全局复用,不管哪个Task栈,只要存在目标Activity ,就复用。每个Activity占有一个新的Task栈。


