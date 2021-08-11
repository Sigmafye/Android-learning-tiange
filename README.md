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
可通过`android:taskAffinity=".exampleAffinity"`实现任务栈的指定，任务栈默认是包名。

### singleInstance
> 全局单例模式  
全局复用,不管哪个Task栈,只要存在目标Activity ,就复用。每个Activity占有一个新的Task栈。

## listener
监听三要素：
- Event Source(事件源)
- Event(事件)
- Event Listener(事件监听器)

## callback
> 基于回调的事件处理机制:  
> 当回调和监听同时存在：  
> 监听器-->控件本身-->向外传播。   
> return true:不会继续向外传播  
> return false:继续向外传播

## dispatcher
``` 
D/MyButton: ---dispatchTouchEvent---
D/OnTouchListener: ---onTouch---
D/MyButton: ----onTouchEvent----
D/MyButton: ---dispatchTouchEvent---
I/chatty: uid=10135(com.example.matrix) identical 1 line
D/MyButton: ---dispatchTouchEvent---
D/Listener: ---onClick---  
```
> 源代码  View.dispatchTouchEvent()  
> onClick/onLongClick来自onTouchEvent的处理  

**dispatchTouchEvent -> setOnTouchListener -> onTouchEvent**  
```java
public boolean dispatchTouchEvent(MotionEvent event) {
            //noinspection SimplifiableIfStatement
            ListenerInfo li = mListenerInfo;
            if (li != null && li.mOnTouchListener != null
                    && (mViewFlags & ENABLED_MASK) == ENABLED
                    && li.mOnTouchListener.onTouch(this, event)) {  //如果自己定义的OnTouchListener为true,那么返回true
                result = true;
            }
            //执行onTouchEvent
            if (!result && onTouchEvent(event)) {
                result = true;
            }
        }
        return result;
    }
```
> **过程分析：**  
> 在ACTION_DOWN之后会有100ms的检测，如果手指没有离开屏幕，则再执行400ms的检测，即一个长按事件需要500m来触发  
> 如果在这期间手指离开控件，则取消执行onTouchEvent。  
> 如果在期间return true。则不会继续传递。  

## storage
### Internal
Internal storage directories:
> /data/data/ < applicationId> /shared_ _prefs  
> /data/data/ <applicationId> /databases  
> /data/data/ <applicationId> /files  
> /data/data/ <applicationId> /cache  
> context.getCacheDir(); context.getFilesDir()  
#### SharedPreferences 
存储位置：/data/data/<applicationId>/shared_prefs/<fileName>.xml
applicationId不一定就是包名  
fileName就是getSharedPreferences(String name, int mode)的name参数  
示例：
```bash
PS C:\Users\Administrator\Desktop> adb shell
adb server version (32) doesn't match this client (41); killing...
* daemon started successfully
sagit:/ $ run-as com.example.matrix

sagit:/data/data/com.example.matrix $ ls
app_textures app_webview cache code_cache shared_prefs

sagit:/data/data/com.example.matrix $ cd shared_prefs/
sagit:/data/data/com.example.matrix/shared_prefs $ ls
WebViewChromiumPrefs.xml data.xml

sagit:/data/data/com.example.matrix/shared_prefs $ cat data.xml
<?xml version='1.0' encoding='utf-8' standalone='yes' ?>
<map>
    <string name="name">textColor</string>
</map>

sagit:/data/data/com.example.matrix/shared_prefs $
```
### External
#### pulic
Would not be deleted when App is uninstalled.
> Environment.getExternalStoragePublicDirectory(int type)
#### private
> /mnt/sdcard/Android/data/data/ <applicationId> /cache
> /mnt/sdcard/Android/data/data/ <applicationId> /files
