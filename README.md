# Switch - Android
This library is used to change intents and/or fragments using one line of code.

<h2>Download</h2>

1. Add it in your root build.gradle at the end of repositories:<br/>
```
allprojects {
   repositories {
      ...
      maven { url 'https://jitpack.io' }
   }
}
```
  
2. Add the dependency:<br />
```
dependencies {
   compile 'com.github.ivansison02:switch:-SNAPSHOT'
}
```

<h2>Instruction</h2>

1. Add intents and/or fragments on the start.
```
Switch.with(this).addIntent(String tag, Intent intent);
Switch.with(this).addFragment(String tag, Fragment fragment);
```

2. Changing<br/>
* Intent
  ```
  Switch.with(this).to(tag);
  ```

* Fragment
  ```
  Switch.with(this)
     .setFrameLayout(R.id.frame)
     .from(getSupportFragmentManager()) // getActivity().getSupportFragmentManager() when implementing on a fragment
     .to("tag");
  ```
  
* For passing bundle/argument.
 ```
  Switch.with(this)
     .passData(bundle)
     .to(tag);
  ```

