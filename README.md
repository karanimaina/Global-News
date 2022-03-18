# Global-News
This is an android application that helps users  get  news headlines across the globe , a user can navigate throgh the App and catch up with the latet  tredong news.
## Samples
ou can open each of the following samples as an Android Studio project, and run them on a mobile device or a virtual device (AVD). When doing so you need to add each sample app you wish to try to a Firebase project on the Firebase console. You can add multiple sample apps to the same Firebase project. There's no need to create separate projects for each app.
To add a sample app to a Firebase project, use the applicationId value specified in the app/build.gradle file of the app as the Android package name. Download the generated google-services.json file, and copy it to the app/ directory of the sample you wish to run.

## Auhor
 @Felix Maina

## Setup and Istallation
<li>DownLoad android sstudio from https://developer.android.com/</li>
<li>Java 11</li>
<li>git clone this repo  in  your terminal</li>
<li>on the terminal navigate to the android folder you extracted </li>
<li>nnavigate to the bin  folder </li>
<li>type ./studio.sh to launch the android idea environment </li>
<li>Open the project</li>

## BDD
<li>change the run method to Application</li>
<li>Setup the emulator either as your phone by enabling the usb debugging in your developer settings or by using a custom  AVD device</li>
<li>confirm that all tests do pass</li>
<li>You are presented with a login page, click  create account to create an account for this application, click enter and the app navigates to the home activity</li>
<li>on the home page in th app bar section yo will see a text of "Welcome + yourName!" this means you are sucesfully logged into the application </li>
<li>down below there is a spinner with countries initials, select your preffered  country and click the button Find News, the app navigates to the News List Activity, </li>
<li>In the news list activity scroll down to see the general news , you can click on the category that you ae interested in , you can also query specific news , containing  a specific keyword, to see more details about a specific news click on that news that matches your interests, the app navigates to the news detail Activity</li>
<li>on the news detail Activity, you will get to see the title , the image , the url, the source, the cntent and a small brief descriptiion about that sspecific article </li>
<li>down below there is a like button, click on that button to save that news , click on the back button back to the homepage and  click on the saved news and you get to see the news that you saved </li>

## Tests
run the main actvity test, this tests on the App name and perform on click method that moves you to the next activity.
run instrumentation test, this test if , the funnstionality employed are functional

## License
MIT License

Copyright (c) 2022 Felix Maina

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
