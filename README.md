# PhotoEditor
 
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


