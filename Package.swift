// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "CapacitorCustomAndroidNotification",
    platforms: [.iOS(.v13)],
    products: [
        .library(
            name: "CapacitorCustomAndroidNotification",
            targets: ["AndroidNotificationPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", branch: "main")
    ],
    targets: [
        .target(
            name: "AndroidNotificationPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/AndroidNotificationPlugin"),
        .testTarget(
            name: "AndroidNotificationPluginTests",
            dependencies: ["AndroidNotificationPlugin"],
            path: "ios/Tests/AndroidNotificationPluginTests")
    ]
)
