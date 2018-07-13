
#!/bin/bash

cd /opt/eap/bin/
until $(curl --output /dev/null --silent --head --fail http://localhost:9990); do
    printf '.'
    sleep 5
done
./jboss-cli.sh -c --file=/tmp/setup/ds-setup.sh
bash
