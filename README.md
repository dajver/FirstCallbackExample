# FirstCallbackExample

This is first version of callbacks from this example

```java
// The callback interface
interface MyCallback {
    void callbackCall();
}

// The class that takes the callback
class Worker {
   MyCallback callback;

   void onEvent() {
      callback.callbackCall();
   }
}

// Option 1:

class MainActivity extends Activity implements MyCallback {
   void callbackCall() {
      // callback code goes here
   }
}
