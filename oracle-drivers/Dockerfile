FROM registry.access.redhat.com/jboss-eap-7/eap71-openshift


COPY OJDBC-Full/ojdbc6.jar /home/jboss/
RUN mkdir /tmp/setup
COPY setup.sh /tmp/setup/
COPY ds-setup.sh /tmp/setup/
#USER 1000130000
USER root
RUN chown jboss:jboss /tmp/setup
RUN chmod +x /tmp/setup/*.sh

USER jboss
ENTRYPOINT  "/tmp/setup/setup.sh"
