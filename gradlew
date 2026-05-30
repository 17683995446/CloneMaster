#!/usr/bin/env sh

#
# Gradle Wrapper for Linux/Unix
#

##############################################################################
#
#   Gradle start up script for POSIX
#
##############################################################################

set -e

find_app_home() {
    local link_name="$0"
    while [ -h "$link_name" ]; do
        local dir=$(cd -P $(dirname "$link_name") && pwd)
        link_name=$(readlink "$link_name")
        if [ "$link_name" != /* ]; then
            link_name="$dir/$link_name"
        fi
    done
    cd -P "$(dirname "$link_name")"
    pwd
}

APP_HOME=$(find_app_home)
APP_NAME=$(basename "$0")
CLASSPATH=$APP_HOME/gradle/wrapper/gradle-wrapper.jar

if [ -n "$JAVA_HOME" ]; then
    if [ -x "$JAVA_HOME/jre/sh/java" ]; then
        JAVACMD="$JAVA_HOME/jre/sh/java"
    else
        JAVACMD="$JAVA_HOME/bin/java"
    fi
    if [ ! -x "$JAVACMD" ]; then
        echo "ERROR: JAVA_HOME is set to an invalid directory: $JAVA_HOME"
        exit 1
    fi
else
    JAVACMD="java"
    if ! command -v java >/dev/null 2>&1; then
        echo "ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH."
        exit 1
    fi
fi

if [ "$(uname)" = "Darwin" ]; then
    MAX_FD_LIMIT=$(ulimit -H -n)
    if [ "$MAX_FD_LIMIT" = "unlimited" ]; then
        MAX_FD_LIMIT=10240
    fi
    ulimit -n "$MAX_FD_LIMIT" 2>/dev/null || true
fi

DEFAULT_JVM_OPTS="-Xmx2048m -Xms256m -Dfile.encoding=UTF-8"

MAX_FD="maximum"

save_args() {
    APP_ARGS=""
    for arg in "$@"; do
        APP_ARGS="$APP_ARGS \"$arg\""
    done
}

save_args "$@"

exec "$JAVACMD" $DEFAULT_JVM_OPTS -classpath "$CLASSPATH" org.gradle.wrapper.GradleWrapperMain "$@"
