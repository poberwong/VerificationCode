# VerificationCode
随机生成多种方式验证码的实现<br>
这里主要实现了基本随机验证码BaseVerify和带有逻辑运算的简单验证码LogicVerify<br>
##Usage：
###setp1：<br>
在你的布局文件中对应的地方定义一个空的ImageView<br>
###setp2：<br>
在程序中利用调用对应验证方法getInstance()获取实例赋给接口引用变量<br>
###setp3：<br>
控件.setImageBitmap(接口引用变量.createBitmap())；来为ImageView实例化位图对象以及重新获取验证码<br>

##效果图
![](https://github.com/Bob1993/ImageCache/blob/master/Images/1.gif)
