using System;
using MonoTouch.Foundation;
using MonoTouch.UIKit;

using com.badlogic.gdx.backends.ios;
using com.github.sixro.pooomodoro.core;

namespace com.github.sixro.pooomodoro
{
	[Register ("AppDelegate")]
	public partial class AppDelegate : IOSApplication {
		public AppDelegate () : base(new Pooomodoro(), createConfig()) {}

		internal static IOSApplicationConfiguration createConfig () {
			IOSApplicationConfiguration config = new IOSApplicationConfiguration();
			config.orientationLandscape = true;
			config.orientationPortrait = false;
			config.useAccelerometer = true;
			config.useMonotouchOpenTK = true;
			config.useObjectAL = true;
			return config;
		}
	}

	public class Application {
		static void Main (string[] args) {
			UIApplication.Main (args, null, "AppDelegate");
		}
	}
}
