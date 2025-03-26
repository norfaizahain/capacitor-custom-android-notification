import { PluginListenerHandle, WebPlugin } from '@capacitor/core';

import type { AndroidNotificationPlugin,notificationEvents } from './definitions';

export class AndroidNotificationWeb
  extends WebPlugin
  implements AndroidNotificationPlugin
{
  private eventListeners: { [event: string]: ((event: any) => void)[] } = {};
  async checkNotificationPermission(): Promise<{ status: "granted" | "denied" | "not_applicable" }> {
    console.warn("checkNotificationPermission() is not available on the web.");
    return { status: "not_applicable" };
  }
  
  async addListener(eventName: notificationEvents, listener: (data: any) => void): Promise<PluginListenerHandle> {
    if (!this.eventListeners[eventName]) {
      this.eventListeners[eventName] = [];
    }
    this.eventListeners[eventName].push(listener);
    // Return an object with a `remove` method to unregister the listener
    return {
      remove: () => {
        this.eventListeners[eventName] = this.eventListeners[eventName].filter(l => l !== listener);
        return Promise.resolve();
      }
    };
  }
}
