# Navigation with Deeplink

![Screenshot](doc/navigation-graph.png)

Orders

    adb shell am start -a android.intent.action.VIEW -d "https://navigation.rakangsoftware.com/order" com.rakangsoftware.navigation

    adb shell am start -a android.intent.action.VIEW -d "https://navigation.rakangsoftware.com/order?orderId=1" com.rakangsoftware.navigation

Profile

    adb shell am start -a android.intent.action.VIEW -d "https://navigation.rakangsoftware.com/profile" com.rakangsoftware.navigation

