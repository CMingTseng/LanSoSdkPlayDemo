LanSoSdkPlayDemo  

PS. 因為只能使用到 2016/12/31 ,請將系統時間往回設定,以利於預覽DEMO
===================================
# fork from https://github.com/LanSoSdk/LanSoSdkPlayDemo

#最新版本new version:


This is our video SDK player demo, support Soft Codec and hardware Acceleration, simple interface, welcome to download. We have a more professional and reliable SDK package, look forward to your business cooperation.  About US: Provide professional stable android video codec SDK multimedia development framework. Offers a variety of features customized services.


####business
这是我们的视频SDK播放器演示程序,全面支持软解和硬解,接口简单,欢迎下载使用. 我们有更专业稳定可靠的SDK包, 期待您的商务合作.  关于我们:提供专业稳定的android/视频编解码SDK多媒体开发框架. 提供各种功能的定制服务.   


这个基于我们开发的LanSoSdk而做的一个视频播放器演示, 安卓平台, 支持软解和硬解, 当硬件的不是很理想的时候或者不支持的时候, 可以切换到软解模式,方便您的使用.
里面有demo源代码,满足视频播放的基本需求,接口及其简单, 您可以任意复制代码并运用里面的各种代码，当前也可以使用到您的商业软件中. 
欢迎使用

有问题, 可联系我们, support@lansongtech.com.

####播放功能列表(free)

###基本播放:
	1,正常播放, 支持MP4,FLV,AVI,TS,3GP,RMVB,WM,WMV格式视频.
	
	2,是基於SDK開發的VideoPlayer
	
	3,可以在播放过程中,无缝切换各种显示画面;
	
### 說明　:
	1,LanSoPlaySDK 是lib核心用於呼叫FFMPEG部分.
	
	2,LanSoVideoPlayer是基於SDK開發的VideoPlayer可软硬解自动切换.完全支持软硬解.并软解功能支持NEON指令,多线程解码,並且可以在播放过程中,无缝切换各种显示画面;


## Using with Gradle

 add the library module to your app's dependency by modifying `app/build.gradle`
   ```
   ...
   dependencies {
       ...
        compile 'com.lansongtech.ffmpeg:lansoplaysdk:0.0.0'
        compile 'com.lansongtech.ffmpeg:lansovideoplayer:0.0.0'
       ...
   }
   ...	
      
      
