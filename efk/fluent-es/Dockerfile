FROM fluent/fluentd:latest

USER root
WORKDIR /
RUN apk add --update netcat-openbsd && rm -rf /var/cache/apk/*

ENV PATH /home/ubuntu/ruby/bin:$PATH
RUN gem install fluent-plugin-elasticsearch

ADD fluent.conf /fluentd/etc/fluent.conf
CMD fluentd -c /fluentd/etc/$FLUENTD_CONF -p /fluentd/plugins $FLUENTD_OPT
