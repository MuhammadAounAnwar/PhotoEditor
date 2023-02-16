Explanation for the selected technology

Language:
Personally i am comfortable in both languages, JAVA and KOTLIN.
For the selection, I have chose KOTLIN, because its required by most of the companies.
Secondly, It gives Null safety which i have to handle manually in JAVA.
Third and most important, it provides alot of built-in functionalities which are not available in JAVA. In Contrast of JAVA, I don’t have to write boilerplate code which is pre-built in kotlin.

Components:
I could have used simple Fragment Transaction using FragmentManager, but i have used NavigationComponent.

Database:
I have used Room DB. and there are alot of reasons for it.
Hilt supports Room DB.
Pagination 3 supports Room DB.
And all the latest components, supports it.

Dependency Injection:
Used Hilt for DI in comparison to Dagger 2 which saves alot of boilerplate code.



1 -- What are alternative ways to process images in Java? Which package you recommend and why?

There are alot of options available in market, to process images in native android development.
But personally i user GLIDE. The main reason to use it, Its easy. And gives range of options to work with.

Like to load large images, compress image size, cache image for offline use and alot of other features.



2 -- How to make the app handle big images like > 10mb picture?

In side the application if we have to handle manually, we can use Bitmap.
It allows us to compress the image size and to process in parts.
And If we don’t have to handle it manually, we have many options to go for which will handle all the overhead by themselves. Like Glide and Picasso.

In Offline manner,  we can store images in png format to save storage.



3 -- How to make image processing faster in mobile?

We can do it using multithreading approach(Handlers, Executors, Coroutines). As far as it concerned with algorithm OpenCV is well known for such purpose.
Personally i have no experience in such field.


