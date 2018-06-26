# databinding
Studying data binding

I realized that it doens't work if you have a included view on your primary view.

First of all turn on data binding

```
android {
  ...
  dataBinding {
        enabled = true
    }
    ...
}
```

Then Add plugin
```
apply plugin: 'kotlin-kapt'
```

Don't wory about adding dependencies Gradle will do it automatically for you

Now is the time to add your binding class

```
data class Description(val description: String)
```

add at the top of your XML the layout tag

```xml
<layout xmlns:android="http://schemas.android.com/apk/res/android">
    <variable
      name="description"
      type="com.estudos.rendell.kotlinestudos.feature.Description" />
  ...
</layout>
```

Then link the variable to your View

```
<TextView
  android:layout_width="wrap_content"
  android:layout_height="wrap_content"
  android:text="@{description.description}" />
```

Now go to your activity
  
```
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val binding = DataBindingUtil.setContentView<ActivityScrollingBinding>(this, R.layout.activity_scrolling)
    val description = Description(getString(R.string.large_text))
    setSupportActionBar(binding.toolbar)
    binding.setVariable(BR.description, description)
    binding.executePendingBindings()
}
```
  
  ActivityScrollingBinding is a generated class
  BR is a generated class
  
  That's it ready to GO
