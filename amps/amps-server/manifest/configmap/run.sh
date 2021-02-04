#!/bin/sh
SET_INDEX=${HOSTNAME##*-}
echo "Starting initializing for pod $SET_INDEX"
if [ "$SET_INDEX" = "0" ]; then
  cp /mnt/scripts/LDN-Primary.xml /mnt/data/amps-config.xml
  echo LDN-Primary > /mnt/data/AMPS_NAME
  echo amps-1.amps-servers > /mnt/data/REP_SERVER
elif [ "$SET_INDEX" = "1" ]; then
  cp /mnt/scripts/LDN-Backup.xml /mnt/data/amps-config.xml
    echo LDN-Backup > /mnt/data/AMPS_NAME
    echo amps-0.amps-servers > /mnt/data/REP_SERVER
else
  echo "Invalid statefulset index"
  exit 1
fi