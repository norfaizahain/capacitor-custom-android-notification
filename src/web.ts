import { WebPlugin } from '@capacitor/core';

import type { AndroidNotificationPlugin } from './definitions';

export class AndroidNotificationWeb
  extends WebPlugin
  implements AndroidNotificationPlugin
{
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
