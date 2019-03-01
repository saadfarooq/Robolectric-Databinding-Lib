# Robolectric-Databinding-Lib

Running Robolectric 4.1 with DataBinding enabled in lib modules will throw `java.lang.NoClassDefFoundError: androidx/databinding/DataBinderMapperImpl`.

To reproduce:
- Run `ConnectedLibActivityTest` -> OK
- Run `LibActivityTest` -> Error


stacktrace:
```
[Robolectric] com.malvinstn.robolectric.lib.LibActivityTest.testAssertHelloText: sdk=28; resources=binary
Called loadFromPath(/system/framework/framework-res.apk, true); mode=binary sdk=28

java.lang.NoClassDefFoundError: androidx/databinding/DataBinderMapperImpl

	at com.malvinstn.robolectric.lib.LibActivity.onCreate(LibActivity.kt:12)
	at android.app.Activity.performCreate(Activity.java:7136)
	at android.app.Activity.performCreate(Activity.java:7127)
	at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1271)
	at androidx.test.runner.MonitoringInstrumentation.callActivityOnCreate(MonitoringInstrumentation.java:674)
	at org.robolectric.android.controller.ActivityController.lambda$create$0(ActivityController.java:69)
	at org.robolectric.shadows.ShadowLooper.runPaused(ShadowLooper.java:365)
	at org.robolectric.android.controller.ActivityController.create(ActivityController.java:69)
	at org.robolectric.android.controller.ActivityController.create(ActivityController.java:74)
	at org.robolectric.android.fakes.RoboMonitoringInstrumentation.startActivitySync(RoboMonitoringInstrumentation.java:46)
	at androidx.test.rule.ActivityTestRule.launchActivity(ActivityTestRule.java:358)
	at androidx.test.rule.ActivityTestRule$ActivityStatement.evaluate(ActivityTestRule.java:529)
	at org.junit.rules.RunRules.evaluate(RunRules.java:20)
	at org.robolectric.internal.SandboxTestRunner$2.evaluate(SandboxTestRunner.java:260)
	at org.robolectric.internal.SandboxTestRunner.runChild(SandboxTestRunner.java:130)
	at org.robolectric.internal.SandboxTestRunner.runChild(SandboxTestRunner.java:42)
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
	at org.robolectric.internal.SandboxTestRunner$1.evaluate(SandboxTestRunner.java:84)
	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
	at androidx.test.ext.junit.runners.AndroidJUnit4.run(AndroidJUnit4.java:104)
	at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
	at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)
	at com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:47)
	at com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:242)
	at com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70)
Caused by: java.lang.ClassNotFoundException: androidx.databinding.DataBinderMapperImpl
	at org.robolectric.internal.bytecode.SandboxClassLoader.getByteCode(SandboxClassLoader.java:163)
	at org.robolectric.internal.bytecode.SandboxClassLoader.maybeInstrumentClass(SandboxClassLoader.java:118)
	at org.robolectric.internal.bytecode.SandboxClassLoader.lambda$findClass$0(SandboxClassLoader.java:111)
	at org.robolectric.util.PerfStatsCollector.measure(PerfStatsCollector.java:50)
	at org.robolectric.internal.bytecode.SandboxClassLoader.findClass(SandboxClassLoader.java:110)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
	at com.malvinstn.robolectric.lib.LibActivity.onCreate(LibActivity.kt:12)
	at android.app.Activity.$$robo$$android_app_Activity$performCreate(Activity.java:7136)
	at android.app.Activity.performCreate(Activity.java)
	at android.app.Activity.$$robo$$android_app_Activity$performCreate(Activity.java:7127)
	at android.app.Activity.performCreate(Activity.java)
	at android.app.Instrumentation.$$robo$$android_app_Instrumentation$callActivityOnCreate(Instrumentation.java:1271)
	at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java)
	... 25 more


Process finished with exit code 255

```
