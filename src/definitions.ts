import { PluginListenerHandle } from "@capacitor/core";
export declare type notificationEvents = 'inAppNotificationTriggered';
export declare type notificationMessage = {
  message: string;
};
export interface AndroidNotificationPlugin {
  checkNotificationPermission(): Promise<{ status: "granted" | "denied" | "not_applicable" }>;
  addListener(eventName: notificationEvents, listener: (event: notificationMessage) => void): Promise<PluginListenerHandle>;
}
