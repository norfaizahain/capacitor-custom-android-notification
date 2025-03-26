import Foundation

@objc public class AndroidNotification: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
