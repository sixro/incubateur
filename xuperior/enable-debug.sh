#! /bin/sh

if [ $# != 1 ]; then
	echo "Usage `basename $0` DEVICE_NAME"
	echo "  where DEVICE_NAME actually can be:"
	echo "    * galaxy-s"
	echo "    * emulator"
	exit 1
fi

DEVICE_NAME=$1

DEVICE="none"

if [ "$DEVICE_NAME" = "galaxy-s" ]; then
	DEVICE=34C80002FFFC0000
elif [ "$DEVICE_NAME" = "emulator" ]; then
	DEVICE=emulator-5554
else
	echo "Unknown device '${DEVICE_NAME}'"
	exit 1
fi

adb -s $DEVICE shell setprop log.tag.Xuperior:BoardActivity  DEBUG
adb -s $DEVICE shell setprop log.tag.Xuperior:BoardView      DEBUG
adb -s $DEVICE shell setprop log.tag.Xuperior:MainActivity   DEBUG
adb -s $DEVICE shell setprop log.tag.Xuperior:SettingsActivi DEBUG
adb -s $DEVICE shell setprop log.tag.Xuperior:CalibrateActiv DEBUG
adb -s $DEVICE shell setprop log.tag.Compass                 DEBUG
