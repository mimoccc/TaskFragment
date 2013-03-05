TaskFragment
============

TaskFragment is designed to provide a container for complex &amp; reusable functions in Android platform.


Why you need it
=============

In daily development work, you will find some functions would be reused in different components/projects, but hard to package them to a class/method. for example, take/pick photos, Authorization for SNS etc.

Because of Android's Design priciple, Use 3rd party Activity is very common in Android app development, but use onActivityResult interface is the only way to get the result, that's the main reason we can't create a simple reusable component in those case.

TaskFragment is create for this purpose.

Dependency
=============

- Android support libary r10


How to use TaskFragment
=======
- It's a quite simple abstract class file, you can feel free to copy it to your project folder.
- Inherit and implement it.


Contribute
=======

- feel free to Fork it


Other
=======
- Demo will be created soon.
