import { registerPlugin } from '@capacitor/core';

import type { AndroidNotificationPlugin } from './definitions';

const AndroidNotification = registerPlugin<AndroidNotificationPlugin>(
  'AndroidNotification',
  {
    web: () => import('./web').then(m => new m.AndroidNotificationWeb()),
  },
);

export * from './definitions';
export { AndroidNotification };
