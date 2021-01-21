#!/bin/sh
SET_INDEX=${HOSTNAME##*-}
echo "Starting initializing for pod $SET_INDEX"
if [ "$SET_INDEX" = "0" ]; then
  cp /mnt/scripts/LDN-Primary.xml /mnt/data/amps-config.xml
elif [ "$SET_INDEX" = "1" ]; then
  cp /mnt/scripts/LDN-Backup.xml /mnt/data/amps-config.xml
else
  echo "Invalid statefulset index"
  exit 1
fi