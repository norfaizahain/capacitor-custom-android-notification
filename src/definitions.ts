export interface AndroidNotificationPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
